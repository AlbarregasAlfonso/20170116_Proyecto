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

    public Usuario(String userName, String clave) {
        this.userName = userName;
        this.clave = clave;
    }
    
    public Usuario() {
    }

    public Usuario(String idUsuario, String userName, String bloqueado) {
        this.idUsuario = idUsuario;
        this.userName = userName;
        this.bloqueado = bloqueado;
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
