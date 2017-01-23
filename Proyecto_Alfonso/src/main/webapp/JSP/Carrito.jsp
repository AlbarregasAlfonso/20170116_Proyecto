<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../INI/Cabecera.jsp"/>
<jsp:include page="../INI/RegistroCompra.jsp"/>

<div class="container">
    <h2><c:out value="Carrito"/></h2>
    <p>Caracteristicas del producto</p>
    <table class="table">
        <thead>
            <tr>
                <th>Descripcion</th>
                <th>Caracteristica</th>
                <th>precio</th>
                <th></th>
                <th>Cantidad</th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <c:set var="totalPrecio" value="0"/>
        <c:forEach items="${productosCarrito}" var="lp">
            <tbody>
                <tr>

                    <td><img src="${pageContext.request.contextPath}/IMG/${lp.producto.idProducto}.1.jpg" alt="Lights" style="width:20%"></td>
                    <td><c:out value="${lp.producto.denominacion}"/></td>
                    <td><c:out value="${lp.producto.precioUnitario}"/></td>
                    <td><a href="${pageContext.request.contextPath}/ControllersCarrito?signo=menos&idProducto=${lp.producto.idProducto}" style="font-size:24px" class="fa" >&#xf104;</a></td>
                    <td><c:out value="${lp.cantidad}"/></td>
                    <td><a href="${pageContext.request.contextPath}/ControllersCarrito?signo=mas&idProducto=${lp.producto.idProducto}" style="font-size:24px" class="fa" >&#xf105;</a></td>
                    <td><a href="${pageContext.request.contextPath}/ControllersCarrito?idpedido=${lp.idPedido}&idProducto=${lp.producto.idProducto}&borramos=borramos" style="font-size:24px" class="fa" >&#xf00d;</a></td>
                    <c:set var="totalPrecio" value="${totalPrecio+(lp.producto.precioUnitario*lp.cantidad)}"/>
                    <c:set var="idPedido" value="${lp.idPedido}"/>"
                </tr>                    

            </c:forEach>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td><c:out value="aqui esta el valor del pedido ${idPedido}"/></td>
                
                <c:if test="${sessionScope.apellido!=null}">
                    
                    <td><a href="" data-toggle="modal" data-target="#RegistroCompra"><button type="button" class="btn btn-info">Comprar</button></a></td>
                
                </c:if>
                    
                <c:if test="${sessionScope.apellido==null}">
                    
                    <td><a href="${pageContext.request.contextPath}/ControllersPagar?idPedido=${idPedido}"><button type="button" class="btn btn-success">Comprar</button></a></td>
                
                </c:if>
                    
                <td>Total</td>
                
                <td><c:out value="${totalPrecio}"/></td>   
            </tr>


        </tbody>
    </table>

</div>

<jsp:include page="../INI/Pie.jsp"/>