package org.example;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Ventana ventana = new Ventana();
    }
}

class Ventana extends JFrame {
    public Ventana() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1400, 800);

        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.X_AXIS));

        PanelBus panelBus = new PanelBus();
        PanelComprador panelComprador = new PanelComprador();
        PanelInformacion panelInformacion = new PanelInformacion();

        containerPanel.add(panelBus);
        containerPanel.add(panelComprador);
        containerPanel.add(panelInformacion);

        this.add(containerPanel);
        this.setVisible(true);
    }
}

class PanelBus extends JPanel {
    private JButton asiento1;
    private JButton asiento2;
    private JButton asiento3;
    private JButton asiento4;
    private JButton asiento5;
    private JButton asiento6;
    private JButton asiento7;
    private JButton asiento8;
    private JButton asiento9;
    private JButton asiento10;
    private JButton asiento11;
    private JButton asiento12;
    private JButton asiento13;
    private JButton asiento14;
    private JButton asiento15;
    private JButton asiento16;



    private int rectangleX = 180;
    private int rectangleY = 320;
    private int rectangleWidth = 750;
    private int rectangleHeight = 200;

    public PanelBus() {
        setLayout(null);

        asiento1 = new JButton("1");
        asiento2 = new JButton("2");
        asiento3 = new JButton("3");
        asiento4 = new JButton("4");
        asiento5 = new JButton("5");
        asiento6 = new JButton("6");
        asiento7 = new JButton("7");
        asiento8 = new JButton("8");
        asiento9 = new JButton("9");
        asiento10 = new JButton("10");
        asiento11 = new JButton("11");
        asiento12 = new JButton("12");
        asiento13 = new JButton("13");
        asiento14 = new JButton("14");
        asiento15 = new JButton("15");
        asiento16 = new JButton("16");

        setupButton(asiento1, rectangleX, rectangleY);
        setupButton(asiento2, rectangleX + 90, rectangleY);
        setupButton(asiento3, rectangleX + 180, rectangleY);
        setupButton(asiento4, rectangleX + 270, rectangleY);
        setupButton(asiento5, rectangleX + 360, rectangleY);
        setupButton(asiento6, rectangleX + 450, rectangleY);
        setupButton(asiento7, rectangleX + 540, rectangleY);
        setupButton(asiento8, rectangleX + 630, rectangleY);
        setupButton(asiento9, rectangleX, rectangleY + 150);
        setupButton(asiento10, rectangleX + 90, rectangleY + 150);
        setupButton(asiento11, rectangleX + 180, rectangleY + 150);
        setupButton(asiento12, rectangleX + 270, rectangleY +150);
        setupButton(asiento13, rectangleX + 360, rectangleY + 150);
        setupButton(asiento14, rectangleX + 450, rectangleY +150);
        setupButton(asiento15, rectangleX + 540, rectangleY +150);
        setupButton(asiento16, rectangleX + 630, rectangleY + 150);

        /*
        asiento1.setBounds(rectangleX, rectangleY, 80, 50);
        asiento2.setBounds(rectangleX + 90, rectangleY, 80, 50);
        asiento3.setBounds(rectangleX + 180, rectangleY, 80, 50);
        asiento4.setBounds(rectangleX + 270, rectangleY, 80, 50);
        asiento5.setBounds(rectangleX + 360, rectangleY, 80, 50);
        asiento6.setBounds(rectangleX + 450, rectangleY, 80, 50);
        asiento7.setBounds(rectangleX + 540, rectangleY, 80, 50);
        asiento8.setBounds(rectangleX + 630, rectangleY, 80, 50);

        asiento1.setBackground(Color.GREEN);
        asiento2.setBackground(Color.GREEN);
        asiento3.setBackground(Color.GREEN);
        asiento4.setBackground(Color.GREEN);
        asiento5.setBackground(Color.GREEN);
        asiento6.setBackground(Color.GREEN);
        asiento7.setBackground(Color.GREEN);
        asiento8.setBackground(Color.GREEN);
        asiento9.setBackground(Color.GREEN);
        asiento10.setBackground(Color.GREEN);
        asiento11.setBackground(Color.GREEN);
        asiento12.setBackground(Color.GREEN);
        asiento13.setBackground(Color.GREEN);
        asiento14.setBackground(Color.GREEN);
        asiento15.setBackground(Color.GREEN);
        asiento16.setBackground(Color.GREEN);



        asiento9.setBounds(rectangleX, rectangleY + 150, 80, 50);
        asiento10.setBounds(rectangleX + 90, rectangleY + 150, 80, 50);
        asiento11.setBounds(rectangleX + 180, rectangleY + 150, 80, 50);
        asiento12.setBounds(rectangleX + 270, rectangleY +150, 80, 50);
        asiento13.setBounds(rectangleX + 360, rectangleY + 150, 80, 50);
        asiento14.setBounds(rectangleX + 450, rectangleY +150, 80, 50);
        asiento15.setBounds(rectangleX + 540, rectangleY +150, 80, 50);
        asiento16.setBounds(rectangleX + 630, rectangleY + 150, 80, 50);


         */

        add(asiento1);
        add(asiento2);
        add(asiento3);
        add(asiento4);
        add(asiento5);
        add(asiento6);
        add(asiento7);
        add(asiento8);
        add(asiento9);
        add(asiento10);
        add(asiento11);
        add(asiento12);
        add(asiento13);
        add(asiento14);
        add(asiento15);
        add(asiento16);
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

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1200, 800);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.gray);
        g.fillRect(rectangleX, rectangleY, rectangleWidth, rectangleHeight);

        g.setColor(Color.white);
        g.drawString("Bus", 550, 430);

        g.setColor(Color.black);
        Font myFont = new Font("Arial", Font.PLAIN, 20);
        g.setFont(myFont);
        g.drawString("Panel de Informaciones", 100, 50);

    }
}







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

class PanelInformacion extends JPanel {


    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.black);
        g.drawRect(0,0,500,300);


    }
}

