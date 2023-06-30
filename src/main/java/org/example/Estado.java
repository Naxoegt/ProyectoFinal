package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Estado extends Observador {
    private List<Asiento> selectedSeats = new ArrayList<>();

    public void agregarAsiento(Asiento seat) {
        selectedSeats.add(seat);
        NotificarObservadores();
    }

    public void removerAsiento(Asiento seat) {
        selectedSeats.remove(seat);
        NotificarObservadores();
    }

    public int getTotal() {
        return selectedSeats.stream().mapToInt(Asiento::Valor).sum();
    }

    public String getAsiento() {
        return selectedSeats.stream().map(asiento -> Integer.toString(asiento.Numero())).collect(Collectors.joining(", "));
    }

    public String getTipo() {
        int normalAsientos = (int) selectedSeats.stream()
                .filter(asiento -> asiento instanceof AsientoNormal)
                .count();
        int premiumAsientos = (int) selectedSeats.stream()
                .filter(asiento -> asiento instanceof AsientoPremium)
                .count();

        return "Normal x " + normalAsientos + ", Premium x " + premiumAsientos;
    }
}