package home.calc.gui;

import home.calc.Lineup;
import home.calc.Player;
import home.calc.PlayerOnPosition;
import home.calc.utils.Actions;
import home.calc.utils.Listeners;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
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
    private String[] columnTitles1 = {"Name(Age/Str)", "Position", "Real Stregth", "Fitnes(moral)", "Specialities", "Can play"};
    private String[] columnTitles2 = {"Position", "Name(Age/Str)", "Real Stregth", "Fitnes(moral)", "Specialities"};
    private JScrollPane tableScrollPane1;
    private JScrollPane tableScrollPane2;
    private DefaultTableModel model1;
    private DefaultTableModel model2;
    private RowSorter<TableModel> sorter;
    private JPanel centerPanel;
    private JPanel generateLineupsPanel;
    private JButton findLineups;
    private JList formationList;
    private String[] formations;
    private JLabel totalLineups;
    private String own;
    private Listeners listeners;
    ArrayList<Player> players;


    public Roster(Listeners listeners, String own) {
        this.listeners = listeners;
        this.own = own;
        formations = new String[]{"7-2-1", "6-3-1", "6-2-2", "5-4-1", "5-3-2", "5-2-3", "4-4-2", "4-5-1", "4-3-3", "3-6-1", "3-5-2", "3-4-3", "3-3-4", "4-2-4", "3-2-5"};
        model1 = new MyTableModel(null, columnTitles1);
        model2 = new DefaultTableModel(null, columnTitles2);

        sorter = new TableRowSorter<TableModel>(model1);
        table1 = new JTable(model1);
        table1.setRowSorter(sorter);
        tableScrollPane1 = new JScrollPane(table1);
        table2 = new JTable(model2);
        tableScrollPane2 = new JScrollPane(table2);

        table1.getModel().addTableModelListener(new TableModelListener() {

            @Override
            public void tableChanged(TableModelEvent e) {
                System.out.println("Changed(" + players.size() + ") " + e.getColumn() + " " + e.getFirstRow() + " - " + e.getLastRow());
                if (e.getColumn() == 5) {
                    players.get(e.getFirstRow()).setCanPlay((Boolean) table1.getModel().getValueAt(e.getFirstRow(), e.getColumn()));
                }
            }
        });

        this.setLayout(new BorderLayout());
        JPanel tablePanel1 = new JPanel();
        JPanel tablePanel2 = new JPanel();
        totalLineups = new JLabel();
        tablePanel1.setLayout(new BorderLayout());
        tablePanel2.setLayout(new BorderLayout());
        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2, 1));
        this.add(centerPanel, BorderLayout.CENTER);

        centerPanel.add(tablePanel1);
        centerPanel.add(tablePanel2);
        tablePanel1.add(table1.getTableHeader(), BorderLayout.PAGE_START);
        tablePanel2.add(table1.getTableHeader(), BorderLayout.PAGE_START);
        tablePanel1.add(tableScrollPane1, BorderLayout.CENTER);
        tablePanel2.add(tableScrollPane2, BorderLayout.CENTER);
        JPanel eastPanel = new JPanel();
        eastPanel.setLayout(new GridLayout(10, 1));
        eastPanel.add(totalLineups);

        JButton first = new JButton("max");
        first.setActionCommand(own + "_first");
        first.addActionListener(listeners.get(Actions.SWITCH_LINEUPS));
        eastPanel.add(first);

        JButton next = new JButton(">");
        next.setActionCommand(own + "_next");
        next.addActionListener(listeners.get(Actions.SWITCH_LINEUPS));
        eastPanel.add(next);

        JButton prev = new JButton("<");
        prev.setActionCommand(own + "_prev");
        prev.addActionListener(listeners.get(Actions.SWITCH_LINEUPS));
        eastPanel.add(prev);

        JButton def = new JButton("D");
        def.setActionCommand(own + "_def");
        def.addActionListener(listeners.get(Actions.SWITCH_LINEUPS));
        eastPanel.add(def);

        JButton mid = new JButton("M");
        mid.setActionCommand(own + "_mid");
        mid.addActionListener(listeners.get(Actions.SWITCH_LINEUPS));
        eastPanel.add(mid);

        JButton frw = new JButton("F");
        frw.setActionCommand(own + "_frw");
        frw.addActionListener(listeners.get(Actions.SWITCH_LINEUPS));
        eastPanel.add(frw);

        JButton left = new JButton("L");
        left.addActionListener(listeners.get(Actions.SWITCH_LINEUPS));
        left.setActionCommand(own + "_left");
        eastPanel.add(left);

        JButton center = new JButton("C");
        center.setActionCommand(own + "_center");
        center.addActionListener(listeners.get(Actions.SWITCH_LINEUPS));
        eastPanel.add(center);

        JButton right = new JButton("R");
        right.setActionCommand(own + "_right");
        right.addActionListener(listeners.get(Actions.SWITCH_LINEUPS));
        eastPanel.add(right);

        tablePanel2.add(eastPanel, BorderLayout.EAST);
        generateLineupsPanel = new JPanel();
        generateLineupsPanel.setLayout(new GridLayout(1, 3));
        this.add(generateLineupsPanel, BorderLayout.SOUTH);
        findLineups = new JButton("find");
        findLineups.setActionCommand(own);
        findLineups.addActionListener(listeners.get(Actions.FIND_LINEUPS));
        formationList = new JList(formations);
        formationList.setLayoutOrientation(JList.VERTICAL);
        formationList.setVisibleRowCount(4);
        JScrollPane listScroller = new JScrollPane(formationList);
        tablePanel2.add(listScroller, BorderLayout.WEST);
        generateLineupsPanel.add(findLineups);
    }

    public void cleanLineup() {
        int rows = model2.getRowCount();
        for (int i = rows - 1; i >= 0; i--) {
            model2.removeRow(i);
        }
    }

    public String[] getFormations() {
        int[] i = formationList.getSelectedIndices();
        String[] out = new String[i.length];
        for (int j = 0; j < i.length; j++) {
            out[j] = formations[i[j]];
        }
        return out;
    }


    public void loadData(ArrayList<Player> players) {
        this.players = players;
        int rows = model1.getRowCount();
        for (int i = rows - 1; i >= 0; i--) {
            model1.removeRow(i);
        }
        for (Player p : this.players) {
            model1.addRow(new Object[]{
                    p.getName() + "(" + p.getAge() + "/" + p.getStrength() + ")",
                    p.getPosition(),
                    p.getRealStrength().toString(),
                    p.getFitness().toString() + "% (" + p.getMoral() + ")",
                    p.getSpecialities(),
                    p.canPlay()
            });
        }

    }


    public void showCount(String count) {
        this.totalLineups.setText(count);

    }

    public void disableButton() {
        findLineups.setText("Stop");
        findLineups.removeActionListener(listeners.get(Actions.FIND_LINEUPS));
        findLineups.addActionListener(listeners.get(Actions.STOP));
    }

    public void enableButton() {
        findLineups.setText("Find");
        findLineups.removeActionListener(listeners.get(Actions.STOP));
        findLineups.addActionListener(listeners.get(Actions.FIND_LINEUPS));
    }

    public void loadLineupData(Lineup players, String totalLineups) {
        ;
        int rows = model2.getRowCount();
        for (int i = rows - 1; i >= 0; i--) {
            model2.removeRow(i);
        }
        for (PlayerOnPosition p : players.getPlayers()) {
            model2.addRow(new String[]{
                    p.getPosition().toString(),
                    p.getPlayer().getName() + "(" + p.getPlayer().getAge() + "/" + p.getPlayer().getStrength() + ")",
                    p.getPredictedStrength().toString(),
                    p.getPlayer().getFitness().toString() + "% (" + p.getPlayer().getMoral() + ")",
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
                "All players",
                players.getAllStrength().toString()
        });
        model2.addRow(new String[]{
                "",
                "Defenders",
                players.getDefenceLineStrength().toString()
        });
        model2.addRow(new String[]{
                players.getType(),
                "Midfielders",
                players.getMidleLineStrength().toString()
        });
        model2.addRow(new String[]{
                "",
                "Forwards",
                players.getForwardLineStrength().toString()
        });
        model2.addRow(new String[]{
                "",
                "Left",
                players.getLeftLineStrength().toString()
        });
        model2.addRow(new String[]{
                "",
                "Center",
                players.getCenterLineStrength().toString()
        });
        model2.addRow(new String[]{
                "",
                "Right",
                players.getRightLineStrength().toString()
        });
        if (players.getSubstitutions().size() > 0) {
            model2.addRow(new String[]{
                    "Substitutions",
                    "",
                    ""
            });
        }
        for (Player p : players.getSubstitutions()) {
            model2.addRow(new String[]{
                    p.getPosition().toString(),
                    p.getName() + "(" + p.getAge() + "/" + p.getStrength() + ")",
                    p.getRealStrength().toString(),
                    p.getFitness().toString() + "% (" + p.getMoral() + ") Games: " + p.getGames(),
                    p.getSpecialities()

            });
        }
        this.totalLineups.setText(totalLineups);

    }
}
