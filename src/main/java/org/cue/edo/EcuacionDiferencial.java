package org.cue.edo;

import java.util.Scanner;

/**
 * Esta clase resuelve ecuaciones diferenciales de la forma y'' + ay' + by = 0.
 */
public class EcuacionDiferencial {

    /**
     * Método principal que ejecuta el programa.
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        // Creamos un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Entrada de los coeficientes a y b de la ecuación diferencial
        System.out.println("Ecuación diferencial de la forma: y'' + ay' + by = 0");
        System.out.print("Ingrese el valor de a: ");
        double a = scanner.nextDouble();
        System.out.print("Ingrese el valor de b: ");
        double b = scanner.nextDouble();

        // Calculamos las raíces de la ecuación característica
        double discriminante = a * a - 4 * b;

        if (discriminante > 0) {
            // Raíces reales y distintas
            double r1 = (-a + Math.sqrt(discriminante)) / 2;
            double r2 = (-a - Math.sqrt(discriminante)) / 2;
            System.out.println("La solución general es:");
            System.out.printf("y(t) = C1 * e^(%.2f * t) + C2 * e^(%.2f * t)%n", r1, r2);

        } else if (discriminante == 0) {
            // Raíces reales e iguales
            double r = -a / 2;
            System.out.println("La solución general es:");
            System.out.printf("y(t) = (C1 + C2 * t) * e^(%.2f * t)%n", r);

        } else {
            // Raíces complejas
            double realPart = -a / 2;
            double imaginaryPart = Math.sqrt(-discriminante) / 2;
            System.out.println("La solución general es:");
            System.out.printf("y(t) = e^(%.2f * t) * (C1 * cos(%.2f * t) + C2 * sin(%.2f * t))%n",
                    realPart, imaginaryPart, imaginaryPart);
        }

        // Cerramos el objeto Scanner
        scanner.close();
    }
}