


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="INI/Cabecera.jsp"/>


<!--
<div class="content">
    <div class="container">
        <div class="alert alert-success" class="content">
            <strong>Success!</strong> This alert box could indicate a successful or positive action.
        </div>
    </div>
</div>-->

<c:if  test="${usuario.tipo!='a'}">


    <br>
    <br>
    <br>
    <br>
    <br>


        <h2>Productos en oferta</h2>
        <p>¡Aquí tenemos los precios mas baratos del mercado!</p>
        <p>Compra todo lo que necesites</p>

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
                <a href="${pageContext.request.contextPath}/Controllers?imagen=${primeraOferta}">
                    <img src="IMG/${primeraOferta}.1.jpg" alt="" width="1000" height="600">
                    <div class="carousel-caption">
                        <h3><c:out value="${denominacionOferta}"/></h3>
                        <h3><c:out value="${precioOferta}"/></h3>
                    </div> 
                </a>
            </div>

            <c:forEach begin="1"  items="${productosEnOferta}" var="pc">
                <div class="item">
                    <a href="${pageContext.request.contextPath}/Controllers?imagen=${pc.idProducto}">

                        <img src="${pageContext.request.contextPath}/IMG/${pc.idProducto}.1.jpg" alt="Chania" width="1000" height="600">
                        <div class="carousel-caption">
                            <h3><c:out value="${pc.denominacion}"/></h3>
                            <h3><c:out value="${pc.precioUnitario} €"/></h3>
                        </div>
                    </a>
                </div>
            </c:forEach>
        </div>


        <!-- Left and right controls -->
        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Anterior</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Siguiente</span>
        </a>
    </div>

    <jsp:include page="INI/Pie.jsp"/>

</c:if>



<c:if  test="${usuario.tipo=='a'}">
</body>
</html>
</c:if>



