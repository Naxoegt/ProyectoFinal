package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class ListaDeAsientos {
    private List<JButton> asientos = new ArrayList<>();
    private List<Asiento> informacionAsientos = new ArrayList<>();
    private Estado Estado;

    public ListaDeAsientos(Estado Estado) {
        this.Estado = Estado;
        int rectangleX = 180;
        int rectangleY = 10;
        for (int i = 0; i < 16; i++) {
            Asiento asientoInfo;
            if (i < 8) {
                asientoInfo = new AsientoPremium();
            } else {
                asientoInfo = new AsientoNormal();
            }
            asientoInfo.setNumero(i + 1);
            informacionAsientos.add(asientoInfo);

            JButton asiento = new JButton(String.valueOf(i + 1));
            setupButton(asiento, rectangleX + (i % 8) * 90, rectangleY + (i / 8) * 150, asientoInfo);
            asientos.add(asiento);
        }
    }

    private void setupButton(JButton button, int x, int y, Asiento asientoInfo) {
        button.setBounds(x, y, 80, 50);
        button.setBackground(Color.GREEN);
        button.addActionListener(e -> {
            if (button.getBackground() == Color.GREEN) {
                button.setBackground(Color.ORANGE);
                Estado.agregarAsiento(asientoInfo);
            } else {
                button.setBackground(Color.GREEN);
                Estado.removerAsiento(asientoInfo);
            }
            SwingUtilities.getWindowAncestor(button).repaint(); // add this line
        });
    }

    public void updateSeatValues(String origin, String destination) {
        for (Asiento asiento : informacionAsientos) {
            if (asiento instanceof AsientoNormal) {
                ((AsientoNormal) asiento).setValor(origin, destination);
            } else {
                ((AsientoPremium) asiento).setValor(origin, destination);
            }
        }
    }


    public List<JButton> getAsiento() {
        return asientos;
    }

    public List<Asiento> getInformacionAsientos() {
        return informacionAsientos;
    }
}