package org.example;

import java.awt.*;

import javax.swing.*;

class PanelComprador extends JPanel implements Observer {
    private Estado Estado;
    private JLabel tagTotal;
    private JLabel tagAsientos;
    private JLabel tagTipo;

    public PanelComprador(Estado Estado){
        this.Estado = Estado;
        tagTotal = new JLabel();
        tagAsientos = new JLabel();
        tagTipo = new JLabel();

        setLayout(null);

        tagTotal.setBounds(150, 580, 200, 20);
        tagAsientos.setBounds(150, 380, 200, 20);
        tagTipo.setBounds(150, 430, 200, 20);

        add(tagTotal);
        add(tagAsientos);
        add(tagTipo);
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
