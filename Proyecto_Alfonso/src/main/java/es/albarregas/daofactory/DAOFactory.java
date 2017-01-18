/*
 * Decompiled with CFR 0_118.
 * 
 * Could not load the following classes:
 *  es.albarregas.dao.IRegistroDAO
 *  es.albarregas.dao.IEquiposDAO
 *  es.albarregas.daofactory.FicheroDAOFactory
 *  es.albarregas.daofactory.MySQLDAOFactory
 *  es.albarregas.daofactory.OracleDAOFactory
 */
package es.albarregas.daofactory;



import es.albarregas.dao.ICaracyprodsDAO;
import es.albarregas.daofactory.MySQLDAOFactory;
import es.albarregas.dao.IClienteDAO;
import es.albarregas.dao.IImagenesDAO;
import es.albarregas.dao.ILineasPedidosDAO;
import es.albarregas.dao.IPedidosDAO;
import es.albarregas.dao.IProductoDAO;
import es.albarregas.dao.IUsuarioDAO;

public abstract class DAOFactory {
    public static final int MYSQL = 1;
    public static final int ORACLE = 2;
    public static final int FICHERO = 3;

    public abstract IClienteDAO getRegistroDAO();
  
    public abstract IUsuarioDAO getUsuarioDAO();
    
    public abstract IImagenesDAO getImagenDAO();
    
    public abstract IPedidosDAO getPedidosDAO();
    
    public abstract ILineasPedidosDAO getLineaPedidosDAO();
    
    public abstract ICaracyprodsDAO getCaracyprodsDAO();
    
    public abstract IProductoDAO getProductoDAO();
    
    public abstract ICaracyprodsDAO getCaracyprodsDAODAO();
    
    



    public static DAOFactory getDAOFactory(int tipo) {
        MySQLDAOFactory daof = null;
        switch (tipo) {
            case 1: {
                daof = new MySQLDAOFactory();
                break;
            }
            case 2: {
    //            daof = new OracleDAOFactory();
                break;
            }
            case 3: {
      //          daof = new FicheroDAOFactory();
            }
        }
        return daof;
    }
}