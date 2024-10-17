package org.cue.enums.cafeteria;

public class Main {
    public static void main(String[] args) {
        // Usar el enum TamanioCafe definido en un archivo separado
        TamanioCafe miCafe = TamanioCafe.GRANDE;

        // Mostrar información del café seleccionado
        System.out.println("El tamaño seleccionado es: " + miCafe);
        System.out.println("El precio es: $" + miCafe.getPrecio());

        // Usar switch con el enum
        switch (miCafe) {
            case PEQUENO:
                System.out.println("Has elegido un café pequeño.");
                break;
            case MEDIANO:
                System.out.println("Has elegido un café mediano.");
                break;
            case GRANDE:
                System.out.println("Has elegido un café grande.");
                break;
            default:
                System.out.println("No se ha seleccionado un tamaño válido.");
                break;
        }
    }

}
