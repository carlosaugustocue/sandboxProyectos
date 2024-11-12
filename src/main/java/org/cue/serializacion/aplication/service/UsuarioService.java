package org.cue.serializacion.aplication.service;

import org.cue.serializacion.domain.Usuario;
import java.util.List;

public interface UsuarioService {
    void agregarUsuario(Usuario usuario);
    void eliminarUsuario(String nombreDeUsuario);
    Usuario buscarUsuario(String nombreDeUsuario);
    List<Usuario> listarUsuarios();
}
