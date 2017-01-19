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

    public String inicioSession(String username, String clave) {

        String mensaje = " ";

        String consulta = "SELECT * FROM usuarios";
        
        try {
            
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            Throwable throwable = null;
            
            try {
                
                while (resultado.next()) {

                    if (resultado.getString("UserName").equals(username) && resultado.getString("clave").equals(clave)) {

                        if (resultado.getString("bloqueado").equals("s")) {
                            
                            mensaje = "usuario bloqueado";
                            break;
                            
                        } else {
                            
                            mensaje = "bienvenido " + resultado.getString("UserName");
                            break;
                        }
                    } else {
                        
                        mensaje = "Usuario o contraseña erroneos";
                        
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
            System.out.println("Error al ejecutar la sentencia de consulta");
            ex.printStackTrace();
        }
        closeConnection();
        return mensaje;
    }

    public void addUsuario(Usuario usuario) {
        try {
            String sqlAux = "select idCliente from clientes where IdCliente=(select max(IdCliente) from clientes);";
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(sqlAux);
            String idCliente = "";

            while (resultado.next()) {
                idCliente = resultado.getString("idCliente");
            }

            String sql = "insert into usuarios (IdUsuario,UserName,Clave,UltimoAcceso,Tipo,Bloqueado) values (?,?,?,now(),'u','n')";

            PreparedStatement preparada = ConnectionFactory.getConnection().prepareStatement(sql);
            preparada.setString(1, idCliente);
            preparada.setString(2, usuario.getUserName());
            preparada.setString(3, usuario.getClave());
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
    public String getSacarIdUsuario(String userName) {
        String re = null;
        if (userName == null) {
            userName = "";
        }

        String consulta = "select IdUsuario from usuarios where UserName='" + userName + "'";
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            Throwable throwable = null;
            try {
                while (resultado.next()) {
                    re = resultado.getString("IdUsuario");

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
        closeConnection();
        return re;
    }

    @Override
    public String SacarTipoUsuario(String idUsuario) {
        String re = null;
        if (idUsuario == null) {
            idUsuario = "";
        }

        String consulta = "select Tipo from usuarios where idUsuario='" + idUsuario + "'";
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            Throwable throwable = null;
            try {
                while (resultado.next()) {
                    re = resultado.getString("Tipo");

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
        closeConnection();
        return re;
    }

    @Override
    public ArrayList<Usuario> getUsuarios() {
        ArrayList<Usuario> lista;

        lista = new ArrayList<Usuario>();
        String consulta = "select * from usuarios where tipo='u'";
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            Throwable throwable = null;
            try {
                while (resultado.next()) {
                    Usuario u = new Usuario();
                    u.setIdUsuario(resultado.getString("IdUsuario"));
                    u.setUserName(resultado.getString("UserName"));
                    u.setBloqueado(resultado.getString("Bloqueado"));
                    lista.add(u);
                }
            } catch (Throwable producto) {
                throwable = producto;
                throw producto;
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
            ex.printStackTrace();
        }
        closeConnection();
        return lista;
    }

    @Override
    public void BloquearDesbloquearUsuario(String IdUsuario, String estado) {
        try {
            String sql = "UPDATE usuarios SET Bloqueado=? WHERE IdUsuario=?";
            PreparedStatement preparada = ConnectionFactory.getConnection().prepareStatement(sql);
            preparada.setString(1, estado);
            preparada.setString(2, IdUsuario);
            preparada.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Algo ha pasado al actualizar");
            Logger.getLogger(MysqlUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();

    }

    public Usuario obtenerUsuario(String idUsuario) {

        Usuario u = new Usuario();
        String consulta = "select * from usuarios where IdUsuario=" + idUsuario;

        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            Throwable throwable = null;
            try {
                while (resultado.next()) {
                    u = new Usuario();
                    u.setTipo(resultado.getString("Tipo"));
                    u.setIdUsuario(resultado.getString("IdUsuario"));
                    u.setUserName(resultado.getString("UserName"));
                    u.setBloqueado(resultado.getString("Bloqueado"));
                    u.setClave(resultado.getString("Clave"));
                    u.setUltimoAcceso(resultado.getString("UltimoAcceso"));
                }
            } catch (Throwable producto) {
                throwable = producto;
                throw producto;
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
        return u;

    }
}
