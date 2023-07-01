package org.example;

import org.example.domain.AsientoNormal;
import org.example.domain.AsientoPremium;
import org.example.domain.Estado;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EstadoTest {
    @Test
    @DisplayName("Test valor total diferentes itinerarios diferentes precios")
    void testGetTotal() {
        Estado estado = new Estado();
        AsientoNormal asiento1 = new AsientoNormal();
        AsientoPremium asiento2 = new AsientoPremium();
        asiento1.setValor("Concepcion", "Puerto Varas");
        asiento2.setValor("Concepcion", "Osorno");
        estado.agregarAsiento(asiento1);
        estado.agregarAsiento(asiento2);
        assertEquals(8000, estado.getTotal());
    }

    @Test
    @DisplayName("Test getAsiento normal y premium")
    void testGetAsiento() {
        Estado estado = new Estado();
        AsientoNormal asiento1 = new AsientoNormal();
        AsientoPremium asiento2 = new AsientoPremium();
        estado.agregarAsiento(asiento1);
        estado.agregarAsiento(asiento2);
        assertEquals("1, 2", estado.getAsiento());
    }

    @Test
    @DisplayName("Test tipo de asiento")
    void testGetTipo() {
        Estado estado = new Estado();
        AsientoNormal asiento1 = new AsientoNormal();
        AsientoPremium asiento2 = new AsientoPremium();
        estado.agregarAsiento(asiento1);
        estado.agregarAsiento(asiento2);
        assertEquals("Normal x 1, Premium x 1", estado.getTipo());
    }

    @Test
    @DisplayName("Test setOrigen")
    void testSetOrigen() {
        Estado estado = new Estado();
        estado.setOrigen("Concepcion");
        assertEquals("Concepcion", estado.getOrigen());
    }

    @Test
    @DisplayName("Test setDestino")
    void testSetDestino() {
        Estado estado = new Estado();
        estado.setDestino("Puerto Varas");
        assertEquals("Puerto Varas", estado.getDestino());
    }
}
