/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluacionfinal;

public class Libro {
    private String nombre;
    private String autor;
    private String disponible = "Disponible"; 

    public Libro() {}

    public Libro(String nombre, String autor, String disponibilidad) {
        setNombre(nombre);
        setAutor(autor);
        setDisponible(disponible);
    }

    public Libro(String linea) {
        String[] elementos = linea.split("\\&\\$");
        this.nombre = elementos[0];
        this.autor = elementos[1];
        this.disponible = elementos[2];
    }
    
    public Libro(String linea, int n) {
        this.nombre = linea;
    }   
    

    public String getNombre() { 
        return nombre; 
    }
    public void setNombre(String nombre) { 
        nombre = nombre.trim().replace("  "," ").replace("  "," ");
        if(nombre.toLowerCase().length() >= 2 && nombre.toLowerCase().length() <= 30) {
            this.nombre = nombre;
        } else {
            throw new IllegalArgumentException("El nombre es obligatorio y debe tener entre 2 y 30 caracteres");
        }
    }

    public String getAutor() { 
        return autor; 
    }
    public void setAutor(String autor) { 
        autor = autor.trim().replace("  "," ").replace("  "," ");
        if(autor.toLowerCase().length() >= 2 && autor.toLowerCase().length() <= 30) {
            this.autor = autor;
        } else {
            throw new IllegalArgumentException("El nombre es obligatorio y debe tener entre 2 y 30 caracteres");
        }
    }

    public String getDisponible() {
        return disponible;
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }

    public Object[] toArray(){
        return new Object[]{nombre, autor, disponible};
    }

    @Override
    public String toString() {
        return nombre + "&$" + autor + "&$" + disponible;
    }

}



