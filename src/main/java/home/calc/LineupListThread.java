package home.calc;

import home.calc.gui.MainWindow;
import home.calc.gui.Roster;
import home.calc.utils.Positions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by def on 08.06.14.
 */
public class LineupListThread extends Thread {

    private Team team;
    private ArrayList<Lineup> allLineups;
    private ArrayList<Positions[]> positions;
    private Integer current;
    private String[] formations;
    private Roster roster;
    private Boolean stoped;


    public LineupListThread(Team team, String[] formations, Roster roster) {
        this.allLineups = new ArrayList<Lineup>();
        this.team = team;
        this.formations = formations;
        this.roster = roster;
        stoped = false;


        positions = new ArrayList<Positions[]>();
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.CM, Positions.CM, Positions.LF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.CM, Positions.CM, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.CM, Positions.CM, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.LF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.RD, Positions.CM, Positions.CM, Positions.LF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.RD, Positions.CM, Positions.CM, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.RD, Positions.CM, Positions.CM, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.RD, Positions.LM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.RD, Positions.LM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.RD, Positions.LM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.LF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.CM, Positions.CM, Positions.LF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.CM, Positions.CM, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.CM, Positions.CM, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.LF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.CM, Positions.CM, Positions.LF, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.CM, Positions.CM, Positions.LF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.CM, Positions.CM, Positions.CF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.CM, Positions.CM, Positions.CF, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.RM, Positions.LF, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.RM, Positions.LF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.RM, Positions.CF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.RM, Positions.CF, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.LF, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.LF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.CF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.CF, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.LF, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.LF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.CF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.CF, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.CM, Positions.CM, Positions.LF, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.CM, Positions.CM, Positions.LF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.CM, Positions.CM, Positions.CF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.CM, Positions.CM, Positions.CF, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.RM, Positions.LF, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.RM, Positions.LF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.RM, Positions.CF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.RM, Positions.CF, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.LF, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.LF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.CF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.CF, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.LF, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.LF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.CF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.CF, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.LF, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.LF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.CF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.CF, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.LF, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.LF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.CF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.CF, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.LF, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.LF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.CF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.CF, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.LF, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.LF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.CF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.CF, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.RD, Positions.RD, Positions.CM, Positions.CM, Positions.LF, Positions.CF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.RM, Positions.LF, Positions.CF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.LF, Positions.CF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.LF, Positions.CF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.CM, Positions.CM, Positions.LF, Positions.CF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.RM, Positions.LF, Positions.CF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.LF, Positions.CF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.LF, Positions.CF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.LF, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.LF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.CF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.CF, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.LF, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.LF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.CF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.CF, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.LF, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.LF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.CF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.CF, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.CM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.CM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.CM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.LF, Positions.CF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.CM, Positions.CM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.CM, Positions.CM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.CM, Positions.CM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.CM, Positions.RM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.CM, Positions.RM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.CM, Positions.RM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.CM, Positions.CM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.CM, Positions.CM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.CM, Positions.CM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.LF, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.LF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.CF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.CF, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.LF, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.LF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.CF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.CF, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.RM, Positions.LF, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.RM, Positions.LF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.RM, Positions.CF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.RM, Positions.CF, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.CM, Positions.RM, Positions.LF, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.CM, Positions.RM, Positions.LF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.CM, Positions.RM, Positions.CF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.CM, Positions.RM, Positions.CF, Positions.CF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.LF, Positions.CF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.LF, Positions.CF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.LF, Positions.CF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.LF, Positions.CF, Positions.CF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.LF, Positions.CF, Positions.CF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.LF, Positions.CF, Positions.CF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.LF, Positions.LF, Positions.CF, Positions.RF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.LF, Positions.LF, Positions.CF, Positions.CF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.LF, Positions.CF, Positions.CF, Positions.RF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.LF, Positions.CF, Positions.CF, Positions.CF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.LF, Positions.LF, Positions.CF, Positions.RF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.LF, Positions.LF, Positions.CF, Positions.CF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.LF, Positions.CF, Positions.CF, Positions.RF, Positions.RF
        });
        positions.add(new Positions[]{
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.LF, Positions.CF, Positions.CF, Positions.CF, Positions.RF
        });
    }

    private String getTypeFormation(Positions[] formation) {
        Integer d = 0;
        Integer m = 0;
        Integer f = 0;
        for (Positions position : formation) {
            if (position.toString().contains("D")) {
                d++;
            } else if (position.toString().contains("M")) {
                m++;
            } else if (position.toString().contains("F")) {
                f++;
            }
        }
        return d + "-" + m + "-" + f;
    }

    @Override
    public void run() {
        roster.disableButton();
        for (Positions[] formation : positions) {
            String typeFormation = getTypeFormation(formation);
            Boolean interestingFormation = false;
            for (String curF : formations) {
                if (curF.equals(typeFormation)) {
                    interestingFormation = true;
                }
            }
            if (interestingFormation) {
                Integer[] i = new Integer[11]; // Счетчики для перебора игроков
                Integer j = 0; // счетчки позиций
                Integer count = 1;
                for (Positions position : formation) {
                    System.out.print(position.toString() + " ");
                    i[j] = team.getFilteredPlayersByPosition(position.toString()).size();
                    count = count * i[j];
                    j++;
                }

                System.out.println(typeFormation + " Всего возможно вариантов " + count);

                if (count > 0) {
                    current = 0;
                    TeamCounter teamCounter = new TeamCounter(11);
                    teamCounter.setMaxValues(i);
                    while (teamCounter.notFinished()) {
                        // генерим все варианты составов
                        Lineup lineup = new Lineup(team);
                        Integer p = 0;
                        for (Positions position : formation) {
                            lineup.addPlayer(
                                    position,
                                    team.getFilteredPlayersByPosition(
                                            position.toString())
                                            .get(teamCounter.getCurrentCounter()[p] - 1));
                            if (!lineup.isCorrect() || this.stoped) {
                                break;
                            }
                            p++;
                        }
                        if (this.stoped) {
                            break;
                        }
                        if (lineup.isCorrect()) {
                            lineup.calculate();
                            this.allLineups.add(lineup);
                            roster.showCount(this.allLineups.size() + "");
                        }
                        teamCounter.nextVal();
                    }


                }
                if (this.stoped) {
                    break;
                }

                System.out.println("Нашли " + allLineups.size());
                if (allLineups.size() > 0) {
                    Collections.sort(allLineups, new Comparator<Lineup>() {
                        @Override
                        public int compare(Lineup o1, Lineup o2) {
                            return o2.getAllStrength() - o1.getAllStrength();
                        }
                    });
                    roster.loadLineupData(allLineups.get(allLineups.size() - 1), "/" + allLineups.size());
                }
            }
            if (this.stoped) {
                break;
            }
        }
        roster.enableButton();
    }

    public Integer count() {
        return allLineups.size();
    }

    public ArrayList<Lineup> getLineups() {
        return allLineups;
    }

    public ArrayList<Lineup> getLineupsByType(String type) {
        ArrayList<Lineup> typeLineaups = new ArrayList<Lineup>();
        for (Lineup l : allLineups) {
            System.out.println(l.getPlayers().size());
            if (l.getType().equals(type)) {
                typeLineaups.add(l);
            }
        }
        return typeLineaups;
    }

    public Lineup getBestDefence() {
        Integer i = 0;
        Integer j = 0;
        Integer s = allLineups.get(i).getDefenceLineStrength();
        for (Lineup l : allLineups) {
            if (s < l.getDefenceLineStrength()) {
                s = l.getDefenceLineStrength();
                i = j;
                System.out.println(s + " сумма " + j);
            }
            j++;
            this.current = i;

        }

        return allLineups.get(i);
    }

    public Lineup getBestMidle() {
        Integer i = 0;
        Integer j = 0;
        Integer s = allLineups.get(i).getMidleLineStrength();
        for (Lineup l : allLineups) {
            if (s < l.getMidleLineStrength()) {
                s = l.getMidleLineStrength();
                i = j;
                System.out.println(s + " сумма " + j);
            }
            j++;
            this.current = i;
        }

        return allLineups.get(i);
    }

    public Lineup getBestForward() {
        Integer i = 0;
        Integer j = 0;
        Integer s = allLineups.get(i).getForwardLineStrength();
        for (Lineup l : allLineups) {
            if (s < l.getForwardLineStrength()) {
                s = l.getForwardLineStrength();
                i = j;
                System.out.println(s + " сумма " + j);
            }
            j++;
            this.current = i;
        }

        return allLineups.get(i);
    }

    public Lineup getBestLeft() {
        Integer i = 0;
        Integer j = 0;
        Integer s = allLineups.get(i).getLeftLineStrength();
        for (Lineup l : allLineups) {
            if (s < l.getLeftLineStrength()) {
                s = l.getLeftLineStrength();
                i = j;
                System.out.println(s + " сумма " + j);
            }
            j++;
            this.current = i;
        }

        return allLineups.get(i);
    }

    public Lineup getBestCenter() {
        Integer i = 0;
        Integer j = 0;
        Integer s = allLineups.get(i).getCenterLineStrength();
        for (Lineup l : allLineups) {
            if (s < l.getCenterLineStrength()) {
                s = l.getCenterLineStrength();
                i = j;
                System.out.println(s + " сумма " + j);
            }
            j++;
            this.current = i;
        }

        return allLineups.get(i);
    }

    public Lineup getBestRight() {
        Integer i = 0;
        Integer j = 0;
        Integer s = allLineups.get(i).getRightLineStrength();
        for (Lineup l : allLineups) {
            if (s < l.getRightLineStrength()) {
                s = l.getRightLineStrength();
                i = j;
                System.out.println(s + " сумма " + j);
            }
            j++;
            this.current = i;
        }

        return allLineups.get(i);
    }

    public Lineup getBestStrength() {
        Integer i = 0;
        Integer j = 0;
        Integer s = allLineups.get(j).getAllStrength();
        for (Lineup l : allLineups) {
            if (s < l.getAllStrength()) {
                s = l.getAllStrength();
                i = j;
                System.out.println(s + " сумма " + j);

            }
            j++;
            this.current = i;
        }
        return allLineups.get(i);
    }

    public Integer getCurrent() {
        return current;
    }

    public Lineup getNext() {
        if (current < allLineups.size()) {
            current++;
        }
        return allLineups.get(current);
    }

    public Lineup getFirst() {
        current = 0;
        return allLineups.get(current);
    }

    public Lineup getPrev() {
        if (current > 0) {
            current--;
        }
        return allLineups.get(current);
    }

    public void stopWork() {
        this.stoped = true;
    }

    private class TeamCounter {
        private Integer[] counter;
        private Integer[] maxValues;
        private Boolean finished = false;

        public TeamCounter(Integer count) {
            this.counter = new Integer[count];

            for (int j = 0; j < count; j++) {
                this.counter[j] = 1;
            }
        }

        public void setMaxValues(Integer[] maxValues) {
            this.maxValues = maxValues;
        }

        public Integer[] getCurrentCounter() {
            return this.counter;
        }

        public Boolean notFinished() {
            return !finished;
        }

        public void nextVal() {
            for (int j = counter.length - 1; j >= 0; j--) {
                if (counter[j] + 1 > maxValues[j]) {
                    counter[j] = 1;
                    if (j == 0) {
                        this.finished = true;
                    }
                } else {
                    counter[j] = counter[j] + 1;
                    break;
                }
            }
        }
    }
}
