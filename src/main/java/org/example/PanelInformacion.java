package org.example;

import java.awt.*;

import javax.swing.*;

class PanelInformacion extends JPanel {

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1200, 600); // set this to desired width and height
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.black);
        g.drawRect(0,0,1000,500); // set this to the same size as above
    }
}
