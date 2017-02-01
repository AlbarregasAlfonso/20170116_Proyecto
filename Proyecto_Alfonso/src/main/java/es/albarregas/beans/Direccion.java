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
public class Direccion {
    private String nombre;
    private String nombreDireccion;
    private Pueblo pueblo;
    private Provincia provincia;
    private String telefono;
    private String idDireccion;
    private String codigoPostal;

    public Direccion(String nombre, String nombreDireccion) {
        this.nombre = nombre;
        this.nombreDireccion = nombreDireccion;
    }


    public Direccion(String nombre, String nombreDireccion, String telefono, String codigoPostal) {
        this.nombre = nombre;
        this.nombreDireccion = nombreDireccion;
        this.telefono = telefono;
        this.codigoPostal = codigoPostal;
    }
    
    
    public Direccion(String idDireccion,String nombre, String nombreDireccion,String telefono, Pueblo pueblo, Provincia provincia) {
        this.nombre = nombre;
        this.nombreDireccion = nombreDireccion;
        this.pueblo = pueblo;
        this.provincia = provincia;
        this.telefono = telefono;
        this.idDireccion = idDireccion;
    }

 public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    
    
    
    public Pueblo getPueblo() {
        return pueblo;
    }

    public void setPueblo(Pueblo pueblo) {
        this.pueblo = pueblo;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public Direccion() {
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreDireccion() {
        return nombreDireccion;
    }

    public void setNombreDireccion(String nombreDireccion) {
        this.nombreDireccion = nombreDireccion;
    }
    
    
    public String getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(String idDireccion) {
        this.idDireccion = idDireccion;
    }
    
}
