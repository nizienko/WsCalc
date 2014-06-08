package home.calc.gui;

import home.calc.Lineup;
import home.calc.Player;
import home.calc.PlayerOnPosition;
import home.calc.utils.Actions;
import home.calc.utils.Listeners;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * User: def
 * Date: 5/24/14
 * Time: 1:14 AM
 */
public class Roster extends JPanel {
    private JTable table1;
    private JTable table2;
    private String[] columnTitles1 = { "Position", "Name", "Real Stregth", "Fitnes", "Specialities" };
    private String[] columnTitles2 = { "Position", "Name", "Real Stregth", "Fitnes", "Specialities"};
    private JScrollPane tableScrollPane1;
    private JScrollPane tableScrollPane2;
    private DefaultTableModel model1;
    private DefaultTableModel model2;
    private RowSorter<TableModel> sorter;
    private JPanel centerPanel;
    private JPanel generateLineupsPanel;
    private JTextField str;
    private JTextField fit;
    private JButton findLineups;
    private JList formationList;
    private String[] formations;
    private JLabel totalLineups;
    private String own;
    private Listeners listeners;



    public Roster(Listeners listeners, String own) {
        this.listeners = listeners;
        this.own = own;
        formations = new String[]{ "7-2-1", "6-3-1", "6-2-2", "5-4-1", "5-3-2", "5-2-3", "4-4-2", "4-5-1", "4-3-3", "3-6-1", "3-5-2", "3-4-3", "3-3-4", "4-2-4","3-2-5" };
        model1 = new DefaultTableModel(null, columnTitles1);
        model2 = new DefaultTableModel(null, columnTitles2);

        sorter = new TableRowSorter<TableModel>(model1);
        table1 = new JTable(model1);
        table1.setRowSorter(sorter);
        tableScrollPane1 = new JScrollPane(table1);
        table2 = new JTable(model2);
        tableScrollPane2 = new JScrollPane(table2);

        this.setLayout(new BorderLayout());
        JPanel tablePanel1 = new JPanel();
        JPanel tablePanel2 = new JPanel();
        totalLineups = new JLabel();
        tablePanel1.setLayout(new BorderLayout());
        tablePanel2.setLayout(new BorderLayout());
        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2,1));
        this.add(centerPanel, BorderLayout.CENTER);

        centerPanel.add(tablePanel1);
        centerPanel.add(tablePanel2);
        tablePanel1.add(table1.getTableHeader(), BorderLayout.PAGE_START);
        tablePanel2.add(table1.getTableHeader(), BorderLayout.PAGE_START);
        tablePanel1.add(tableScrollPane1, BorderLayout.CENTER);
        tablePanel2.add(tableScrollPane2, BorderLayout.CENTER);
        JPanel eastPanel = new JPanel();
        eastPanel.setLayout(new GridLayout(9,1));
        eastPanel.add(totalLineups);

        JButton next = new JButton(">");
        next.setActionCommand(own+"_next");
        next.addActionListener(listeners.get(Actions.SWITCH_LINEUPS));
        eastPanel.add(next);

        JButton prev = new JButton("<");
        prev.setActionCommand(own+"_prev");
        prev.addActionListener(listeners.get(Actions.SWITCH_LINEUPS));
        eastPanel.add(prev);

        JButton def = new JButton("D");
        def.setActionCommand(own+"_def");
        def.addActionListener(listeners.get(Actions.SWITCH_LINEUPS));
        eastPanel.add(def);

        JButton mid = new JButton("M");
        mid.setActionCommand(own+"_mid");
        mid.addActionListener(listeners.get(Actions.SWITCH_LINEUPS));
        eastPanel.add(mid);

        JButton frw = new JButton("F");
        frw.setActionCommand(own+"_frw");
        frw.addActionListener(listeners.get(Actions.SWITCH_LINEUPS));
        eastPanel.add(frw);

        JButton left = new JButton("L");
        left.addActionListener(listeners.get(Actions.SWITCH_LINEUPS));
        left.setActionCommand(own+"_left");
        eastPanel.add(left);

        JButton center = new JButton("C");
        center.setActionCommand(own+"_center");
        center.addActionListener(listeners.get(Actions.SWITCH_LINEUPS));
        eastPanel.add(center);

        JButton right = new JButton("R");
        right.setActionCommand(own+"_right");
        right.addActionListener(listeners.get(Actions.SWITCH_LINEUPS));
        eastPanel.add(right);

        tablePanel2.add(eastPanel, BorderLayout.EAST);
        generateLineupsPanel = new JPanel();
        generateLineupsPanel.setLayout(new GridLayout(1,5));
        this.add(generateLineupsPanel, BorderLayout.SOUTH);
        str = new JTextField("20");
        fit = new JTextField("85");
        findLineups = new JButton("find");
        findLineups.setActionCommand(own);
        findLineups.addActionListener(listeners.get(Actions.FIND_LINEUPS));
        formationList = new JList(formations);
        formationList.setLayoutOrientation(JList.VERTICAL);
        formationList.setVisibleRowCount(4);
        JScrollPane listScroller = new JScrollPane(formationList);
        tablePanel2.add(listScroller, BorderLayout.WEST);
        generateLineupsPanel.add(findLineups);

        generateLineupsPanel.add(new JLabel("strengt > "));
        generateLineupsPanel.add(str);
        generateLineupsPanel.add(new JLabel("fitnes > "));
        generateLineupsPanel.add(fit);



    }

    public String[] getFormations(){
        int[] i = formationList.getSelectedIndices();
        String[] out = new String[i.length];
        for (int j = 0; j < i.length; j++){
            out[j] = formations[i[j]];
        }
        return out;
    }

    public Integer getStrength(){
        try {
            return Integer.parseInt(str.getText());
        }
        catch (NumberFormatException e){
            e.printStackTrace();
            System.out.println("Берем ноль!");
            return 0;
        }
    }
    public Integer getFitnes(){
        try {
            return Integer.parseInt(fit.getText());
        }
        catch (NumberFormatException e){
            e.printStackTrace();
            System.out.println("Берем ноль!");
            return 0;
        }
    }

    public void loadData(ArrayList<Player> players){;
        int rows = model1.getRowCount();
        for(int i = rows - 1; i >=0; i--)
        {
            model1.removeRow(i);
        }
        for (Player p: players){
            model1.addRow(new String[] {
                    p.getName(),
                    p.getPosition(),
                    p.getRealStrength().toString(),
                    p.getFitness().toString(),
                    p.getSpecialities() });
        }

    }

    public void setMinStr(){
        this.str.setText(model1.getValueAt(12, 2).toString());
    }

    public void showCount(String count){
        this.totalLineups.setText(count);

    }

    public void disableButton(){
        findLineups.setText("Stop");
        findLineups.removeActionListener(listeners.get(Actions.FIND_LINEUPS));
        findLineups.addActionListener(listeners.get(Actions.STOP));
    }

    public void enableButton(){
        findLineups.setText("Find");
        findLineups.removeActionListener(listeners.get(Actions.STOP));
        findLineups.addActionListener(listeners.get(Actions.FIND_LINEUPS));
    }

    public void loadLineupData(Lineup players, String totalLineups){;
        int rows = model2.getRowCount();
        for(int i = rows - 1; i >=0; i--)
        {
            model2.removeRow(i);
        }
        for (PlayerOnPosition p: players.getPlayers()) {
            model2.addRow(new String[]{
                    p.getPosition().toString(),
                    p.getPlayer().getName(),
                    p.getPredictedStrength().toString(),
                    p.getPlayer().getFitness().toString()+"%",
                    p.getPlayer().getSpecialities()

            });
        }
        model2.addRow(new String[]{
        });
        model2.addRow(new String[]{
                "Leader",
                players.getPlayers().get(players.getLeader()).getPlayer().getName(),
                players.getLeaderBonus().toString()

        });
        model2.addRow(new String[]{
                "Total:",
                "All players" ,
                players.getAllStrength().toString()
        });
        model2.addRow(new String[]{
                "",
                "Defenders" ,
                players.getDefenceLineStrength().toString()
        });
        model2.addRow(new String[]{
                players.getType(),
                "Midfielders" ,
                players.getMidleLineStrength().toString()
        });
        model2.addRow(new String[]{
                "",
                "Forwards" ,
                players.getForwardLineStrength().toString()
        });
        model2.addRow(new String[]{
                "",
                "Left" ,
                players.getLeftLineStrength().toString()
        });
        model2.addRow(new String[]{
                "",
                "Center" ,
                players.getCenterLineStrength().toString()
        });
        model2.addRow(new String[]{
                "",
                "Right" ,
                players.getRightLineStrength().toString()
        });
        if (players.getSubstitutions().size()>0){
            model2.addRow(new String[]{
                    "Substitutions",
                    "" ,
                    ""
            });
        }
        for(Player p: players.getSubstitutions()){
            model2.addRow(new String[]{
                    p.getPosition().toString(),
                    p.getName(),
                    p.getRealStrength().toString(),
                    p.getFitness().toString() + "%("+p.getGames()+")",
                    p.getSpecialities()

            });
        }
        this.totalLineups.setText(totalLineups);

    }
}
