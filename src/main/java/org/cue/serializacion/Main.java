package org.cue.serializacion;

import org.cue.serializacion.aplication.service.UsuarioServiceImpl;
import org.cue.serializacion.domain.Usuario;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static UsuarioServiceImpl usuarioService = new UsuarioServiceImpl();

    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("==== Gestor de Usuarios ====");
            System.out.println("1. Agregar Usuario");
            System.out.println("2. Eliminar Usuario");
            System.out.println("3. Buscar Usuario");
            System.out.println("4. Listar Usuarios");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    agregarUsuario();
                    break;
                case 2:
                    eliminarUsuario();
                    break;
                case 3:
                    buscarUsuario();
                    break;
                case 4:
                    listarUsuarios();
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void agregarUsuario() {
        System.out.print("Nombre de usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        Usuario usuario = new Usuario(nombre, email);
        usuarioService.agregarUsuario(usuario);
        System.out.println("Usuario agregado.");
    }

    private static void eliminarUsuario() {
        System.out.print("Ingrese el nombre de usuario que desea eliminar: ");
        String nombre = scanner.nextLine();
        usuarioService.eliminarUsuario(nombre);
        System.out.println("Usuario eliminado.");
    }

    private static void buscarUsuario() {
        System.out.print("Ingrese el nombre de usuario a buscar: ");
        String nombre = scanner.nextLine();
        Usuario usuario = usuarioService.buscarUsuario(nombre);
        if (usuario != null) {
            System.out.println("Usuario encontrado: " + usuario);
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    private static void listarUsuarios() {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            usuarios.forEach(System.out::println);
        }
    }
}
