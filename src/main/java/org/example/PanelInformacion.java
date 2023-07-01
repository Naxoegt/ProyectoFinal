package org.example;

import java.awt.*;

import javax.swing.*;
/**
 * Clase que representa un panel que muestra información sobre el itinerario de viaje,
 * incluyendo el origen, destino y la lista de asientos disponibles.
 */
class PanelInformacion extends JPanel {
    private String origen = "";
    private String destino = "";
    private ListaDeAsientos listaDeAsientos;
    private Estado estado;

    private int column1X = 200;
    private int column2X = 520;
    private int startY = 180;
    /**
     * Crea un nuevo PanelInformacion con la lista de asientos y el estado proporcionados, y configura
     * el diseño del panel.
     * @param listaDeAsientos La lista de asientos disponibles.
     * @param estado          El estado actual del sistema.
     */
    public PanelInformacion(ListaDeAsientos listaDeAsientos, Estado estado) {
        this.listaDeAsientos = listaDeAsientos;
        this.estado = estado;
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
                    origen = destinos[finalI].getText();
                    estado.setOrigen(origen);
                } else {
                    destino = destinos[finalI].getText();
                    estado.setDestino(destino);
                }

                if (!origen.isEmpty() && !destino.isEmpty()) {
                    listaDeAsientos.ActualizarValoresAsientos(origen, destino);
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
        g.drawString("Desde:", 170, 150);
        g.setColor(Color.black);
        g.drawString("A:", 490, 150);
    }
}