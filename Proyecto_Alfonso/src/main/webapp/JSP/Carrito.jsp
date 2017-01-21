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
        <th>Caracterist</th>
      </tr>
    </thead>
    <c:forEach begin="1" items="${productosCarrito}" var="lp">
    <tbody>
      <tr>
          
          <td><img src="${pageContext.request.contextPath}/IMG/${lp.producto.idProducto}.1.jpg" alt="Lights" style="width:20%"></td>
        <td><c:out value="${lp.producto.denominacion}"/></td>
        <td><c:out value="${lp.producto.precioUnitario}"/></td>
        <td><c:out value="${lp.cantidad}"/></td>
      </tr>      
        
    </tbody>
    </c:forEach>
  </table>
</div>



<jsp:include page="../INI/Pie.jsp"/>