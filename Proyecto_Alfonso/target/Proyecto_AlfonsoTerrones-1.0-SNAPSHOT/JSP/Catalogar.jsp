


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

    <c:forEach items="${productos}"  var="p">
        <tbody>
            <tr>
                <td><label><c:out value="${p.denominacion}"/> :</label></td>

                <c:if test="${p.fueraCatalogo=='n'}">

                    <td><a href="${pageContext.request.contextPath}/ControllersAdministrador2?descatalogarProducto=descatalogarProducto&idProducto=${p.idProducto}&fueraCatalogo=s"><button type="button" class="btn btn-primary">Descatalogar</button></a>  </td>
                </c:if>
                <c:if test="${p.fueraCatalogo=='s'}">

                    <td><a href="${pageContext.request.contextPath}/ControllersAdministrador2?descatalogarProducto=descatalogarProducto&idProducto=${p.idProducto}&fueraCatalogo=n"><button type="button" class="btn btn-primary">Catalogar</button></a>  </td>

                </c:if>


            </tr>
        </tbody>
    </c:forEach>
</table>

</body>
</html>
