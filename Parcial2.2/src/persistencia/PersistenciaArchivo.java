/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import model.Clinica;
import java.io.*;

public class PersistenciaArchivo implements IPersistencia {
    public void guardar(Clinica clinica, String ruta) throws Exception {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ruta));
        out.writeObject(clinica);
        out.close();
    }

    public Clinica cargar(String ruta) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(ruta));
        Clinica clinica = (Clinica) in.readObject();
        in.close();
        return clinica;
    }
}