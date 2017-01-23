/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.LineasPedidos;
import es.albarregas.beans.Producto;
import es.albarregas.beans.ProductoCaracteristicas;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
        String consulta = "SELECT * FROM productos " + where;
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
                    producto.setPrecioUnitario(resultado.getString("PrecioUnitario"));
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
        String re=null;
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
                     
                    re=resultado.getString("Denominacion");

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
        String re=null;
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
                    re=resultado.getString("descripcion"); 
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
        String re=null;
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
                    re=resultado.getString("Stock"); 
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

   

    
    
}
   