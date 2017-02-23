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
import static java.lang.Float.parseFloat;
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

                if (request.getParameter("direccionDeEnvio") == null) {
                    
                    request.setAttribute("mensaje", "Tienes que seleccionar donde enviaremos el pedido");
                    request.getRequestDispatcher("/JSP/Pagar.jsp").forward(request, response);

                }

                if (pdao.obtenerProductosQueFaltanEnStock(u.getIdUsuario()) != null) {
                    
                    request.getSession().setAttribute("carrito", "cerrado");
                    ArrayList<Producto> productosSinStock = pdao.obtenerProductosQueFaltanEnStock(u.getIdUsuario());
                    
                    float precioTotal=0f;
                    float cantidad1;
                    float precioUnitario;
                    String idPedido = "";
                    
                    for(LineasPedidos p:productosCarritoDesglose){
                         idPedido=p.getIdPedido();
                        cantidad1 = parseFloat(p.getCantidad()); 
                        precioUnitario = parseFloat(p.getProducto().getPrecioConIva());
                        precioTotal=precioTotal+precioUnitario*cantidad1;
                    }
                    pedao.modificarEstadoDePedido("s", u.getIdUsuario(),request.getParameter("direccionDeEnvio"), precioTotal+5,"5",idPedido);

                    for (Producto p : productosSinStock) {

                        request.setAttribute("mensaje", "Hay productos que aún no lo tenemos en stock");
                        pdao.insertarEnProductosSinStock( p.getDenominacion(), p.getCantidadQueFaltaEnStock(),p.getIdProducto());

                    }
                    
                    request.getRequestDispatcher("index.jsp").forward(request, response);

                } else {

                    
                    request.setAttribute("mensaje", "Su pedido llegara en 5 dias laborales");
                    
                    float precioTotal=0f;
                    float cantidad1;
                    float precioUnitario;
                    String idPedido = "0";
                   
                    for(LineasPedidos p:productosCarritoDesglose){
                        
                        idPedido=p.getIdPedido();
                        System.out.println("Este for es el idPedido="+idPedido);
                        cantidad1 = parseFloat(p.getCantidad()); 
                        precioUnitario = parseFloat(p.getProducto().getPrecioConIva());
                        precioTotal=precioTotal+precioUnitario*cantidad1;
                    }
 
                    System.out.println("Este es el idPedido="+idPedido);
                    
                    pedao.modificarEstadoDePedido("r", u.getIdUsuario(),request.getParameter("direccionDeEnvio"),precioTotal+5,"5",idPedido);
                    request.getSession().setAttribute("carrito", "cerrado");
                    pdao.disminuirProductosEnStock(u.getIdUsuario(),"r",idPedido);
                   
                    request.getRequestDispatcher("index.jsp").forward(request, response);

                }

            }

            if (request.getParameter("Enviar") != null) {
           
              
                
                cdao.terminarRegistro(request.getParameter("nombre"), request.getParameter("apellidos"), request.getParameter("nif"), request.getParameter("fechaNac"), u.getIdUsuario());
             
                String codigoYCiudad=(request.getParameter("codigoPostal"));
                String codigoPostal=codigoYCiudad.substring(0,5);
                String pueblo=codigoYCiudad.substring(6, codigoYCiudad.length());
 
                ddao.introducirDireccion(request.getParameter("nombreDireccion"), request.getParameter("direccion"),codigoPostal, request.getParameter("telefono"), u.getIdUsuario(),pueblo);

                Provincia p = new Provincia();
                p = prodao.obtenerProvincia(request.getParameter("codigoPostal"));

                direcciones = ddao.obtenerDirecciones(u.getIdUsuario());
                request.setAttribute("direcciones", direcciones);

                request.getRequestDispatcher("/JSP/Pagar.jsp").forward(request, response);

            }

            if (request.getParameter("EnviarDesdePago") != null) {
               
                String codigoYCiudad=(request.getParameter("codigoPostal"));
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
           
            request.getRequestDispatcher("/JSP/Pagar.jsp").forward(request, response);

    
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
