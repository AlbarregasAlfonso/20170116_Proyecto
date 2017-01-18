/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.beans;

/**
 *
 * @author alfonso
 */
public class Cliente {
   
    private String nombre;
    private String apellidos;
    private String email;
    private String nif;
    private String fechaNacimiento;
    private Producto producto;

    
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
  

    
    public Cliente(String nombre, String apellidos, String email, String nif, String fechaNacimiento) {
  
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.nif = nif;
        this.fechaNacimiento = fechaNacimiento;
       
    }

    public Cliente() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

  
    
    
}
