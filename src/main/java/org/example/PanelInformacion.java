package org.example;

import java.awt.*;

import javax.swing.*;

class PanelInformacion extends JPanel {

    private int column1X = 200; // posicion X de columna "desde"
    private int column2X = 520; // posicion X de columna "A"
    private int startY = 180; // posicion Y de ambas columnas

    public PanelInformacion() {
        setLayout(null);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        ButtonGroup buttonGroup2 = new ButtonGroup();

        Destino[] Destinos = Destino.values();
        for (int i = 0; i < Destinos.length; i++) {
            int columnX = (i < 4) ? column1X : column2X;
            int rowY = startY + (i % 4) * 30;

            JRadioButton radioButton = new JRadioButton(Destinos[i].getText());
            radioButton.setBounds(columnX, rowY, 100, 20);
            radioButton.setFocusPainted(false);
            radioButton.setBorderPainted(false);
            radioButton.setOpaque(false);

            if (i < 4) {
                buttonGroup1.add(radioButton);
            } else {
                buttonGroup2.add(radioButton);
            }

            add(radioButton);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1200, 600); // set this to desired width and height
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.lightGray);
        g.fillRect(100, 50, 1000, 500);

        g.setColor(Color.black);
        g.drawString("Detalles de Compra", 130, 100);
        g.setColor(Color.black);
        g.drawString("Desde:", 170, 150);
        g.setColor(Color.black);
        g.drawString("A:", 490, 150);
    }
}
