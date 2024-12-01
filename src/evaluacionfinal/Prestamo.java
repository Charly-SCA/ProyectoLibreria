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
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Prestamo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Solicitante solicitante;
    private ArrayList<Libro> librosPrestados;
    private LocalDate fechaPrestamo;
    private LocalDate fechaLimiteEntrega;
    private LocalDate fechaDevolucion;

    public Prestamo(Solicitante solicitante, ArrayList<Libro> librosPrestados, LocalDate fechaPrestamo, LocalDate fechaLimiteEntrega) {
        this.solicitante = solicitante;
        this.librosPrestados = librosPrestados;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaLimiteEntrega = fechaLimiteEntrega;
        this.fechaDevolucion = null;
    }
    
    public Prestamo(Solicitante solicitante, ArrayList<Libro> librosPrestados, LocalDate fechaLimiteEntrega) {
        this.solicitante = solicitante;
        this.librosPrestados = librosPrestados;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaLimiteEntrega = fechaLimiteEntrega;
        this.fechaDevolucion = null;
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

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void devolverLibros() {
        this.fechaDevolucion = LocalDate.now();
        for (Libro libro : librosPrestados) {
            libro.setDisponible(true);
        }
    }
    
    public Object[] toArray(){
        return new Object[]{solicitante, fechaPrestamo, fechaDevolucion};
    }

    @Override
    public String toString() {
        StringBuilder libros = new StringBuilder();
        for (Libro libro : librosPrestados) {
            libros.append(libro.getNombre()).append(", ");
        }
        return "Solicitante: " + solicitante.getNombre() + ", Libros: " + libros.toString() + 
               ", Fecha de Préstamo: " + fechaPrestamo + ", Fecha Límite de Entrega: " + fechaLimiteEntrega + 
               ", Fecha de Devolución: " + (fechaDevolucion != null ? fechaDevolucion : "No devuelto");
    }
}


