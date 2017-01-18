/*
 * Decompiled with CFR 0_118.
 * 
 * Could not load the following classes:
 *  es.albarregas.dao.EquiposDAO
 *  es.albarregas.dao.IRegistroDAO
 *  es.albarregas.dao.IEquiposDAO
 *  es.albarregas.dao.MysqlRegistroDAO
 */
package es.albarregas.daofactory;



import es.albarregas.dao.ICaracyprodsDAO;
import es.albarregas.dao.MysqlClienteDAO;
import es.albarregas.dao.IClienteDAO;
import es.albarregas.dao.IImagenesDAO;
import es.albarregas.dao.ILineasPedidosDAO;
import es.albarregas.dao.IPedidosDAO;
import es.albarregas.dao.IProductoDAO;
import es.albarregas.dao.IUsuarioDAO;
import es.albarregas.dao.MysqlCaracyprodsDAO;
import es.albarregas.dao.MysqlImagenDAO;
import es.albarregas.dao.MysqlLineasPedidosDAO;
import es.albarregas.dao.MysqlPedidosDAO;
import es.albarregas.dao.MysqlProductoDAO;
import es.albarregas.dao.MysqlUsuarioDAO;

public class MySQLDAOFactory extends DAOFactory {
    
    @Override
    public IClienteDAO getRegistroDAO() {
        return new MysqlClienteDAO();
    }
    
    @Override
    public IUsuarioDAO getUsuarioDAO(){
        return new MysqlUsuarioDAO();
    }

    @Override
    public IImagenesDAO getImagenDAO() {
        return new MysqlImagenDAO();
    }

    @Override
    public ICaracyprodsDAO getCaracyprodsDAO() {
        return new MysqlCaracyprodsDAO();
    }

    @Override
    public IProductoDAO getProductoDAO() {
        return new MysqlProductoDAO();
    }

    @Override
    public ICaracyprodsDAO getCaracyprodsDAODAO() {
        return new MysqlCaracyprodsDAO();
    }

    @Override
    public IPedidosDAO getPedidosDAO() {
        return new MysqlPedidosDAO();    }

    @Override
    public ILineasPedidosDAO getLineaPedidosDAO() {
        return new MysqlLineasPedidosDAO();
    }

   
}