package org.example;

import java.awt.*;

import javax.swing.JPanel;

class PanelComprador extends JPanel {

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
        g.drawString("* Pasajes: ", 70, 350);

        g.setColor(Color.black);
        g.drawString("* Equipaje: ", 70, 400);

        g.setColor(Color.black);
        g.drawString("* Total: ", 70, 600);

    }
}
