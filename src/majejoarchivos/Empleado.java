/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package majejoarchivos;

import java.time.LocalDate;

/**
 *
 * @author Alberto
 */
public class Empleado {
    private String clave;
    private String nombre;
    private String apellidos;
    private LocalDate fechaIngreso;
    private double sueldo;

    public Empleado(){}
    /**
     * Construye un empleado a partir del contenido de una línea leida de
     * un archivo, esta línea tendrá que venir con separadores &$ 
     * @param datos 
     */
    
    public Empleado(String clave, String nombre, String apellidos, LocalDate fechaIngreso, double sueldo){
        this.clave=clave;
        this.nombre=nombre;
        this.apellidos = apellidos;
        this.fechaIngreso = fechaIngreso;
        this.sueldo = sueldo;
    }

    public Empleado(String linea) {
        String[] elementos=linea.split("\\&\\$");
        this.clave=elementos[0];
        this.nombre=elementos[1];
        this.apellidos = elementos[2];
        this.fechaIngreso = LocalDate.parse(elementos[3]);
        this.sueldo = Double.parseDouble(elementos[4]);
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Object[] toArray(){
        return new Object[]{clave,apellidos+ " " +nombre,fechaIngreso};
    }

    @Override
    public String toString() {
        return clave + "&$" + nombre + "&$" + apellidos + "&$" + fechaIngreso + "&$" + sueldo;
    }
}
