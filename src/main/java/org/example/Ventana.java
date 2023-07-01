package org.example;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class Ventana extends JFrame {
    public Ventana() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Estado estado = new Estado();
        PanelComprador panelComprador = new PanelComprador(estado);
        estado.addObservador(panelComprador);
        PanelBus panelBus = new PanelBus(estado);
        PanelInformacion panelInformacion = new PanelInformacion(panelBus.listaDeAsientos);

        JPanel nestedPanel = new JPanel(new BorderLayout());
        nestedPanel.add(panelInformacion, BorderLayout.NORTH);
        nestedPanel.add(panelBus, BorderLayout.CENTER);

        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.X_AXIS));
        containerPanel.add(nestedPanel);
        containerPanel.add(panelComprador);

        add(containerPanel);

        pack();
        setVisible(true);
    }
}