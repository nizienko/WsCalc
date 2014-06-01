package home.calc;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import home.calc.utils.Positions;

import java.util.*;

/**
 * User: def
 * Date: 4/9/14
 * Time: 11:44 PM
 */
public class LineupList {
    private Team team;
    private ArrayList<Lineup> allLineups;
    private Integer str;
    private Integer current;

    public LineupList(Team team, Integer str, Integer physic, String[] formations) {
        this.str = str;
        this.allLineups = new ArrayList<Lineup>();
        this.team = team;

        ArrayList <Positions[]> positions = new ArrayList<Positions[]>();
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.CM, Positions.CM, Positions.LF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.CM, Positions.CM, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.CM, Positions.CM, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.LF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.RD, Positions.CM, Positions.CM, Positions.LF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.RD, Positions.CM, Positions.CM, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.RD, Positions.CM, Positions.CM, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.RD, Positions.LM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.RD, Positions.LM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.RD, Positions.LM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.LF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.CM, Positions.CM, Positions.LF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.CM, Positions.CM, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.CM, Positions.CM, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.LF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.CM, Positions.CM, Positions.LF, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.CM, Positions.CM, Positions.LF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.CM, Positions.CM, Positions.CF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.CM, Positions.CM, Positions.CF, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.RM, Positions.LF, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.RM, Positions.LF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.RM, Positions.CF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.RM, Positions.CF, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.LF, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.LF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.CF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.CF, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.LF, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.LF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.CF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.CF, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.CM, Positions.CM, Positions.LF, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.CM, Positions.CM, Positions.LF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.CM, Positions.CM, Positions.CF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.CM, Positions.CM, Positions.CF, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.RM, Positions.LF, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.RM, Positions.LF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.RM, Positions.CF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.RM, Positions.CF, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.LF, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.LF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.CF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.CF, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.LF, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.LF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.CF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.CF, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.LF, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.LF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.CF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.CF, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.LF, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.LF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.CF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.CF, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.LF, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.LF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.CF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.CF, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.LF, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.LF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.CF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.CF, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.RD, Positions.RD, Positions.CM, Positions.CM, Positions.LF, Positions.CF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.RM, Positions.LF, Positions.CF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.LF, Positions.CF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.LF, Positions.CF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.CM, Positions.CM, Positions.LF, Positions.CF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.RD, Positions.LM, Positions.RM, Positions.LF, Positions.CF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.LF, Positions.CF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.LF, Positions.CF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.LF, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.LF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.CF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.CF, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.LF, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.LF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.CF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.CF, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.LF, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.LF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.CF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.CF, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.CM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.CM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.CM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.LF, Positions.CF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.CM, Positions.CM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.CM, Positions.CM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.CM, Positions.CM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.CM, Positions.RM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.CM, Positions.RM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.CM, Positions.RM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.CM, Positions.CM, Positions.RM, Positions.LF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.CM, Positions.CM, Positions.RM, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.CM, Positions.CM, Positions.RM, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.LF, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.LF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.CF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.CF, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.LF, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.LF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.CF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.CF, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.RM, Positions.LF, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.RM, Positions.LF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.RM, Positions.CF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.RM, Positions.CF, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.CM, Positions.RM, Positions.LF, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.CM, Positions.RM, Positions.LF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.CM, Positions.RM, Positions.CF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.CM, Positions.RM, Positions.CF, Positions.CF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.LM, Positions.CM, Positions.RM, Positions.LF, Positions.CF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.CM, Positions.RM, Positions.LF, Positions.CF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.RM, Positions.LF, Positions.CF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.CM, Positions.RM, Positions.LF, Positions.CF, Positions.CF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.LF, Positions.CF, Positions.CF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.LF, Positions.CF, Positions.CF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.LF, Positions.LF, Positions.CF, Positions.RF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.LF, Positions.LF, Positions.CF, Positions.CF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.LF, Positions.CF, Positions.CF, Positions.RF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.CM, Positions.CM, Positions.LF, Positions.CF, Positions.CF, Positions.CF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.LF, Positions.LF, Positions.CF, Positions.RF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.LF, Positions.LF, Positions.CF, Positions.CF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.LF, Positions.CF, Positions.CF, Positions.RF, Positions.RF
        });
        positions.add(new Positions[] {
                Positions.GK, Positions.LD, Positions.CD, Positions.RD, Positions.LM, Positions.RM, Positions.LF, Positions.CF, Positions.CF, Positions.CF, Positions.RF
        });

        for (Positions[] formation: positions) {
            Integer[] i = new Integer[11]; // Счетчики для перебора игроков
            Integer j = 0; // счетчки позиций
            Integer count = 1;
            Integer d = 0;
            Integer m = 0;
            Integer f = 0;
            for (Positions position: formation) {
                System.out.print(position.toString() + " ");
                i[j] = team.getFilteredPlayersByPosition(position.toString(), str, physic).size();
                count = count * i[j];
                j++;
                if (position.toString().contains("D")){
                    d++;
                }
                else if (position.toString().contains("M")){
                    m++;
                }
                else if (position.toString().contains("F")){
                    f++;
                }
            }

            System.out.println(d+" "+m+" "+f+" Всего возможно вариантов " + count+", для игроков силой не меньше "+str);
            Boolean interestingFormation = false;
            for(String curF: formations){
                if (curF.equals(d + "-" + m + "-" + f)){
                    interestingFormation = true;
                    System.out.println("Наша формация!");
                }
            }
            if (count > 0 & interestingFormation){
                current = 0;
                TeamCounter teamCounter = new TeamCounter(11);
                teamCounter.setMaxValues(i);
                while (teamCounter.notFinished()) {
                    // генерим все варианты составов
                    Lineup lineup = new Lineup();
                    Integer p = 0;
                    for (Positions position: formation) {

                        lineup.addPlayer(
                                position,
                                team.getFilteredPlayersByPosition(
                                        position.toString(), str, physic)
                                        .get(teamCounter.getCurrentCounter()[p] - 1));
                        p++;
                    }
                    if (lineup.isCorrect()){
                        lineup.printLineUp();
                        lineup.calculate();
                        System.out.println("После");
                        lineup.printLineUp();
                        this.allLineups.add(lineup);
                    }
                    else {
    //                    System.out.println("Нашли некорректный состав");
                    }
                    teamCounter.nextVal();
                }

            }
            System.out.println("Нашли " + allLineups.size());
            if (allLineups.size() > 0){
                Collections.sort(allLineups, new Comparator<Lineup>() {
                    @Override
                    public int compare(Lineup o1, Lineup o2) {
                        return o2.getAllStrength() - o1.getAllStrength();
                    }
                });
                allLineups.get(current).printLineUp();
                System.out.println(allLineups.get(current).getType());
            }

        }

    }
    public Integer count(){
        return allLineups.size();
    }

    public ArrayList<Lineup> getLineups(){
        return allLineups;
    }
    public ArrayList<Lineup> getLineupsByType(String type){
        ArrayList<Lineup> typeLineaups = new ArrayList<Lineup>();
        for (Lineup l: allLineups){
            System.out.println(l.getPlayers().size());
            if (l.getType().equals(type)){
                typeLineaups.add(l);
            }
        }
        return typeLineaups;
    }

    public Lineup getBestDefence(){
        Integer i = 0;
        Integer j = 0;
        Integer s = allLineups.get(i).getDefenceLineStrength();
        for (Lineup l: allLineups){
            if (s < l.getDefenceLineStrength()){
                s = l.getDefenceLineStrength();
                i = j;
                System.out.println(s + " сумма " + j);
            }
            j++;
            this.current = i;

        }

        return allLineups.get(i);
    }
    public Lineup getBestMidle(){
        Integer i = 0;
        Integer j = 0;
        Integer s = allLineups.get(i).getMidleLineStrength();
        for (Lineup l: allLineups){
            if (s < l.getMidleLineStrength()){
                s = l.getMidleLineStrength();
                i = j;
                System.out.println(s + " сумма " + j);
            }
            j++;
            this.current = i;
        }

        return allLineups.get(i);
    }

    public Lineup getBestForward(){
        Integer i = 0;
        Integer j = 0;
        Integer s = allLineups.get(i).getForwardLineStrength();
        for (Lineup l: allLineups){
            if (s < l.getForwardLineStrength()){
                s = l.getForwardLineStrength();
                i = j;
                System.out.println(s + " сумма " + j);
            }
            j++;
            this.current = i;
        }

        return allLineups.get(i);
    }

    public Lineup getBestLeft(){
        Integer i = 0;
        Integer j = 0;
        Integer s = allLineups.get(i).getLeftLineStrength();
        for (Lineup l: allLineups){
            if (s < l.getLeftLineStrength()){
                s = l.getLeftLineStrength();
                i = j;
                System.out.println(s + " сумма " + j);
            }
            j++;
            this.current = i;
        }

        return allLineups.get(i);
    }
    public Lineup getBestCenter(){
        Integer i = 0;
        Integer j = 0;
        Integer s = allLineups.get(i).getCenterLineStrength();
        for (Lineup l: allLineups){
            if (s < l.getCenterLineStrength()){
                s = l.getCenterLineStrength();
                i = j;
                System.out.println(s + " сумма " + j);
            }
            j++;
            this.current = i;
        }

        return allLineups.get(i);
    }
    public Lineup getBestRight(){
        Integer i = 0;
        Integer j = 0;
        Integer s = allLineups.get(i).getRightLineStrength();
        for (Lineup l: allLineups){
            if (s < l.getRightLineStrength()){
                s = l.getRightLineStrength();
                i = j;
                System.out.println(s + " сумма " + j);
            }
            j++;
            this.current = i;
        }

        return allLineups.get(i);
    }

    public Lineup getBestStrength(){
        Integer i = 0;
        Integer j = 0;
        Integer s = allLineups.get(j).getAllStrength();
        for (Lineup l: allLineups){
            if (s < l.getAllStrength()){
                s = l.getAllStrength();
                i = j;
                System.out.println(s + " сумма " + j);

            }
            j++;
            this.current = i;
        }
        return allLineups.get(i);
    }

    public Integer getCurrent(){
        return current;
    }
    public Lineup getNext(){
        if (current<allLineups.size()){
            current++;
        }
        return allLineups.get(current);
    }
    public Lineup getPrev(){
        if (current>0){
            current--;
        }
        return allLineups.get(current);
    }

    private class TeamCounter{
        private Integer[] counter;
        private Integer[] maxValues;
        private Boolean finished = false;
        public TeamCounter(Integer count) {
            this.counter = new Integer[count];

            for (int j=0; j<count; j++){
                this.counter[j] = 1;
            }
        }

        public void setMaxValues(Integer[] maxValues){
            this.maxValues = maxValues;
        }
        public Integer[] getCurrentCounter(){
            return this.counter;
        }

        public Boolean notFinished(){
            return !finished;
        }

        public void nextVal(){
            for (int j = counter.length-1; j >= 0; j--){
                if (counter[j]+1 > maxValues[j]){
                    counter[j]= 1;
                    if (j==0){
                        this.finished = true;
                    }
                }
                else {
                    counter[j] = counter[j] + 1;
                    break;
                }
            }

        }

    }
}
