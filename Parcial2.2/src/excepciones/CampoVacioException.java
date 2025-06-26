/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

public class CampoVacioException extends Exception {
    public CampoVacioException(String campo) {
        super("El campo '" + campo + "' no puede estar vacío.");
    }
}