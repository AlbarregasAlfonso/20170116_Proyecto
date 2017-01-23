
         <div class="modal fade" id="RegistroCompra" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">¿Aún no estas registrado?</h4>
        </div>
        <div class="modal-body">
            
        <form action="Controllers" method="POST">
        
        <table>
            
            <tr>
                <td>Nombre de usuario</td>
                <td><input name="user" pattern="[a-zA-Z]+" type="text"/></td>       
            </tr>
            <tr>
                <td>clave</td>
                <td><input name="clave" type="password"/></td>      
            </tr>
            <tr>
                <td>nombre</td>
                <td><input name="nombre" type="text"/></td>         
            </tr> 
            <tr>
                <td>apellidos</td>
                <td><input name="apellidos" type="text"/></td>       
            </tr>
            <tr>
                <td>email</td>
                <td><input name="email" type="text"/></td>          
            </tr>
            <tr>
                <td>NIF</td>
                <td><input name="nif" type="text"/></td>         
            </tr>
            <tr>
                <td>Fecha de nacimiento</td>
                <td><input name="fechaNacimiento" type="text"/></td>       
            </tr>
            <tr>
                <td><input type="submit" name="Enviar" value="registro"/></td>
                <td></td>        
            </tr>

        </table>

        </form>
           </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
        </div>
      </div>
      
    </div>
   </div>
 