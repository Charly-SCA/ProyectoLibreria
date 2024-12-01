/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluacionfinal;

import java.io.Serializable;

/**
 *
 * @author charl
 */
class Solicitante implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String nombre;

    public Solicitante(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
