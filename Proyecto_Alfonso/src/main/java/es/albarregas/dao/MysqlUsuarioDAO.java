
package es.albarregas.dao;

import es.albarregas.beans.Cliente;

import es.albarregas.dao.ConnectionFactory;
import java.io.PrintStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import es.albarregas.beans.Cliente;
import es.albarregas.beans.Usuario;
import es.albarregas.dao.IClienteDAO;

public class MysqlUsuarioDAO implements IUsuarioDAO {
  

   public boolean inicioSession (String username, String clave){
       
       boolean encontrado=false;
       
       String consulta = "SELECT * FROM usuarios";
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            Throwable throwable = null;
            try {
                while (resultado.next()) {
                    System.out.println("Estamos comparando"+resultado.getString("UserName")+" con "+username+" y la clave "+resultado.getString("clave")+" con "+clave);
                    if(resultado.getString("UserName").equals(username) && resultado.getString("clave").equals(clave)){
                        System.out.println("Entramosssss");
                        encontrado=true;
                    }
                }
            }
            catch (Throwable equipo) {
                throwable = equipo;
                throw equipo;
            }
            finally {
                if (resultado != null) {
                    if (throwable != null) {
                        try {
                            resultado.close();
                        }
                        catch (Throwable equipo) {
                            throwable.addSuppressed(equipo);
                        }
                    } else {
                        resultado.close();
                    }
                }
            }
        }
        catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentencia de consulta");
            ex.printStackTrace();
        }
        return encontrado;
   }
    
    public void addUsuario(Usuario usuario) {
        try {
            String sqlAux="select idCliente from clientes where IdCliente=(select max(IdCliente) from clientes);";
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(sqlAux);   
            String idCliente ="";
             
            while (resultado.next()) {
                  idCliente = resultado.getString("idCliente");
              }

            String sql = "insert into usuarios (IdUsuario,UserName,Clave,UltimoAcceso,Tipo,Bloqueado) values (?,?,?,now(),'u','n')";

            
            PreparedStatement preparada = ConnectionFactory.getConnection().prepareStatement(sql);
            preparada.setString(1, idCliente);
            preparada.setString(2, usuario.getUserName());
            preparada.setString(3, usuario.getClave());
            preparada.executeUpdate();
 
        }
        catch (SQLException ex) {
            System.out.println("Algo ha pasado al insertar");
            Logger.getLogger(MysqlUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
 
   



    @Override
    public void closeConnection() {
        ConnectionFactory.closeConnection();
    }

    @Override
    public String getSacarIdUsuario(String userName) {
        String re=null;
        if (userName == null) {
            userName = "";
        }
        
        String consulta = "select IdUsuario from usuarios where UserName='" + userName +"'";
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            Throwable throwable = null;
            try {
                 while (resultado.next()) {
                    re=resultado.getString("IdUsuario");
                    
                 }
               
            } catch (Exception e) {
                
            } finally {
                if (resultado != null) {
                    if (throwable != null) {
                        try {
                            resultado.close();
                        } catch (Exception e) {
                           
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
        return re;
    }


}