package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Clase que representa una lista de asientos disponibles en un autobús.
 * Contiene una lista de botones de asiento y una lista de objetos Asiento asociados.
 * También se encarga de actualizar los valores de los asientos según el origen y destino especificados.
 */
class ListaDeAsientos {
    private List<JButton> asientos = new ArrayList<>();
    private List<Asiento> informacionAsientos = new ArrayList<>();
    private Estado estado;

    
    /**
     * Crea una nueva instancia de ListaDeAsientos con el estado especificado.
     * @param estado El estado del sistema de reservas de asientos.
     */
    public ListaDeAsientos(Estado estado) {
        this.estado = estado;
        int rectangleX = 180;
        int rectangleY = 10;
        for (int i = 0; i < 16; i++) {
            Asiento asientoInfo = (i < 8) ? new AsientoPremium() : new AsientoNormal();
            asientoInfo.setNumero(i + 1);
            informacionAsientos.add(asientoInfo);

            JButton asiento = new JButton(String.valueOf(i + 1));
            setupBoton(asiento, rectangleX + (i % 8) * 90, rectangleY + (i / 8) * 150, asientoInfo);
            asientos.add(asiento);
        }
    }
    
    
    /**
     * Configura un botón de asiento con la posición, tamaño y el objeto Asiento asociado.
     * @param button      El botón de asiento a configurar.
     * @param x           La posición X del botón.
     * @param y           La posición Y del botón.
     * @param asientoInfo El objeto Asiento asociado al botón.
     */
    private void setupBoton(JButton button, int x, int y, Asiento asientoInfo) {
        button.setBounds(x, y, 80, 50);
        button.setBackground(Color.GREEN);
        button.addActionListener(e -> {
            if (button.getBackground() == Color.GREEN) {
                button.setBackground(Color.ORANGE);
                estado.agregarAsiento(asientoInfo);
            } else {
                button.setBackground(Color.GREEN);
                estado.removerAsiento(asientoInfo);
            }
            SwingUtilities.getWindowAncestor(button).repaint();
        });
    }

    /**
     * Actualiza los valores de los asientos según el origen y destino especificados.
     * @param origen  El origen del viaje.
     * @param destino El destino del viaje.
     */
    public void ActualizarValoresAsientos(String origen, String destino) {
        for (Asiento asiento : informacionAsientos) {
            if (asiento instanceof AsientoNormal) {
                ((AsientoNormal) asiento).setValor(origen, destino);
            } else {
                ((AsientoPremium) asiento).setValor(origen, destino);
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