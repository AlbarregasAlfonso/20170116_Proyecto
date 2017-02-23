
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
                            <input type="text" name="user"  required title="Recuerda: solo puedes introducir letras" class="form-control" id="ejemplo_email_3"
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
                            <input type="text" name="email" pattern="[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*[.][a-zA-Z]{1,5}" required title="Recuerda: XXXX@XX.com" class="form-control" id="ejemplo_email_3"
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
 