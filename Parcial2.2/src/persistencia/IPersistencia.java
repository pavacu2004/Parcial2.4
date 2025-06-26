/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import model.Clinica;

public interface IPersistencia {
    void guardar(Clinica clinica, String ruta) throws Exception;
    Clinica cargar(String ruta) throws Exception;
}