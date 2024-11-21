package org.cue.patrones;

public class Main {
    public static void main(String[] args) {
        // Obtener la única instancia del Singleton.
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        // Llamar a un método desde la instancia.
        singleton1.showMessage();

        // Comprobar que ambas instancias son la misma.
        System.out.println(singleton1 == singleton2); // Imprime: true
    }
}


