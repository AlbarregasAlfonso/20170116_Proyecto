<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../INI/Cabecera.jsp"/>

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
      </tr>      
        
    </tbody>
    </c:forEach>
  </table>
</div>



<jsp:include page="../INI/Pie.jsp"/>