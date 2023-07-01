package org.example;
import org.example.UI.PanelComprador;
import org.example.domain.Asiento;
import org.example.domain.AsientoNormal;
import org.example.domain.AsientoPremium;
import org.example.domain.Estado;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PanelCompradorTest {

    private Estado estado;
    private PanelComprador panelComprador;

    @BeforeEach
    void setUp() {
        estado = new Estado();
        panelComprador = new PanelComprador(estado);
        estado.addObservador(panelComprador);
    }

    @Test
    @DisplayName("Test agregar asiento normal")
    void testAgregarAsientoNormal() {
        Asiento asiento1 = new AsientoNormal();
        asiento1.setNumero(1);
        estado.agregarAsiento(asiento1);

        assertEquals("1", panelComprador.tagAsientos.getText());
        assertEquals("Normal x 1, Premium x 0", panelComprador.tagTipo.getText());
    }

    @Test
    @DisplayName("Test agregar asiento premium")
    void testAgregarAsientoPremium() {
        Asiento asiento2 = new AsientoPremium();
        asiento2.setNumero(2);
        estado.agregarAsiento(asiento2);

        assertEquals("2", panelComprador.tagAsientos.getText());
        assertEquals("Normal x 0, Premium x 1", panelComprador.tagTipo.getText());
    }

    @Test
    @DisplayName("Test agregar Asientos de ambos tipos")
    void testAgregarAsientos() {
        Asiento asiento1 = new AsientoNormal();
        asiento1.setNumero(1);
        Asiento asiento2 = new AsientoPremium();
        asiento2.setNumero(2);

        estado.agregarAsiento(asiento1);
        estado.agregarAsiento(asiento2);

        assertEquals("1, 2", panelComprador.tagAsientos.getText());
        assertEquals("Normal x 1, Premium x 1", panelComprador.tagTipo.getText());
    }
}
