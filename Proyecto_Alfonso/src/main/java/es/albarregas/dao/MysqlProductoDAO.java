/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.LineasPedidos;
import es.albarregas.beans.Producto;
import es.albarregas.beans.ProductoCaracteristicas;
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
public class MysqlProductoDAO implements IProductoDAO {

    @Override
    public ArrayList<Producto> getProductos(String where) {
        ArrayList<Producto> lista;
        if (where == null) {
            where = "";
        }
        lista = new ArrayList<Producto>();
        String consulta = "SELECT IdProducto,IdCategoria,IdMarca,Denominacion,Descripcion,IdProveedor,PrecioUnitario*(select GastosEnvio from general),Stock,StockMinimo,FechaAlta,Oferta,FueraCatalogo,Rating FROM productos " + where;
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            Throwable throwable = null;
            try {

                while (resultado.next()) {
                    Producto producto = new Producto();
                    producto.setIdProducto(resultado.getString("IdProducto"));
                    producto.setIdCategoria(resultado.getString("IdCategoria"));
                    producto.setIdMarca(resultado.getString("IdMarca"));
                    producto.setDenominacion(resultado.getString("Denominacion"));
                    producto.setDescripcion(resultado.getString("Descripcion"));
                    producto.setIdProveedor(resultado.getString("IdProveedor"));
                    producto.setPrecioUnitario(resultado.getString("PrecioUnitario*(select GastosEnvio from general)"));
                    producto.setStock(resultado.getString("Stock"));
                    producto.setStockMinimo(resultado.getString("StockMinimo"));
                    producto.setFechaAlta(resultado.getString("FechaAlta"));
                    producto.setOferta(resultado.getString("Oferta"));
                    producto.setFueraCatalogo(resultado.getString("FueraCatalogo"));
                    producto.setRating(resultado.getString("Rating"));
                    lista.add(producto);
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
    public void closeConnection() {
        ConnectionFactory.closeConnection();
    }

    @Override
    public ArrayList<ProductoCaracteristicas> getProductosCaracteristicas(String idProducto) {
        ArrayList<ProductoCaracteristicas> lista;
        if (idProducto == null) {
            idProducto = "";
        }
        lista = new ArrayList<ProductoCaracteristicas>();
        String consulta = "select p.IdProducto,p.Denominacion,ca.Descripcion,c.Nombre,catego.Nombre FROM caracteristicas c INNER JOIN caracyprods ca ON ca.IdCaracteristica = c.IdCaracteristica INNER JOIN productos p ON p.IdProducto=ca.IdProducto INNER JOIN categorias catego ON catego.IdCategoria=p.IdCategoria where p.IdProducto= " + idProducto;
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            Throwable throwable = null;
            try {
                while (resultado.next()) {
                    ProductoCaracteristicas producto = new ProductoCaracteristicas();
                    producto.setIdProducto(resultado.getString("p.IdProducto"));
                    producto.setDenominacion(resultado.getString("p.Denominacion"));
                    producto.setDescripcion(resultado.getString("ca.Descripcion"));
                    producto.setNombreCaracteristica(resultado.getString("c.Nombre"));
                    producto.setTipoProducto(resultado.getString("catego.Nombre"));

                    lista.add(producto);
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
            System.out.println("Error al ejecutar la sentencia getProductosCaracteristicas");
            ex.printStackTrace();
        }
        closeConnection();
        return lista;
    }

    @Override
    public String getSacarNombreProducto(String idProducto) {
        String re = null;
        if (idProducto == null) {
            idProducto = "";
        }

        String consulta = "select Denominacion from productos where IdProducto= " + idProducto;
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            Throwable throwable = null;
            try {
                while (resultado.next()) {

                    re = resultado.getString("Denominacion");

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
            System.out.println("Error al ejecutar la sentencia getSacarNombreProducto");
            ex.printStackTrace();
        }

        closeConnection();
        return re;
    }

    @Override
    public String getSacarDescripcionProducto(String idProducto) {
        String re = null;
        if (idProducto == null) {
            idProducto = "";
        }

        String consulta = "select descripcion from productos where IdProducto=" + idProducto;
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            Throwable throwable = null;
            try {
                while (resultado.next()) {
                    re = resultado.getString("descripcion");
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
            System.out.println("Error al ejecutar la sentencia getSacarDescripcionProducto");
            ex.printStackTrace();
        }
        closeConnection();
        return re;

    }

    @Override
    public String getSacarStock(String idProducto) {
        String re = null;
        if (idProducto == null) {
            idProducto = "";
        }

        String consulta = "select Stock from productos where IdProducto=" + idProducto;
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            Throwable throwable = null;
            try {
                while (resultado.next()) {
                    re = resultado.getString("Stock");
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
            System.out.println("Error al ejecutar la sentencia getSacarStock");
            ex.printStackTrace();
        }
        closeConnection();
        return re;
    }

    @Override
    public String sacarIdProducto(String denominacion) {
        String re = null;
        if (denominacion == null) {
            denominacion = "";
        }

        String consulta = "select IdProducto from productos where denominacion='" + denominacion + "'";
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            Throwable throwable = null;
            try {
                while (resultado.next()) {
                    re = resultado.getString("IdProducto");
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
            System.out.println("Error al ejecutar la sentencia getSacarNombreProducto");
            ex.printStackTrace();
        }

        closeConnection();
        return re;
    }

    @Override
    public ArrayList<Producto> obtenerProductosQueFaltanEnStock(String idCliente) {

        ArrayList<Producto> lista = null;
        if (idCliente == null) {
            idCliente = "";
        }

        String consulta = "select pro.Denominacion,(lp.Cantidad-pro.Stock),pro.IdProducto from pedidos p inner join lineaspedidos lp on p.IdPedido=lp.IdPedido inner join productos pro on pro.IdProducto=lp.IdProducto where p.IdCliente=" + idCliente + " and p.Estado='p' and lp.Cantidad>pro.Stock";
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            Throwable throwable = null;
            try {

                while (resultado.next()) {
                    lista = new ArrayList();

                    System.out.println("Estamos en el dao " + resultado.getString("pro.Denominacion") + " y la cantidad " + resultado.getString("(lp.Cantidad-pro.Stock)"));
                    Producto producto = new Producto(resultado.getString("pro.IdProducto"),resultado.getString("pro.Denominacion"), resultado.getString("(lp.Cantidad-pro.Stock)"));
                    lista.add(producto);
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
        System.out.println("Vamos a salir del dao");

        System.out.println("El valor de la lista" + lista);

        return lista;
    }

    @Override
    public void disminuirProductosEnStock(String idCliente,String estado, String idPedido) {
        try {
            String sql = "UPDATE productos pro inner join lineaspedidos lp on lp.IdProducto=pro.IdProducto inner join pedidos pedi on pedi.IdPedido=lp.IdPedido SET Stock=(-(lp.Cantidad)+pro.Stock) where pedi.IdCliente=" + idCliente + " and pedi.estado='"+estado+"' and pedi.idpedido="+idPedido;
            System.out.println(sql);
            System.out.println("Estamos disminuyendo el stock");
            PreparedStatement preparada = ConnectionFactory.getConnection().prepareStatement(sql);

            preparada.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Algo ha pasado al actualizar");
            Logger.getLogger(MysqlUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();

    }

    @Override
    public ArrayList<Producto> productosSinStock() {
        ArrayList<Producto> lista = lista = new ArrayList<Producto>();
       
   
        String consulta = " select deminacion,faltan from productosSinStock";
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            Throwable throwable = null;
            try {

                while (resultado.next()) {
                    Producto producto = new Producto();
                    producto.setDenominacion(resultado.getString("deminacion"));
                    producto.setCantidadQueFaltaEnStock(resultado.getString("faltan"));
                    lista.add(producto);
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
    public void insertarEnProductosSinStock(String denominacion, String faltan, String idProducto) {
            try {
            

            String sql = "insert into productosSinStock values('"+denominacion+"','"+faltan+"','"+idProducto+"')";
            System.out.println("Vamos a insertarrr!! "+sql);
            PreparedStatement preparada = ConnectionFactory.getConnection().prepareStatement(sql);

            preparada.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Algo ha pasado al insertar");
            Logger.getLogger(MysqlUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();

    }

    @Override
    public void aumentarStockProducto(String denominacion,String cantidad) {
        try {
            String sql = "UPDATE productos SET Stock=Stock+10-"+cantidad+" where denominacion='"+denominacion+"'";
            PreparedStatement preparada = ConnectionFactory.getConnection().prepareStatement(sql);

            preparada.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Algo ha pasado al actualizar aumentarStockProducto");
            Logger.getLogger(MysqlUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
    }

    @Override
    public void eliminarDeProductosSinStock(String denominacion) {
          try {
            
            String sql = "DELETE FROM productosSinStock WHERE deminacion = '"+denominacion+"'";
            PreparedStatement preparada = ConnectionFactory.getConnection().prepareStatement(sql);
            preparada.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Algo ha pasado al insertar eliminarProductoLineaPedido");
            System.out.println(ex.getErrorCode());
            //Logger.getLogger(MysqlPedidosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
    }

}
