/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import model.Clinica;
import model.Consulta;
import model.Medico;
import model.Paciente;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class VentanaConsulta extends JFrame {
    private JTextField txtIdPaciente, txtIdMedico, txtSintomas, txtDiagnostico, txtTratamiento;
    private Clinica clinica;

    public VentanaConsulta(Clinica clinica) {
        this.clinica = clinica;

        setTitle("Agendar Consulta");
        setSize(400, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2));

        add(new JLabel("ID Paciente:")); txtIdPaciente = new JTextField(); add(txtIdPaciente);
        add(new JLabel("ID Médico:")); txtIdMedico = new JTextField(); add(txtIdMedico);
        add(new JLabel("Síntomas:")); txtSintomas = new JTextField(); add(txtSintomas);
        add(new JLabel("Diagnóstico:")); txtDiagnostico = new JTextField(); add(txtDiagnostico);
        add(new JLabel("Tratamiento:")); txtTratamiento = new JTextField(); add(txtTratamiento);

        JButton btnRegistrar = new JButton("Registrar");
        add(new JLabel()); // espacio vacío
        add(btnRegistrar);

        btnRegistrar.addActionListener(e -> registrarConsulta());
    }

    private void registrarConsulta() {
        try {
            int idPaciente = Integer.parseInt(txtIdPaciente.getText().trim());
            int idMedico = Integer.parseInt(txtIdMedico.getText().trim());

            Paciente paciente = clinica.getPacientes().stream()
                    .filter(p -> p.getId() == idPaciente).findFirst().orElse(null);
            Medico medico = clinica.getMedicos().stream()
                    .filter(m -> m.getId() == idMedico).findFirst().orElse(null);

            if (paciente == null || medico == null) {
                JOptionPane.showMessageDialog(this, "Paciente o médico no encontrado.");
                return;
            }

            Consulta consulta = new Consulta(
                    paciente, medico, LocalDate.now(),
                    txtSintomas.getText(), txtDiagnostico.getText(), txtTratamiento.getText()
            );

            clinica.agregarConsulta(consulta);
            medico.agendarConsulta(consulta);

            JOptionPane.showMessageDialog(this, "Consulta registrada con éxito.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al registrar la consulta.");
        }
    }
}