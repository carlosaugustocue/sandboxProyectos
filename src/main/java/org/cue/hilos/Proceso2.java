package org.cue.hilos;

public class Proceso2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Proceso 2");
        }
    }
}
