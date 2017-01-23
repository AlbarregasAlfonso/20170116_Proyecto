    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../INI/Cabecera.jsp"/>




        <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>

            <!-- Wrapper for slides -->
            <div class="carousel-inner" role="listbox">


                <div class="item active">
                    <img src="IMG/${imagen}.1.jpg" alt="" width="1000" height="600">
                    <div class="carousel-caption">
                        <h3><c:out value="${NombreProducto}"/></h3>
                    </div>      
                </div>

                <c:forEach begin="1" items="${imagenes}" var="imagenes">

                    <img src="${imagenes.image}" alt="" style="width:100%">
                    <div class="item">
                        <img src="IMG/${imagenes.image}" alt="Chicago" width="1000" height="600">
                        <div class="carousel-caption">
                            <h3><c:out value="${NombreProducto}"/></h3>
                        </div>      
                    </div>
                </c:forEach>
            </div>
</div>  <!-- Tipo de letra -->


            <!-- Left and right controls -->
            <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>


<div class="container">
  <h2><c:out value="${NombreProducto}"/></h2>
  <p>Caracteristicas del producto</p>
  <table class="table">
    <thead>
      <tr>
        <th>Descripcion</th>
        <th>Caracteristica</th>
      </tr>
    </thead>
    <c:forEach begin="1" items="${ProductoCaracteristicas}" var="productos">
    <tbody>
      <tr>
        <td><c:out value="${productos.nombreCaracteristica}"/></td>
        <td><c:out value="${productos.descripcion}"/></td>
      </tr>      
        
    </tbody>
    </c:forEach>
  </table>
</div>
  
<div class="container">
  <button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo">Más informacion</button>
  <div id="demo" class="collapse">
    <c:out value="${DescripcionProducto}"/>
  </div>
  
    
  
  <c:if test="${sessionScope.usuario==null}">
        
        <a href="" data-toggle="modal" data-target="#inicioSesion"><button type="button" class="btn btn-info">Añadir al carrito</button></a>

    </c:if>
    <c:if test="${sessionScope.usuario!=null}">
        
        
        <button type="button" class="btn btn-info" data-toggle="collapse" data-target="#comprar">Añadir al carrito</button>
        <div id="comprar" class="collapse">
            <div class="dropdown">
                <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">¿Cuantos quieres?
                    <span class="caret"></span></button>
                <ul class="dropdown-menu">
                    <c:forEach items="${Stock}" var="s">
                        <li><a href="${pageContext.request.contextPath}/ControllersCarrito?cantidad=${s}&idProducto=${idProducto}&idusuario=${usuario.idUsuario}&productoCaracteristicas=productoCaracteristicas"><c:out  value="${s}"/></a></li>
                    </c:forEach>

                </ul>
            </div>
        </div>
    </c:if>
 
  
</div>
              

        

    </body>
</html>