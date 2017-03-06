/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.Cliente;
import es.albarregas.beans.Imagen;
import es.albarregas.beans.Producto;
import es.albarregas.beans.ProductoCaracteristicas;
import es.albarregas.beans.Usuario;
import es.albarregas.dao.IClienteDAO;
import es.albarregas.dao.IImagenesDAO;
import es.albarregas.dao.IPedidosDAO;
import es.albarregas.dao.IProductoDAO;
import es.albarregas.dao.IUsuarioDAO;
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
 * @author alfonso
 */
@WebServlet(name = "Controllers", urlPatterns = {"/Controllers"})
public class Controllers extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String url = "";
        DAOFactory daof = DAOFactory.getDAOFactory((int) 1);
        IUsuarioDAO udao = daof.getUsuarioDAO();
        IClienteDAO cdao = daof.getRegistroDAO();
        IPedidosDAO pedidosdao = daof.getPedidosDAO();

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

            request.setAttribute("imagen", request.getParameter("imagen"));
            request.getRequestDispatcher("/JSP/ProductoCaracteristicas.jsp").forward(request, response);
        }

        if (request.getParameter("valor") != null) {

            IProductoDAO pdao = daof.getProductoDAO();
            ArrayList<Producto> productos;
            String clausulaWhere = "where fueraCatalogo='n'";
            productos = pdao.getProductos(clausulaWhere);

            List<Producto> productosFraccionado = productos.subList(Integer.parseInt(request.getParameter("valor")), Integer.parseInt(request.getParameter("valor")) + 9);

            request.setAttribute("productosFraccionado", productosFraccionado);
            request.setAttribute("valor", Integer.parseInt(request.getParameter("valor")) + 9);

            ArrayList<Integer> paginacion = new ArrayList<Integer>();
            int contador = 0;

            for (Producto p : productos) {
                contador++;
                if (contador % 9 == 0) {
                    paginacion.add(contador);
                }
            }
            request.setAttribute("paginacion", paginacion);

            url = "/JSP/Productos.jsp";
            request.getRequestDispatcher(url).forward(request, response);
            
        }

        if (request.getParameter("Enviar") != null) {

            if (request.getParameter("Enviar").equals("registro")) {

              
                Cliente cliente = new Cliente("nombre", "apellido", request.getParameter("email"), "nif", "0000-00-00");
                request.getSession().setAttribute("apellido", false);

                Usuario usuario = new Usuario(request.getParameter("user"), request.getParameter("clave"));


                if (udao.userNameyautilizado(request.getParameter("user")).equals("OK") && udao.emailyautilizado(request.getParameter("email")).equals("OK")) {
                 
                    cdao.addCliente(cliente);
                    udao.addUsuario(usuario);
                    request.setAttribute("mensaje", " Usuario " + request.getParameter("user") + " registrado");

                } else {

                    request.setAttribute("mensaje", " Correo " + request.getParameter("email") + " o Usuario " + request.getParameter("user") + " ya existe");
                }

                request.getRequestDispatcher("index.jsp").forward(request, response);

            } else if (request.getParameter("Enviar").equals("iniciarSesion")) {

                if (udao.inicioSessionConMail2(request.getParameter("user"), request.getParameter("clave")).equals("usuario bloqueado") || udao.inicioSessionConMail2(request.getParameter("user"), request.getParameter("clave")).equals("Usuario o contraseña erroneos")) {

                    request.setAttribute("mensaje", udao.inicioSessionConMail2(request.getParameter("user"), request.getParameter("clave")));

                } else {

                    String username = udao.obtenerUsername(request.getParameter("user"));

                    request.getSession().setAttribute("usuario", udao.obtenerUsuario(udao.getSacarIdUsuario(username)));

                    Usuario u = udao.obtenerUsuario(udao.getSacarIdUsuario(username));

                    request.getSession().setAttribute("apellido", cdao.verSiEstanTodosLosDatosDelRegistro(u.getIdUsuario()));//Si no esta el registro al completo el atributo de sesion se pondra a false

                    request.setAttribute("mensaje", u.getUserName() + " bienvenido ");

                    if (pedidosdao.saberSiClienteTienePedidoAbierto(u.getIdUsuario())) {
                        request.getSession().setAttribute("carrito", "abierto");
                    }

                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
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
