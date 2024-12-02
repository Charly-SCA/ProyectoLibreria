/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluacionfinal;

class Solicitante {
    private String nombre;

    public Solicitante() {}

    public Solicitante(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Object[] toArray(){
        return new Object[]{nombre};
    }

    @Override
    public String toString() {
        return nombre;
    }
}

