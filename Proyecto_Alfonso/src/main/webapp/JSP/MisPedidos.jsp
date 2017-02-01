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
                        <td><c:out value="${p.estado}"/></td>
                        <td><c:out value="${p.direccion.nombre}"/></td>
                        <td><c:out value="${p.direccion.nombreDireccion}"/></td>
                        <td><c:out value="${p.direccion.telefono}"/></td>
                        <td><c:out value="${p.direccion.codigoPostal}"/></td>                        
                    </tr>      

                </tbody>
            </c:forEach>
        </table>








    </body>
</html>
