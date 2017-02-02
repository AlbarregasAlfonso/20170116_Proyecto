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
public class Usuario {
    
private String idUsuario;
private String userName;
private String clave;
private String bloqueado;
private String ultimoAcceso;
private String tipo;
private Cliente cliente;


    public Usuario(String userName, String clave, Cliente cliente) {
        this.userName = userName;
        this.clave = clave;
        this.cliente = cliente;
    }
    
    public Usuario(String userName, String clave) {
        this.userName = userName;
        this.clave = clave;
    }

    public Usuario(String idUsuario, String userName, String clave, String bloqueado, String ultimoAcceso, String tipo) {
        this.idUsuario = idUsuario;
        this.userName = userName;
        this.clave = clave;
        this.bloqueado = bloqueado;
        this.ultimoAcceso = ultimoAcceso;
        this.tipo = tipo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    
    
    public Usuario() {
    }

   

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUltimoAcceso() {
        return ultimoAcceso;
    }

    public void setUltimoAcceso(String ultimoAcceso) {
        this.ultimoAcceso = ultimoAcceso;
    }

    
    
    
    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    

    public String getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(String bloqueado) {
        this.bloqueado = bloqueado;
    }

    
    

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

}
