<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../INI/Cabecera.jsp"/>

</br>
</br>
</br>
</br>
<h1>¿A quien deseas bloquear o desbloquear?</h1>
<table class="table">
    <thead>
        <tr>
            <th>Usuario</th>
            <th>Bloqueado</th>
            <th>Desbloqueado</th>
        </tr>
    </thead>

    <c:forEach items="${usuarios}"  var="u">
        <tbody>
            <tr>
                <td><label><c:out value="${u.userName}"/> :</label></td>

                <c:if test="${u.bloqueado=='n'}">

            <td><input onclick= "self.location.href = 'ControllersAdministrador?bloquear=s&idusuario=${u.idUsuario}&mensaje=usuario ${u.userName} bloqueado'" type="radio" value="bloqueado" /></td>
            <td><input onclick= "self.location.href = 'ControllersAdministrador?bloquear=n&idusuario=${u.idUsuario}&mensaje=usuario ${u.userName} desbloqueado'" type="radio" value="desbloqueado" checked="checked"/></td>

        </c:if>
        <c:if test="${u.bloqueado=='s'}">

            <td><input onclick= "self.location.href = 'ControllersAdministrador?bloquear=s&idusuario=${u.idUsuario}&mensaje=usuario ${u.userName} bloqueado'" type="radio" value="bloqueado" checked="checked"/></td>
            <td><input onclick= "self.location.href = 'ControllersAdministrador?bloquear=n&idusuario=${u.idUsuario}&mensaje=usuario ${u.userName} desbloqueado'" type="radio" value="desbloqueado"/></td>
                </c:if>


    </tr>
</tbody>
</c:forEach>
</table>

</body>
</html>
