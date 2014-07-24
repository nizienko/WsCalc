package home.calc;

import home.calc.utils.Performance;
import home.calc.utils.Positions;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * User: def
 * Date: 5/22/14
 * Time: 12:45 AM
 */
public class Calculator {

    private Team myTeam, competitor;

    public Calculator() {

    }

    public void loadTeams(Team myTeam, Team competitor) {
        this.myTeam = myTeam;
        this.competitor = competitor;
    }

    public Team getMyTeam() {
        return myTeam;
    }

    public Team getCompetitor() {
        return competitor;
    }

    public String getOppositePosition(String position) {
        if (position.equals("GK")) return position;
        String oppositePosition = "";
        if (position.substring(0, 1).equals("L")) oppositePosition = "R";
        else if (position.substring(0, 1).equals("R")) oppositePosition = "L";
        else oppositePosition = "C";
        if (position.substring(1, 2).equals("D")) oppositePosition = oppositePosition + "F";
        else if (position.substring(1, 2).equals("F")) oppositePosition = oppositePosition + "D";
        else oppositePosition = oppositePosition + "M";
        return oppositePosition;
    }

    public void positionsReport() {

        for (Positions s : Positions.values()) {
            String myPosition = s.toString();
            String competitorPosition = this.getOppositePosition(s.toString());
            System.out.println();
            System.out.println(myPosition + " против " + competitorPosition);
            ArrayList<Player> myPlayers = myTeam.getPlayersByPosition(myPosition);
            System.out.println("Мои " + myPosition + ":");
            Player myStrongestPlayer = myPlayers.get(0);
            for (Player p : myPlayers) {
                System.out.println(p.getName() + " " + p.getRealStrength());
                if (myStrongestPlayer.getRealStrength() < p.getRealStrength()) {
                    myStrongestPlayer = p;
                }
            }
            ArrayList<Player> competitorPlayers = competitor.getPlayersByPosition(competitorPosition);
            System.out.println("Его " + competitorPosition + ":");
            Player himStrongestPlayer = myPlayers.get(0);
            for (Player p : competitorPlayers) {
                System.out.println(p.getName() + " " + p.getRealStrength());
                if (himStrongestPlayer.getRealStrength() < p.getRealStrength()) {
                    himStrongestPlayer = p;
                }
            }
            if (myStrongestPlayer.getRealStrength() >= himStrongestPlayer.getRealStrength()) {
                System.out.println("(!) Выигрышная позиция");
            } else {
                System.out.println("Проигрышная позиция");
            }

        }
    }

    public RosterContent getPlayersReport(ArrayList<Player> myPlayers, ArrayList<Player> competitorPlayers) {

        Player myStrongestPlayer = myPlayers.get(0);
        for (Player p : myPlayers) {
            System.out.println(p.getName() + " " + p.getRealStrength());
            if (myStrongestPlayer.getRealStrength() < p.getRealStrength()) {
                myStrongestPlayer = p;
            }
        }

        Player hisStrongestPlayer = myPlayers.get(0);
        for (Player p : competitorPlayers) {
            System.out.println(p.getName() + " " + p.getRealStrength());
            if (hisStrongestPlayer.getRealStrength() < p.getRealStrength()) {
                hisStrongestPlayer = p;
            }
        }
        if (myStrongestPlayer.getRealStrength() >= hisStrongestPlayer.getRealStrength()) {
            System.out.println("(!) Выигрышная позиция");
        } else {
            System.out.println("Проигрышная позиция");
        }
        return null;
    }
}
