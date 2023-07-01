package org.example;

import java.awt.*;

import javax.swing.*;

public class PanelInformacion extends JPanel {
    private String origin = "";
    private String destination = "";
    private ListaDeAsientos listaDeAsientos;

    private int column1X = 200;
    private int column2X = 520;
    private int startY = 180;

    public PanelInformacion(ListaDeAsientos listaDeAsientos) {
        this.listaDeAsientos = listaDeAsientos;
        setLayout(null);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        ButtonGroup buttonGroup2 = new ButtonGroup();

        Destino[] destinos = Destino.values();
        for (int i = 0; i < destinos.length; i++) {
            int columnX = (i < 4) ? column1X : column2X;
            int rowY = startY + (i % 4) * 30;

            JRadioButton radioButton = new JRadioButton(destinos[i].getText());
            radioButton.setBounds(columnX, rowY, 100, 20);
            radioButton.setFocusPainted(false);
            radioButton.setBorderPainted(false);
            radioButton.setOpaque(false);

            if (i < 4) {
                buttonGroup1.add(radioButton);
            } else {
                buttonGroup2.add(radioButton);
            }

            int finalI = i;
            radioButton.addActionListener(e -> {
                if (finalI < 4) {
                    origin = destinos[finalI].getText();
                } else {
                    destination = destinos[finalI].getText();
                }
                if (!origin.isEmpty() && !destination.isEmpty()) {
                    listaDeAsientos.ActualizarValoresAsientos(origin, destination);
                }
            });

            add(radioButton);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1200, 600);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.lightGray);
        g.fillRect(100, 50, 1000, 500);

        g.setColor(Color.black);
        g.drawString("Detalles de Compra", 130, 100);
        g.setColor(Color.black);
        g.drawString("Origen:", 170, 150);
        g.setColor(Color.black);
        g.drawString("Destino:", 490, 150);
    }
}