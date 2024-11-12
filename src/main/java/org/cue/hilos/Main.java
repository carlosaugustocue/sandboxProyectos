package org.cue.hilos;

public class Main {
    public static void main(String[] args) {
        Proceso1 proceso1 = new Proceso1();

        Proceso2 proceso2 = new Proceso2();
        Thread hilo = new Thread(proceso2);
        proceso1.start();
        hilo.start();
    }
}
