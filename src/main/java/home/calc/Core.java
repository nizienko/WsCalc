package home.calc;

import home.calc.gui.MainWindow;
import home.calc.utils.Actions;
import home.calc.utils.Positions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * User: def
 * Date: 5/23/14
 * Time: 11:34 PM
 */
public class Core {

    private Activities activities;
    private MainWindow mainWindow;
    private Team myTeam;
    private Team competitorTeam;
    private LineupListThread myLineups;
    private LineupListThread competitorLineups;


    public Core() {
        this.mainWindow = new MainWindow(this);
        this.activities = new Activities();
    }

    private void loadTeams() {
        System.out.println("Loading teams...");
        try {
            myTeam = new Team(mainWindow.getMyTeamUrl());
            System.out.println("Моих игроков " + myTeam.getPlayersCount());
            competitorTeam = new Team(mainWindow.getOpponentTeamUrl());
            mainWindow.hideLoadFrame();
            RosterContent rosterContent = new RosterContent(myTeam.getPlayerList(), competitorTeam.getPlayerList());
            mainWindow.showRosters(rosterContent);


        } catch (Exception e) {
            JOptionPane.showMessageDialog(mainWindow, "Loading error");
            e.printStackTrace();
        }
    }

    private void positionReport(String position) {
        System.out.println("Update rosters");
        System.out.println("Моих игроков " + myTeam.getPlayersCount());

        System.out.println(position);
        if (!position.equals(Positions.ALL.toString())) {
            RosterContent rosterContent = new RosterContent(
                    this.myTeam.getPlayersByPosition(position),
                    this.competitorTeam.getPlayersByPosition(activities.getOppositePosition(position)));
            rosterContent.markPlayers();
            mainWindow.showRosters(rosterContent);

        } else {
            RosterContent rosterContent = new RosterContent(
                    myTeam.getPlayerList(),
                    competitorTeam.getPlayerList());
            rosterContent.markPlayers();
            mainWindow.showRosters(rosterContent);
        }

    }

    private void findLineups(String own) {
        try {
            if (myTeam == null) {
                throw new NullPointerException();
            }
            if (own.equals("my")) {
                String[] formations = mainWindow.getFormations(own);
                this.myLineups = new LineupListThread(myTeam, formations, mainWindow.getRoster(own));
                this.mainWindow.cleanLineup(own);
                this.myLineups.start();
            } else if (own.equals("his")) {
                String[] formations = mainWindow.getFormations(own);
                this.competitorLineups = new LineupListThread(competitorTeam, formations, mainWindow.getRoster(own));
                this.mainWindow.cleanLineup(own);
                this.competitorLineups.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void stop(String own) {
        if (own.equals("my")) {
            this.myLineups.stopWork();
        } else if (own.equals("his")) {
            this.competitorLineups.stopWork();
        }
    }

    private void switchLineups(String cmd) {
        System.out.println(cmd);
        if (cmd.equals("my_next")) {
            mainWindow.showLineup(myLineups.getNext(), myLineups.getCurrent() + "/" + myLineups.count(), "my");
        } else if (cmd.equals("his_next")) {
            mainWindow.showLineup(competitorLineups.getNext(), competitorLineups.getCurrent() + "/" + competitorLineups.count(), "his");
        } else if (cmd.equals("my_first")) {
            mainWindow.showLineup(myLineups.getFirst(), myLineups.getCurrent() + "/" + myLineups.count(), "my");
        } else if (cmd.equals("his_first")) {
            mainWindow.showLineup(competitorLineups.getFirst(), competitorLineups.getCurrent() + "/" + competitorLineups.count(), "his");
        } else if (cmd.equals("my_prev")) {
            mainWindow.showLineup(myLineups.getPrev(), myLineups.getCurrent() + "/" + myLineups.count(), "my");
        } else if (cmd.equals("his_prev")) {
            mainWindow.showLineup(competitorLineups.getPrev(), competitorLineups.getCurrent() + "/" + competitorLineups.count(), "his");
        } else if (cmd.equals("my_def")) {
            mainWindow.showLineup(myLineups.getBestDefence(), myLineups.getCurrent() + "/" + myLineups.count(), "my");
        } else if (cmd.equals("his_def")) {
            mainWindow.showLineup(competitorLineups.getBestDefence(), competitorLineups.getCurrent() + "/" + competitorLineups.count(), "his");
        } else if (cmd.equals("my_mid")) {
            mainWindow.showLineup(myLineups.getBestMidle(), myLineups.getCurrent() + "/" + myLineups.count(), "my");
        } else if (cmd.equals("his_mid")) {
            mainWindow.showLineup(competitorLineups.getBestMidle(), competitorLineups.getCurrent() + "/" + competitorLineups.count(), "his");
        } else if (cmd.equals("my_frw")) {
            mainWindow.showLineup(myLineups.getBestForward(), myLineups.getCurrent() + "/" + myLineups.count(), "my");
        } else if (cmd.equals("his_frw")) {
            mainWindow.showLineup(competitorLineups.getBestForward(), competitorLineups.getCurrent() + "/" + competitorLineups.count(), "his");
        } else if (cmd.equals("my_left")) {
            mainWindow.showLineup(myLineups.getBestRight(), myLineups.getCurrent() + "/" + myLineups.count(), "my");
        } else if (cmd.equals("his_left")) {
            mainWindow.showLineup(competitorLineups.getBestLeft(), competitorLineups.getCurrent() + "/" + competitorLineups.count(), "his");
        } else if (cmd.equals("my_center")) {
            mainWindow.showLineup(myLineups.getBestCenter(), myLineups.getCurrent() + "/" + myLineups.count(), "my");
        } else if (cmd.equals("his_center")) {
            mainWindow.showLineup(competitorLineups.getBestCenter(), competitorLineups.getCurrent() + "/" + competitorLineups.count(), "his");
        } else if (cmd.equals("my_right")) {
            mainWindow.showLineup(myLineups.getBestRight(), myLineups.getCurrent() + "/" + myLineups.count(), "my");
        } else if (cmd.equals("his_right")) {
            mainWindow.showLineup(competitorLineups.getBestRight(), competitorLineups.getCurrent() + "/" + competitorLineups.count(), "his");
        }
        try {
            mainWindow.loadCompareInfo(myLineups.getLineups().get(myLineups.getCurrent()),
                    competitorLineups.getLineups().get(competitorLineups.getCurrent()));
        } catch (Exception e) {

        }

    }

    private void compareTeams() {
        mainWindow.showCompareWindow();
    }

    private void savePlayersChanges(int c, int s) {
        System.out.println("Changed " + c + " " + s);

    }

    public ActionListener getListener(Actions action) {
        switch (action) {
            case LOAD_TEAMS:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        loadTeams();
                    }
                };
            case POSITION_REPORT:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        positionReport(e.getActionCommand());
                    }
                };
            case FIND_LINEUPS:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        findLineups(e.getActionCommand());

                    }
                };
            case STOP:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        stop(e.getActionCommand());

                    }
                };
            case COMPARE_TEAMS:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            compareTeams();
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                };
            case SWITCH_LINEUPS:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        switchLineups(e.getActionCommand());
                    }
                };

        }
        return null;
    }

}
