
package es.albarregas.dao;

import es.albarregas.beans.Cliente;
import java.util.ArrayList;

public interface IClienteDAO {

    public ArrayList<Cliente> getCliente(String var1);

    public void addCliente(Cliente cliente);
    
    public boolean verSiEstanTodosLosDatosDelRegistro(String idCliente);
    
    public void terminarRegistro(String nombre, String apellidos,String nif, String fechaNac,String idUsuario);
    
    public void closeConnection();
}