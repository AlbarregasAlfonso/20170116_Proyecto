/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Caracyprods;
import es.albarregas.beans.Cliente;
import es.albarregas.beans.Imagen;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author AlfonsoTerrones
 */
public class MysqlCaracyprodsDAO implements ICaracyprodsDAO{


    @Override
    public void closeConnection() {
         ConnectionFactory.closeConnection();
    }

    @Override
    public ArrayList<Caracyprods> getCaracyprods(String where) {
        ArrayList<Caracyprods> lista;
        if (where == null) {
            where = "";
        }
        lista = new ArrayList<Caracyprods>();
        String consulta = "SELECT * FROM caracyprods " + where;
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            Throwable throwable = null;
            try {
                while (resultado.next()) {
                    Caracyprods caracyprods = new Caracyprods();
  
                    caracyprods.setIdCaracyProds(resultado.getString("IdCaracyProds"));
                    caracyprods.setIdProducto(resultado.getString("IdProducto"));
                    caracyprods.setIdCaracteristica(resultado.getString("IdCaracteristica"));
                    caracyprods.setDescripcion(resultado.getString("Descripcion"));
                    caracyprods.setIdx(resultado.getString("Idx"));
                    lista.add(caracyprods);
                }
            }
            catch (Throwable caracyprods) {
                throwable = caracyprods;
                throw caracyprods;
            }
            finally {
                if (resultado != null) {
                    if (throwable != null) {
                        try {
                            resultado.close();
                        }
                        catch (Throwable registro) {
                            throwable.addSuppressed(registro);
                        }
                    } else {
                        resultado.close();
                    }
                }
            }
        }
        catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentencia");
            ex.printStackTrace();
        }
        return lista;
    }
    
}
