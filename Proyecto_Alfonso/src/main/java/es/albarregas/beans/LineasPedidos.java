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
public class LineasPedidos {
    private String idPedido;
    private int numeroLinea;
    private String idProducto;
    private String cantidad;
    private String precioUnitario;
    private Producto producto;

    public LineasPedidos(String idPedido, int numeroLinea, String idProducto, String cantidad) {
        this.idPedido = idPedido;
        this.numeroLinea = numeroLinea;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }

    public LineasPedidos(String cantidad, Producto producto , String idPedido) {
        this.idPedido = idPedido;
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    

    public LineasPedidos() {
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public int getNumeroLinea() {
        return numeroLinea;
    }

    public void setNumeroLinea(int numeroLinea) {
        this.numeroLinea = numeroLinea;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(String precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    
           
    
    
}
