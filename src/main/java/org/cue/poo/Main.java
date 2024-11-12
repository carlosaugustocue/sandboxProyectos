package org.cue.poo;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

//        UIMenu.showMenu();
        Patient paciente1 = new Patient("Carlos Augusto","carlos@correo.com");
//        paciente.setName("Carlos Augusto");
//        System.out.println(paciente.getName());
        ArrayList<Patient> patients = new ArrayList<>();
        System.out.println(patients);
        System.out.println("*****************");
        patients.add(paciente1);
        System.out.println(patients);
        System.out.println("*****************");







    }
}
