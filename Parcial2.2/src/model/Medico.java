/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import java.util.ArrayList;
import java.util.List;

public class Medico extends Persona implements Agendable {
    private String especialidad;
    private List<Consulta> consultas;

    public Medico(int id, int edad, String nombre, String apellido, String especialidad) {
        super(id, edad, nombre, apellido);
        this.especialidad = especialidad;
        this.consultas = new ArrayList<>();
    }

    public String getEspecialidad() { return especialidad; }

    public void agendarConsulta(Consulta c) {
        consultas.add(c);
    }

    public List<Consulta> getConsultas() { return consultas; }
}