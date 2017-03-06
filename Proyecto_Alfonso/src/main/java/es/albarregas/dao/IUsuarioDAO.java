
package es.albarregas.dao;

import es.albarregas.beans.Cliente;
import es.albarregas.beans.Usuario;
import java.util.ArrayList;

public interface IUsuarioDAO {

    public void addUsuario(Usuario usuario);
    
    public String inicioSession (String correo, String clave);
    
    public String inicioSessionConMail2 (String correo, String clave);
    
    public String emailyautilizado (String mail);
    
    public String userNameyautilizado(String mail);
    
    public String inicioSessionConMail (String correo, String clave);
    
    public String getSacarIdUsuario(String userName);
    
    public String obtenerUsername (String mail);
    
    public String SacarTipoUsuario(String idUsuario);
    
    public ArrayList<Usuario> getUsuarios();
    
    public void BloquearDesbloquearUsuario(String IdUsuario, String estado);
    
    public Usuario obtenerUsuario(String idUsuario);
    
    public Usuario obtenerUsuariosConCliente(String idCliente);
    
    public void editarUsuarios(String nombre, String username, String clave, String apellidos, String mail, String idUsuario);
    
    public void closeConnection();
}