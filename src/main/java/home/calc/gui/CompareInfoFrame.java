package home.calc.gui;

import home.calc.Lineup;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: def
 * Date: 01.06.14
 * Time: 1:26
 * To change this template use File | Settings | File Templates.
 */
public class CompareInfoFrame extends JFrame {
    private JTable table1;
    private String[] columnTitles1 = { "My", "Descripton", "His" };
    private JScrollPane tableScrollPane1;
    private DefaultTableModel model1;
    private RowSorter<TableModel> sorter;

    public CompareInfoFrame(){
        this.setTitle("Comparing");
        this.setVisible(false);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setPreferredSize(new Dimension(400, 300));
        JPanel panel = new JPanel();
        model1 = new DefaultTableModel(null, columnTitles1);
        table1 = new JTable(model1);
        sorter = new TableRowSorter<TableModel>(model1);
        table1.setRowSorter(sorter);
        panel.setLayout(new BorderLayout());
        panel.add(table1.getTableHeader(), BorderLayout.PAGE_START);
        panel.add(table1, BorderLayout.CENTER);
        this.setContentPane(panel);
        this.pack();

    }

    public void showWindow(){
        this.setVisible(true);
    }



    public void showInfo(Lineup l1, Lineup l2){
        int rows = model1.getRowCount();
        for(int i = rows - 1; i >=0; i--)
        {
            model1.removeRow(i);
        }
        model1.addRow(new String[]{
                l1.getType(),
                "formation",
                l2.getType()
        });
        model1.addRow(new String[]{
                l1.getAllStrength()+"("+(l1.getAllStrength()-l2.getAllStrength())+")",
                "all players",
                l2.getAllStrength()+"("+(l2.getAllStrength()-l1.getAllStrength())+")",
        });
        model1.addRow(new String[]{
                l1.getDefenceLineStrength()+"("+(l1.getDefenceLineStrength()-l2.getDefenceLineStrength())+")",
                "defenders",
                l2.getDefenceLineStrength()+"("+(l2.getDefenceLineStrength()-l1.getDefenceLineStrength())+")",
        });
        model1.addRow(new String[]{
                l1.getDefenceLineStrength()+"("+(l1.getDefenceLineStrength()-l2.getForwardLineStrength())+")",
                "defenders vs forwards",
                l2.getDefenceLineStrength()+"("+(l2.getDefenceLineStrength()-l1.getForwardLineStrength())+")",
        });
        model1.addRow(new String[]{
                l1.getMidleLineStrength()+"("+(l1.getMidleLineStrength()-l2.getMidleLineStrength())+")",
                "midfielders",
                l2.getMidleLineStrength()+"("+(l2.getMidleLineStrength()-l1.getMidleLineStrength())+")",
        });
        model1.addRow(new String[]{
                l1.getForwardLineStrength()+"("+(l1.getForwardLineStrength()-l2.getForwardLineStrength())+")",
                "forwards",
                l2.getForwardLineStrength()+"("+(l2.getForwardLineStrength()-l1.getForwardLineStrength())+")",
        });
        model1.addRow(new String[]{
                l1.getForwardLineStrength()+"("+(l1.getForwardLineStrength()-l2.getDefenceLineStrength())+")",
                "forwards vs defenders",
                l2.getForwardLineStrength()+"("+(l2.getForwardLineStrength()-l1.getDefenceLineStrength())+")",
        });
        model1.addRow(new String[]{
                l1.getLeftLineStrength()+"("+(l1.getLeftLineStrength()-l2.getRightLineStrength())+")",
                "left vs right",
                l2.getLeftLineStrength()+"("+(l2.getLeftLineStrength()-l1.getRightLineStrength())+")",
        });
        model1.addRow(new String[]{
                l1.getCenterLineStrength()+"("+(l1.getCenterLineStrength()-l2.getCenterLineStrength())+")",
                "center",
                l2.getCenterLineStrength()+"("+(l2.getCenterLineStrength()-l1.getCenterLineStrength())+")",
        });
        model1.addRow(new String[]{
                l1.getRightLineStrength()+"("+(l1.getRightLineStrength()-l2.getLeftLineStrength())+")",
                "right vs left",
                l2.getRightLineStrength()+"("+(l2.getRightLineStrength()-l1.getLeftLineStrength())+")",
        });


    }
}
