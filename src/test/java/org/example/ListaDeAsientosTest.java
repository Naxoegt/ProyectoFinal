package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ListaDeAsientosTest {
    private Estado estado;
    private ListaDeAsientos listaDeAsientos;

    @BeforeEach
    void setUp() {
        estado = new Estado();
        listaDeAsientos = new ListaDeAsientos(estado);
    }

    @Test
    @DisplayName("Test probar el metodo getAsiento")
    void testGetAsiento() {
        assertEquals(16, listaDeAsientos.getAsiento().size());
    }

    @Test
    @DisplayName("Test probar el metodo getInformacionAsientos")
    void testGetInformacionAsientos() {
        assertEquals(16, listaDeAsientos.getInformacionAsientos().size());
    }

    @Test
    @DisplayName("Verificar precios para asientos en los extremos normales y premium")
    void testActualizarValoresAsientosConcePV() {
        listaDeAsientos.ActualizarValoresAsientos("Concepcion", "Puerto Varas");

        //asientos premium
        assertEquals(5000, listaDeAsientos.getInformacionAsientos().get(1).Valor());
        assertEquals(5000, listaDeAsientos.getInformacionAsientos().get(7).Valor());
        //aasientos normales extremos
        assertEquals(4000, listaDeAsientos.getInformacionAsientos().get(8).Valor());
        assertEquals(4000, listaDeAsientos.getInformacionAsientos().get(15).Valor());
    }

    @Test
    @DisplayName("Verificar precios para asientos en los extremos normales y premium")
    void testActualizarValoresAsientosPVOsorno() {
        listaDeAsientos.ActualizarValoresAsientos("Puerto Varas", "Osorno");

        //asientos premium
        assertEquals(2000, listaDeAsientos.getInformacionAsientos().get(1).Valor());
        assertEquals(2000, listaDeAsientos.getInformacionAsientos().get(7).Valor());
        //aasientos normales extremos
        assertEquals(1000, listaDeAsientos.getInformacionAsientos().get(8).Valor());
        assertEquals(1000, listaDeAsientos.getInformacionAsientos().get(15).Valor());
    }


    @Test
    @DisplayName("Verificar que de un origen al mismo destino no se sume un precio total")
    void testPriceForSameDestinationConceConce() {
        Estado estado = new Estado();
        ListaDeAsientos listaDeAsientos = new ListaDeAsientos(estado);

        // Set the same origin and destination
        String origin = "Concepcion";
        String destination = "Concepcion";

        // Update the prices based on the origin and destination
        listaDeAsientos.ActualizarValoresAsientos(origin, destination);

        // Check that the price for all asientos is 0
        listaDeAsientos.getInformacionAsientos().forEach(asiento -> assertEquals(0, asiento.Valor()));
    }

    @Test
    @DisplayName("Verificar que de un origen al mismo destino no se sume un precio total")
    void testPriceForSameDestinationValdiValdi() {
        Estado estado = new Estado();
        ListaDeAsientos listaDeAsientos = new ListaDeAsientos(estado);

        // Set the same origin and destination
        String origin = "Valdivia";
        String destination = "Valdivia";

        // Update the prices based on the origin and destination
        listaDeAsientos.ActualizarValoresAsientos(origin, destination);

        // Check that the price for all asientos is 0
        listaDeAsientos.getInformacionAsientos().forEach(asiento -> assertEquals(0, asiento.Valor()));
    }

    @Test
    @DisplayName("Verificar que de un origen al mismo destino no se sume un precio total")
    void testPriceForSameDestinationPvPv() {
        Estado estado = new Estado();
        ListaDeAsientos listaDeAsientos = new ListaDeAsientos(estado);

        // Set the same origin and destination
        String origin = "Puerto Varas";
        String destination = "Puerto Varas";

        // Update the prices based on the origin and destination
        listaDeAsientos.ActualizarValoresAsientos(origin, destination);

        // Check that the price for all asientos is 0
        listaDeAsientos.getInformacionAsientos().forEach(asiento -> assertEquals(0, asiento.Valor()));
    }

    @Test
    @DisplayName("Verificar que de un origen al mismo destino no se sume un precio total")
    void testPriceForSameDestinationOsornoOsorno() {
        Estado estado = new Estado();
        ListaDeAsientos listaDeAsientos = new ListaDeAsientos(estado);

        // Set the same origin and destination
        String origin = "Osorno";
        String destination = "Osorno";

        // Update the prices based on the origin and destination
        listaDeAsientos.ActualizarValoresAsientos(origin, destination);

        // Check that the price for all asientos is 0
        listaDeAsientos.getInformacionAsientos().forEach(asiento -> assertEquals(0, asiento.Valor()));
    }
}

