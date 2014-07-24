package home.calc.gui;

import home.calc.Lineup;
import home.calc.RosterContent;
import home.calc.utils.Actions;
import home.calc.utils.Listeners;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


/**
 * User: def
 * Date: 5/23/14
 * Time: 9:08 PM
 */
public class MainWindow extends JFrame {
    private JMenuBar menuBar;
    private JMenu menuTeam;
    private JMenuItem loadTeams;
    private JMenuItem compareTeams;
    private JMenuItem schema;

    private LoadTeamsFrame loadTeamsFrame;
    private CompareInfoFrame compareInfoFrame;
    private SchemaFrame schemaFrame;
    private JPanel mainPanel;
    private JPanel centerPanel;
    private Roster myTeamRoster;
    private Roster opponentRoster;
    private UpperPanel upperPanel;

    public MainWindow(Listeners listeners) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setDefaultLookAndFeelDecorated(false);
        this.setPreferredSize(new Dimension(900, 700));
        this.setTitle("wifa calculator");


        menuBar = new JMenuBar();
        menuTeam = new JMenu("Team");
        menuTeam.setMnemonic(KeyEvent.VK_T);
        menuTeam.getAccessibleContext().setAccessibleDescription("Load teams");
        menuBar.add(menuTeam);
        loadTeams = new JMenuItem("Load teams", KeyEvent.VK_L);
        compareTeams = new JMenuItem("Compare teams", KeyEvent.VK_C);
        schema = new JMenuItem("Schema", KeyEvent.VK_S);
        menuTeam.add(loadTeams);
        menuTeam.add(compareTeams);
        menuTeam.add(schema);

        compareTeams.addActionListener(listeners.get(Actions.COMPARE_TEAMS));
        loadTeamsFrame = new LoadTeamsFrame(listeners);
        schemaFrame = new SchemaFrame();
        compareInfoFrame = new CompareInfoFrame();
        loadTeams.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadTeamsFrame.setVisible(true);
            }
        });
        schema.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                schemaFrame.setVisible(true);
            }
        });


        upperPanel = new UpperPanel(listeners);
        upperPanel.setVisible(false);
        this.setJMenuBar(menuBar);
        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(1, 2));
        myTeamRoster = new Roster(listeners, "my");
        opponentRoster = new Roster(listeners, "his");
        centerPanel.add(myTeamRoster);
        centerPanel.add(opponentRoster);
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(upperPanel, BorderLayout.NORTH);

        this.setContentPane(mainPanel);

        this.pack();
        this.setVisible(true);
    }

    public void hideLoadFrame() {
        loadTeamsFrame.setVisible(false);
        upperPanel.setVisible(true);
    }

    public String getMyTeamUrl() {
        return loadTeamsFrame.getMyTeamUrl();
    }

    public String getOpponentTeamUrl() {
        return loadTeamsFrame.getOpponentTeamUrl();
    }

    public void showRosters(RosterContent rosters) {
        myTeamRoster.loadData(rosters.getMyPlayers());
        opponentRoster.loadData(rosters.getOpponentPlayers());
    }

    public void showCompareWindow() {
        compareInfoFrame.showWindow();
    }

    public void loadCompareInfo(Lineup l1, Lineup l2) {
        compareInfoFrame.showInfo(l1, l2);
        schemaFrame.loadLineUps(l1, l2);
    }

    public void showLineup(Lineup lineup, String totalLineups, String own) {
        if (own.equals("my")) {
            myTeamRoster.loadLineupData(lineup, totalLineups);
        } else if (own.equals("his")) {
            opponentRoster.loadLineupData(lineup, totalLineups);
        }
    }

    public void cleanLineup(String own) {
        if (own.equals("my")) {
            myTeamRoster.cleanLineup();
        } else if (own.equals("his")) {
            opponentRoster.cleanLineup();
        }
    }


    public String[] getFormations(String own) {
        if (own.equals("my")) {
            return myTeamRoster.getFormations();
        } else if (own.equals("his")) {
            return opponentRoster.getFormations();
        } else {
            return null;
        }
    }

    public Roster getRoster(String own) {
        if (own.equals("my")) {
            return myTeamRoster;
        } else if (own.equals("his")) {
            return opponentRoster;
        } else return null;
    }
}
