/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Consulta implements Serializable {
    private Paciente paciente;
    private Medico medico;
    private LocalDate fecha;
    private String sintomas, diagnostico, tratamiento;

    public Consulta(Paciente paciente, Medico medico, LocalDate fecha,
                    String sintomas, String diagnostico, String tratamiento) {
        this.paciente = paciente;
        this.medico = medico;
        this.fecha = fecha;
        this.sintomas = sintomas;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
    }

    public Paciente getPaciente() { return paciente; }

    public Medico getMedico() { return medico; }

    public String getResumen() {
        return fecha + " - " + paciente.getNombre() + " atendido por " + medico.getNombre();
    }
}