package org.cue.patrones;

public class Singleton {

    // Variable estática que contiene la única instancia de la clase.
    private static Singleton instance;

    // Constructor privado para evitar instanciación desde fuera.
    private Singleton() {
        System.out.println("Instancia creada.");
    }

    // Método público estático para obtener la instancia única.
    public static Singleton getInstance() {
        if (instance == null) { // Crear instancia si no existe.
            instance = new Singleton();
        }
        return instance; // Retornar la instancia única.
    }

    // Método de ejemplo para usar el Singleton.
    public void showMessage() {
        System.out.println("¡Hola desde el Singleton!");
    }
}

