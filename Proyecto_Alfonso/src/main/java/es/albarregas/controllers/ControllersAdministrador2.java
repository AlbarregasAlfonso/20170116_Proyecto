/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.dao.IProductoDAO;
import es.albarregas.daofactory.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AlfonsoTerrones
 */
@WebServlet(name = "ControllersAdministrador2", urlPatterns = {"/ControllersAdministrador2"})
public class ControllersAdministrador2 extends HttpServlet {

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
          if(request.getParameter("anadir")!=null){
              System.out.println("Hemos enstrado");
              
              request.getRequestDispatcher("/JSP/AnadirProductos.jsp").forward(request, response);
              System.out.println("Aqui no llego");
          }
          
          if(request.getParameter("Enviar")!=null){
              DAOFactory daof = DAOFactory.getDAOFactory((int) 1);
              IProductoDAO pdao = daof.getProductoDAO();
              pdao.anadirProducto(request.getParameter("denominacion"), request.getParameter("descripcion"),request.getParameter("precio"), request.getParameter("stock"),request.getParameter("oferta"),request.getParameter("catalogo"), request.getParameter("categoria"));
              request.setAttribute("mensaje", request.getParameter("denominacion")+" añadido");
              request.getRequestDispatcher("index.jsp").forward(request, response);
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
