package org.example.UI;

import org.example.domain.Estado;
import org.example.UI.PanelBus;
import org.example.UI.PanelComprador;
import org.example.UI.PanelInformacion;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
/**
 * Clase que representa la ventana principal de la aplicación. Contiene un panel de bus, un panel
 * de información y un panel de comprador.
 */
class Ventana extends JFrame {
    public Ventana() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Estado estado = new Estado();
        PanelComprador panelComprador = new PanelComprador(estado);
        estado.addObservador(panelComprador);
        PanelBus panelBus = new PanelBus(estado);
        PanelInformacion panelInformacion = new PanelInformacion(panelBus.listaDeAsientos, estado);

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