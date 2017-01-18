/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Pedidos;

/**
 *
 * @author AlfonsoTerrones
 */
public interface IPedidosDAO {
    
    public void insertarCarrito(Pedidos p);
    
     public String idPedidoMax();
    
}
