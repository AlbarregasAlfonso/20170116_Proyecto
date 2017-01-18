/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.LineasPedidos;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author AlfonsoTerrones
 */
public class MysqlLineasPedidosDAO implements ILineasPedidosDAO{

    @Override
    public void insertarProductoACarrito(LineasPedidos lp) {
//          try {
//            String sql = "INSERT INTO `empresaweb`.`pedidos` (`IdPedido`, `Estado`, `IdCliente` , `Fecha`) VALUES (?,?,?,now())";
//
//            PreparedStatement preparada = ConnectionFactory.getConnection().prepareStatement(sql);
//            preparada.setInt(1, 0);
//            preparada.setString(2, p.getEstado());
//            preparada.setString(3, p.getIdCliente());
//            preparada.executeUpdate();
//        } catch (SQLException ex) {
//            System.out.println("Algo ha pasado al insertar");
//            System.out.println(ex.getErrorCode());
//            //Logger.getLogger(MysqlPedidosDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

   
    
}
