
package es.albarregas.dao;

import es.albarregas.beans.Cliente;
import java.util.ArrayList;

public interface IClienteDAO {

    public ArrayList<Cliente> getCliente(String var1);

    public void addCliente(Cliente cliente);
    
    public void closeConnection();
}