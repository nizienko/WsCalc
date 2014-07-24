package home.calc;

import home.calc.utils.Performance;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

/**
 * User: def
 * Date: 5/24/14
 * Time: 5:57 PM
 */
public class RosterContent {

    private ArrayList<Player> myPlayers;
    private ArrayList<Player> opponentPlayers;

    public RosterContent(ArrayList<Player> myPlayers, ArrayList<Player> opponentPlayers) {
        System.out.println("New roster! " + myPlayers.size() + " " + opponentPlayers.size());
        this.myPlayers = sort(myPlayers);
        this.opponentPlayers = sort(opponentPlayers);

    }

    public ArrayList<Player> getMyPlayers() {
        return this.myPlayers;
    }

    public ArrayList<Player> getOpponentPlayers() {
        return this.opponentPlayers;
    }

    private ArrayList<Player> sort(ArrayList<Player> players) {
        ArrayList<Player> sortedPlayers = new ArrayList<Player>();
        Integer i;
        while (players.size() > 0) {
            int best = 0;
            for (i = 0; i < players.size(); i++) {
                if (players.get(i).strongerThan(players.get(best))) {
                    best = i;
                }
            }
            sortedPlayers.add(players.get(best));
            players.remove(best);
            best = 0;
        }
        return sortedPlayers;
    }

    public void markPlayers() {
        System.out.println("Посчитаем среднюю силу игроков");
        Integer mySum = 0;
        Integer opponentSum = 0;
        Integer i;

        System.out.println("Моя команда");
        for (i = 0; i < myPlayers.size(); i++) {
            mySum = mySum + myPlayers.get(i).getRealStrength();
        }
        BigDecimal myAvg = new BigDecimal(mySum)
                .divide(new BigDecimal(myPlayers.size()), RoundingMode.HALF_UP);
        System.out.println("Суммарная смла " + mySum + " средняя сила " + myAvg + " Игроков " + myPlayers.size());


        System.out.println("Команда сопернкиа");
        for (i = 0; i < opponentPlayers.size(); i++) {
            opponentSum = opponentSum + opponentPlayers.get(i).getRealStrength();
        }
        BigDecimal opponentAvg = new BigDecimal(opponentSum)
                .divide(new BigDecimal(opponentPlayers.size()), RoundingMode.HALF_UP);
        System.out.println("Суммарная смла " + opponentSum + " средняя сила " + opponentAvg + " Игроков " + opponentPlayers.size());

        BigDecimal avg = myAvg.add(opponentAvg).divide(new BigDecimal(2), RoundingMode.HALF_UP);
        int myBest = 0;
        int opponentBest = 0;

        for (i = 0; i < myPlayers.size(); i++) {
            if (avg.compareTo(new BigDecimal(myPlayers.get(i).getRealStrength())) == 1) {
                myPlayers.get(i).setPerformance(Performance.BAD);
            } else {
                myPlayers.get(i).setPerformance(Performance.GOOD);
                if (myPlayers.get(i).strongerThan(myPlayers.get(myBest))) {
                    myBest = i;
                }
            }
        }
        for (i = 0; i < opponentPlayers.size(); i++) {
            if (avg.compareTo(new BigDecimal(opponentPlayers.get(i).getRealStrength())) == 1) {
                opponentPlayers.get(i).setPerformance(Performance.BAD);
            } else {
                opponentPlayers.get(i).setPerformance(Performance.GOOD);
                if (opponentPlayers.get(i).strongerThan(opponentPlayers.get(opponentBest))) {
                    opponentBest = i;
                }
            }
        }
        if (myPlayers.get(myBest).strongerThan(opponentPlayers.get(opponentBest))) {
            myPlayers.get(myBest).setPerformance(Performance.BEST);
        } else if (opponentPlayers.get(opponentBest).strongerThan(myPlayers.get(myBest))) {
            opponentPlayers.get(opponentBest).setPerformance(Performance.BEST);
        } else {
            myPlayers.get(myBest).setPerformance(Performance.BEST);
            opponentPlayers.get(opponentBest).setPerformance(Performance.BEST);
        }

    }
}
