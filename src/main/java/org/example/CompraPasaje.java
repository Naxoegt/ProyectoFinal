package org.example;

public class CompraPasaje {
    private Ciudad ciudadOrigen;
    private Ciudad ciudadDestino;
    private Asiento asiento;

    public CompraPasaje(Ciudad ciudadOrigen, Ciudad ciudadDestino, Asiento asiento) {
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.asiento = asiento;
    }

    public Ciudad getCiudadOrigen() {
        return ciudadOrigen;
    }

    public Ciudad getCiudadDestino() {
        return ciudadDestino;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public int calcularPrecioTotal() {
        int precioBase = asiento.Valor();
        int precioOrigen = ciudadOrigen.getPrecio();
        int precioDestino = ciudadDestino.getPrecio();

        return precioBase + precioOrigen + precioDestino;
    }
}
