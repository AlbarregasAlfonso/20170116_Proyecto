/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Cliente;
import es.albarregas.beans.Pedidos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AlfonsoTerrones
 */
public class MysqlPedidosDAO implements IPedidosDAO {

    /*
    recorremos la linea de pedidos para comprobar si esta ya en la tabla
    si no lo ha encontrado damos de alta producto nuevo
    lineadepedidos insertamos el pedido
    metemos el producto
    
     */
    @Override
    public void insertarCarrito(Pedidos p) {
        try {
            String sql = "INSERT INTO `empresaweb`.`pedidos` (`IdPedido`, `Estado`, `IdCliente` , `Fecha`) VALUES (?,?,?,now())";

            PreparedStatement preparada = ConnectionFactory.getConnection().prepareStatement(sql);
            preparada.setInt(1, 0);
            preparada.setString(2, p.getEstado());
            preparada.setString(3, p.getIdCliente());
            preparada.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Algo ha pasado al insertar");
            System.out.println(ex.getErrorCode());
            //Logger.getLogger(MysqlPedidosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String idPedidoMax() {
        String re = null;
        try {
            String idPedido = "Select max(IdPedido) from pedidos";
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(idPedido);
            Throwable throwable = null;
            try {
                if (resultado.next()) {
                    re = resultado.getString("IdPedido");
                }
            } catch (Throwable cliente) {
                throwable = cliente;
                throw cliente;
            } finally {
                if (resultado != null) {
                    if (throwable != null) {
                        try {
                            resultado.close();
                        } catch (Throwable registro) {
                            throwable.addSuppressed(registro);
                        }
                    } else {
                        resultado.close();
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentencia");
            ex.printStackTrace();
        }
        return re;
    }

}
