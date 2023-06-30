package org.example;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

class PanelBus extends JPanel {
    ListaDeAsientos listaDeAsientos;
    private int rectangleX = 180;
    private int rectangleY = 320;
    private int rectangleWidth = 750;
    private int rectangleHeight = 200;

    public PanelBus(Estado Estado) {
        setLayout(null);

        listaDeAsientos = new ListaDeAsientos(Estado); // Pass Estado here
        for(JButton asiento : listaDeAsientos.getAsiento()) {
            add(asiento);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1200, 800);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.gray);
        g.fillRect(rectangleX, rectangleY, rectangleWidth, rectangleHeight);

        g.setColor(Color.white);
        g.drawString("Bus", 550, 430);

        g.setColor(Color.black);
        Font myFont = new Font("Arial", Font.PLAIN, 20);
    }
}
