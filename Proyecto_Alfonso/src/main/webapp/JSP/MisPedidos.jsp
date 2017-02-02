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
        <table class="table">
            <thead>
                <tr>
                    <th>Fecha</th>
                    <th>Estado</th>
                    <th>Nombre</th>
                    <th>Direccion</th>
                    <th>Telefono</th>
                    <th>CodigoPostal</th>

                </tr>
            </thead>
            <c:forEach items="${pedidosCliente}" var="p">
                <tbody>
                    <tr>
                        <td><c:out value="${p.fecha}"/></td>
                        <c:if test="${p.estado=='r'}">
                            <td>Enviado</td>
                        </c:if>
                        <c:if test="${p.estado=='s'}">
                            <td>A la espera de Stock</td>
                        </c:if>
                        <c:if test="${p.estado=='p'}">
                            <td>En produccion</td>
                        </c:if>
                        
                        <td><c:out value="${p.direccion.nombre}"/></td>
                        <td><c:out value="${p.direccion.nombreDireccion}"/></td>
                        <td><c:out value="${p.direccion.telefono}"/></td>
                        <td><c:out value="${p.direccion.codigoPostal}"/></td>                        
                    </tr>      

                </tbody>
            </c:forEach>
        </table>

    </div>

</div>








</body>
</html>
