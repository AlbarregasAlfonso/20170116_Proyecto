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
import es.albarregas.dao.IClienteDAO;

public class MysqlClienteDAO
        implements IClienteDAO {

    @Override
    public ArrayList<Cliente> getCliente(String where) {
        ArrayList<Cliente> lista;
        if (where == null) {
            where = "";
        }
        lista = new ArrayList<Cliente>();
        String consulta = "SELECT * FROM clientes " + where;
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            Throwable throwable = null;
            try {
                while (resultado.next()) {
                    Cliente cliente = new Cliente();
                    //cliente.setIdCliente(resultado.getString("idCliente"));
                    cliente.setNombre(resultado.getString("nombre"));
                    cliente.setApellidos(resultado.getString("apellidos"));
                    cliente.setEmail(resultado.getString("email"));
                    cliente.setNif(resultado.getString("nif"));
                    cliente.setFechaNacimiento(resultado.getString("fechaNacimiento"));
                    lista.add(cliente);
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

    public void addCliente(Cliente cliente) {
        try {
            String sql = "insert into clientes (IdCliente,Nombre,Apellidos,Email,NIF,FechaNacimiento,FechaAlta) values (?,?,?,?,?,?,now())";
            PreparedStatement preparada = ConnectionFactory.getConnection().prepareStatement(sql);
            preparada.setInt(1, 0);
            preparada.setString(2, cliente.getNombre());
            preparada.setString(3, cliente.getApellidos());
            preparada.setString(4, cliente.getEmail());
            preparada.setString(5, cliente.getNif());
            preparada.setString(6, cliente.getFechaNacimiento());
            preparada.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Algo ha pasado al insertar en addCliente");
            Logger.getLogger(MysqlClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
    }

    @Override
    public void closeConnection() {
        ConnectionFactory.closeConnection();
    }

    @Override
    public boolean verSiEstanTodosLosDatosDelRegistro(String idCliente) {
        boolean semaforo = true;
        String re = null;

        try {
            String sql = " select Nombre from clientes where IdCliente="+idCliente;
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);
            Throwable throwable = null;
            try {
                if (resultado.next()) {
                    re = resultado.getString("Nombre");
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
            System.out.println("Error al ejecutar la sentencia aumentarPedido");
            ex.printStackTrace();
        }
        closeConnection();

        if (re.equals("nombre")) {
            semaforo = false;
        } else {
            semaforo = true;
        }

        return semaforo;
    }

    @Override
    public void terminarRegistro(String nombre, String apellidos,String nif, String fechaNac, String idUsuario) {
        try {
            
            String sql = "UPDATE clientes SET Nombre='"+nombre+"', Apellidos='"+apellidos+"',NIF='"+nif+"',FechaNacimiento='"+fechaNac+"' WHERE IdCliente="+idUsuario;
           
            PreparedStatement preparada = ConnectionFactory.getConnection().prepareStatement(sql);
            preparada.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Algo ha pasado al actualizar");
            Logger.getLogger(MysqlUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
    }

}
