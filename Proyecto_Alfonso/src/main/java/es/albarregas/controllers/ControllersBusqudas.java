/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.Imagen;
import es.albarregas.beans.ProductoCaracteristicas;
import es.albarregas.dao.IClienteDAO;
import es.albarregas.dao.IImagenesDAO;
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
@WebServlet(name = "ControllersBusqudas", urlPatterns = {"/ControllersBusqudas"})
public class ControllersBusqudas extends HttpServlet {

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

            
            
            String url = "";
            DAOFactory daof = DAOFactory.getDAOFactory((int) 1);
          
            
            
            if(request.getParameter("nombre")!=null){
                IProductoDAO pdao = daof.getProductoDAO();
                pdao.sacarIdProducto(request.getParameter("nombre"));
                
                IImagenesDAO idao = daof.getImagenDAO();
                ArrayList<Imagen> imagenes;

                String clausulaWhere = pdao.sacarIdProducto(request.getParameter("nombre"));
                imagenes = idao.getImagenes(clausulaWhere);

                request.setAttribute("imagenes", imagenes);

               
                ArrayList<ProductoCaracteristicas> productoYCaracteristica;
                String IdProducto = pdao.sacarIdProducto(request.getParameter("nombre"));

                productoYCaracteristica = pdao.getProductosCaracteristicas(IdProducto);
                request.setAttribute("ProductoCaracteristicas", productoYCaracteristica);

                request.setAttribute("DescripcionProducto", pdao.getSacarDescripcionProducto(IdProducto));

                request.setAttribute("NombreProducto", pdao.getSacarNombreProducto(IdProducto));

                request.setAttribute("idProducto", pdao.sacarIdProducto(request.getParameter("nombre")));


                request.setAttribute("imagen", pdao.sacarIdProducto(request.getParameter("nombre")));
                request.getRequestDispatcher("/JSP/ProductoCaracteristicas.jsp").forward(request, response);
                
                
                
                out.println("<h1>Servlet ControllersBusqudas at " + request.getParameter("nombre") + "</h1>");  
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
