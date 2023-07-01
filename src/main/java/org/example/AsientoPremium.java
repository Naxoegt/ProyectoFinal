package org.example;
/**
 * La clase AsientoPremium es una subclase de Asiento que representa un asiento premium en un bus.
 * Hereda los atributos y métodos de la clase Asiento.
 */
class AsientoPremium extends Asiento {
    private int valor;
    private int tipo = 1;

    public int Valor() {
        return valor;
    }

    public int Tipo() {
        return tipo;
    }

    /**
     * Establece el valor del asiento premium basado en el origen y destino especificados.
     * @param origen  El origen del viaje.
     * @param destino El destino del viaje.
     */
    public void setValor(String origen, String destino) {
        if ((origen.equals("Concepcion") && destino.equals("Puerto Varas")) || (origen.equals("Puerto Varas") && destino.equals("Concepcion"))) {
            valor = 5000;
        } else if ((origen.equals("Concepcion") && destino.equals("Valdivia")) || (origen.equals("Valdivia") && destino.equals("Concepcion"))) {
            valor = 3000;
        } else if ((origen.equals("Concepcion") && destino.equals("Osorno")) || (origen.equals("Osorno") && destino.equals("Concepcion"))) {
            valor = 4000;
        } else if ((origen.equals("Puerto Varas") && destino.equals("Valdivia")) || (origen.equals("Valdivia") && destino.equals("Puerto Varas"))) {
            valor = 3500;
        } else if ((origen.equals("Puerto Varas") && destino.equals("Osorno")) || (origen.equals("Osorno") && destino.equals("Puerto Varas"))) {
            valor = 2000;
        } else if ((origen.equals("Valdivia") && destino.equals("Osorno")) || (origen.equals("Osorno") && destino.equals("Valdivia"))) {
            valor = 3000;
        } else {
            valor = 0;
        }
    }
}
