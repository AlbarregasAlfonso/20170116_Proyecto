/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.Producto;
import es.albarregas.dao.IProductoDAO;
import es.albarregas.daofactory.DAOFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AlfonsoTerrones
 */
@WebServlet(name = "ControllersBusquedaAvan", urlPatterns = {"/ControllersBusquedaAvan"})
public class ControllersBusquedaAvan extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

      
        String url = "";
        DAOFactory daof = DAOFactory.getDAOFactory((int) 1);

        if (request.getParameter("valor") != null) {

            IProductoDAO pdao = daof.getProductoDAO();
            ArrayList<Producto> productos;

            List<Producto> productosFraccionado;
            String clausulaWhere = null;

            if (request.getParameter("Buscar") != null) {

                switch (request.getParameter("categoria")) {

                    case "1":

                        clausulaWhere = "where p.IdCategoria=" + request.getParameter("categoria") + " and p.PrecioUnitario>" + request.getParameter("desde") + " and p.PrecioUnitario<" + request.getParameter("hasta") + " and p.denominacion LIKE '%" + request.getParameter("tipo") + "%' and p.denominacion LIKE '%" + request.getParameter("velocidad") + "%' and c.descripcion LIKE '%" + request.getParameter("bits") + "%'";

                        break;

                    case "2":

                        clausulaWhere = "where p.IdCategoria=" + request.getParameter("categoria") + " and p.PrecioUnitario>" + request.getParameter("desde") + " and p.PrecioUnitario<" + request.getParameter("hasta") + " and p.denominacion LIKE '%" + request.getParameter("marca") + "%' and c.descripcion LIKE '%" + request.getParameter("socket") + "%' and c.descripcion LIKE '%" + request.getParameter("chipset") + "%'";

                        break;

                    case "3":

                        clausulaWhere = "where p.IdCategoria=" + request.getParameter("categoria") + " and p.PrecioUnitario>" + request.getParameter("desde") + " and p.PrecioUnitario<" + request.getParameter("hasta") + " and c.descripcion LIKE '%" + request.getParameter("tamemoria") + "%' and c.descripcion LIKE '%" + request.getParameter("inmemoria") + "%'  and c.descripcion LIKE '%" + request.getParameter("tipomemoria") + "%'  and p.denominacion LIKE '%" + request.getParameter("marca") + "%'";

                        break;

                    case "4":

                        clausulaWhere = "where p.IdCategoria=" + request.getParameter("categoria") + " and p.PrecioUnitario>" + request.getParameter("desde") + " and p.PrecioUnitario<" + request.getParameter("hasta") + " and p.denominacion LIKE '%" + request.getParameter("tipomemo") + "%' and c.descripcion LIKE '%" + request.getParameter("capacidad") + "%'  and c.descripcion LIKE '%" + request.getParameter("voltaje") + "%'  and p.denominacion LIKE '%" + request.getParameter("marca") + "%'";

                        break;

                    case "5":

                        clausulaWhere = "where p.IdCategoria=" + request.getParameter("categoria") + " and p.PrecioUnitario>" + request.getParameter("desde") + " and p.PrecioUnitario<" + request.getParameter("hasta") + " and c.descripcion LIKE '%" + request.getParameter("tamano") + "%' and c.descripcion LIKE '%" + request.getParameter("capacidad") + "%'  and c.descripcion LIKE '%" + request.getParameter("velocidad") + "%'  and p.denominacion LIKE '%" + request.getParameter("marca") + "%'";

                        break;

                    case "6":

                        clausulaWhere = "where p.IdCategoria=" + request.getParameter("categoria") + " and p.PrecioUnitario>" + request.getParameter("desde") + " and p.PrecioUnitario<" + request.getParameter("hasta") + " and c.descripcion LIKE '%" + request.getParameter("capacidad") + "%' and p.denominacion LIKE '%" + request.getParameter("marca") + "%'";

                        break;

                    case "7":

                        clausulaWhere = "where p.IdCategoria=" + request.getParameter("categoria") + " and p.PrecioUnitario>" + request.getParameter("desde") + " and p.PrecioUnitario<" + request.getParameter("hasta") + " and c.descripcion LIKE '%" + request.getParameter("capacidad") + "%' and p.denominacion LIKE '%" + request.getParameter("tipo") + "%' and p.denominacion LIKE '%" + request.getParameter("marca") + "%'";

                        break;

                    case "8":

                        clausulaWhere = "where p.IdCategoria=" + request.getParameter("categoria") + " and p.PrecioUnitario>" + request.getParameter("desde") + " and p.PrecioUnitario<" + request.getParameter("hasta") + " and c.descripcion LIKE '%" + request.getParameter("capacidad") + "%' and p.denominacion LIKE '%" + request.getParameter("pulgadas") + "%' and p.denominacion LIKE '%" + request.getParameter("marca") + "%'";

                        break;

                    case "9":

                        clausulaWhere = "where p.IdCategoria=" + request.getParameter("categoria") + " and p.PrecioUnitario>" + request.getParameter("desde") + " and p.PrecioUnitario<" + request.getParameter("hasta") + " and c.descripcion LIKE '%" + request.getParameter("tipo") + "%'";

                        break;              
                    case "10":

                        break;

                    case "11":

                        clausulaWhere = "where p.IdCategoria=" + request.getParameter("categoria") + " and p.PrecioUnitario>" + request.getParameter("desde") + " and p.PrecioUnitario<" + request.getParameter("hasta") + " and c.descripcion LIKE '%" + request.getParameter("capacidad") + "%' and p.denominacion LIKE '%" + request.getParameter("usb") + "%' and p.denominacion LIKE '%" + request.getParameter("marca") + "%'";

                        break;

                    case "12":

                        clausulaWhere = "where p.IdCategoria=" + request.getParameter("categoria") + " and p.PrecioUnitario>" + request.getParameter("desde") + " and p.PrecioUnitario<" + request.getParameter("hasta") + " and c.descripcion LIKE '%" + request.getParameter("modular") + "%' and p.denominacion LIKE '%" + request.getParameter("vatios") + "%' and p.denominacion LIKE '%" + request.getParameter("marca") + "%'";

                        break;

                    case "13":

                        clausulaWhere = "where p.IdCategoria=" + request.getParameter("categoria") + " and p.PrecioUnitario>" + request.getParameter("desde") + " and p.PrecioUnitario<" + request.getParameter("hasta") + " and c.descripcion LIKE '%" + request.getParameter("formato") + "%' and c.descripcion LIKE '%" + request.getParameter("resolucion") + "%'  and c.descripcion LIKE '%" + request.getParameter("pulgadas") + "%'  and p.denominacion LIKE '%" + request.getParameter("marca") + "%'";

                        break;
                        
                    case "14":
                        
                         clausulaWhere = "where p.IdCategoria=" + request.getParameter("categoria") + " and p.PrecioUnitario>" + request.getParameter("desde") + " and p.PrecioUnitario<" + request.getParameter("hasta") + "  and p.denominacion LIKE '%" + request.getParameter("marca") + "%' and c.descripcion LIKE '%" + request.getParameter("bluetooh") + "%'";
                        
                        break;
                        
                    case "15":
                        
                        clausulaWhere = "where p.IdCategoria=" + request.getParameter("categoria") + " and p.PrecioUnitario>" + request.getParameter("desde") + " and p.PrecioUnitario<" + request.getParameter("hasta") + " and c.descripcion LIKE '%" + request.getParameter("conexion") + "%' and c.descripcion LIKE '%" + request.getParameter("tipo") + "%'  and p.denominacion LIKE '%" + request.getParameter("marca") + "%'";                        
                        
                        break;
                        
                    case "16":
                        
                        clausulaWhere = "where p.IdCategoria=" + request.getParameter("categoria") + " and p.PrecioUnitario>" + request.getParameter("desde") + " and p.PrecioUnitario<" + request.getParameter("hasta");                        
                        
                        break;
                    case "17":
                        
                        clausulaWhere = "where p.IdCategoria=" + request.getParameter("categoria") + " and p.PrecioUnitario>" + request.getParameter("desde") + " and p.PrecioUnitario<" + request.getParameter("hasta") + " and c.descripcion LIKE '%" + request.getParameter("velocidad") + "%'  and p.denominacion LIKE '%" + request.getParameter("marca") + "%'";                        

                        break;

                }

                productos = pdao.getProductosAvan(clausulaWhere);

                request.setAttribute("productosFraccionado", productos);

                url = "/JSP/ProductosAvan.jsp";

                request.setAttribute("categoria", request.getParameter("categoria"));

                request.getRequestDispatcher(url).forward(request, response);

            } else {

                clausulaWhere = "where IdCategoria=" + request.getParameter("categoria");

                productos = pdao.getProductos(clausulaWhere);

                productosFraccionado = productos.subList(Integer.parseInt(request.getParameter("valor")), Integer.parseInt(request.getParameter("valor")) + productos.size());

                request.setAttribute("productosFraccionado", productosFraccionado);

                request.setAttribute("valor", Integer.parseInt(request.getParameter("valor")) + 9);

                url = "/JSP/ProductosAvan.jsp";

                request.setAttribute("categoria", request.getParameter("categoria"));

                request.getRequestDispatcher(url).forward(request, response);

            }

        }

        if (request.getParameter("mas") != null) {

            IProductoDAO pdao = daof.getProductoDAO();

            ArrayList<Producto> productos;
            productos = pdao.productosMasVendidos();

            request.setAttribute("productosFraccionado", productos);
            request.setAttribute("topventas", "top ventas");

            url = "/JSP/Productos.jsp";
            request.getRequestDispatcher(url).forward(request, response);

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
