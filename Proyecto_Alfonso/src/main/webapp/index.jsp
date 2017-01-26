

 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="INI/Cabecera.jsp"/>
<jsp:include page="INI/InicioSesion.jsp"/>








<div class="container">
            <h2>Productos en oferta</h2>
            <p>¡Aquí tenemos los precios mas baratos del mercado!</p>
            <p>Compra todo lo que necesites</p>
            <div class="row">

<%@page contentType="text/html" pageEncoding="UTF-8"%>
                <c:forEach  items="${productosEnOferta}" var="pc">
                    <div class="col-md-6">
                        <div class="thumbnail">
                            <a href="${pageContext.request.contextPath}/Controllers?imagen=${pc.idProducto}">
                                <img class="thumbnail" src="${pageContext.request.contextPath}/IMG/${pc.idProducto}.1.jpg" alt="Lights" style="width:100%">
                                <div class="caption">
                                    <p><c:out value="${pc.denominacion}"/></p>
                                    <p><c:out value="${pc.precioUnitario} €"/></p>
                                </div>
                            </a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>




                
<div id="contact" class="container">
  <h3 class="text-center">Contacto</h3>
 

  <div class="row">
    <div class="col-md-4">
      
      <p><span class="glyphicon glyphicon-map-marker"></span>Badajoz, Es</p>
      <p><span class="glyphicon glyphicon-phone"></span>Telefono: +34 647749447</p>
      <p><span class="glyphicon glyphicon-envelope"></span>Email: alfonsotem@gmail.com</p>
    </div>
    <div class="col-md-8">
      <div class="row">
        <div class="col-sm-6 form-group">
          <input class="form-control" id="name" name="name" placeholder="Nombre" type="text" required>
        </div>
        <div class="col-sm-6 form-group">
          <input class="form-control" id="email" name="email" placeholder="Email" type="email" required>
        </div>
      </div>
      <textarea class="form-control" id="comments" name="comments" placeholder="Comentario" rows="5"></textarea>
      <br>
      <div class="row">
        <div class="col-md-12 form-group">
          <button class="btn pull-right" type="submit">Enviar</button>
        </div>
      </div>
    </div>
  </div>
  <br>
</div>


<c:out value="${usuario}"/>

<jsp:include page="INI/Pie.jsp"/>





