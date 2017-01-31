/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.Direccion;
import es.albarregas.beans.LineasPedidos;
import es.albarregas.beans.Producto;
import es.albarregas.beans.Provincia;
import es.albarregas.beans.Usuario;
import es.albarregas.dao.IClienteDAO;
import es.albarregas.dao.IDireccionesDAO;
import es.albarregas.dao.ILineasPedidosDAO;
import es.albarregas.dao.IPedidosDAO;
import es.albarregas.dao.IProductoDAO;
import es.albarregas.dao.IProvinciaDAO;
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
@WebServlet(name = "ControllersPagar", urlPatterns = {"/ControllersPagar"})
public class ControllersPagar extends HttpServlet {

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
            out.println("<title>Servlet ControllersPagar</title>");
            out.println("</head>");
            out.println("<body>");

            DAOFactory daof = DAOFactory.getDAOFactory((int) 1);
            IPedidosDAO pedao = daof.getPedidosDAO();
            IClienteDAO cdao = daof.getRegistroDAO();
            IProvinciaDAO prodao = daof.getProvinciaDAO();
            IProductoDAO pdao = daof.getProductoDAO();

            IDireccionesDAO ddao = daof.getDireccionesDAO();
            ILineasPedidosDAO lpdao = daof.getLineaPedidosDAO();
            Usuario u = (Usuario) request.getSession().getAttribute("usuario");
            ArrayList<LineasPedidos> productosCarritoDesglose = lpdao.getProductosEnCarritoConDesglose(u.getIdUsuario());
            request.setAttribute("productosCarritoDeglose", productosCarritoDesglose);

            ArrayList<Direccion> direcciones = ddao.obtenerDirecciones(u.getIdUsuario());
            request.setAttribute("direcciones", direcciones);

            if (request.getParameter("Enviar2") != null) {
                System.out.println("Envaiamos2");
                if (request.getParameter("direccionDeEnvio") == null) {
                    System.out.println("no hay direccion");
                    request.setAttribute("mensaje", "Tienes que seleccionar donde enviaremos el pedido");
                    request.getRequestDispatcher("/JSP/Pagar.jsp").forward(request, response);

                }

                if (pdao.obtenerProductosQueFaltanEnStock(u.getIdUsuario()) != null) {
                    
                    request.getSession().setAttribute("carrito", "cerrado");
                    System.out.println("No hay stock");
                    ArrayList<Producto> productosSinStock = pdao.obtenerProductosQueFaltanEnStock(u.getIdUsuario());
                    pedao.modificarEstadoDePedido("s", u.getIdUsuario());

                    for (Producto p : productosSinStock) {

                        System.out.println("Esto es lo que hay" + p.getDenominacion()+"Y faltan "+p.getCantidadQueFaltaEnStock());
                        request.setAttribute("mensaje", "El producto " + p.getDenominacion() + " no lo tenemos en Stock ahora mismo");
                        pdao.insertarEnProductosSinStock( p.getDenominacion(), p.getCantidadQueFaltaEnStock());

                    }
                    
                    request.getRequestDispatcher("index.jsp").forward(request, response);

                } else {

                    pdao.disminuirProductosEnStock(u.getIdUsuario());
                    request.setAttribute("mensaje", "Su pedido llegara en 5 dias laborales");
                    pedao.modificarEstadoDePedido("r", u.getIdUsuario());
                    request.getSession().setAttribute("carrito", "cerrado");
                    request.getRequestDispatcher("index.jsp").forward(request, response);

                }

            }
//            if (request.getParameter("direccionDeEnvio") != null) {
//                
//                //HAs reyenado todos los datos
//                
//                if (pdao.obtenerProductosQueFaltanEnStock(u.getIdUsuario()) != null) {
//                
//                    ArrayList<Producto> productosSinStock = pdao.obtenerProductosQueFaltanEnStock(u.getIdUsuario());
//                    
//                    for (Producto p : productosSinStock) {
//                    
//                         
//                        request.setAttribute("mensaje", "del producto " + p.getDenominacion() + " no hay stock");
//                    
//                    } 
//           
//                }else{
//                   
//                    System.out.println("entramos en finalizar compra bien y quitar de stock");
//                   
//                    pdao.disminuirProductosEnStock(u.getIdUsuario());
//                    
//                }
//                
//                request.getRequestDispatcher("index.jsp").forward(request, response);
//                
//            } else if(request.getParameter("Enviar2")!=null){
//                
//                request.setAttribute("mensaje", "Tienes que seleccionar donde enviaremos el pedido");
//                request.getRequestDispatcher("/JSP/Pagar.jsp").forward(request, response);
//            
//            }

            if (request.getParameter("Enviar") != null) {
                
              
                
                cdao.terminarRegistro(request.getParameter("nombre"), request.getParameter("apellidos"), request.getParameter("nif"), request.getParameter("fechaNac"), u.getIdUsuario());
             //   ddao.introducirDireccion(request.getParameter("nombreDireccion"), request.getParameter("direccion"), request.getParameter("codigoPostal"), request.getParameter("telefono"), u.getIdUsuario());

                Provincia p = new Provincia();
                p = prodao.obtenerProvincia(request.getParameter("codigoPostal"));

                direcciones = ddao.obtenerDirecciones(u.getIdUsuario());
                request.setAttribute("direcciones", direcciones);

                request.getRequestDispatcher("/JSP/Pagar.jsp").forward(request, response);

            }

            if (request.getParameter("EnviarDesdePago") != null) {
                
                  String codigoYCiudad=(request.getParameter("codigoPostal"));
                System.out.println("Este es el codigo "+codigoYCiudad.substring(0,5)+" y la direccion "+codigoYCiudad.substring(6, codigoYCiudad.length()));
                String codigoPostal=codigoYCiudad.substring(0,5);
                String pueblo=codigoYCiudad.substring(6, codigoYCiudad.length());
                
                
                ddao.introducirDireccion(request.getParameter("nombreDireccion"), request.getParameter("direccion"),codigoPostal, request.getParameter("telefono"), u.getIdUsuario(),pueblo);

                lpdao = daof.getLineaPedidosDAO();
                u = (Usuario) request.getSession().getAttribute("usuario");
                productosCarritoDesglose = lpdao.getProductosEnCarritoConDesglose(u.getIdUsuario());
                request.setAttribute("productosCarritoDeglose", productosCarritoDesglose);

                direcciones = ddao.obtenerDirecciones(u.getIdUsuario());
                request.setAttribute("direcciones", direcciones);

                request.setAttribute("mensaje", "Has añadido una nueva dirección");
                request.getRequestDispatcher("/JSP/Pagar.jsp").forward(request, response);
            }

//            if(!pedao.obtenerApellidoDelClienteDeUnPedido(request.getParameter("idPedido"))){//si no esta registrado entramos aqui
//                
//                
//                 
//
//                 
//            }
            request.getRequestDispatcher("/JSP/Pagar.jsp").forward(request, response);

            out.println("Esto va to perfe");
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
