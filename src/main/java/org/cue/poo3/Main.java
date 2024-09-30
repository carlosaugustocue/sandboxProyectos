package org.cue.poo3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Persona> personas = new ArrayList<>();

        // Crear dos objetos de tipo PersonaImpl
        Persona persona1 = new PersonaImpl("Carlos", "Augusto", 30);
        Persona persona2 = new PersonaImpl("Ana", "Gomez", 25);

        // Crear las personas en la lista
        personas.add(persona1);
        personas.add(persona2);

        // Leer una persona por su nombre
        Persona personaEncontrada = null;
        for (Persona persona : personas) {
            if (persona.getNombre().equals("Carlos")) {
                personaEncontrada = persona;
                break;
            }
        }

        // Actualizar la edad de la persona encontrada
        if (personaEncontrada != null) {
            personaEncontrada.setEdad(31);
        }

        // Eliminar una persona de la lista
        personas.removeIf(persona -> persona.getNombre().equals("Ana"));

        // Imprimir la lista de personas al final
        for (Persona persona : personas) {
            System.out.println(persona);
        }
    }
}