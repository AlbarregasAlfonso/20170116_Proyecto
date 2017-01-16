/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Imagen;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author AlfonsoTerrones
 */
public class MysqlImagenDAO implements IImagenesDAO {

    @Override
    public ArrayList<Imagen> getImagenes(String var1) {
        ArrayList<Imagen> lista;
        if (var1 == null) {
            var1 = "";
        }
        lista = new ArrayList<Imagen>();
        String consulta = "SELECT * FROM imagenes where idProducto="+var1;
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            Throwable throwable = null;
            try {
                while (resultado.next()) {
                    Imagen imagen = new Imagen();
                    imagen.setIdImagen(resultado.getString("IdImagen"));
                    imagen.setIdProducto(resultado.getString("IdProducto"));
                    imagen.setImage(resultado.getString("Image"));
                    lista.add(imagen);
                }
            } catch (Throwable imagen) {
                throwable = imagen;
                throw imagen;
            } finally {
                if (resultado != null) {
                    if (throwable != null) {
                        try {
                            resultado.close();
                        } catch (Throwable registro) {
                            throwable.addSuppressed(registro);
                        }
                    } else {
                        resultado.close();
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentencia");
            ex.printStackTrace();
        }
        return lista;
    }

    @Override
    public void closeConnection() {
        ConnectionFactory.closeConnection();
    }

}
