package org.example;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

class Ventana extends JFrame {
    public Ventana() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.X_AXIS));

        Estado Estado = new Estado();

        PanelComprador panelComprador = new PanelComprador(Estado);
        Estado.addObserver(panelComprador);
        PanelBus panelBus = new PanelBus(Estado);
        PanelInformacion panelInformacion = new PanelInformacion(panelBus.listaDeAsientos);

        JPanel nestedPanel = new JPanel();
        nestedPanel.setLayout(new BorderLayout());

        nestedPanel.add(panelInformacion, BorderLayout.NORTH);
        nestedPanel.add(panelBus, BorderLayout.CENTER);

        containerPanel.add(nestedPanel);
        containerPanel.add(panelComprador);

        this.add(containerPanel);

        this.pack(); // make the frame fit to preferred size of all components
        this.setVisible(true);
    }
}