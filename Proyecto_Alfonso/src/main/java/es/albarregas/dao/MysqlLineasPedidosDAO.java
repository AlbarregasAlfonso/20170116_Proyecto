/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.LineasPedidos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author AlfonsoTerrones
 */
public class MysqlLineasPedidosDAO implements ILineasPedidosDAO{

    @Override
    public void insertarProductoACarrito(LineasPedidos lp) {
          try {
            String sql = "INSERT INTO `empresaweb`.`lineaspedidos` (`IdPedido`, `NumeroLinea`, `IdProducto`, `Cantidad`) VALUES (?,?,?,?)";

            PreparedStatement preparada = ConnectionFactory.getConnection().prepareStatement(sql);
            preparada.setString(1, lp.getIdPedido());
            preparada.setInt(2, lp.getNumeroLinea());
            preparada.setString(3, lp.getIdProducto());
            preparada.setString(4, lp.getCantidad());

            preparada.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Algo ha pasado al insertar");
            System.out.println(ex.getErrorCode());
            //Logger.getLogger(MysqlPedidosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
          closeConnection();
    }
    
     public int idLineaPedidoMax() {
        int re=0;
        try {
            String idPedido = "Select max(NumeroLinea) from lineaspedidos";
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(idPedido);
            Throwable throwable = null;
            try {
                if (resultado.next()) {
                    re = resultado.getInt("max(NumeroLinea)");
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
        closeConnection();
        return re;
    }
     
     @Override
    public void closeConnection() {
       ConnectionFactory.closeConnection();
    }

   
    
}
