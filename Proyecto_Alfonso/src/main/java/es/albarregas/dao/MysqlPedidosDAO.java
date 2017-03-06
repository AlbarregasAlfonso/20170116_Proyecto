/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Cliente;
import es.albarregas.beans.Direccion;
import es.albarregas.beans.Pedidos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
            System.out.println("Algo ha pasado al insertar  insertarCarrito(Pedidos p)");
            System.out.println(ex.getErrorCode());
            //Logger.getLogger(MysqlPedidosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
    }

    @Override
    public String idPedidoMaxDeUnCliente(String idCliente) {
        String re = null;
        try {
            String idPedido = "Select max(IdPedido) from pedidos  where IdCliente="+idCliente;
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(idPedido);
            Throwable throwable = null;
            try {
                if (resultado.next()) {
                    re = resultado.getString("max(IdPedido)");
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
            System.out.println("Error al ejecutar la sentencia idPedidoMax()");
            ex.printStackTrace();
        }
        closeConnection();
        return re;
    }

    @Override
    public void closeConnection() {
       ConnectionFactory.closeConnection();
    }

    @Override
    public String sacarEstadoUltimoPedido(String idusuario) {
      String re=null;

        
        String consulta = "select estado from pedidos where IdCliente="+idusuario+" order by IdPedido desc limit 1";
     
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            Throwable throwable = null;
            try {

                 while (resultado.next()) {

                    re=resultado.getString("estado");
                    
                 }
               
            } catch (Exception e) {
                
            } finally {
                if (resultado != null) {
                    if (throwable != null) {
                        try {
                            resultado.close();
                        } catch (Exception e) {
                           
                        }
                    } else {
                        resultado.close();
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentencia sacarEstadoUltimoPedido(String idusuario)");
            ex.printStackTrace();
        }

        closeConnection();
        
        if (re==null){
            re=" ";
        }
        
        return re;
    }
    
     @Override
    public boolean obtenerApellidoDelClienteDeUnPedido(String idPedido) {
           
     boolean semaforo = true;
     String re="";

        try {
            String aux = " select cl.apellidos from pedidos pe inner join lineaspedidos lp on pe.IdPedido=lp.IdPedido inner join clientes cl on cl.IdCliente=pe.IdCliente where pe.IdPedido="+idPedido;
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(aux);
            Throwable throwable = null;
            try {
                if (resultado.next()) {
                    re = resultado.getString("cl.apellidos");
                }
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                if (resultado != null) {
                    if (throwable != null) {
                        try {
                            resultado.close();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    } else {
                        resultado.close();
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentencia obtenerApellidoDelClienteDeUnPedido(String idPedido)");
            ex.printStackTrace();
        }
        closeConnection();
        
        if(re.equals("apellido")){
            semaforo=false;
        }else{
            semaforo=true;
        }
        
        return semaforo;
    }

    @Override
    public void modificarEstadoDePedido(String estado, String idCliente,String idDireccion,float totalprecio,String gastosEnvio, String idPedido) {
           try {
            String sql = "update pedidos set estado='"+estado+"',BaseImponible="+totalprecio+", GastosEnvio="+gastosEnvio+", IdDireccion="+idDireccion+" where IdCliente="+idCliente+" and IdPedido="+idPedido;
            PreparedStatement preparada = ConnectionFactory.getConnection().prepareStatement(sql);
            preparada.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Algo ha pasado al actualizar");
            Logger.getLogger(MysqlUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
    }

    @Override
    public void modificarEstadosDesPedidos() {
         try {
            String sqlAux = "select pe.idpedido from productos p inner join lineaspedidos lp on lp.idproducto=p.idproducto inner join pedidos pe on lp.idpedido=pe.idpedido where stock>cantidad and pe.estado='s'";
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(sqlAux);
            String idPedido = null;

            while (resultado.next()) {
                idPedido = resultado.getString("pe.idpedido");
            }
           

            String sql = "update pedidos set estado='r' where IdPedido="+idPedido+"";
            PreparedStatement preparada = ConnectionFactory.getConnection().prepareStatement(sql);
            preparada.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Algo ha pasado al insertar");
            Logger.getLogger(MysqlUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       closeConnection();
        
    }

//    @Override
//    public ArrayList<Pedidos> obtenerPedidos(String idCliente) {
//        Pedidos p = new Pedidos();
//        Direccion d= new Direccion();
//        String consulta = "select * from pedidos where IdUsuario=" + idCliente;
//
//        try {
//            Statement sentencia = ConnectionFactory.getConnection().createStatement();
//            ResultSet resultado = sentencia.executeQuery(consulta);
//            Throwable throwable = null;
//            try {
//                while (resultado.next()) {
//                 //   d = new Direccion()
//                    p = new Pedidos(resultado.getString("Fecha"),resultado.getString("estado"));
//                   
//                }
//            } catch (Throwable producto) {
//                throwable = producto;
//                throw producto;
//            } finally {
//                if (resultado != null) {
//                    if (throwable != null) {
//                        try {
//                            resultado.close();
//                        } catch (Throwable producto) {
//                            throwable.addSuppressed(producto);
//                        }
//                    } else {
//                        resultado.close();
//                    }
//                }
//            }
//        } catch (SQLException ex) {
//            System.out.println("Error al ejecutar la sentencia");
//            System.out.println(ex.getMessage());
//        }
//        closeConnection();
//       // return u;
//       return ArrayList<Pedidos> = new ArrayList();
//
//    }

    @Override
    public ArrayList<Pedidos> obtenerPedidos(String idCliente) {
        
        
      
        ArrayList<Pedidos> lista = new ArrayList<Pedidos>();
        if (idCliente == null) {
            idCliente = "";
        }

        String consulta = "select p.idPedido,p.Fecha,p.estado,p.idcliente,p.BaseImponible,p.gastosEnvio, d.NombreDireccion,d.direccion,d.codigoPostal,d.telefono from pedidos p inner join direcciones d on d.iddireccion=p.iddireccion where p.idCliente="+idCliente;
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            Throwable throwable = null;
            try {

                while (resultado.next()) {
                    
                      Direccion de=new Direccion(resultado.getString("d.direccion"),resultado.getString("d.NombreDireccion"),resultado.getString("d.telefono"),resultado.getString("d.codigoPostal"));
                      //String idPedido, String idCliente, String fecha, String estado, String baseImponible, String gastosEnvio, Direccion direccion
                      Pedidos p=new Pedidos(resultado.getString("p.idPedido"),resultado.getString("p.Fecha"),resultado.getString("p.Fecha"),resultado.getString("p.estado"),resultado.getString("p.BaseImponible"),resultado.getString("p.gastosEnvio"),de);
                    lista.add(p);
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
            System.out.println("Error al ejecutar la sentencia getProductos(String where)");
            ex.printStackTrace();
        }
        closeConnection();

        return lista;
    }

    @Override
    public boolean saberSiClienteTienePedidoAbierto(String idCliente) {
         boolean semaforo = true;
     String re="";

        try {
            String aux = "select IdPedido from pedidos where IdCliente="+idCliente+" and estado='p'";
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(aux);
            Throwable throwable = null;
            try {
                if (resultado.next()) {
                    re = resultado.getString("IdPedido");
                }
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                if (resultado != null) {
                    if (throwable != null) {
                        try {
                            resultado.close();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    } else {
                        resultado.close();
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentencia obtenerApellidoDelClienteDeUnPedido(String idPedido)");
            ex.printStackTrace();
        }
        closeConnection();
        
        if(re != null){
            semaforo=true;
        }else{
            semaforo=false;
        }
        
        return semaforo;
        
    }

    
}
