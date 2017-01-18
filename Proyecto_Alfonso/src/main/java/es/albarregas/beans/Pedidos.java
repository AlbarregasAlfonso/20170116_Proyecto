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
public class Pedidos {
 
    
    private String estado;
    private String idCliente;

    public Pedidos(String estado, String idCliente) {
        this.estado = estado;
        this.idCliente = idCliente;
    } 
    
    public String getEstado() {
        return estado;
    }

    public Pedidos() {
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
    
    
}
