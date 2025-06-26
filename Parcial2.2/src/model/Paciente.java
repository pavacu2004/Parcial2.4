/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author paval
 */

public class Paciente extends Persona {
    private String eps;

    public Paciente(int id, int edad, String nombre, String apellido, String eps) {
        super(id, edad, nombre, apellido);
        this.eps = eps;
    }

    public String getEps() { return eps; }
}