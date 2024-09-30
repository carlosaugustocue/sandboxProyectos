package org.cue.serializacion.interfaces;

import org.cue.serializacion.domain.Usuario;
import java.util.List;

public interface UsuarioRepository {
    void guardarUsuarios(List<Usuario> usuarios);
    List<Usuario> cargarUsuarios();
    void agregarUsuario(Usuario usuario);
    void eliminarUsuario(String nombreDeUsuario);
    Usuario buscarUsuario(String nombreDeUsuario);
}
