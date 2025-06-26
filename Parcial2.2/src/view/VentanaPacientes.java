/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import model.Clinica;
import model.Paciente;

import javax.swing.*;
import java.awt.*;

public class VentanaPacientes extends JFrame {
    private JTextField txtId, txtNombre, txtApellido, txtEdad, txtEPS;
    private JTextArea areaPacientes;
    private Clinica clinica;

    public VentanaPacientes(Clinica clinica) {
        this.clinica = clinica;

        setTitle("Gestión de Pacientes");
        setSize(400, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(6, 2));
        panel.add(new JLabel("ID:")); txtId = new JTextField(); panel.add(txtId);
        panel.add(new JLabel("Nombre:")); txtNombre = new JTextField(); panel.add(txtNombre);
        panel.add(new JLabel("Apellido:")); txtApellido = new JTextField(); panel.add(txtApellido);
        panel.add(new JLabel("Edad:")); txtEdad = new JTextField(); panel.add(txtEdad);
        panel.add(new JLabel("EPS:")); txtEPS = new JTextField(); panel.add(txtEPS);
        JButton btnRegistrar = new JButton("Registrar");
        JButton btnListar = new JButton("Listar");
        panel.add(btnRegistrar); panel.add(btnListar);

        add(panel, BorderLayout.NORTH);

        areaPacientes = new JTextArea();
        areaPacientes.setEditable(false);
        add(new JScrollPane(areaPacientes), BorderLayout.CENTER);

        btnRegistrar.addActionListener(e -> registrarPaciente());
        btnListar.addActionListener(e -> listarPacientes());
    }

    private void registrarPaciente() {
        try {
            int id = Integer.parseInt(txtId.getText().trim());
            int edad = Integer.parseInt(txtEdad.getText().trim());
            String nombre = txtNombre.getText().trim();
            String apellido = txtApellido.getText().trim();
            String eps = txtEPS.getText().trim();

            Paciente p = new Paciente(id, edad, nombre, apellido, eps);
            clinica.agregarPaciente(p);
            JOptionPane.showMessageDialog(this, "Paciente registrado con éxito.");
            limpiar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en el registro.");
        }
    }

    private void listarPacientes() {
        areaPacientes.setText("");
        for (Paciente p : clinica.getPacientes()) {
            areaPacientes.append("ID: " + p.getId() + " - " + p.getNombre() + " " + p.getApellido() + "\n");
        }
    }

    private void limpiar() {
        txtId.setText(""); txtNombre.setText(""); txtApellido.setText(""); txtEdad.setText(""); txtEPS.setText("");
    }
}