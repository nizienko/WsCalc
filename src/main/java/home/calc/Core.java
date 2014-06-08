package home.calc;

import home.calc.gui.MainWindow;
import home.calc.utils.Actions;
import home.calc.utils.Listeners;
import home.calc.utils.Positions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * User: def
 * Date: 5/23/14
 * Time: 11:34 PM
 */
public class Core {

    private Calculator calculator;
    private MainWindow mainWindow;
    private Listeners listeners = new Listeners();
    private Team myTeam;
    private Team competitorTeam;
    private LineupListThread myLineups;
    private LineupListThread competitorLineups;


    public Core() {
        this.setActionListeners();
        this.mainWindow = new MainWindow(listeners);
        this.calculator = new Calculator();
//        FormationGenerator formationGenerator = new FormationGenerator();
    }

    private void loadTeams() {
        System.out.println("Loading teams...");
        try {
            myTeam = new Team(mainWindow.getMyTeamUrl());
            System.out.println("Моих игроков "+myTeam.getPlayersCount());
            competitorTeam = new Team(mainWindow.getOpponentTeamUrl());
            mainWindow.hideLoadFrame();
            RosterContent rosterContent = new RosterContent(myTeam.getPlayerList(), competitorTeam.getPlayerList());
            mainWindow.showRosters(rosterContent);
            mainWindow.setMinStr();

//            LineupList lineupList1 = new LineupList(myTeam, 40, 90);


        }
        catch (Exception e){
            JOptionPane.showMessageDialog(mainWindow, "Loading error");
            e.printStackTrace();
        }
    }

    private void positionReport(String position){
        System.out.println("Update rosters");
        System.out.println("Моих игроков " + myTeam.getPlayersCount());

        System.out.println(position);
        if (!position.equals(Positions.ALL.toString())) {
            RosterContent rosterContent = new RosterContent(
                    this.myTeam.getPlayersByPosition(position),
                    this.competitorTeam.getPlayersByPosition(calculator.getOppositePosition(position)));
            rosterContent.markPlayers();
            mainWindow.showRosters(rosterContent);

        }
        else {
            RosterContent rosterContent = new RosterContent(
                    myTeam.getPlayerList(),
                    competitorTeam.getPlayerList());
            rosterContent.markPlayers();
            mainWindow.showRosters(rosterContent);
        }

    }

    private void findLineups(String own){
        try {
            if (own.equals("my")){
                String[] formations = mainWindow.getFormations(own);
                this.myLineups = new LineupListThread(myTeam, mainWindow.getStregth(own), mainWindow.getFitnes(own), formations, mainWindow.getRoster(own));
                this.mainWindow.cleanLineup(own);
                this.myLineups.start();
            }
            else if (own.equals("his")){
                String[] formations = mainWindow.getFormations(own);
                this.competitorLineups = new LineupListThread(competitorTeam, mainWindow.getStregth(own), mainWindow.getFitnes(own), formations, mainWindow.getRoster(own));
                this.mainWindow.cleanLineup(own);
                this.competitorLineups.start();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void stop(String own){
        if (own.equals("my")){
            this.myLineups.stopWork();
        }
        else if (own.equals("his")){
            this.competitorLineups.stopWork();
        }
    }

//    private void findLineups(String own){
//        try {
//            if (own.equals("my")){
//                Integer i = 0;
//                Integer curStr = 250;
//                Integer str = mainWindow.getStregth(own);
//                String[] formations = mainWindow.getFormations(own);
//                while (i < 100 & curStr >= str) {
//                    this.myLineups = new LineupList(myTeam, curStr, mainWindow.getFitnes(own), formations);
//                    i = this.myLineups.count();
//                    curStr = curStr - 1;
//                }
//                System.out.println(" " + this.myLineups.count());
//
//                try {
//                    mainWindow.showLineup(this.myLineups.getLineups().get(0), myLineups.getCurrent()+"/"+myLineups.count(), own);
//                }
//                catch (IndexOutOfBoundsException e){
//                    e.printStackTrace();
//                    mainWindow.cleanLineup(own);
//                }
//            }
//            else if (own.equals("his")) {
//                Integer i = 0;
//                Integer curStr = 200;
//                Integer str = mainWindow.getStregth(own);
//                String[] formations = mainWindow.getFormations(own);
//                while (i < 100 & curStr >= str) {
//                    this.competitorLineups = new LineupList(this.competitorTeam, curStr, mainWindow.getFitnes(own), formations);
//                    i = this.competitorLineups.count();
//                    curStr = curStr - 1;
//                }
//                try {
//                    mainWindow.showLineup(this.competitorLineups.getLineups().get(0), competitorLineups.getCurrent()+"/"+competitorLineups.count(),own);
//                }
//                catch (IndexOutOfBoundsException e){
//                    e.printStackTrace();
//                    mainWindow.cleanLineup(own);
//                }
//            }
//            try {
//                mainWindow.loadCompareInfo(myLineups.getLineups().get(myLineups.getCurrent()),
//                        competitorLineups.getLineups().get(competitorLineups.getCurrent()));
//            }
//            catch (Exception e){
//
//            }
//
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//    }

    private void switchLineups(String cmd){
        System.out.println(cmd);
        if (cmd.equals("my_next")){
            mainWindow.showLineup(myLineups.getNext(), myLineups.getCurrent()+"/"+myLineups.count(), "my");
        }
        else if (cmd.equals("his_next")){
            mainWindow.showLineup(competitorLineups.getNext(), competitorLineups.getCurrent()+"/"+competitorLineups.count(), "his");
        }
        else if (cmd.equals("my_prev")){
            mainWindow.showLineup(myLineups.getPrev(), myLineups.getCurrent()+"/"+myLineups.count(), "my");
        }
        else if (cmd.equals("his_prev")){
            mainWindow.showLineup(competitorLineups.getPrev(), competitorLineups.getCurrent()+"/"+competitorLineups.count(), "his");
        }
        else if (cmd.equals("my_def")){
            mainWindow.showLineup(myLineups.getBestDefence(), myLineups.getCurrent()+"/"+myLineups.count(), "my");
        }
        else if (cmd.equals("his_def")){
            mainWindow.showLineup(competitorLineups.getBestDefence(), competitorLineups.getCurrent()+"/"+competitorLineups.count(), "his");
        }
        else if (cmd.equals("my_mid")){
            mainWindow.showLineup(myLineups.getBestMidle(), myLineups.getCurrent()+"/"+myLineups.count(), "my");
        }
        else if (cmd.equals("his_mid")){
            mainWindow.showLineup(competitorLineups.getBestMidle(), competitorLineups.getCurrent()+"/"+competitorLineups.count(), "his");
        }
        else if (cmd.equals("my_frw")){
            mainWindow.showLineup(myLineups.getBestForward(), myLineups.getCurrent()+"/"+myLineups.count(), "my");
        }
        else if (cmd.equals("his_frw")){
            mainWindow.showLineup(competitorLineups.getBestForward(), competitorLineups.getCurrent()+"/"+competitorLineups.count(), "his");
        }
        else if (cmd.equals("my_left")){
            mainWindow.showLineup(myLineups.getBestRight(), myLineups.getCurrent()+"/"+myLineups.count(), "my");
        }
        else if (cmd.equals("his_left")){
            mainWindow.showLineup(competitorLineups.getBestLeft(), competitorLineups.getCurrent()+"/"+competitorLineups.count(), "his");
        }
        else if (cmd.equals("my_center")){
            mainWindow.showLineup(myLineups.getBestCenter(), myLineups.getCurrent()+"/"+myLineups.count(), "my");
        }
        else if (cmd.equals("his_center")){
            mainWindow.showLineup(competitorLineups.getBestCenter(), competitorLineups.getCurrent()+"/"+competitorLineups.count(), "his");
        }
        else if (cmd.equals("my_right")){
            mainWindow.showLineup(myLineups.getBestRight(), myLineups.getCurrent()+"/"+myLineups.count(), "my");
        }
        else if (cmd.equals("his_right")){
            mainWindow.showLineup(competitorLineups.getBestRight(), competitorLineups.getCurrent()+"/"+competitorLineups.count(), "his");
        }
        try {
            mainWindow.loadCompareInfo(myLineups.getLineups().get(myLineups.getCurrent()),
                    competitorLineups.getLineups().get(competitorLineups.getCurrent()));
        }
        catch (Exception e){

        }

    }

    private void compareTeams(){
        mainWindow.showCompareWindow();
    }



    private void setActionListeners(){
        listeners.put(Actions.LOAD_TEAMS, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadTeams();
            }
        });

        listeners.put(Actions.POSITION_REPORT, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                positionReport(e.getActionCommand());
            }
        });
        listeners.put(Actions.FIND_LINEUPS, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                findLineups(e.getActionCommand());

            }
        });
        listeners.put(Actions.STOP, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                stop(e.getActionCommand());

            }
        });
        listeners.put(Actions.COMPARE_TEAMS, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    compareTeams();
                }
                catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });
        listeners.put(Actions.SWITCH_LINEUPS, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchLineups(e.getActionCommand());
            }
        });
    }
}
