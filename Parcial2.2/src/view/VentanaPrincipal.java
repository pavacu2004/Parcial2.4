/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import model.Clinica;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {
    public VentanaPrincipal(Clinica clinica) {
        setTitle("Sistema de Gestión Clínica");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));

        JButton btnPacientes = new JButton("Registrar Pacientes");
        JButton btnMedicos = new JButton("Registrar Médicos");
        JButton btnConsulta = new JButton("Agendar Consulta");
        JButton btnHistorial = new JButton("Historial / Consultas por Médico");

        btnPacientes.addActionListener(e -> new VentanaPacientes(clinica).setVisible(true));
        btnMedicos.addActionListener(e -> new VentanaMedicos(clinica).setVisible(true));
        btnConsulta.addActionListener(e -> new VentanaConsulta(clinica).setVisible(true));
        btnHistorial.addActionListener(e -> new VentanaHistorial(clinica).setVisible(true));

        panel.add(btnPacientes);
        panel.add(btnMedicos);
        panel.add(btnConsulta);
        panel.add(btnHistorial);

        add(panel);
    }
}