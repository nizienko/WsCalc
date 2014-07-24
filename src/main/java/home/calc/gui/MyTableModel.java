package home.calc.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Created by def on 23.07.14.
 */
public class MyTableModel extends DefaultTableModel {

    public MyTableModel(Object[][] o, String[] columnTitles1) {
        super(o, columnTitles1);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class c = String.class;
        if (columnIndex == 5) {
            c = Boolean.class;
        }
        return c;
    }
}
