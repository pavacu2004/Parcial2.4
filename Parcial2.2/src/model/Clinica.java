/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

public class Clinica {
    private List<Paciente> pacientes = new ArrayList<>();
    private List<Medico> medicos = new ArrayList<>();
    private List<Consulta> consultas = new ArrayList<>();

    public void agregarPaciente(Paciente p) { pacientes.add(p); }
    public void agregarMedico(Medico m) { medicos.add(m); }
    public void agregarConsulta(Consulta c) { consultas.add(c); }

    public List<Paciente> getPacientes() { return pacientes; }
    public List<Medico> getMedicos() { return medicos; }
    public List<Consulta> getConsultas() { return consultas; }

    public List<Consulta> consultarPorPaciente(int idPaciente) {
        List<Consulta> resultado = new ArrayList<>();
        for (Consulta c : consultas) {
            if (c.getPaciente().getId() == idPaciente)
                resultado.add(c);
        }
        return resultado;
    }

    public List<Consulta> consultarPorMedico(int idMedico) {
        List<Consulta> resultado = new ArrayList<>();
        for (Consulta c : consultas) {
            if (c.getMedico().getId() == idMedico)
                resultado.add(c);
        }
        return resultado;
    }
}