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
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class Prestamo {
    public Solicitante solicitante;
    public ArrayList<Libro> librosPrestados;
    public LocalDate fechaPrestamo;
    public LocalDate fechaLimiteEntrega;
    private LocalDate fechaDevolucion;
    private String devolucion;

    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private LocalDate parseFecha(String fecha) {
        try {
            return LocalDate.parse(fecha, FORMATO_FECHA);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("La fecha no tiene el formato válido (dd-MM-yyyy): " + fecha);
        }
    }
    
    public Prestamo() {
        this.fechaPrestamo = LocalDate.now();  
    }

    public Prestamo(Solicitante solicitante, ArrayList<Libro> librosPrestados, LocalDate fechaPrestamo, 
            LocalDate fechaLimiteEntrega, String devolucion) {
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
    }

    public Prestamo(String linea) { 
        String[] elementos = linea.split("\\&\\$"); 
        if (elementos.length >= 5) {
            this.solicitante = new Solicitante(elementos[0]); 
            this.librosPrestados = new ArrayList<>(); 
            for (String libro : elementos[1].split(",")) { 
                this.librosPrestados.add(new Libro(libro.trim(),1)); 
            } 
            this.fechaPrestamo = LocalDate.parse(elementos[2]); 
            this.fechaLimiteEntrega = LocalDate.parse(elementos[3]); 
            this.fechaDevolucion = LocalDate.parse(elementos[4]);
        }else if(elementos.length==4){
            this.solicitante = new Solicitante(elementos[0]);
            this.librosPrestados = new ArrayList<>(); 
            for (String libro : elementos[1].split(",")) { 
                this.librosPrestados.add(new Libro(libro.trim())); 
            } 
            this.fechaPrestamo = LocalDate.parse(elementos[2]); 
            this.fechaLimiteEntrega = LocalDate.parse(elementos[3]);
        }
    }

    public Solicitante getSolicitante() {
        return solicitante;
    }
    public void setSolicitante(Solicitante solicitante) {
        this.solicitante = solicitante;
    }

    public ArrayList<Libro> getLibrosPrestados() {
        return librosPrestados;
    }
    public void setLibrosPrestados(ArrayList<Libro> librosPrestados) {
        this.librosPrestados = librosPrestados;
    }
    

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }
    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaLimiteEntrega() {
        return fechaLimiteEntrega;
    }
    public void setFechaLimiteEntrega(String fechaLimite) {
        LocalDate fecha = parseFecha(fechaLimite);
        if (fecha.isBefore(fechaPrestamo)) {
            throw new IllegalArgumentException("La fecha límite no puede ser anterior a la fecha de solicitud.");
        }
        this.fechaLimiteEntrega = fecha;
    }

    public LocalDate getFechaDev() {
        return fechaDevolucion;
    }

    public void setFechaDev(LocalDate fechaDev) {
        this.fechaDevolucion = fechaDev;
    }

   public void devolverLibros() { 
       this.devolucion = "Devuelto"; 
       for (Libro libro : librosPrestados) { 
           libro.setDisponible("Disponible"); 
       } 
   }

    public Object[] toArray() { 
        return new Object[]{solicitante, fechaPrestamo, fechaLimiteEntrega, fechaDevolucion, devolucion};
    }

    @Override
    public String toString() {
        StringBuilder libros = new StringBuilder();
        for (Libro libro : librosPrestados) {
            libros.append(libro.getNombre()).append(",");
        }
        return solicitante.getNombre() + "&$" + libros.toString().replaceAll(",$", "") + 
               "&$" + fechaPrestamo + "&$" + fechaLimiteEntrega + "&$" + fechaDevolucion;
    }
}



