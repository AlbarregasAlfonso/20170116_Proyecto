/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;


import es.albarregas.beans.Producto;
import es.albarregas.beans.ProductoCaracteristicas;
import java.util.ArrayList;

/**
 *
 * @author AlfonsoTerrones
 */
public interface IProductoDAO {
    
    public ArrayList<Producto> getProductos(String where);
    
    public ArrayList<Producto> getProductosAvan(String where);
    
    public ArrayList<ProductoCaracteristicas> getProductosCaracteristicas(String idProducto); 
    
    public String getSacarNombreProducto(String idProducto);
    
    public String getSacarDescripcionProducto(String idProducto);
    
    public String getSacarStock(String idProducto);
    
    public String sacarIdProducto(String denominacion);
    
    public ArrayList<Producto> obtenerProductosQueFaltanEnStock (String idCliente);
    
    public ArrayList<Producto> productosSinStock();
    
    public void disminuirProductosEnStock (String idCliente, String estado, String idPedido);
    
    public void insertarEnProductosSinStock(String denominacion, String faltan, String idProducto);
    
    public void aumentarStockProducto(String denominacion,String cantidad);
    
    public void eliminarDeProductosSinStock(String denominacion);
    
    public ArrayList<Producto> productosMasVendidos();
    
    public void anadirProducto (String denominacion,String descripcion, String precio, String stock, String oferta,String catalogo, String categoria);
    
    public void closeConnection();
    
}
