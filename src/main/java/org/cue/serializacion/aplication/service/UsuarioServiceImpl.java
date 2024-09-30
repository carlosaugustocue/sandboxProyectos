package org.cue.serializacion.aplication.service;

import org.cue.serializacion.domain.Usuario;
import org.cue.serializacion.infrastructure.repository.UsuarioRepositoryImpl;

import java.util.List;

public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepositoryImpl usuarioRepository = new UsuarioRepositoryImpl();

    @Override
    public void agregarUsuario(Usuario usuario) {
        usuarioRepository.agregarUsuario(usuario);
    }

    @Override
    public void eliminarUsuario(String nombreDeUsuario) {
        usuarioRepository.eliminarUsuario(nombreDeUsuario);
    }

    @Override
    public Usuario buscarUsuario(String nombreDeUsuario) {
        return usuarioRepository.buscarUsuario(nombreDeUsuario);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.cargarUsuarios();
    }
}
