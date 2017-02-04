/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.Producto;
import es.albarregas.dao.IProductoDAO;
import es.albarregas.dao.IProvinciaDAO;
import es.albarregas.daofactory.DAOFactory;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebServlet;



/**
 *
 * @author AlfonsoTerrones
 */
@WebServlet(name = "MyListenner", urlPatterns = {"/MyListenner"})
public class MyListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        

        DAOFactory daof = DAOFactory.getDAOFactory((int) 1);
        IProductoDAO pdao = daof.getProductoDAO();
        ArrayList<Producto> productosOferta = pdao.getProductos(" where Oferta='s'");
        sc.setAttribute("productosEnOferta",  productosOferta);
        IProvinciaDAO prodao = daof.getProvinciaDAO();
      
        for(Producto p:productosOferta){
            
             sc.setAttribute("primeraOferta",p.getIdProducto());
             sc.setAttribute("denominacionOferta",p.getDenominacion());
             sc.setAttribute("precioOferta",p.getPrecioUnitario());
             
             break;
        }
  

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

}
