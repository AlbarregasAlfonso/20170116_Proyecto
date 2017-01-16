
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="modal fade" id="inicioSesion" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Inicio de Sesión</h4>
            </div>
            <div class="modal-body">
                <form action="Controllers" method="POST">

                    <h2><c:out value="${noEncontrado}"/></h2>

                    <div class="col-sm-6 form-group">
                        <input class="form-control" id="name" name="user" placeholder="Usuario" type="text" required>
                    </div>
                    <div class="col-sm-6 form-group">
                        <input class="form-control" id="name" name="clave" placeholder="clave" type="password" required>
                    </div>
                    <input type="submit" name="Enviar" value="iniciarSesion"/>

                </form>  
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
            </div>

        </div>

    </div>
</div>

