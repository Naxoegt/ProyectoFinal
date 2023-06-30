package org.example;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Ventana extends JFrame {
    public Ventana() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1400, 1000);

        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.X_AXIS));

        Estado Estado = new Estado();

        // Instancia el panelcomprador antes de agregarlo como observador
        PanelComprador panelComprador = new PanelComprador(Estado);
        Estado.addObserver(panelComprador);
        PanelBus panelBus = new PanelBus(Estado);
        PanelInformacion panelInformacion = new PanelInformacion();

        containerPanel.add(panelInformacion);
        containerPanel.add(panelBus);
        containerPanel.add(panelComprador);

        this.add(containerPanel);
        this.setVisible(true);
    }
}