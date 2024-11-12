package org.cue.serializacion.infrastructure.repository;

import org.cue.serializacion.domain.Usuario;
import org.cue.serializacion.interfaces.UsuarioRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositoryImpl implements UsuarioRepository {

    private static final String ARCHIVO_USUARIOS = "data/usuarios.dat";

    @Override
    public void guardarUsuarios(List<Usuario> usuarios) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_USUARIOS))) {
            oos.writeObject(usuarios);
        } catch (IOException e) {
            System.out.println("Error al guardar usuarios: " + e.getMessage());
        }
    }

    @Override
    public List<Usuario> cargarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_USUARIOS))) {
            usuarios = (List<Usuario>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo de usuarios no encontrado. Se creará uno nuevo.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar usuarios: " + e.getMessage());
        }
        return usuarios;
    }

    @Override
    public void agregarUsuario(Usuario usuario) {
        List<Usuario> usuarios = cargarUsuarios();
        usuarios.add(usuario);
        guardarUsuarios(usuarios);
    }

    @Override
    public void eliminarUsuario(String nombreDeUsuario) {
        List<Usuario> usuarios = cargarUsuarios();
        usuarios.removeIf(u -> u.getNombreDeUsuario().equals(nombreDeUsuario));
        guardarUsuarios(usuarios);
    }

    @Override
    public Usuario buscarUsuario(String nombreDeUsuario) {
        List<Usuario> usuarios = cargarUsuarios();
        return usuarios.stream()
                .filter(u -> u.getNombreDeUsuario().equals(nombreDeUsuario))
                .findFirst()
                .orElse(null);
    }
}
