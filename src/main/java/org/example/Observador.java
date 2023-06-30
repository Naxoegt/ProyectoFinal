package org.example;

import java.util.ArrayList;
import java.util.List;

class Observador {
    private List<Observer> Observadores = new ArrayList<>();

    public void addObserver(Observer observer) {
        Observadores.add(observer);
    }

    public void NotificarObservadores() {
        for (Observer observer : Observadores) {
            observer.update();
        }
    }
}