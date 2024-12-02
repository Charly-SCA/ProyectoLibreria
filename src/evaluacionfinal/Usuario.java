/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluacionfinal;
/**
 *
 * @author charl
 */
import java.util.ArrayList;
import java.util.regex.Pattern;


public class Usuario{
    
    
    private int clave;
    private String apodo;
    private String nombre;
    private String apellidos;
    private String contrasena;
    
    public Usuario(){
    }
    public Usuario(String linea){
        String[] elementos=linea.split("//&//$");
        this.clave=Integer.parseInt(elementos[0]);
        this.apodo=elementos[1];
        this.nombre = elementos[2];
        this.apellidos = elementos[3];
        this.contrasena = elementos[4];
    }
    
    public Usuario(int clave, String apodo, String nombre, String apellidos, String contrasena) {
        this.clave = clave;
        this.apodo = apodo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.contrasena = contrasena;
    }

    public Usuario(String apodo, String contrasena) {
        this.apodo = apodo;
        this.contrasena = contrasena;
    }

    Usuario(int parseInt, String dato, String dato0, String dato1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getApodo() { 
        return apodo; 
    }
    public void setApodo(String apodo) { 
         if (apodo.toLowerCase().matches("[cmtadegs][0-9]{2}12[0-9]{4}")) {
            this.apodo = apodo;
        }
         else {
            throw new IllegalArgumentException("El número de control es obligatorio y debe tener un formato válido");
        }
    }

    public String getNombre() { 
        return nombre; 
    }
    public void setNombre(String nombre) { 
        nombre=nombre.trim().replace("  "," ").replace("  "," ");
        //entre 2 y máximo 30
        if(nombre.toLowerCase().length()>=2 && nombre.toLowerCase().length()<=30)
            this.nombre = nombre;
        else
            throw new IllegalArgumentException("El nombre es obligatorio y debe tener entre "
                    + "2 y 30 caracteres");
        
    }

    public String getApellidos() { 
        return apellidos; 
    }
    public void setApellidos(String apellidos) { 
        this.apellidos = apellidos; 
    }

    public String getContrasena() { 
        return contrasena; 
    }
    public void setContrasena(String contrasena) { 
        this.contrasena = contrasena; 
    }

    public static boolean esAlumno(String apodo) {
        return Pattern.matches("S\\d{8}", apodo);
    }

    public Object[] toArray(){
        return new Object[]{clave,apodo,nombre,apellidos,contrasena};
    }
    
    @Override
    public String toString() {
        return clave +"&$ " +apodo + "&$" + nombre + "&$" + apellidos + "&$" + contrasena;
    }
}

