/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package viewmodel;

import model.*;

public class ClinicaViewModel {
    private Clinica clinica;

    public ClinicaViewModel(Clinica clinica) {
        this.clinica = clinica;
    }

    public void registrarPaciente(Paciente p) { clinica.agregarPaciente(p); }
    public void registrarMedico(Medico m) { clinica.agregarMedico(m); }
    public void registrarConsulta(Consulta c) {
        clinica.agregarConsulta(c);
        c.getMedico().agendarConsulta(c);
    }

    public Clinica getClinica() { return clinica; }
}