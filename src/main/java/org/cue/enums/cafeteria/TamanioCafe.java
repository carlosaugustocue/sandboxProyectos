package org.cue.enums.cafeteria;

// Archivo: TamanioCafe.java
public enum TamanioCafe {
    PEQUENO(2.5),
    MEDIANO(3.0),
    GRANDE(4.0);

    private double precio;

    TamanioCafe(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }
}

