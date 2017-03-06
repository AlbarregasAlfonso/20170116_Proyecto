
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="modal fade" id="inicioSesion" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header" style="padding:35px 50px;">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4><span class="glyphicon glyphicon-lock"></span> Login</h4>
<!--                <h4><div id="message"></div></h4>-->
            </div>
            <div class="modal-body" style="padding:40px 50px;">
                <form action="Controllers" method="GET">
                    <div class="form-group">
                        <label for="usrname"><span class="glyphicon glyphicon-user"></span> Correo</label>
                        <input type="text" class="form-control" id="name" name="user" placeholder="Enter email">
                    </div>
                    <div class="form-group">
                        <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Password</label>
                        <input type="password" class="form-control" id="name" name="clave" placeholder="Enter password">
                    </div>
                    
                    
                    <input type="hidden" name="cantidad"  value="1"/>
                    
                    
                    
                    <div class="form-group">
                                <div class="col-lg-offset-1 col-lg-1">
                                    <button type="submit" name="Enviar" value="iniciarSesion" class="btn btn-default" style="float:left">Enviar</button>
                                </div>
                            </div>
                </form>
                <br/>
                <br/>
                <br/>
                <a   data-toggle="collapse" data-target="#demo">¿Aún no estas registrado?</a>
                <div id="demo" class="collapse">
                    <br/>
                    <br/>
                    <br/>
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
            </div>
            
                
            
            <div class="modal-footer">
                <button type="button" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>

            </div>
        </div>

    </div>
</div> 