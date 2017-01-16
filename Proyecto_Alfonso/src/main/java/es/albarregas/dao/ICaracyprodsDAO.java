/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Caracyprods;
import es.albarregas.beans.Imagen;
import java.util.ArrayList;

/**
 *
 * @author AlfonsoTerrones
 */
public interface ICaracyprodsDAO {
    
    public ArrayList<Caracyprods> getCaracyprods(String where);
    
    public void closeConnection();
    
}
