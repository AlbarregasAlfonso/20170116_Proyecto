/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Provincia;

/**
 *
 * @author AlfonsoTerrones
 */
public interface IProvinciaDAO {
 
    public Provincia obtenerProvincia(String codigoPostal);
    
    public void mostrarTodosLosPueblos();
    
     public void closeConnection();
}
