package org.example;

import org.example.domain.AsientoNormal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AsientoNormalTest {
    @Test
    @DisplayName("Test de diferentes configuraciones para origen y destino")
    void testValor() {
        AsientoNormal asiento = new AsientoNormal();

        asiento.setValor("Concepcion", "Puerto Varas");
        assertEquals(4000, asiento.Valor());

        asiento.setValor("Valdivia", "Osorno");
        assertEquals(2000, asiento.Valor());

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
        AsientoNormal asiento = new AsientoNormal();
        assertEquals(2, asiento.Tipo());
    }

    @Test
    @DisplayName("Test numero de asiento")
    void testNumero() {
        AsientoNormal asiento = new AsientoNormal();
        asiento.setNumero(15);
        assertEquals(15, asiento.Numero());
    }

    @Test
    @DisplayName("Test reserva de asiento")
    void testReserved() {
        AsientoNormal asiento = new AsientoNormal();
        asiento.setReserved(true);
        assertEquals(true, asiento.isReserved());

        asiento.setReserved(false);
        assertEquals(false, asiento.isReserved());
    }
}
