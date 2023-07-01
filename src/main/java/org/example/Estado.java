package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Estado {
    private String origen = "";
    private String destino = "";

    private List<Asiento> asientosSeleccionados = new ArrayList<>();

    private List<Observador> Observadors = new ArrayList<>();

    public void addObservador(Observador Observador) {
        Observadors.add(Observador);
    }

    public void removeObservador(Observador Observador) {
        Observadors.remove(Observador);
    }

    public void notifyObservadors() {
        Observadors.forEach(Observador::update);
    }

    public void agregarAsiento(Asiento seat) {
        asientosSeleccionados.add(seat);
        notifyObservadors();
    }

    public void removerAsiento(Asiento seat) {
        asientosSeleccionados.remove(seat);
        notifyObservadors();
    }

    public int getTotal() {
        return asientosSeleccionados.stream().mapToInt(Asiento::Valor).sum();
    }

    public String getAsiento() {
        return asientosSeleccionados.stream().map(asiento -> String.valueOf(asiento.Numero())).collect(Collectors.joining(", "));
    }

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
