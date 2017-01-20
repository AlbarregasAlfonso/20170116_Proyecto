/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.beans;

import java.util.ArrayList;

/**
 *
 * @author AlfonsoTerrones
 */
public class Pedidos {

    private String idCliente;
    private String fecha;
    private String estado;
    private String baseImponible;
    private String descuento;
    private String gastosEnvio;
    private String iva;
    private String idDireccion;
    ArrayList<LineasPedidos> lineasPedidos;

    public Pedidos(String idCliente, String estado) {
        this.idCliente = idCliente;
        this.estado = estado;
    }

    public ArrayList<LineasPedidos> getLineasPedidos() {
        return lineasPedidos;
    }

    public void setLineasPedidos(ArrayList<LineasPedidos> lineasPedidos) {
        this.lineasPedidos = lineasPedidos;
    }
    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getBaseImponible() {
        return baseImponible;
    }

    public void setBaseImponible(String baseImponible) {
        this.baseImponible = baseImponible;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public String getGastosEnvio() {
        return gastosEnvio;
    }

    public void setGastosEnvio(String gastosEnvio) {
        this.gastosEnvio = gastosEnvio;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    public String getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(String idDireccion) {
        this.idDireccion = idDireccion;
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
