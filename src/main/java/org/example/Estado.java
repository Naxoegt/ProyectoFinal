package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/**
 * Clase que representa el estado actual del sistema de reservas de asientos.
 * Contiene información sobre el origen, destino y los asientos seleccionados.
 * También gestiona una lista de observadores que deben actualizarse cuando el estado cambia.
 */
class Estado {
    private String origen = "";
    private String destino = "";

    private List<Asiento> asientosSeleccionados = new ArrayList<>();

    private List<Observador> Observadors = new ArrayList<>();

    /**
     * Agrega un observador al estado.
     * @param observador El observador a agregar.
     */
    public void addObservador(Observador Observador) {
        Observadors.add(Observador);
    }

    /**
     * Elimina un observador del estado.
     * @param observador El observador a eliminar.
     */
    public void removeObservador(Observador Observador) {
        Observadors.remove(Observador);
    }

    /**
     * Notifica a todos los observadores registrados que el estado ha cambiado y deben actualizarse.
     */
    public void notifyObservadors() {
        Observadors.forEach(Observador::update);
    }
    
    /**
     * Agrega un asiento seleccionado al estado y notifica a los observadores.
     * @param asiento El asiento seleccionado a agregar.
     */
    public void agregarAsiento(Asiento asiento) {
        asientosSeleccionados.add(asiento);
        notifyObservadors();
    }
    /**
     * Elimina un asiento seleccionado del estado y notifica a los observadores.
     * @param asiento El asiento seleccionado a eliminar.
     */
    public void removerAsiento(Asiento asiento) {
        asientosSeleccionados.remove(asiento);
        notifyObservadors();
    }

    /**
     * Devuelve el valor total de los asientos seleccionados.
     * @return El valor total de los asientos seleccionados.
     */
    public int getTotal() {
        return asientosSeleccionados.stream().mapToInt(Asiento::Valor).sum();
    }

    /**
     * Devuelve una representación en forma de cadena de los números de los asientos seleccionados.
     * @return Los números de los asientos seleccionados como una cadena.
     */
    public String getAsiento() {
        return asientosSeleccionados.stream().map(asiento -> String.valueOf(asiento.Numero())).collect(Collectors.joining(", "));
    }

    /**
     * Devuelve una cadena que representa la cantidad de asientos normales y premium seleccionados.
     * @return Una cadena que indica la cantidad de asientos normales y premium seleccionados.
     */
    public String getTipo() {
        int normalAsientos = (int) asientosSeleccionados.stream().filter(asiento -> asiento instanceof AsientoNormal).count();
        int premiumAsientos = (int) asientosSeleccionados.stream().filter(asiento -> asiento instanceof AsientoPremium).count();

        return "Normal x " + normalAsientos + ", Premium x " + premiumAsientos;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
}
