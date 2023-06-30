package org.example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class PanelComprador extends JPanel implements Observer {
    private Estado Estado;
    private JLabel tagTotal;
    private JLabel tagAsientos;
    private JLabel tagTipo;
    private JCheckBox equipajeExtraCheckbox;
    private JButton confirmarButton;
    private JButton finalizarButton;


    public PanelComprador(Estado Estado){
        this.Estado = Estado;
        tagTotal = new JLabel();
        tagAsientos = new JLabel();
        tagTipo = new JLabel();
        equipajeExtraCheckbox = new JCheckBox("Equipaje Extra");
        confirmarButton = new JButton("Confirmar");
        finalizarButton = new JButton("Finalizar Compra");

        setLayout(null);

        tagTotal.setBounds(150, 580, 200, 20);
        tagAsientos.setBounds(150, 380, 200, 20);
        tagTipo.setBounds(150, 430, 200, 20);
        equipajeExtraCheckbox.setBounds(150, 480, 150, 20);
        confirmarButton.setBounds(150, 530, 100, 30);
        finalizarButton.setBounds(150, 630, 150, 30);

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (equipajeExtraCheckbox.isSelected()) {
                    int pesoMaximo = 30;

                    String pesoEquipajeText = JOptionPane.showInputDialog(PanelComprador.this, "Ingrese el peso del equipaje extra (kg):");
                    try {
                        int pesoEquipaje = Integer.parseInt(pesoEquipajeText);
                        if (pesoEquipaje <= pesoMaximo) {
                            // El peso del equipaje extra es válido, realizar las acciones correspondientes
                            // Por ejemplo, mostrar un mensaje de confirmación
                            JOptionPane.showMessageDialog(PanelComprador.this, "Equipaje extra confirmado. Peso: " + pesoEquipaje + " kg.");
                        } else {
                            // El peso del equipaje extra excede el límite permitido
                            JOptionPane.showMessageDialog(PanelComprador.this, "El peso del equipaje extra excede el límite permitido de " + pesoMaximo + " kg.");
                        }
                    } catch (NumberFormatException ex) {
                        // El valor ingresado no es numérico
                        JOptionPane.showMessageDialog(PanelComprador.this, "Ingrese un valor numérico válido para el peso del equipaje extra.");
                    }
                } else {
                    // Lógica para cuando no se lleva equipaje extra
                    // Por ejemplo, mostrar un mensaje de confirmación de no llevar equipaje extra
                    JOptionPane.showMessageDialog(PanelComprador.this, "No se llevará equipaje extra.");
                }
            }
        });
        finalizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int precioTotal = Estado.getTotal();
                JOptionPane.showMessageDialog(PanelComprador.this, "Precio Total: $" + precioTotal + "\n¡Muchas gracias por su compra!");
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
        tagTotal.setText(String.valueOf(Estado.getTotal()));
        tagAsientos.setText(Estado.getAsiento());
        tagTipo.setText(Estado.getTipo());

    }
    public Dimension getPreferredSize(){
        return new Dimension(400,700);
    }
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.lightGray);
        g.fillRect(50,150,300,500);

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

        tagTotal.setText(String.valueOf(Estado.getTotal()));
        tagAsientos.setText(Estado.getAsiento());
        tagTipo.setText(Estado.getTipo());
        update();
    }
}
