package org.cue.poo;

public class Doctor {
    static int id = 0;
    String name;
    String speciality;

    // Método constructor
    Doctor(){
        System.out.println("Construyendo el objeto Doctor");
        id++;
    }

    Doctor(String name){
        System.out.println("El nombre del doctor asignado es: " + name);
    }

    // Comportamientos
    public void showName(){
        System.out.println(name);
    }

    public void showIdent(){
        System.out.println("ID Doctor: " + id);
    }

}
