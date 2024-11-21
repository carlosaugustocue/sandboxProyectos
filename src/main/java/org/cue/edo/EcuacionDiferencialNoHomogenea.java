package org.cue.edo;


public class EcuacionDiferencialNoHomogenea {

    public static void main(String[] args) {
        // Coeficientes de la ecuación diferencial
        double a = -3; // Coeficiente de y'
        double b = 2;  // Coeficiente de y
        String terminoNoHomogeneo = "e^t";

        // Calcular el discriminante de la ecuación característica
        double discriminante = a * a - 4 * b;

        // Resolver la ecuación homogénea
        System.out.println("Solución de la ecuación homogénea:");
        if (discriminante > 0) {
            // Raíces reales y distintas
            double r1 = (-a + Math.sqrt(discriminante)) / 2;
            double r2 = (-a - Math.sqrt(discriminante)) / 2;
            System.out.printf("y_h(t) = C1 * e^(%.2f * t) + C2 * e^(%.2f * t)%n", r1, r2);
        } else if (discriminante == 0) {
            // Raíces reales e iguales
            double r = -a / 2;
            System.out.printf("y_h(t) = (C1 + C2 * t) * e^(%.2f * t)%n", r);
        } else {
            // Raíces complejas
            double realPart = -a / 2;
            double imaginaryPart = Math.sqrt(-discriminante) / 2;
            System.out.printf("y_h(t) = e^(%.2f * t) * (C1 * cos(%.2f * t) + C2 * sin(%.2f * t))%n",
                    realPart, imaginaryPart, imaginaryPart);
        }

        // Encontrar la solución particular
        System.out.println("\nSolución particular para el término no homogéneo " + terminoNoHomogeneo + ":");
        System.out.println("Como el término no homogéneo es e^t, proponemos una solución particular de la forma:");
        System.out.println("y_p(t) = A * t * e^t");

        // Imprimir la solución general
        System.out.println("\nSolución general:");
        System.out.println("y(t) = y_h(t) + y_p(t)");
    }
}

