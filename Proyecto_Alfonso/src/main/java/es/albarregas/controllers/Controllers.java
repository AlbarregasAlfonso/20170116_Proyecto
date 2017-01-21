/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.Caracyprods;
import es.albarregas.beans.Cliente;
import es.albarregas.beans.Imagen;
import es.albarregas.beans.Producto;
import es.albarregas.beans.ProductoCaracteristicas;
import es.albarregas.beans.Usuario;
import es.albarregas.dao.ICaracyprodsDAO;
import es.albarregas.dao.IClienteDAO;
import es.albarregas.dao.IImagenesDAO;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author alfonso
 */
@WebServlet(name = "Controllers", urlPatterns = {"/Controllers"})
public class Controllers extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");

            String url = "";
            DAOFactory daof = DAOFactory.getDAOFactory((int) 1);

            IUsuarioDAO udao = daof.getUsuarioDAO();
                      
            if (request.getParameter("cerrarsesion") != null) {
                
                request.setAttribute("mensaje", "Hasta pronto!");
                request.getSession().removeAttribute("usuario");
                request.getSession().removeAttribute("carrito");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                
            }

            if (request.getParameter("imagen") != null) {

                IImagenesDAO idao = daof.getImagenDAO();
                ArrayList<Imagen> imagenes;

                String clausulaWhere = request.getParameter("imagen");
                imagenes = idao.getImagenes(clausulaWhere);

                request.setAttribute("imagenes", imagenes);

                IProductoDAO pdao = daof.getProductoDAO();
                ArrayList<ProductoCaracteristicas> productoYCaracteristica;
                String IdProducto = request.getParameter("imagen");

                productoYCaracteristica = pdao.getProductosCaracteristicas(IdProducto);
                request.setAttribute("ProductoCaracteristicas", productoYCaracteristica);

                request.setAttribute("DescripcionProducto", pdao.getSacarDescripcionProducto(IdProducto));

                request.setAttribute("NombreProducto", pdao.getSacarNombreProducto(IdProducto));

                request.setAttribute("idProducto", request.getParameter("imagen"));

                int numEntero = Integer.parseInt(pdao.getSacarStock(IdProducto));
                
                //hacemos un array con la misma dimesion que productos en stock tengamos
                int[] stock = new int[numEntero];
                for (int i = 1; i < stock.length + 1; i++) {                    
                    stock[i - 1] = i;
                }
       
                request.setAttribute("Stock", stock);
                request.setAttribute("imagen", request.getParameter("imagen"));
                request.getRequestDispatcher("/JSP/ProductoCaracteristicas.jsp").forward(request, response);
            }

            if (request.getParameter("valor") != null) {

                out.println("<h1>Servlet Controladorrrrrr at " + request.getContextPath() + "</h1>");

                IProductoDAO pdao = daof.getProductoDAO();
                ArrayList<Producto> productos;
                String clausulaWhere = new String();
                productos = pdao.getProductos(clausulaWhere);

                //fraccionar el array
                List<Producto> productosFraccionado = productos.subList(Integer.parseInt(request.getParameter("valor")), Integer.parseInt(request.getParameter("valor")) + 9);

                request.setAttribute("productosFraccionado", productosFraccionado);
                request.setAttribute("valor", Integer.parseInt(request.getParameter("valor")) + 9);

                url = "/JSP/Productos.jsp";

                request.getRequestDispatcher(url).forward(request, response);

            }

            //request.getRequestDispatcher(url).forward(request, response);
            if (request.getParameter("Enviar").equals("registro")) {

                IClienteDAO cdao = daof.getRegistroDAO();
                Cliente cliente = new Cliente(request.getParameter("nombre"), request.getParameter("apellidos"), request.getParameter("email"), request.getParameter("nif"), request.getParameter("fechaNacimiento"));
                cdao.addCliente(cliente);

                Usuario usuario = new Usuario(request.getParameter("user"), request.getParameter("clave"));
                udao.addUsuario(usuario);

                request.getRequestDispatcher("index.jsp").forward(request, response);

            } else if (request.getParameter("Enviar").equals("iniciarSesion")) {

                if (udao.inicioSession(request.getParameter("user"), request.getParameter("clave")).equals("usuario bloqueado") || udao.inicioSession(request.getParameter("user"), request.getParameter("clave")).equals("Usuario o contraseña erroneos")) {
                    request.setAttribute("mensaje", udao.inicioSession(request.getParameter("user"), request.getParameter("clave")));
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                } else {
                    request.getSession().setAttribute("usuario", udao.obtenerUsuario(udao.getSacarIdUsuario(request.getParameter("user"))));

                    Usuario u = udao.obtenerUsuario(udao.getSacarIdUsuario(request.getParameter("user")));
                    request.setAttribute("mensaje", udao.inicioSession(request.getParameter("user"), request.getParameter("clave")));
                    request.getRequestDispatcher("index.jsp").forward(request, response);

                }
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
