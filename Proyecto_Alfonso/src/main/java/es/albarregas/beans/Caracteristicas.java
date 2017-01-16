/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.beans;

/**
 *
 * @author AlfonsoTerrones
 */
public class Caracteristicas {
    private String IdCaracteristica;
    private String IdCategoria;
    private String Nombre;

    public String getIdCaracteristica() {
        return IdCaracteristica;
    }

    public void setIdCaracteristica(String IdCaracteristica) {
        this.IdCaracteristica = IdCaracteristica;
    }

    public String getIdCategoria() {
        return IdCategoria;
    }

    public void setIdCategoria(String IdCategoria) {
        this.IdCategoria = IdCategoria;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    
}
