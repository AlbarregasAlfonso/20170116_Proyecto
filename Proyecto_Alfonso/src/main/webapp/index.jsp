


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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


        <div class="container">


            <h2>Productos en oferta</h2>
            <p>¡Aquí tenemos los precios mas baratos del mercado!</p>
            <p>Compra todo lo que necesites</p>
        

                <div class="container">
                    <br>
                    <div id="myCarousel" class="carousel slide" data-ride="carousel">
                        <!-- Indicators -->
                        <ol class="carousel-indicators">
                            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                            <li data-target="#myCarousel" data-slide-to="1"></li>
                            <li data-target="#myCarousel" data-slide-to="2"></li>
                            <li data-target="#myCarousel" data-slide-to="3"></li>
                        </ol>

                        <!-- Wrapper for slides -->
                        <div class="carousel-inner" role="listbox">

                            <div class="item active">
                                <img src="IMG/${primeraOferta}.1.jpg" alt="" width="1000" height="600">
                                <div class="carousel-caption">
                                    <h3><c:out value="${denominacionOferta}"/></h3>
                                    <h3><c:out value="${precioOferta}"/></h3>
                                </div>      
                            </div>


                            <c:forEach begin="1"  items="${productosEnOferta}" var="pc">
                                <div class="item">
                                    <img src="${pageContext.request.contextPath}/IMG/${pc.idProducto}.1.jpg" alt="Chania" width="2000" height="600">
                                    <div class="carousel-caption">
                                        <h3><c:out value="${pc.denominacion}"/></h3>
                                        <h3><c:out value="${pc.precioUnitario} €"/></h3>
                                    </div>
                                </div>
                            </c:forEach>

                        </div>

                        <!-- Left and right controls -->
                        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
















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

    
  
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <div class="content">

            <c:if test="${mensaje!=null}">
                <div class="alert alert-success" class="content">
                    <h5> <c:out value="${mensaje}"/> <strong></strong></h5>
                </div>
            </c:if>
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

</c:if>



<c:if  test="${usuario.tipo=='a'}">
</body>
</html>
</c:if>



