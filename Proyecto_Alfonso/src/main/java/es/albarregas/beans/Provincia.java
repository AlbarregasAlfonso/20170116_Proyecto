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
public class Provincia {
    private String idPueblo;
    private String idProvincia;
    private String codigoPostal;
    private String nombre;
    private String nombrePueblo;

    public Provincia(String idPueblo, String idProvincia, String codigoPostal, String nombre, String nombrePueblo) {
        this.idPueblo = idPueblo;
        this.idProvincia = idProvincia;
        this.codigoPostal = codigoPostal;
        this.nombre = nombre;
        this.nombrePueblo = nombrePueblo;
    }

    
    public String getIdPueblo() {
        return idPueblo;
    }

    public void setIdPueblo(String idPueblo) {
        this.idPueblo = idPueblo;
    }

    public String getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(String idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombrePueblo() {
        return nombrePueblo;
    }

    public void setNombrePueblo(String nombrePueblo) {
        this.nombrePueblo = nombrePueblo;
    }

    public Provincia() {
    }

    public Provincia(String nombre) {
        this.nombre = nombre;
    }

}
