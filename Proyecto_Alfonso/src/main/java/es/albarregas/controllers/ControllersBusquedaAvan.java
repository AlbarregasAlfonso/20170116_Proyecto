/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.Producto;
import es.albarregas.dao.IClienteDAO;
import es.albarregas.dao.IProductoDAO;
import es.albarregas.dao.IUsuarioDAO;
import es.albarregas.daofactory.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
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

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            String url = "";
            DAOFactory daof = DAOFactory.getDAOFactory((int) 1);

            if (request.getParameter("valor") != null) {

                out.println("<h1>Servlet Controladorrrrrr at " + request.getContextPath() + "</h1>");

                IProductoDAO pdao = daof.getProductoDAO();

                ArrayList<Producto> productos;

                List<Producto> productosFraccionado;
                String clausulaWhere = null;

                if (request.getParameter("Buscar") != null) {

                    switch (request.getParameter("categoria")) {
                        
                        case "1":

                            System.out.println("Esta esss categoria switch" + request.getParameter("categoria"));
                            //clausulaWhere = "where IdCategoria=" + request.getParameter("categoria") + " and PrecioUnitario>" + request.getParameter("desde") + " and PrecioUnitario<" + request.getParameter("hasta") + " and denominacion LIKE '%" + request.getParameter("tipo") + "%'";
                            clausulaWhere = "where p.IdCategoria=" + request.getParameter("categoria") + " and p.PrecioUnitario>" + request.getParameter("desde") + " and p.PrecioUnitario<" + request.getParameter("hasta") + " and c.descripcion LIKE '%" + request.getParameter("tipo") + "%'";

                            //productos = pdao.getProductos(clausulaWhere);
                            productos = pdao.getProductosAvan(clausulaWhere);
                            System.out.println("Lili");
                            System.out.println("Longitud del vector " + productos.size());
                            //fraccionar el array
                            productosFraccionado = productos.subList(Integer.parseInt(request.getParameter("valor")), Integer.parseInt(request.getParameter("valor")) + productos.size());

                            break;
                        case "2":
                            break;
                        case "3":
                            break;
                        case "4":
                            break;
                        case "5":
                            break;
                        case "6":
                            break;
                        case "7":
                            break;
                        case "8":
                            break;
                        case "9":

                            System.out.println("Esta esss" + request.getParameter("categoria"));
                            //clausulaWhere = "where IdCategoria=" + request.getParameter("categoria") + " and PrecioUnitario>" + request.getParameter("desde") + " and PrecioUnitario<" + request.getParameter("hasta") + " and denominacion LIKE '%" + request.getParameter("tipo") + "%'";
                             //clausulaWhere = "where IdCategoria=" + request.getParameter("categoria") + " and PrecioUnitario>" + request.getParameter("desde") + " and PrecioUnitario<" + request.getParameter("hasta") + " and denominacion LIKE '%" + request.getParameter("tipo") + "%'";
                            clausulaWhere = "where p.IdCategoria=" + request.getParameter("categoria") + " and p.PrecioUnitario>" + request.getParameter("desde") + " and p.PrecioUnitario<" + request.getParameter("hasta") + " and c.descripcion LIKE '%" + request.getParameter("tipo") + "%'";

                            //productos = pdao.getProductos(clausulaWhere);
                            productos = pdao.getProductosAvan(clausulaWhere);

                            System.out.println("Longitud del vector " + productos.size());
                            //fraccionar el array
                            productosFraccionado = productos.subList(Integer.parseInt(request.getParameter("valor")), Integer.parseInt(request.getParameter("valor")) + productos.size());

                            break;
                        case "10":
                            break;
                        case "11":
                            break;
                        case "12":
                            break;
                        case "13":
                            break;
                        case "14":
                            break;
                        case "15":
                            break;
                        case "16":
                            break;
                        case "17":
                            break;

                    }

                } else {

                    System.out.println("Esta esss" + request.getParameter("categoria"));
                    clausulaWhere = "where IdCategoria=" + request.getParameter("categoria");

                    productos = pdao.getProductos(clausulaWhere);

                    System.out.println("Longitud del vector " + productos.size());
                    //fraccionar el array
                    productosFraccionado = productos.subList(Integer.parseInt(request.getParameter("valor")), Integer.parseInt(request.getParameter("valor")) + productos.size());

                }

                productos = pdao.getProductos(clausulaWhere);

                System.out.println("Longitud del vector " + productos.size());
                //fraccionar el array
                 productosFraccionado = productos.subList(Integer.parseInt(request.getParameter("valor")), Integer.parseInt(request.getParameter("valor")) + productos.size());

                request.setAttribute("productosFraccionado", productosFraccionado);

                request.setAttribute("valor", Integer.parseInt(request.getParameter("valor")) + 9);

                url = "/JSP/ProductosAvan.jsp";

                request.setAttribute("categoria", request.getParameter("categoria"));

                request.getRequestDispatcher(url).forward(request, response);

            }
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
