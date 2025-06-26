/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package view;

import model.Clinica;
import model.Medico;

import javax.swing.*;
import java.awt.*;

public class VentanaMedicos extends JFrame {
    private JTextField txtId, txtNombre, txtApellido, txtEdad, txtEsp;
    private JTextArea areaMedicos;
    private Clinica clinica;

    public VentanaMedicos(Clinica clinica) {
        this.clinica = clinica;

        setTitle("Gestión de Médicos");
        setSize(400, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(6, 2));
        panel.add(new JLabel("ID:")); txtId = new JTextField(); panel.add(txtId);
        panel.add(new JLabel("Nombre:")); txtNombre = new JTextField(); panel.add(txtNombre);
        panel.add(new JLabel("Apellido:")); txtApellido = new JTextField(); panel.add(txtApellido);
        panel.add(new JLabel("Edad:")); txtEdad = new JTextField(); panel.add(txtEdad);
        panel.add(new JLabel("Especialidad:")); txtEsp = new JTextField(); panel.add(txtEsp);
        JButton btnRegistrar = new JButton("Registrar");
        JButton btnListar = new JButton("Listar");
        panel.add(btnRegistrar); panel.add(btnListar);

        add(panel, BorderLayout.NORTH);

        areaMedicos = new JTextArea();
        areaMedicos.setEditable(false);
        add(new JScrollPane(areaMedicos), BorderLayout.CENTER);

        btnRegistrar.addActionListener(e -> registrarMedico());
        btnListar.addActionListener(e -> listarMedicos());
    }

    private void registrarMedico() {
        try {
            int id = Integer.parseInt(txtId.getText().trim());
            int edad = Integer.parseInt(txtEdad.getText().trim());
            String nombre = txtNombre.getText().trim();
            String apellido = txtApellido.getText().trim();
            String esp = txtEsp.getText().trim();

            Medico m = new Medico(id, edad, nombre, apellido, esp);
            clinica.agregarMedico(m);
            JOptionPane.showMessageDialog(this, "Médico registrado.");
            limpiar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en el registro.");
        }
    }

    private void listarMedicos() {
        areaMedicos.setText("");
        for (Medico m : clinica.getMedicos()) {
            areaMedicos.append("ID: " + m.getId() + " - " + m.getNombre() + " " + m.getApellido() + "\n");
        }
    }

    private void limpiar() {
        txtId.setText(""); txtNombre.setText(""); txtApellido.setText(""); txtEdad.setText(""); txtEsp.setText("");
    }
}