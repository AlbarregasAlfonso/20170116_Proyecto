/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.Usuario;
import es.albarregas.dao.IUsuarioDAO;
import es.albarregas.daofactory.DAOFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AlfonsoTerrones
 */
@WebServlet(name = "ControllersUsuario", urlPatterns = {"/ControllersUsuario"})
public class ControllersUsuario extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");


            DAOFactory daof = DAOFactory.getDAOFactory((int) 1);
            IUsuarioDAO udao = daof.getUsuarioDAO();

            Usuario u = (Usuario) request.getSession().getAttribute("usuario");

            if (request.getParameter("editar") != null) {
                
                Usuario usuario = udao.obtenerUsuariosConCliente(u.getIdUsuario());
                request.setAttribute("usuario", usuario);
                request.getRequestDispatcher("/JSP/EditarDatos.jsp").forward(request, response);

            }
            
            if (request.getParameter("Enviar") != null) {
                
                udao.editarUsuarios(request.getParameter("nombre"), request.getParameter("username"), request.getParameter("clave"), request.getParameter("apellidos"),request.getParameter("email"), u.getIdUsuario());
                request.setAttribute("mensaje", "Usuario "+request.getParameter("nombre")+" editado");
                request.getRequestDispatcher("index.jsp").forward(request, response);
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
