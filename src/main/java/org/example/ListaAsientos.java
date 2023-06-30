package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class ListaAsientos {
    private List<JButton> asientos = new ArrayList<>();

    public ListaAsientos() {
        int rectangleX = 180;
        int rectangleY = 320;
        for (int i = 0; i < 16; i++) {
            JButton asiento = new JButton(String.valueOf(i + 1));
            setupButton(asiento, rectangleX + (i % 8) * 90, rectangleY + (i / 8) * 150);
            asientos.add(asiento);
        }
    }

    private void setupButton(JButton button, int x, int y) {
        button.setBounds(x, y, 80, 50);
        button.setBackground(Color.GREEN);
        button.addActionListener(e -> {
            if (button.getBackground() == Color.GREEN) {
                button.setBackground(Color.ORANGE);
            } else {
                button.setBackground(Color.GREEN);
            }
        });
    }

    public List<JButton> getAsientos() {
        return asientos;
    }
}