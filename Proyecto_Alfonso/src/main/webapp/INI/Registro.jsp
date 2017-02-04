
<!--         <div class="modal fade" id="Registro" role="dialog">
    <div class="modal-dialog">
    
       Modal content
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
                <td>email</td>
                <td><input name="email" type="text"/></td>          
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
   </div>-->







<div class="modal fade" id="Registro" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Para finalizar su compra debes de terminar su registro</h4>
            </div>
            <div class="modal-body">
 
                <form action="Controllers" method="POST" class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="ejemplo_email_3" class="col-lg-2 control-label">UserName</label>
                        <div class="col-lg-10">
                            <input type="text" name="user" pattern="[a-zA-Z]+" class="form-control" id="ejemplo_email_3"
                                   placeholder="Nombre de uusario">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="ejemplo_email_3" class="col-lg-2 control-label">Clave</label>
                        <div class="col-lg-10">
                            <input type="password" name="clave" class="form-control" id="ejemplo_email_3"
                                   placeholder="">
                        </div>
                    </div><div class="form-group">
                        <label for="ejemplo_email_3" class="col-lg-2 control-label">Email</label>
                        <div class="col-lg-10">
                            <input type="text" name="email" class="form-control" id="ejemplo_email_3"
                                   placeholder="XXXX@XX.com">
                        </div>
                    </div>
                   
                    <div class="form-group">
                        <div class="col-lg-offset-1 col-lg-1">
                            <button type="submit" name="Enviar" value="registro" class="btn btn-default" style="float:left">Enviar</button>
                        </div>
                    </div>
                </form>
            </div>
         
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
            </div>
        </div>

    </div>
</div>
 