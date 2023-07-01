package org.example;

class AsientoNormal extends Asiento {
    private int valor;
    private int tipo = 2;

    public int Valor() {
        return valor;
    }

    public int Tipo() {
        return tipo;
    }

    public void setValor(String origen, String destino) {
        if ((origen.equals("Concepcion") && destino.equals("Puerto Varas")) || (origen.equals("Puerto Varas") && destino.equals("Concepcion"))) {
            valor = 4000;
        } else if ((origen.equals("Concepcion") && destino.equals("Valdivia")) || (origen.equals("Valdivia") && destino.equals("Concepcion"))) {
            valor = 2000;
        } else if ((origen.equals("Concepcion") && destino.equals("Osorno")) || (origen.equals("Osorno") && destino.equals("Concepcion"))) {
            valor = 3000;
        } else if ((origen.equals("Puerto Varas") && destino.equals("Valdivia")) || (origen.equals("Valdivia") && destino.equals("Puerto Varas"))) {
            valor = 2500;
        } else if ((origen.equals("Puerto Varas") && destino.equals("Osorno")) || (origen.equals("Osorno") && destino.equals("Puerto Varas"))) {
            valor = 1000;
        } else if ((origen.equals("Valdivia") && destino.equals("Osorno")) || (origen.equals("Osorno") && destino.equals("Valdivia"))) {
            valor = 2000;
        } else {
            valor = 0;
        }
    }
}