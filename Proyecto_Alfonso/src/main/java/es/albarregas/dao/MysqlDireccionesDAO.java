/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Direccion;
import es.albarregas.beans.Provincia;
import es.albarregas.beans.Pueblo;
import static es.albarregas.dao.ConnectionFactory.closeConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AlfonsoTerrones
 */
public class MysqlDireccionesDAO implements IDireccionesDAO {

    @Override
    public void introducirDireccion(String nombreDireccion, String direccion, String codigoPostal, String telefono, String idUsuario, String nombre) {
        try {
            String sqlAux = "select max(IdDireccion)+1 from direcciones";
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(sqlAux);
            String idDireccion = null;

            while (resultado.next()) {
                idDireccion = resultado.getString("max(IdDireccion)+1");
            }
            if (idDireccion == null) {
                idDireccion = "1";

            }

            String sql = "insert into direcciones value(" + idDireccion + "," + idUsuario + ",'" + nombreDireccion + "','" + direccion + "'," + codigoPostal + ",(select IdPueblo from pueblos where CodigoPostal=" + codigoPostal + " and Nombre='" + nombre + "')," + telefono + ")";
            PreparedStatement preparada = ConnectionFactory.getConnection().prepareStatement(sql);
            preparada.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Algo ha pasado al insertar");
            Logger.getLogger(MysqlUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();

    }

    @Override
    public void closeConnection() {
        ConnectionFactory.closeConnection();
    }

    @Override
    public ArrayList<Direccion> obtenerDirecciones(String idCliente) {
        ArrayList<Direccion> lista;
        if (idCliente == null) {
            idCliente = "";
        }
        lista = new ArrayList<Direccion>();
        String consulta = "select di.IdDireccion,pu.Nombre,pu.CodigoPostal,pr.Nombre,di.NombreDireccion,di.Direccion,di.CodigoPostal,di.Telefono,di.IdCliente from direcciones di inner join pueblos pu on pu.IdPueblo=di.IdPueblo inner join provincias pr on pr.IdProvincia=pu.IdProvincia where di.IdCliente=" + idCliente;
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            Throwable throwable = null;
            try {
                while (resultado.next()) {

                    Pueblo pu = new Pueblo(resultado.getString("pu.Nombre"), resultado.getString("pu.CodigoPostal"));
                    Provincia p = new Provincia(resultado.getString("pr.Nombre"));
                    Direccion d = new Direccion(resultado.getString("di.IdDireccion"), resultado.getString("di.Direccion"), resultado.getString("di.NombreDireccion"), resultado.getString("di.Telefono"), pu, p);

                    lista.add(d);
                }
            } catch (Throwable cliente) {
                throwable = cliente;
                throw cliente;
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
        closeConnection();
        return lista;
    }

    @Override
    public boolean buscarNombreDireccion(String nombreDireccion) {
        Boolean mensaje=true;

        String consulta = "select NombreDireccion from direcciones";

        try {

            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            Throwable throwable = null;

            try {

                while (resultado.next()) {

                    if (resultado.getString("NombreDireccion").equals(nombreDireccion)) {
                        mensaje = false;
                        break;

                    } else {

                    }
                }
            } catch (Throwable equipo) {
                throwable = equipo;
                throw equipo;
            } finally {
                if (resultado != null) {
                    if (throwable != null) {
                        try {
                            resultado.close();
                        } catch (Throwable equipo) {
                            throwable.addSuppressed(equipo);
                        }
                    } else {
                        resultado.close();
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MysqlUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al ejecutar la sentencia de consulta inicioSession");
            ex.printStackTrace();
        }
        closeConnection();
        return mensaje;
    }

}
