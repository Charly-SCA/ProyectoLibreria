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
import java.time.LocalDate;
import java.util.ArrayList;

public class Prestamo {
    public Solicitante solicitante;
    public ArrayList<Libro> librosPrestados;
    public LocalDate fechaPrestamo;
    public LocalDate fechaLimiteEntrega;
    public String devolucion ="No devuelto";

    public Prestamo() {}

    public Prestamo(Solicitante solicitante, ArrayList<Libro> librosPrestados, LocalDate fechaPrestamo, LocalDate fechaLimiteEntrega, String devolucion) {
        this.solicitante = solicitante;
        this.librosPrestados = librosPrestados;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaLimiteEntrega = fechaLimiteEntrega;
        this.devolucion = devolucion;
    }
    
    public Prestamo(Solicitante solicitante, ArrayList<Libro> librosPrestados, LocalDate fechaLimiteEntrega) {
        this.solicitante = solicitante;
        this.librosPrestados = librosPrestados;
        this.fechaLimiteEntrega = fechaLimiteEntrega;
        this.devolucion = "";
    }

    public Prestamo(String linea) { 
        String[] elementos = linea.split("\\&\\$"); 
        this.solicitante = new Solicitante(elementos[0]); 
        this.librosPrestados = new ArrayList<>(); 
        for (String libro : elementos[1].split(",")) { 
            this.librosPrestados.add(new Libro(libro.trim())); 
        } 
        this.fechaPrestamo = LocalDate.parse(elementos[2]); 
        this.fechaLimiteEntrega = LocalDate.parse(elementos[3]); 
        this.devolucion = elementos[4]; 
    }

    public Solicitante getSolicitante() {
        return solicitante;
    }

    public ArrayList<Libro> getLibrosPrestados() {
        return librosPrestados;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public LocalDate getFechaLimiteEntrega() {
        return fechaLimiteEntrega;
    }

    public String getFechaDevolucion() {
        return devolucion;
    }

    public void devolverLibros() {
        this.devolucion = devolucion;
        for (Libro libro : librosPrestados) {
            libro.setDisponible(true);
        }
    }

    public Object[] toArray() { 
        return new Object[]{solicitante, fechaPrestamo, 
            devolucion};
    }

    @Override
    public String toString() {
        StringBuilder libros = new StringBuilder();
        for (Libro libro : librosPrestados) {
            libros.append(libro.getNombre()).append(", ");
        }
        return solicitante.getNombre() + "&$" + libros.toString().replaceAll(", $", "") + 
               "&$" + fechaPrestamo + "&$" + fechaLimiteEntrega + "&$" + devolucion;
    }
}



