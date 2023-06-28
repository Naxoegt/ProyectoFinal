package org.example;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

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