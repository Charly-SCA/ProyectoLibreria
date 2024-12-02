/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majejoarchivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author charl
 */
public class MajejoArchivos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File archivo=new File("registro.poo");
        Scanner lector=null;
        FileWriter escritor=null;
        try {
            lector=new Scanner(archivo);
            escritor=new FileWriter(archivo, true);
            // Quiero escribir al inicio del archivo y desechar lo que ya tenia
            // 
            escritor.write("HOLA A TODOS\n");
            while(true)
                System.out.println(lector.nextLine());
            
        } 
        catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
        }catch(IOException ex){
            System.out.println("Error al guardar el archivo");
        }catch(NoSuchElementException ex){
            System.out.println("Fin del archivo");
        }finally{
            if(lector!=null)
                lector.close();
            try{
                escritor.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al guardar en el archivo", 
                        "Lectura y escritura", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
}
