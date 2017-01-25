<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../INI/Cabecera.jsp"/>
<jsp:include page="../INI/RegistroCompra.jsp"/>

<div class="col-sm-6" >
    <div class="container">
        <h2><c:out value="Carrito"/></h2>
        <p>Desglose de su producto</p>
        <table class="table">
            <thead>
                <tr>
                    <th>Imagen</th>
                    <th>Caracteristica</th>
                    <th>precio</th>
                    <th>precio con iva</th>
                    <th>Cantidad</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <c:set var="totalPrecio" value="0"/>
            <!--        < c:set var="contador" value="0"/>
            -->
            <c:forEach items="${productosCarritoDeglose}" var="lp">
                <tbody>
                    <tr>
                        <td><img src="${pageContext.request.contextPath}/IMG/${lp.producto.idProducto}.1.jpg" alt="Lights" style="width:10%"></td>
                        <td><c:out value="${lp.producto.denominacion}"/></td>
                        <td><c:out value="${lp.producto.precioUnitario}"/></td>
                        <td><c:out value="${lp.producto.precioConIva}"/></td>
                        <td><c:out value="${lp.cantidad}"/></td>
                    </tr>                    
                </c:forEach>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>Total</td>

                    <td><c:out value="${totalPrecio}"/></td>   
                </tr>


            </tbody>
        </table>

    </div>
</div>
</body>
</html>