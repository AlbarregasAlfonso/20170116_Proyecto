/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.LineasPedidos;
import es.albarregas.beans.Pedidos;
import es.albarregas.beans.Usuario;
import es.albarregas.dao.ILineasPedidosDAO;
import es.albarregas.dao.IPedidosDAO;
import es.albarregas.daofactory.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
            ILineasPedidosDAO lpdao = daof.getLineaPedidosDAO();

            ArrayList<LineasPedidos> productosCarrito;
            Usuario u = (Usuario) request.getSession().getAttribute("usuario");
            productosCarrito = lpdao.getProductosEnCarrito(u.getIdUsuario());
            request.setAttribute("productosCarrito", productosCarrito);

            if (request.getParameter("borramos") != null) {
                
                lpdao.eliminarProductoLineaPedido(request.getParameter("idpedido"), request.getParameter("idProducto"));
                request.getRequestDispatcher("/JSP/Carrito.jsp").forward(request, response);    
            }
            
            if (request.getParameter("signo") != null) {

                lpdao.modificarValorCantidad(request.getParameter("signo"), request.getParameter("idProducto"));
                request.getRequestDispatcher("/JSP/Carrito.jsp").forward(request, response);

            }

            if (request.getParameter("Vercarrito") != null) {
                
                request.getRequestDispatcher("/JSP/Carrito.jsp").forward(request, response);
            }

 
            if (pedao.sacarEstadoUltimoPedido(request.getParameter("idusuario")).equals("p")) {
                    
                System.out.println("El idPedido es "+request.getParameter("idpedido"));
                System.out.println("El valor de boolean para saber si existe o no "+lpdao.aumentarPedido(request.getParameter("idpedido"), request.getParameter("cantidad"), request.getParameter("idProducto")));
                
                lpdao.idLineaPedidoMax();
                int numeroLinea = lpdao.idLineaPedidoMax();
                LineasPedidos lp = new LineasPedidos(pedao.idPedidoMax(), numeroLinea + 1, request.getParameter("idProducto"), request.getParameter("cantidad"));

                lpdao.insertarProductoACarrito(lp);

                request.getSession().setAttribute("carrito", "abierto");
                request.setAttribute("mensaje", "Has añadido un producto al carrito");
                request.getRequestDispatcher("index.jsp").forward(request, response);

            } else if(request.getParameter("productoCaracteristicas")!=null){
                
                System.out.println("entramos porq "+pedao.sacarEstadoUltimoPedido(request.getParameter("idusuario"))+" es distinto de p");
                System.out.println("Entramos en crear pedido");
                Pedidos p = new Pedidos(u.getIdUsuario(), "p");
                pedao.insertarCarrito(p);

                lpdao.idLineaPedidoMax();
                int numeroLinea = lpdao.idLineaPedidoMax();
                LineasPedidos lp = new LineasPedidos(pedao.idPedidoMax(), numeroLinea + 1, request.getParameter("idProducto"), request.getParameter("cantidad"));

                lpdao.insertarProductoACarrito(lp);

                request.setAttribute("mensaje", "Nuevo carrito creado");
                request.getSession().setAttribute("carrito", "abierto");

                request.getRequestDispatcher("index.jsp").forward(request, response);

            }

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
