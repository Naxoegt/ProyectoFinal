package org.example.domain;

/**
 * Enum que define los posibles destinos y origenes de un viaje en el sistema.
 */
public enum Destino {
    desde_Conce("Concepcion"),
    desde_PV("Puerto Varas"),
    desde_Valdi("Valdivia"),
    desde_sorno("Osorno"),
    hacia_Conce("Concepcion"),
    hacia_PV("Puerto Varas"),
    hacia_Valdi("Valdivia"),
    hacia_Osorno("Osorno");

    private final String text;

    Destino(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

