package org.cue.poo2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Direccion direccion1 = new Direccion("Calle Falsa 123", "Springfield", "12345");
        Direccion direccion2 = new Direccion("Avenida Siempre Viva 742", "Springfield", "67890");

        Persona persona = new Persona("Carlos", 30);
        persona.addDireccion(direccion1);
        persona.addDireccion(direccion2);

        persona.mostrarInfo();
    }
}