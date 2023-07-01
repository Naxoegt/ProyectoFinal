package org.example.domain;
/**
 * La clase Asiento representa un asiento en un bus.
 * Contiene información sobre el estado de reserva, valor, tipo y número del asiento.
 */
public class Asiento {
    protected boolean reserved = false;

    protected int valor;
    protected int tipo;
    protected int numero;

    /**
     * Devuelve el valor del asiento.
     * @return El valor del asiento.
     */
    public int Valor() {
        return valor;
    }

    /**
     * Establece el valor del asiento.
     * @param valor El valor del asiento.
     */
    public void setValor(int valor) {
        this.valor = valor;
    }
    /**
     * Devuelve el tipo de asiento.
     * @return El tipo de asiento.
     */
    public int Tipo() {
        return tipo;
    }

    /**
     * Establece el tipo de asiento.
     * @param tipo El tipo de asiento.
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    /**
     * Devuelve el número del asiento.
     * @return El número del asiento.
     */
    public int Numero() {
        return numero;
    }
    /**
     * Establece el número del asiento.
     * @param numero El número del asiento.
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }
    /**
     * Verifica si el asiento está reservado.
     * @return true si el asiento está reservado, false de lo contrario.
     */
    public boolean isReserved() {
        return reserved;
    }
    /**
     * Establece el estado de reserva del asiento.
     * @param reserved true si el asiento está reservado, false de lo contrario.
     */
    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }
}
