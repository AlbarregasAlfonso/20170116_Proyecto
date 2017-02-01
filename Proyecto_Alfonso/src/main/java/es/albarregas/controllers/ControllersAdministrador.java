/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.Producto;
import es.albarregas.beans.Usuario;
import es.albarregas.dao.IPedidosDAO;
import es.albarregas.dao.IProductoDAO;
import es.albarregas.dao.IUsuarioDAO;
import es.albarregas.daofactory.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AlfonsoTerrones
 */
@WebServlet(name = "ControllersAdministrador", urlPatterns = {"/ControllersAdministrador"})
public class ControllersAdministrador extends HttpServlet {

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
            out.println("<title>Servlet ControllersAdministrador</title>");
            out.println("</head>");
            out.println("<body>");

            DAOFactory daof = DAOFactory.getDAOFactory((int) 1);
            IUsuarioDAO udao = daof.getUsuarioDAO();
            IProductoDAO pdao = daof.getProductoDAO();
            IPedidosDAO pedao = daof.getPedidosDAO();
            
            String url = null;

            if (request.getParameter("menu") != null) {

                ArrayList<Usuario> usuarios;
                usuarios = udao.getUsuarios();
                request.setAttribute("usuarios", usuarios);
                url = "/JSP/MenuAdministrador.jsp";

            }
            
            if (request.getParameter("bloquear") != null) {
//                
                udao.BloquearDesbloquearUsuario(request.getParameter("idusuario"), request.getParameter("bloquear"));
                request.setAttribute("TipoUsuario", udao.SacarTipoUsuario(udao.getSacarIdUsuario(request.getParameter("user"))));
                request.setAttribute("mensaje", request.getParameter("mensaje"));
                
                url = "index.jsp";

            }
            
            if(request.getParameter("stock") != null){
                
                ArrayList<Producto> productosSinStock = pdao.productosSinStock();
                request.setAttribute("ProductosSinStock",productosSinStock);
               
                url= "/JSP/StockAdmin.jsp";
               
            }
            
            if(request.getParameter("aumentarStock")!=null){
                
                int cantidad = Integer.parseInt(request.getParameter("HacenFalta"));
                cantidad=cantidad+10;
                request.setAttribute("mensaje1", "se han comprado "+cantidad+" productos por lo que ahora mismo en stock hay 10 productos, "+request.getParameter("HacenFalta")+" para el cliente y 10 para el stock");
                pdao.aumentarStockProducto(request.getParameter("productoDenominacion"),request.getParameter("HacenFalta"));
                pdao.eliminarDeProductosSinStock(request.getParameter("productoDenominacion"));
                
                ArrayList<Producto> productosSinStock = pdao.productosSinStock();//actualizamos los productos sin stock
                request.setAttribute("ProductosSinStock",productosSinStock);    //actualizamos productos sin stock
                
                pedao.modificarEstadosDesPedidos();//actualiza el estado de los pedidos
              //  pdao.disminuirProductosEnStock(u.getIdUsuario(),"s");
                
                url= "/JSP/StockAdmin.jsp";
            }

            request.getRequestDispatcher(url).forward(request, response);

            out.println("<h1>Servlet ControllersAdministrador at " + request.getContextPath() + "</h1>");
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
