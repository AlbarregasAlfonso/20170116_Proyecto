/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.LineasPedidos;
import java.util.ArrayList;

/**
 *
 * @author AlfonsoTerrones
 */
public interface ILineasPedidosDAO {
    
    public void insertarProductoACarrito(LineasPedidos lp);
    
    public int idLineaPedidoMax();
    
    public void closeConnection();

    public ArrayList<LineasPedidos> getProductosEnCarrito(String idcliente);
    
    public ArrayList<LineasPedidos> getProductosEnCarritoConDesglose(String idcliente);
    
    public void modificarValorCantidad(String signo,String idProducto,String IdPedido);
    
    public void eliminarProductoLineaPedido(String IdPedido, String IdProducto);
    
    public boolean aumentarPedido (String idPedido, String cantidad, String idProducto);
    
    public boolean buscarProductoEnLineaPedidos (String idCliente, String idProducto);
}
