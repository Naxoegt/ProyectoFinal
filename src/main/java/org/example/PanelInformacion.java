package org.example;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

class PanelInformacion extends JPanel {


    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.black);
        g.drawRect(0,0,500,300);
        
        
    }
}