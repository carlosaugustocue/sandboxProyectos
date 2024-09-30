package org.cue.poo2;

import java.util.ArrayList;

public class Persona {
    private String nombre;
    private int edad;
    private ArrayList<Direccion> direcciones;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.direcciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ArrayList<Direccion> getDirecciones() {
        return direcciones;
    }

    public void addDireccion(Direccion direccion) {
        this.direcciones.add(direccion);
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre + ", Edad: " + edad);
        for (Direccion direccion : direcciones) {
            direccion.mostrarDireccion();
        }
    }
}
