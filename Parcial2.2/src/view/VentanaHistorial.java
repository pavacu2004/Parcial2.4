/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package view;

import model.Clinica;
import model.Consulta;

import javax.swing.*;
import java.awt.*;

public class VentanaHistorial extends JFrame {
    private JTextField txtIdPaciente;
    private JTextArea areaHistorial;
    private Clinica clinica;

    public VentanaHistorial(Clinica clinica) {
        this.clinica = clinica;

        setTitle("Historial del Paciente");
        setSize(400, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelTop = new JPanel(new FlowLayout());
        panelTop.add(new JLabel("ID del Paciente:"));
        txtIdPaciente = new JTextField(10);
        panelTop.add(txtIdPaciente);
        JButton btnBuscar = new JButton("Buscar");
        panelTop.add(btnBuscar);

        add(panelTop, BorderLayout.NORTH);

        areaHistorial = new JTextArea();
        areaHistorial.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaHistorial);
        scroll.setBorder(BorderFactory.createTitledBorder("Consultas encontradas"));
        add(scroll, BorderLayout.CENTER);

        btnBuscar.addActionListener(e -> buscarHistorial());
    }

    private void buscarHistorial() {
        try {
            int id = Integer.parseInt(txtIdPaciente.getText().trim());
            areaHistorial.setText("");
            for (Consulta c : clinica.consultarPorPaciente(id)) {
                areaHistorial.append(c.getResumen() + "\n");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en la búsqueda del historial.");
        }
    }
}