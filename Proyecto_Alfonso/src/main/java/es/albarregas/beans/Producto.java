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
public class Producto {
    private String idProducto;
    private String idCategoria;
    private String idMarca;
    private String denominacion;
    private String descripcion; 
    private String idProveedor;
    private String precioUnitario;
    private String stock;
    private String stockMinimo;
    private String fechaAlta;
    private String oferta;
    private String fueraCatalogo;
    private String rating;
    private String precioConIva;
    private String cantidadQueFaltaEnStock;

    
    
    
    
    public String getCantidadQueFaltaEnStock() {
        return cantidadQueFaltaEnStock;
    }

    public void setCantidadQueFaltaEnStock(String cantidadQueFaltaEnStock) {
        this.cantidadQueFaltaEnStock = cantidadQueFaltaEnStock;
    }

    

    public Producto(String idProducto, String denominacion, String precioUnitario, String stock, String precioConIva) {
        this.idProducto = idProducto;
        this.denominacion = denominacion;
        this.precioUnitario = precioUnitario;
        this.stock = stock;
        this.precioConIva = precioConIva;
    }

      public Producto(String idProducto, String denominacion, String precioUnitario, String stock) {
        this.idProducto = idProducto;
        this.denominacion = denominacion;
        this.precioUnitario = precioUnitario;
        this.stock = stock;
 
    }
   

    public Producto() {
    }

    public Producto(String idProducto, String denominacion, String cantidadQueFaltaEnStock) {
        this.idProducto = idProducto;
        this.denominacion = denominacion;
        this.cantidadQueFaltaEnStock = cantidadQueFaltaEnStock;
    }

   

    
    
    public String getPrecioConIva() {
        return precioConIva;
    }

    public void setPrecioConIva(String precioConIva) {
        this.precioConIva = precioConIva;
    }

    
    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(String idMarca) {
        this.idMarca = idMarca;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(String precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(String stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getOferta() {
        return oferta;
    }

    public void setOferta(String oferta) {
        this.oferta = oferta;
    }

    public String getFueraCatalogo() {
        return fueraCatalogo;
    }

    public void setFueraCatalogo(String fueraCatalogo) {
        this.fueraCatalogo = fueraCatalogo;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
    
    
    
}
