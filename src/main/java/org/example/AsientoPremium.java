package org.example;

class AsientoPremium extends Asiento {
    private int valor = 2000;
    private int tipo = 1;


    public AsientoPremium() {}

    public int Valor() {
        return valor;
    }
    public int Tipo() {
        return tipo;
    }

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
        }
    }
}
