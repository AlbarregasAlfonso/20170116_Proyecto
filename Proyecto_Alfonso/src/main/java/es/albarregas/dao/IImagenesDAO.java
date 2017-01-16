
package es.albarregas.dao;

import es.albarregas.beans.Cliente;
import es.albarregas.beans.Imagen;
import es.albarregas.beans.Usuario;
import java.util.ArrayList;

public interface IImagenesDAO {

    public ArrayList<Imagen> getImagenes(String idProducto);
    

    public void closeConnection();
}