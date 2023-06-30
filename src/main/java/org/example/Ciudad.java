package org.example;

public class Ciudad {
    private String nombre;
    private int precio;

    public Ciudad(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }
}
