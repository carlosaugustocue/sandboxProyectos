package org.cue.persistenciaInicial;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Persistencia {
    private static final String ARCHIVO_PACIENTES = "pacientes.txt";
    private static final String ARCHIVO_CITAS = "citas.txt";

    // Guardar lista de pacientes en archivo
    public static void guardarPacientes(List<Paciente> pacientes) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_PACIENTES))) {
            oos.writeObject(pacientes);
        } catch (IOException e) {
            System.out.println("Error al guardar pacientes: " + e.getMessage());
        }
    }

    // Cargar lista de pacientes desde archivo
    public static List<Paciente> cargarPacientes() {
        List<Paciente> pacientes = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_PACIENTES))) {
            pacientes = (List<Paciente>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo de pacientes no encontrado, creando nuevo.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar pacientes: " + e.getMessage());
        }
        return pacientes;
    }

    // Guardar lista de citas en archivo
    public static void guardarCitas(List<Cita> citas) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_CITAS))) {
            oos.writeObject(citas);
        } catch (IOException e) {
            System.out.println("Error al guardar citas: " + e.getMessage());
        }
    }

    // Cargar lista de citas desde archivo
    public static List<Cita> cargarCitas() {
        List<Cita> citas = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_CITAS))) {
            citas = (List<Cita>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo de citas no encontrado, creando nuevo.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar citas: " + e.getMessage());
        }
        return citas;
    }
}

