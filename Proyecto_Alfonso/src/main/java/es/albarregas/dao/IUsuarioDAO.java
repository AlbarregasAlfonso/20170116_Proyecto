
package es.albarregas.dao;

import es.albarregas.beans.Cliente;
import es.albarregas.beans.Usuario;
import java.util.ArrayList;

public interface IUsuarioDAO {

    public void addUsuario(Usuario usuario);
    
    public boolean inicioSession (String correo, String clave);
    
    public String getSacarIdUsuario(String userName);

    public void closeConnection();
}