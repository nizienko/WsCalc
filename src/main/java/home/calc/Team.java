package home.calc;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

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
        } else {
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
        for (Element s : teamPlayers) {
            this.players.add(new Player(s.parent().parent()));
        }
        int[] str = new int[players.size()];
        int i = 0;
        for (Player p : players) {
            if (p.canPlay()) {
                try {
                    str[i] = p.getRealStrength();
                    i++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        Arrays.sort(str);
        int minStr;
        try {
            minStr = str[str.length - 11];
        } catch (IndexOutOfBoundsException e) {
            minStr = 0;
        }
        System.out.println(minStr);
        for (int j = 0; j < players.size(); j++) {
            if (players.get(j).getRealStrength() < minStr) {
                players.get(j).setCanPlay(false);
            }
        }

    }

    public Integer getPlayersCount() {
        return this.players.size();
    }

    public BigDecimal getTeamSalary() {
        BigDecimal teamSalary = BigDecimal.ZERO;
        for (Player p : this.players) {
            teamSalary = teamSalary.add(p.getSalary());
        }
        return teamSalary;
    }

    public ArrayList<Player> getPlayersByPosition(String position) {
        ArrayList<Player> playersWithPosition = new ArrayList<Player>();
        for (Player p : this.players) {
            if (p.isPosition(position)) {
                playersWithPosition.add(p);
            }
        }
        return playersWithPosition;
    }

    public ArrayList<Player> getFilteredPlayersByPosition(String position) {
        ArrayList<Player> playersWithPosition = new ArrayList<Player>();
        for (Player p : this.players) {
            if (p.isPosition(position) & (p.canPlay())) {
                playersWithPosition.add(p);
            }
        }
        return playersWithPosition;
    }

    public String[][] getData() {
        String[][] s = new String[this.players.size()][3];
        Integer i = 0;
        for (Player p : this.players) {
            s[i][0] = p.getName();
            s[i][1] = p.getPosition();
            s[i][2] = p.getRealStrength() + "";
            i++;
        }
        return s;
    }

    public ArrayList<Player> getPlayerList() {
        ArrayList<Player> playerList = new ArrayList<Player>();
        for (Player p : players) {
            playerList.add(p);
        }
        return playerList;
    }
}
