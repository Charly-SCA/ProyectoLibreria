/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluacionfinal;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author charl
 */
public class Leer implements Serializable{
    private static final long serialVersionUID = 1L;
    public static void main(String[] args) {
        try {
            // Leer objetos del archivo
            ArrayList<Object> objetos = ManejadorArchivos.leerArchivo("Solicitantes.txt");

            // Verificar si se cargaron objetos
            if (objetos != null && !objetos.isEmpty()) {
                System.out.println("Solicitantes registrados:");
                
                // Convertir a tipo Solicitante y mostrar en consola
                for (Object obj : objetos) {
                    if (obj instanceof Solicitante) {
                        Solicitante solicitante = (Solicitante) obj;
                        System.out.println(solicitante.getNombre());
                    }
                }
            } else {
                System.out.println("No se encontraron solicitantes en el archivo.");
            }

        } catch (ClassNotFoundException e) {
            System.err.println("Error: El formato del archivo no coincide. " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
