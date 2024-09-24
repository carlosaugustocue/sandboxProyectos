package org.cue.test;
import static org.cue.test.Calculadora.*;
import static org.cue.test.Triangulo.*;
import java.text.NumberFormat;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        System.out.println(suma(2,7));
        System.out.println(PI);
        double resultado = area(50.3, 445);

        // Configuración regional para Colombia
        Locale colombia = new Locale("es", "CO");
        NumberFormat formatoColombiano = NumberFormat.getInstance(colombia);

        // Formatear el número
        String resultadoFormateado = formatoColombiano.format(resultado);

        // Mostrar el resultado formateado
        System.out.println("Resultado formateado: " + resultadoFormateado);
    }
}
