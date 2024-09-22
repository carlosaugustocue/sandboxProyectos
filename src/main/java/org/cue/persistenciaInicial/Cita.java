package org.cue.persistenciaInicial;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Cita implements Serializable {
    private LocalDateTime fechaHora;
    private String motivo;
    private Paciente paciente;

    // Constructor
    public Cita(LocalDateTime fechaHora, String motivo, Paciente paciente) {
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.paciente = paciente;
    }

    // Getters y Setters
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "fechaHora=" + fechaHora +
                ", motivo='" + motivo + '\'' +
                ", paciente=" + paciente.getNombre() + " " + paciente.getApellido() +
                '}';
    }
}

