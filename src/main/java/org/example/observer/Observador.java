package org.example.observer;

import java.util.ArrayList;
import java.util.List;
/**
 * interfaz Observador que define el método 'update' que debe ser implementado por las clases que deseen
 * recibir notificaciones de cambios en el estado.
 */
public interface Observador {
    void update();
}