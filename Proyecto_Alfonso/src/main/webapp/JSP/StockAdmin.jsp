<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../INI/Cabecera.jsp"/>
<jsp:include page="../INI/InicioSesion.jsp"/>
<br>
<br>
<br>
<br>


<div class="col-sm-6" >
    <div class="container">

        <p>Caracteristicas del producto</p>
        <table class="table">
            <thead>
                <tr>
                    <th>Descripción</th>
                    <th>Hacen falta</th>
                    <th>Aumentar Stock</th>
                </tr>
            </thead>
            <c:forEach items="${ProductosSinStock}" var="ps">
                <tbody>
                    <tr>
                        <td><c:out value="${ps.denominacion}"/></td>
                        <td><c:out value="${ps.cantidadQueFaltaEnStock}"/></td>
                        <td><a href="ControllersAdministrador?aumentarStock=Aumentar&productoDenominacion=${ps.denominacion}&HacenFalta=${ps.cantidadQueFaltaEnStock}" style="font-size:24px" class="fa">&#xf151;</a></td>
                    </tr>      

                </tbody>
            </c:forEach>
        </table>
         <c:if test="${mensaje1!=null}">
            <div class="alert alert-success" class="content">
                <h5> <c:out value="${mensaje1}"/> <strong></strong></h5>
            </div>
            </c:if>
    </div>
</div>


</body>
</html>
