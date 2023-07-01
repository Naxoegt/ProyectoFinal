package org.example;

import org.example.domain.AsientoNormal;
import org.example.domain.AsientoPremium;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AsientoPremiumTest {
    @Test
    @DisplayName("Test de diferentes configuraciones para origen y destino")
    void testValor() {
        AsientoPremium asiento = new AsientoPremium();

        asiento.setValor("Concepcion", "Puerto Varas");
        assertEquals(5000, asiento.Valor());

        asiento.setValor("Valdivia", "Osorno");
        assertEquals(3000, asiento.Valor());

        // Test en que origen = destino
        asiento.setValor("Concepcion", "Concepcion");
        assertEquals(0, asiento.Valor());

        // Test destino y origen en blanco
        asiento.setValor(" ", " ");
        assertEquals(0, asiento.Valor());
    }


    @Test
    @DisplayName("Test tipo de asiento")
    void testTipo() {
        AsientoPremium asiento = new AsientoPremium();
        assertEquals(1, asiento.Tipo());
    }

    @Test
    @DisplayName("Test numero de asiento")
    void testNumero() {
        AsientoNormal asiento = new AsientoNormal();
        asiento.setNumero(5);
        assertEquals(5, asiento.Numero());
    }

    @Test
    @DisplayName("Test reserva de asiento")
    void testReserved() {
        AsientoPremium asiento = new AsientoPremium();
        asiento.setReserved(true);
        assertEquals(true, asiento.isReserved());

        asiento.setReserved(false);
        assertEquals(false, asiento.isReserved());
    }
}