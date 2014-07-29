package home.calc.gui;

import home.calc.Lineup;
import home.calc.PlayerOnPosition;
import home.calc.utils.Positions;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by def on 02.07.14.
 */
public class SchemaFrame extends JFrame {
    private SchemaPanel panel;
    private int sx = 470;
    private int sy = 720;

    public SchemaFrame() {
        this.setTitle("Zones");
        this.setVisible(false);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        this.setPreferredSize(new Dimension(sx, sy));
        Image img = null;
        try {
            img = ImageIO.read(new File("src/resources/pic/football.png"));
        } catch (IOException ex) {
            System.out.println("Loading image error");
            ex.printStackTrace();
        }

        panel = new SchemaPanel(img);
        this.setContentPane(panel);
        this.pack();
    }

    public void showWindow() {
        this.setVisible(true);
    }

    public void loadLineUps(Lineup l1, Lineup l2) {
        panel.loadInfo(l1, l2);
        panel.repaint();
    }

    private class SchemaPanel extends JPanel {
        private Image img;
        private Lineup l1;
        private Lineup l2;

        public SchemaPanel(Image img) {
            this.img = img;
            this.l1 = null;
            this.l2 = null;
        }

        public void loadInfo(Lineup l1, Lineup l2) {
            this.l1 = l1;
            this.l2 = l2;
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(img, 0, 0, null);
            int x = 90;
            int xc = 130;
            int y = 100;
            int flang = 40;
            Color bgClolor = Color.YELLOW;
            Color textColor = Color.BLACK;
            g.setColor(Color.YELLOW);
            boolean haveLineups = false;
            if (l1 != null & l2 != null) {
                int s1 = 0;
                int c1 = 0;
                int s2 = 0;
                int c2 = 0;
                // LF
                g.setColor(bgClolor);
                g.fillRoundRect(sx / 4 - x / 2 - flang, sy / 4 - y / 2, x, y, 15, 15);
                g.setColor(textColor);
                for (PlayerOnPosition p : l1.getPlayersByPosition(Positions.LF)) {
                    s1 = s1 + p.getPredictedStrength();
                    c1++;
                }
                for (PlayerOnPosition p : l2.getPlayersByPosition(Positions.RD)) {
                    s2 = s2 + p.getPredictedStrength();
                    c2++;
                }
                g.setColor(Color.RED);
                g.drawString(c2 > 0 ? c2 + " " + Positions.RD.toString() + " " + s2 : "", sx / 4 - x / 2 - flang + 5, sy / 4 - y / 2 + 45);
                g.setColor(Color.BLUE);
                g.drawString(c1 > 0 ? c1 + " " + Positions.LF.toString() + " " + s1 : "", sx / 4 - x / 2 - flang + 5, sy / 4 - y / 2 + 75);
                if (s1 > s2) {
                    g.setColor(Color.GREEN);
                } else if (s1 < s2) {
                    g.setColor((Color.RED));
                } else g.setColor(Color.BLUE);
                g.fillOval(sx / 4 - x / 2 - flang, sy / 4 - y / 2, 15, 15);
                // CF
                s1 = 0;
                s2 = 0;
                c1 = 0;
                c2 = 0;
                g.setColor(bgClolor);
                g.fillRoundRect(sx / 2 - xc / 2, sy / 4 - y / 2, xc, y, 15, 15);
                g.setColor(textColor);
                for (PlayerOnPosition p : l1.getPlayersByPosition(Positions.CF)) {
                    s1 = s1 + p.getPredictedStrength();
                    c1++;
                }
                for (PlayerOnPosition p : l2.getPlayersByPosition(Positions.CD)) {
                    s2 = s2 + p.getPredictedStrength();
                    c2++;
                }
                ;
                g.setColor(Color.RED);
                g.drawString(c2 > 0 ? c2 + " " + Positions.CD.toString() + " " + s2 : "", sx / 2 - xc / 2 + 5, sy / 4 - y / 2 + 45);
                g.setColor(Color.BLUE);
                g.drawString(c1 > 0 ? c1 + " " + Positions.CF.toString() + " " + s1 : "", sx / 2 - xc / 2 + 5, sy / 4 - y / 2 + 75);
                if (s1 > s2) {
                    g.setColor(Color.GREEN);
                } else if (s1 < s2) {
                    g.setColor((Color.RED));
                } else g.setColor(Color.BLUE);
                g.fillOval(sx / 2 - xc / 2, sy / 4 - y / 2, 15, 15);
                // RF
                s1 = 0;
                s2 = 0;
                c1 = 0;
                c2 = 0;
                g.setColor(bgClolor);
                g.fillRoundRect(sx * 3 / 4 - x / 2 + flang, sy / 4 - y / 2, x, y, 15, 15);
                g.setColor(textColor);
                for (PlayerOnPosition p : l1.getPlayersByPosition(Positions.RF)) {
                    s1 = s1 + p.getPredictedStrength();
                    c1++;
                }
                for (PlayerOnPosition p : l2.getPlayersByPosition(Positions.LD)) {
                    s2 = s2 + p.getPredictedStrength();
                    c2++;
                }
                ;
                g.setColor(Color.RED);
                g.drawString(c2 > 0 ? c2 + " " + Positions.LD.toString() + " " + s2 : "", sx * 3 / 4 - x / 2 + flang + 5, sy / 4 - y / 2 + 45);
                g.setColor(Color.BLUE);
                g.drawString(c1 > 0 ? c1 + " " + Positions.RF.toString() + " " + s1 : "", sx * 3 / 4 - x / 2 + flang + 5, sy / 4 - y / 2 + 75);
                if (s1 > s2) {
                    g.setColor(Color.GREEN);
                } else if (s1 < s2) {
                    g.setColor((Color.RED));
                } else g.setColor(Color.BLUE);
                g.fillOval(sx * 3 / 4 - x / 2 + flang, sy / 4 - y / 2, 15, 15);
                // LM
                s1 = 0;
                s2 = 0;
                c1 = 0;
                c2 = 0;
                g.setColor(bgClolor);
                g.fillRoundRect(sx / 4 - x / 2 - flang, sy / 2 - y / 2, x, y, 15, 15);
                g.setColor(textColor);
                for (PlayerOnPosition p : l1.getPlayersByPosition(Positions.LM)) {
                    s1 = s1 + p.getPredictedStrength();
                    c1++;
                }
                for (PlayerOnPosition p : l2.getPlayersByPosition(Positions.RM)) {
                    s2 = s2 + p.getPredictedStrength();
                    c2++;
                }
                ;
                g.setColor(Color.RED);
                g.drawString(c2 > 0 ? c2 + " " + Positions.RM.toString() + " " + s2 : "", sx / 4 - x / 2 - flang + 5, sy / 2 - y / 2 + 45);
                g.setColor(Color.BLUE);
                g.drawString(c1 > 0 ? c1 + " " + Positions.LM.toString() + " " + s1 : "", sx / 4 - x / 2 - flang + 5, sy / 2 - y / 2 + 75);
                if (s1 > s2) {
                    g.setColor(Color.GREEN);
                } else if (s1 < s2) {
                    g.setColor((Color.RED));
                } else g.setColor(Color.BLUE);
                g.fillOval(sx / 4 - x / 2 - flang, sy / 2 - y / 2, 15, 15);
                // CM
                s1 = 0;
                s2 = 0;
                c1 = 0;
                c2 = 0;
                g.setColor(bgClolor);
                g.fillRoundRect(sx / 2 - xc / 2, sy / 2 - y / 2, xc, y, 15, 15);
                g.setColor(textColor);
                for (PlayerOnPosition p : l1.getPlayersByPosition(Positions.CM)) {
                    s1 = s1 + p.getPredictedStrength();
                    c1++;
                }
                for (PlayerOnPosition p : l2.getPlayersByPosition(Positions.CM)) {
                    s2 = s2 + p.getPredictedStrength();
                    c2++;
                }
                ;
                g.setColor(Color.RED);
                g.drawString(c2 > 0 ? c2 + " " + Positions.CM.toString() + " " + s2 : "", sx / 2 - xc / 2 + 5, sy / 2 - y / 2 + 45);
                g.setColor(Color.BLUE);
                g.drawString(c1 > 0 ? c1 + " " + Positions.CM.toString() + " " + s1 : "", sx / 2 - xc / 2 + 5, sy / 2 - y / 2 + 75);
                if (s1 > s2) {
                    g.setColor(Color.GREEN);
                } else if (s1 < s2) {
                    g.setColor((Color.RED));
                } else g.setColor(Color.BLUE);
                g.fillOval(sx / 2 - xc / 2, sy / 2 - y / 2, 15, 15);
                // RM
                s1 = 0;
                s2 = 0;
                c1 = 0;
                c2 = 0;
                g.setColor(bgClolor);
                g.fillRoundRect(sx * 3 / 4 - x / 2 + flang, sy / 2 - y / 2, x, y, 15, 15);
                g.setColor(textColor);
                for (PlayerOnPosition p : l1.getPlayersByPosition(Positions.RM)) {
                    s1 = s1 + p.getPredictedStrength();
                    c1++;
                }
                for (PlayerOnPosition p : l2.getPlayersByPosition(Positions.LM)) {
                    s2 = s2 + p.getPredictedStrength();
                    c2++;
                }
                ;
                g.setColor(Color.RED);
                g.drawString(c2 > 0 ? c2 + " " + Positions.LM.toString() + " " + s2 : "", sx * 3 / 4 - x / 2 + flang + 5, sy / 2 - y / 2 + 45);
                g.setColor(Color.BLUE);
                g.drawString(c1 > 0 ? c1 + " " + Positions.RM.toString() + " " + s1 : "", sx * 3 / 4 - x / 2 + flang + 5, sy / 2 - y / 2 + 75);
                if (s1 > s2) {
                    g.setColor(Color.GREEN);
                } else if (s1 < s2) {
                    g.setColor((Color.RED));
                } else g.setColor(Color.BLUE);
                g.fillOval(sx * 3 / 4 - x / 2 + flang, sy / 2 - y / 2, 15, 15);

                // LD
                s1 = 0;
                s2 = 0;
                c1 = 0;
                c2 = 0;
                g.setColor(bgClolor);
                g.fillRoundRect(sx / 4 - x / 2 - flang, sy * 3 / 4 - y / 2, x, y, 15, 15);
                g.setColor(textColor);
                for (PlayerOnPosition p : l1.getPlayersByPosition(Positions.LD)) {
                    s1 = s1 + p.getPredictedStrength();
                    c1++;
                }
                for (PlayerOnPosition p : l2.getPlayersByPosition(Positions.RF)) {
                    s2 = s2 + p.getPredictedStrength();
                    c2++;
                }
                ;
                g.setColor(Color.RED);
                g.drawString(c2 > 0 ? c2 + " " + Positions.RF.toString() + " " + s2 : "", sx / 4 - x / 2 - flang + 5, sy * 3 / 4 - y / 2 + 45);
                g.setColor(Color.BLUE);
                g.drawString(c1 > 0 ? c1 + " " + Positions.LD.toString() + " " + s1 : "", sx / 4 - x / 2 - flang + 5, sy * 3 / 4 - y / 2 + 75);
                if (s1 > s2) {
                    g.setColor(Color.GREEN);
                } else if (s1 < s2) {
                    g.setColor((Color.RED));
                } else g.setColor(Color.BLUE);
                g.fillOval(sx / 4 - x / 2 - flang, sy * 3 / 4 - y / 2, 15, 15);

                // CD
                s1 = 0;
                s2 = 0;
                c1 = 0;
                c2 = 0;
                g.setColor(bgClolor);
                g.fillRoundRect(sx / 2 - xc / 2, sy * 3 / 4 - y / 2, xc, y, 15, 15);
                g.setColor(textColor);
                for (PlayerOnPosition p : l1.getPlayersByPosition(Positions.CD)) {
                    s1 = s1 + p.getPredictedStrength();
                    c1++;
                }
                for (PlayerOnPosition p : l2.getPlayersByPosition(Positions.CF)) {
                    s2 = s2 + p.getPredictedStrength();
                    c2++;
                }
                ;
                g.setColor(Color.RED);
                g.drawString(c2 > 0 ? c2 + " " + Positions.CF.toString() + " " + s2 : "", sx / 2 - xc / 2 + 5, sy * 3 / 4 - y / 2 + 45);
                g.setColor(Color.BLUE);
                g.drawString(c1 > 0 ? c1 + " " + Positions.CD.toString() + " " + s1 : "", sx / 2 - xc / 2 + 5, sy * 3 / 4 - y / 2 + 75);
                if (s1 > s2) {
                    g.setColor(Color.GREEN);
                } else if (s1 < s2) {
                    g.setColor((Color.RED));
                } else g.setColor(Color.BLUE);
                g.fillOval(sx / 2 - xc / 2, sy * 3 / 4 - y / 2, 15, 15);
                // RD
                s1 = 0;
                s2 = 0;
                c1 = 0;
                c2 = 0;
                g.setColor(bgClolor);
                g.fillRoundRect(sx * 3 / 4 - x / 2 + flang, sy * 3 / 4 - y / 2, x, y, 15, 15);
                g.setColor(textColor);
                for (PlayerOnPosition p : l1.getPlayersByPosition(Positions.RD)) {
                    s1 = s1 + p.getPredictedStrength();
                    c1++;
                }
                for (PlayerOnPosition p : l2.getPlayersByPosition(Positions.LF)) {
                    s2 = s2 + p.getPredictedStrength();
                    c2++;
                }
                ;
                g.setColor(Color.RED);
                g.drawString(c2 > 0 ? c2 + " " + Positions.LF.toString() + " " + s2 : "", sx * 3 / 4 - x / 2 + flang + 5, sy * 3 / 4 - y / 2 + 45);
                g.setColor(Color.BLUE);
                g.drawString(c1 > 0 ? c1 + " " + Positions.RD.toString() + " " + s1 : "", sx * 3 / 4 - x / 2 + flang + 5, sy * 3 / 4 - y / 2 + 75);
                if (s1 > s2) {
                    g.setColor(Color.GREEN);
                } else if (s1 < s2) {
                    g.setColor((Color.RED));
                } else g.setColor(Color.BLUE);
                g.fillOval(sx * 3 / 4 - x / 2 + flang, sy * 3 / 4 - y / 2, 15, 15);

                g.setColor(bgClolor);
                g.fillRoundRect(sx / 2 - x / 2, sy - y, x, y / 2, 15, 15);
                g.fillRoundRect(sx / 2 - x / 2, 5, x, y / 2, 15, 15);
                g.setColor(textColor);
                s1 = l1.getPlayersByPosition(Positions.GK).get(0).getPredictedStrength();
                s2 = l2.getPlayersByPosition(Positions.GK).get(0).getPredictedStrength();
                g.setColor(Color.BLUE);
                g.drawString(Positions.GK.toString() + " " + s1, sx / 2 - x / 2 + 10, sy - y + 30);
                g.setColor(Color.RED);
                g.drawString(Positions.GK.toString() + " " + s2, sx / 2 - x / 2 + 10, 5 + 30);

            }
        }

        public void setData() {

        }

    }
}
