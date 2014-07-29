package home.calc.gui;

import home.calc.Core;
import home.calc.utils.Actions;
import home.calc.utils.Listeners;
import home.calc.utils.Positions;

import javax.swing.*;
import java.awt.*;

/**
 * User: def
 * Date: 5/24/14
 * Time: 1:12 PM
 */
public class UpperPanel extends JPanel {

    public UpperPanel(Core core) {

        this.setLayout(new GridLayout(1, 11));


        for (Positions mode : Positions.values()) {
            JButton positionsReport = new JButton(mode.toString());
            positionsReport.setActionCommand(mode.toString());
            positionsReport.addActionListener(core.getListener(Actions.POSITION_REPORT));
            this.add(positionsReport);
        }

    }
}
