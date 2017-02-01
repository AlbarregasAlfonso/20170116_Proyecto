/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Pedidos;
import java.util.ArrayList;

/**
 *
 * @author AlfonsoTerrones
 */
public interface IPedidosDAO {

    public void insertarCarrito(Pedidos p);

    public ArrayList<Pedidos> obtenerPedidos(String idCliente);
    
    public String idPedidoMaxDeUnCliente(String idCliente);

    public String sacarEstadoUltimoPedido(String idusuario);

    public boolean obtenerApellidoDelClienteDeUnPedido(String idPedido);
    
    public void modificarEstadoDePedido(String estado,String idCliente,String idDireccion,float totalprecio,String gastosEnvio);
    
    public void modificarEstadosDesPedidos();

    public void closeConnection();

}
