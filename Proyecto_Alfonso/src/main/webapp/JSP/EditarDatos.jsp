<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../INI/Cabecera.jsp"/>
<jsp:include page="../INI/RegistroCompra.jsp"/>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<div class="row">
    <div class="col-sm-8" >

                <form action="ControllersUsuario" method="POST" class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="ejemplo_email_3" class="col-lg-2 control-label">Nombre</label>
                        <div class="col-lg-10">
                            <input type="text" value="<c:out value="${usuario.cliente.nombre}"/>" name="nombre" class="form-control" id="ejemplo_email_3"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="ejemplo_email_3" class="col-lg-2 control-label">UserName</label>
                        <div class="col-lg-10">
                            <input type="text" value="<c:out value="${usuario.userName}"/>" name="username" class="form-control" id="ejemplo_email_3"/>
                        </div>
                    </div><div class="form-group">
                        <label for="ejemplo_email_3" class="col-lg-2 control-label">Apellidos</label>
                        <div class="col-lg-10">
                            <input type="text" value="<c:out value="${usuario.cliente.apellidos}"/>" name="apellidos" class="form-control" id="ejemplo_email_3">
                        </div>
                    </div><div class="form-group">
                        <label for="ejemplo_email_3" class="col-lg-2 control-label">Email</label>
                        <div class="col-lg-10">
                            <input type="text" value="<c:out value="${usuario.cliente.email}"/>" name="email" class="form-control" id="ejemplo_email_3"
                                   >
                        </div>
                    </div><div class="form-group">
                        <label for="ejemplo_email_3" class="col-lg-2 control-label">clave</label>
                        <div class="col-lg-10">
                            <input type="password" value="<c:out value="${usuario.clave}"/>" name="clave" class="form-control" id="ejemplo_email_3"
                                   placeholder="ejemplo: casa">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-offset-1 col-lg-1">
                            <button type="submit" name="Enviar" class="btn btn-default" style="float:left">Enviar</button>
                        </div>
                    </div>
                </form>
            </div>
        
        
        
        
        
        
        
        
        
    </div>

</body>
</html>