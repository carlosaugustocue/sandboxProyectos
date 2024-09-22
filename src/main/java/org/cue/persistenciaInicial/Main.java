package org.cue.persistenciaInicial;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Paciente> pacientes = new ArrayList<>();
    private static List<Cita> citas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Cargar datos desde archivos
        pacientes = Persistencia.cargarPacientes();
        citas = Persistencia.cargarCitas();

        boolean continuar = true;
        while (continuar) {
            System.out.println("===== Gestión de Pacientes y Citas Médicas =====");
            System.out.println("1. Registrar nuevo paciente");
            System.out.println("2. Actualizar datos de paciente");
            System.out.println("3. Registrar nueva cita");
            System.out.println("4. Eliminar cita");
            System.out.println("5. Mostrar lista de pacientes");
            System.out.println("6. Mostrar citas de un paciente");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    registrarPaciente();
                    break;
                case 2:
                    actualizarPaciente();
                    break;
                case 3:
                    registrarCita();
                    break;
                case 4:
                    eliminarCita();
                    break;
                case 5:
                    mostrarPacientes();
                    break;
                case 6:
                    mostrarCitasDePaciente();
                    break;
                case 7:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

            // Guardar datos actualizados en archivos
            Persistencia.guardarPacientes(pacientes);
            Persistencia.guardarCitas(citas);
        }
    }

    private static void registrarPaciente() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Consumir salto de línea
        System.out.print("Género: ");
        String genero = scanner.nextLine();
        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        Paciente nuevoPaciente = new Paciente(nombre, apellido, edad, genero, direccion, telefono);
        pacientes.add(nuevoPaciente);
        System.out.println("Paciente registrado exitosamente.");
    }

    private static void actualizarPaciente() {
        System.out.print("Ingrese el nombre del paciente que desea actualizar: ");
        String nombre = scanner.nextLine();
        Paciente paciente = buscarPaciente(nombre);
        if (paciente != null) {
            System.out.print("Nuevo nombre (dejar en blanco para mantener el actual): ");
            String nuevoNombre = scanner.nextLine();
            if (!nuevoNombre.isEmpty()) paciente.setNombre(nuevoNombre);

            // Realizar lo mismo para los demás atributos si se desea
            System.out.println("Datos del paciente actualizados.");
        } else {
            System.out.println("Paciente no encontrado.");
        }
    }

    private static void registrarCita() {
        System.out.print("Ingrese el nombre del paciente para la cita: ");
        String nombrePaciente = scanner.nextLine();
        Paciente paciente = buscarPaciente(nombrePaciente);
        if (paciente != null) {
            System.out.print("Fecha y hora (dd-MM-yyyy HH:mm): ");
            String fechaHoraStr = scanner.nextLine();
            LocalDateTime fechaHora = LocalDateTime.parse(fechaHoraStr, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
            System.out.print("Motivo de la cita: ");
            String motivo = scanner.nextLine();

            Cita nuevaCita = new Cita(fechaHora, motivo, paciente);
            citas.add(nuevaCita);
            System.out.println("Cita registrada exitosamente.");
        } else {
            System.out.println("Paciente no encontrado.");
        }
    }

    private static void eliminarCita() {
        System.out.print("Ingrese el nombre del paciente para eliminar la cita: ");
        String nombrePaciente = scanner.nextLine();
        Paciente paciente = buscarPaciente(nombrePaciente);
        if (paciente != null) {
            System.out.println("Citas para el paciente: ");
            List<Cita> citasPaciente = obtenerCitasDePaciente(paciente);
            for (int i = 0; i < citasPaciente.size(); i++) {
                System.out.println((i + 1) + ". " + citasPaciente.get(i));
            }
            System.out.print("Seleccione el número de la cita a eliminar: ");
            int numeroCita = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea
            citas.remove(citasPaciente.get(numeroCita - 1));
            System.out.println("Cita eliminada exitosamente.");
        } else {
            System.out.println("Paciente no encontrado.");
        }
    }

    private static void mostrarPacientes() {
        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
        } else {
            for (Paciente paciente : pacientes) {
                System.out.println(paciente);
            }
        }
    }

    private static void mostrarCitasDePaciente() {
        System.out.print("Ingrese el nombre del paciente: ");
        String nombrePaciente = scanner.nextLine();
        Paciente paciente = buscarPaciente(nombrePaciente);
        if (paciente != null) {
            List<Cita> citasPaciente = obtenerCitasDePaciente(paciente);
            if (citasPaciente.isEmpty()) {
                System.out.println("No hay citas registradas para este paciente.");
            } else {
                for (Cita cita : citasPaciente) {
                    System.out.println(cita);
                }
            }
        } else {
            System.out.println("Paciente no encontrado.");
        }
    }

    // Métodos auxiliares
    private static Paciente buscarPaciente(String nombre) {
        for (Paciente paciente : pacientes) {
            if (paciente.getNombre().equalsIgnoreCase(nombre)) {
                return paciente;
            }
        }
        return null;
    }

    private static List<Cita> obtenerCitasDePaciente(Paciente paciente) {
        List<Cita> citasPaciente = new ArrayList<>();
        for (Cita cita : citas) {
            if (cita.getPaciente().equals(paciente)) {
                citasPaciente.add(cita);
            }
        }
        return citasPaciente;
    }
}

