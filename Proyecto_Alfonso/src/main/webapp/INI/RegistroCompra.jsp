
         <div class="modal fade" id="RegistroCompra" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Para finalizar su compra debes de terminar su registro</h4>
        </div>
        <div class="modal-body">
            
        <form action="ControllersPagar" method="POST">
        
        <table>

            <tr>
              
                <td><input name="nombre" placeholder="Nombre" type="text"/></td>         
            </tr> 
            <tr>
             
                <td><input name="apellidos" placeholder="Apellido" type="text"/></td>       
            </tr>
            <tr>
         
                <td><input name="email" placeholder="Email" type="text"/></td>          
            </tr>
            <tr>
     
                <td><input name="nif" placeholder="NIF" type="text"/></td>         
            </tr>
            <tr>

                <td><input name="fechaNacimiento" placeholder="Fecha Nacimiento 'XXXX-XX-XX" type="text"/></td>       
            </tr>
              <tr>
        
                <td><input name="nombredireccion" placeholder="Nombre Direccion" type="text"/></td>       
            </tr>
              <tr>
   
                <td><input name="direccion" placeholder="Direccion" type="text"/></td>       
            </tr>
              <tr>
       
                <td><input name="codigopostal" placeholder="Codigo Postal" type="text"/></td>       
            </tr>
             <tr>
      
                <td><input name="telefono" placeholder="Telefono" type="text"/></td>       
            </tr>
            <tr>
                <td><input type="submit" name="Enviar" value="RegistroTotal"/></td>
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
 