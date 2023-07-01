package org.example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class PanelComprador extends JPanel implements Observador {
    private Estado estado;
    private JLabel tagTotal;
    private JLabel tagAsientos;
    private JLabel tagTipo;
    private JCheckBox equipajeExtraCheckbox;
    private JButton confirmarButton;
    private JButton finalizarButton;

    public PanelComprador(Estado estado) {
        this.estado = estado;
        tagTotal = new JLabel();
        tagAsientos = new JLabel();
        tagTipo = new JLabel();
        equipajeExtraCheckbox = new JCheckBox("Equipaje Extra");
        confirmarButton = new JButton("Confirmar");
        finalizarButton = new JButton("Finalizar Compra");

        setLayout(null);

        int x = 150;
        tagTotal.setBounds(x, 580, 200, 20);
        tagAsientos.setBounds(x, 380, 200, 20);
        tagTipo.setBounds(x, 430, 200, 20);
        equipajeExtraCheckbox.setBounds(x, 480, 150, 20);
        confirmarButton.setBounds(x, 530, 100, 30);
        finalizarButton.setBounds(x, 630, 150, 30);

        confirmarButton.addActionListener(e -> {
            if (equipajeExtraCheckbox.isSelected()) {
                int pesoMaximo = 30;
                String pesoEquipajeText = JOptionPane.showInputDialog(this, "Ingrese el peso del equipaje extra (kg):");
                try {
                    int pesoEquipaje = Integer.parseInt(pesoEquipajeText);
                    if (pesoEquipaje <= pesoMaximo) {
                        JOptionPane.showMessageDialog(this, "Equipaje extra confirmado. Peso: " + pesoEquipaje + " kg.");
                    } else {
                        JOptionPane.showMessageDialog(this, "El peso del equipaje extra excede el límite permitido de " + pesoMaximo + " kg.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Ingrese un valor numérico válido para el peso del equipaje extra.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "No se llevará equipaje extra.");
            }
        });

        finalizarButton.addActionListener(e -> {
            int precioTotal = estado.getTotal();
            if (precioTotal == 0) {
                JOptionPane.showMessageDialog(this, "Por favor ingrese un itinerario válido");
            } else {
                JOptionPane.showMessageDialog(this, "Precio Total: $" + precioTotal + "\n¡Muchas gracias por su compra!");
            }
        });

        add(tagTotal);
        add(tagAsientos);
        add(tagTipo);
        add(equipajeExtraCheckbox);
        add(confirmarButton);
        add(finalizarButton);
    }

    public void update() {
        tagTotal.setText(String.valueOf(estado.getTotal()));
        tagAsientos.setText(estado.getAsiento());
        tagTipo.setText(estado.getTipo());
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 700);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.lightGray);
        g.fillRect(50, 150, 300, 500);

        g.setColor(Color.black);
        g.drawString("Detalles de Compra", 150, 200);

        g.setColor(Color.black);
        g.drawString("* Destino: ", 70, 300);
        g.setColor(Color.black);
        g.drawString("* Asientos ", 70, 400);

        g.setColor(Color.black);
        g.drawString("* Clase: ", 70, 450);

        g.setColor(Color.black);
        g.drawString("* Equipaje: ", 70, 500);

        g.setColor(Color.black);
        g.drawString("* Total: ", 70, 600);

        tagTotal.setText(String.valueOf(estado.getTotal()));
        tagAsientos.setText(estado.getAsiento());
        tagTipo.setText(estado.getTipo());
        update();
    }
}
