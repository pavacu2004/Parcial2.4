/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import model.Clinica;
import view.VentanaPrincipal;

public class Main {
    public static void main(String[] args) {
        Clinica clinica = new Clinica();
        new VentanaPrincipal(clinica).setVisible(true);
    }
}