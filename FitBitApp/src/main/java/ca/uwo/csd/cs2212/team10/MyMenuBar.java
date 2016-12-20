package ca.uwo.csd.cs2212.team10;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JMenuBar;

public class MyMenuBar extends JMenuBar {

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(87, 87, 87));
       

        g2d.fillRect(0, 0, getWidth() - 1, getHeight() - 1);

    }

}
