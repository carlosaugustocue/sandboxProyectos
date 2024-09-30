package org.cue.serializacion.domain;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String nombreDeUsuario;
    private String email;

    // Constructor
    public Usuario(String nombreDeUsuario, String email) {
        this.nombreDeUsuario = nombreDeUsuario;
        this.email = email;
    }

    // Getters y Setters
    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }

    public void setNombreDeUsuario(String nombreDeUsuario) {
        this.nombreDeUsuario = nombreDeUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombreDeUsuario='" + nombreDeUsuario + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
