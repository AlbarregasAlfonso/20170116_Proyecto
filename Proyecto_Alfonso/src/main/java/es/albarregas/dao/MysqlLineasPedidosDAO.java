/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.LineasPedidos;
import es.albarregas.beans.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author AlfonsoTerrones
 */
public class MysqlLineasPedidosDAO implements ILineasPedidosDAO {

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
        int re = 0;
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
    public ArrayList<LineasPedidos> getProductosEnCarrito(String idcliente) {
        ArrayList<LineasPedidos> lista = new ArrayList<LineasPedidos>();

        String consulta = "select pro.IdProducto, pro.Denominacion,pro.PrecioUnitario, lp.Cantidad,lp.IdPedido from pedidos p inner join lineaspedidos lp on p.IdPedido=lp.IdPedido inner join productos pro on pro.IdProducto=lp.IdProducto where estado='p' and p.IdCliente=" + idcliente;
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            Throwable throwable = null;
            try {
                while (resultado.next()) {
                    Producto p = new Producto(resultado.getString("pro.IdProducto"), resultado.getString("pro.Denominacion"), resultado.getString("pro.PrecioUnitario"));
                    LineasPedidos lp = new LineasPedidos(resultado.getString("lp.Cantidad"), p,resultado.getString("lp.IdPedido"));
                    lista.add(lp);
                }
            } catch (Throwable producto) {

                throwable = producto;
                throw producto;
            } finally {
                if (resultado != null) {
                    if (throwable != null) {
                        try {
                            resultado.close();
                        } catch (Throwable producto) {
                            throwable.addSuppressed(producto);
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
        return lista;
    }

    @Override
    public void closeConnection() {
        ConnectionFactory.closeConnection();
    }

    @Override
    public void modificarValorCantidad(String signo, String idProducto) {

        if (signo.equals("mas")) {
            signo = "+";
        } else {
            signo = "-";
        }

        try {
            
            String sql = " update lineaspedidos set cantidad =cantidad" + signo + "1 where IdProducto=" + idProducto + "";
            PreparedStatement preparada = ConnectionFactory.getConnection().prepareStatement(sql);
            preparada.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Algo ha pasado al insertar");
            System.out.println(ex.getErrorCode());
            //Logger.getLogger(MysqlPedidosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
    }

    @Override
    public void eliminarProductoLineaPedido(String IdPedido, String IdProducto) {


        try {
            
            String sql = "DELETE FROM lineaspedidos WHERE IdProducto = '"+IdProducto+"' && IdPedido = '"+IdPedido+"'";
            PreparedStatement preparada = ConnectionFactory.getConnection().prepareStatement(sql);
            preparada.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Algo ha pasado al insertar");
            System.out.println(ex.getErrorCode());
            //Logger.getLogger(MysqlPedidosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
    }

    @Override
    public boolean aumentarPedido(String idPedido, String cantidad,String idProducto) {
        
     boolean semaforo = true;
     String re="";
     
        try {
            String aux = "select idproducto from lineaspedidos where idproducto="+idProducto+" and idpedido="+idPedido;
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(aux);
            Throwable throwable = null;
            try {
                if (resultado.next()) {
                    re = resultado.getString("idproducto");
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
        
        if(re!=null){
            semaforo=false;
        }else{
            semaforo=true;
        }
        
        return semaforo;
    }

}
