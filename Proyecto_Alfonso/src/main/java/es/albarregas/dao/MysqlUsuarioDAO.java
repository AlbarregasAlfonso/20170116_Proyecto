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

    @Override
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
            System.out.println("Error al ejecutar la sentencia de consulta inicioSession");
            ex.printStackTrace();
        }
        closeConnection();
        return mensaje;
    }

    @Override
    public String inicioSessionConMail(String correo, String clave) {
         String mensaje = " ";

        String consulta = "select c.Email,u.bloqueado, u.Clave from usuarios u inner join clientes c on c.IdCliente=u.IdUsuario";

        try {

            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            Throwable throwable = null;

            try {

                while (resultado.next()) {

                    if (resultado.getString("c.Email").equals(correo) && resultado.getString("u.Clave").equals(clave)) {

                        if (resultado.getString("u.bloqueado").equals("s")) {

                            mensaje = "usuario bloqueado";
                            break;

                        } else {

                            mensaje = "bienvenido ";
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
            System.out.println("Error al ejecutar la sentencia de consulta inicioSession");
            ex.printStackTrace();
        }
        closeConnection();
        System.out.println("Este es el mensaje "+mensaje);
        return mensaje;

    }

    @Override
    public void addUsuario(Usuario usuario) {
        try {
            String sqlAux = "select idCliente from clientes where IdCliente=(select max(IdCliente) from clientes);";
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(sqlAux);
            String idCliente = "";

            while (resultado.next()) {
                idCliente = resultado.getString("idCliente");
            }

            String sql = "insert into usuarios (IdUsuario,UserName,Clave,UltimoAcceso,Tipo,Bloqueado) values (?,?,MD5(?),now(),'u','n')";
            System.out.println(usuario.getUserName());
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

    @Override
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

    @Override
    public Usuario obtenerUsuariosConCliente(String idCliente) {

        Usuario u = new Usuario();
        Cliente c = new Cliente();

        String consulta = " select  u.UserName,u.clave,c.nombre,c.apellidos,c.email from  usuarios u inner join clientes c on c.idcliente=u.idusuario where c.idcliente=" + idCliente;
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            Throwable throwable = null;
            try {
                while (resultado.next()) {
                    // Usuario(String userName, String clave, Cliente cliente) {
                    //public Cliente(String nombre, String apellidos, String email) {
                    u = new Usuario();
                    c = new Cliente();
                    c = new Cliente(resultado.getString("c.nombre"), resultado.getString("c.apellidos"), resultado.getString("c.email"));
                    u = new Usuario(resultado.getString("u.UserName"), resultado.getString("u.clave"), c);
                    System.out.println("Estamos ene l dao de usuario " + u.getUserName());
                    System.out.println("Estamos ene l dao de usuario " + u.getClave());
                    System.out.println("Estamos ene l dao de usuario " + u.getCliente().getApellidos());
                    System.out.println("Estamos ene l dao de usuario " + u.getCliente().getNombre());
                    System.out.println("Estamos ene l dao de usuario " + u.getCliente().getEmail());

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
            System.out.println("Error al ejecutar la sentencia  getProductosEnCarrito");
            ex.printStackTrace();
        }
        closeConnection();
        System.out.println("Justo antes de salirrr" + u.getClave());
        return u;
    }

    @Override
    public void editarUsuarios(String nombre, String username, String clave, String apellidos, String mail, String idUsuario) {
        try {
            String sql = " UPDATE usuarios u inner join clientes c on c.idcliente=u.idusuario SET u.UserName=?,u.clave=?,c.nombre=?,c.apellidos=?,c.email=? where idusuario=?";
            System.out.println(sql);
            PreparedStatement preparada = ConnectionFactory.getConnection().prepareStatement(sql);

            preparada.setString(1, username);
            preparada.setString(2, clave);
            preparada.setString(3, nombre);
            preparada.setString(4, apellidos);
            preparada.setString(5, mail);
            preparada.setString(6, idUsuario);
            preparada.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Algo ha pasado al actualizar editar usuarios");
            Logger.getLogger(MysqlUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
    }

    @Override
    public String emailyautilizado(String mail) {
        String mensaje = " ";

        String consulta = "select Email from clientes";

        try {

            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            Throwable throwable = null;

            try {

                while (resultado.next()) {

                    if (resultado.getString("Email").equals(mail)) {

                        mensaje = "Este usuario ya existe";

                    } else {

                        mensaje = "OK";

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
            System.out.println("Error al ejecutar la sentencia de consulta inicioSession");
            ex.printStackTrace();
        }
        closeConnection();
        return mensaje;

    }
    
    @Override
    public String obtenerUsername (String mail){
          String re = null;
        if (mail == null) {
            mail = "";
        }

        String consulta = "select u.username from usuarios u inner join clientes c on c.idcliente=u.idusuario where c.email='" + mail + "'";
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            Throwable throwable = null;
            try {
                while (resultado.next()) {
                    re = resultado.getString("u.username");
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
}
