/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.LineasPedidos;
import es.albarregas.beans.Pedidos;
import es.albarregas.dao.ILineasPedidosDAO;
import es.albarregas.dao.IPedidosDAO;
import es.albarregas.daofactory.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author AlfonsoTerrones
 */
@WebServlet(name = "ControllersCarrito", urlPatterns = {"/ControllersCarrito"})
public class ControllersCarrito extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllersCarrito</title>");
            out.println("</head>");
            out.println("<body>");

            DAOFactory daof = DAOFactory.getDAOFactory((int) 1);
            IPedidosDAO pedao = daof.getPedidosDAO();
            Pedidos p = new Pedidos("p", (String) request.getSession().getAttribute("usuario"));
            pedao.insertarCarrito(p);
            
           ILineasPedidosDAO lpdao = daof.getLineaPedidosDAO();
            
            //LineasPedidos lp = new LineasPedidos(pedao.idPedidoMax(),3,request.getParameter("idProducto"),request.getParameter("cantidad"), );
            
            LineasPedidos lp;
            lp = new LineasPedidos(pedao.idPedidoMax(),"3",request.getParameter("idProducto"),request.getParameter("cantidad"));
            out.println("<h1>Servletsesion idProducto = " + request.getParameter("idProducto") + "</h1>");
         // out.println("<h1>Servletsesion at " + (String) request.getSession().getAttribute("usuario") + "</h1>");

            out.println("<h1>Servlet ControllersCarrito at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
