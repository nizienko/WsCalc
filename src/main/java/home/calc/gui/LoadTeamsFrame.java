package home.calc.gui;

import home.calc.utils.Actions;
import home.calc.utils.Listeners;

import javax.swing.*;
import java.awt.*;
/**
 * User: def
 * Date: 5/23/14
 * Time: 10:45 PM
 */
public class LoadTeamsFrame extends JFrame {
    private JTextField team1;
    private JTextField team2;
    public LoadTeamsFrame(Listeners listeners) {
        this.setTitle("Load teams");
        this.setVisible(false);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setPreferredSize(new Dimension(300, 100));
        JPanel panel = new JPanel();
        this.setContentPane(panel);
        team1 = new JTextField("/home/def/test.php");
        team2 = new JTextField("/home/def/test2.php");
        JButton load = new JButton("Load");
        panel.setLayout(new GridLayout(3,2));
        panel.add(new JLabel("My team"));
        panel.add(team1);
        panel.add(new JLabel("Opponent"));
        panel.add(team2);
        panel.add(new JLabel());
        panel.add(load);
        load.addActionListener(listeners.get(Actions.LOAD_TEAMS));
        this.pack();

    }

    public String getMyTeamUrl() {
        return team1.getText();
    }

    public String getOpponentTeamUrl() {
        return team2.getText();
    }

}
