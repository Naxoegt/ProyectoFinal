package org.example;

class Asiento {
    protected int valor;
    protected int tipo;
    protected int numero;

    public Asiento(){}

    public int Valor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int Tipo(){
        return tipo;
    }

    public void setTipo(int tipo){
        this.tipo = tipo;
    }

    public int Numero(){
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}