package home.calc;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * User: def
 * Date: 5/21/14
 * Time: 11:59 PM
 */
public class Team {
    private ArrayList<Player> players;

    public Team(String url) throws Exception {
        Document page = null;
        this.players = new ArrayList<Player>();
        if (url.contains("http")) {
            page = Jsoup.connect(url).get();
        }
        else {
            File testRoster = new File(url);
            page = Jsoup.parse(testRoster, "UTF-8");

        }

        Element roster = page.select("b:contains(Основной состав)")
                .first()
                .parent()
                .parent()
                .parent()
                .parent();
        Elements teamPlayers = roster.select("a[href*=ngPlayerInfo]");
        for (Element s: teamPlayers) {
            this.players.add(new Player(s.parent().parent()));
        }
    }

    public Integer getPlayersCount() {
        return this.players.size();
    }

    public BigDecimal getTeamSalary() {
        BigDecimal teamSalary = BigDecimal.ZERO;
        for (Player p: this.players){
            teamSalary = teamSalary.add(p.getSalary());
        }
        return teamSalary;
    }

    public ArrayList<Player> getPlayersByPosition(String position) {
//        System.out.println(this.players.size());
        ArrayList<Player> playersWithPosition = new ArrayList<Player>();
        for (Player p: this.players){
            if (p.isPosition(position)) {
                playersWithPosition.add(p);
//                System.out.println("Этот наш "+ p.getName());
            }
//            System.out.println(p.getName() + " позиция " + p.getPosition()+ ", а мы ищем " + position );
        }
        return playersWithPosition;
    }

    public ArrayList<Player> getFilteredPlayersByPosition(String position, Integer str, Integer physic) {
        ArrayList<Player> playersWithPosition = new ArrayList<Player>();
        for (Player p: this.players){
            if (p.isPosition(position) & (p.getRealStrength() > str) & (p.getFitness() > physic)) {
                playersWithPosition.add(p);
            }
        }
        return playersWithPosition;
    }

    public String[][] getData(){
        String[][] s = new String[this.players.size()][3];
        Integer i = 0;
        for (Player p: this.players){
            s[i][0] = p.getName();
            s[i][1] = p.getPosition();
            s[i][2] = p.getRealStrength()+"";
            i++;
        }
        return s;
    }

    public ArrayList<Player> getPlayerList(){
        ArrayList <Player> playerList = new ArrayList<Player>();
        for (Player p:players){
            playerList.add(p);
        }
        return playerList;
    }
}
