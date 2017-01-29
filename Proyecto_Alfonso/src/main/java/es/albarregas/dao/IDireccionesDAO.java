/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Direccion;
import java.util.ArrayList;

/**
 *
 * @author AlfonsoTerrones
 */
public interface IDireccionesDAO {
    
    public void introducirDireccion(String nombreDireccion, String direccion, String codigoPostal, String telefono, String idUsuario);
    
    public  ArrayList<Direccion> obtenerDirecciones (String idCliente);
    
    public void closeConnection();
}
