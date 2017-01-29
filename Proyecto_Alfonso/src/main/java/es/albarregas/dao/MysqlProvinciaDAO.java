/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Provincia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author AlfonsoTerrones
 */
public class MysqlProvinciaDAO implements IProvinciaDAO{

    @Override
    public Provincia obtenerProvincia(String codigoPostal) {
        Provincia p = null;
        String consulta = "select pu.IdPueblo, pu.IdProvincia, pu.CodigoPostal, pu.Nombre, pro.Nombre from pueblos pu inner join provincias pro on pro.IdProvincia=pu.IdProvincia where codigopostal=" + codigoPostal;

        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            Throwable throwable = null;
            try {
                while (resultado.next()) {
                    p = new Provincia();
                    p.setCodigoPostal(resultado.getString("pu.CodigoPostal"));
                    p.setIdProvincia(resultado.getString("pu.IdProvincia"));
                    p.setIdPueblo(resultado.getString("pu.IdPueblo"));
                    p.setNombre(resultado.getString("pro.Nombre"));
                    p.setNombrePueblo(resultado.getString("pu.Nombre"));
           
                }
            } catch (Throwable Provincia) {
                throwable = Provincia;
                throw Provincia;
            } finally {
                if (resultado != null) {
                    if (throwable != null) {
                        try {
                            resultado.close();
                        } catch (Throwable producto) {
                            throwable.addSuppressed(producto);
                        }
                    } else {
                        resultado.close();
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentencia");
            System.out.println(ex.getMessage());
        }
        closeConnection();
        return p;

    }

  @Override
    public void closeConnection() {
        ConnectionFactory.closeConnection();
    }
    
    
}
