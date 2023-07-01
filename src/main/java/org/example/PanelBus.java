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
    private int rectangleY = 10;
    private int rectangleWidth = 750;
    private int rectangleHeight = 200;

    public PanelBus(Estado estado) {
        setLayout(null);

        listaDeAsientos = new ListaDeAsientos(estado);
        listaDeAsientos.getAsiento().forEach(this::add);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1200, 450);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.gray);
        g.fillRect(rectangleX, rectangleY, rectangleWidth, rectangleHeight);

        g.setColor(Color.white);
        g.drawString("Bus", 550, 120);
    }
}

