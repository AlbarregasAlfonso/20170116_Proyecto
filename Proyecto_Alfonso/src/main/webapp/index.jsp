


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="INI/Cabecera.jsp"/>
<jsp:include page="INI/Trabaja.jsp"/>


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
     
    <a title="Los Tejos" href="https://twitter.com/?lang=es"><img src="IMG/twitter.png" width="100" height="100" / alt="Los Tejos" /></a>
    <a title="Los Tejos" href="https://es-es.facebook.com/"><img src="IMG/Facebook.png" width="100" height="100" / alt="Los Tejos" /></a>
    <a title="Los Tejos" href="https://www.youtube.com/"><img src="IMG/youtube.png" width="100" height="100" / alt="Los Tejos" /></a>
    <a title="Los Tejos" href="http://www.ebay.com/"><img src="IMG/ebay.png" width="100" height="100" / alt="Los Tejos" /></a>
    <a title="Los Tejos" href="https://www.amazon.es/?tag=hydesnav-21&hvadid=24483849088&hvpos=1t1&hvnetw=g&hvrand=15709444381865574062&hvpone=&hvptwo=&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=1005475&hvtargid=kwd-10573980&ref=pd_sl_781oit2196_e"><img src="IMG/amazon.ico" width="100" height="100" / alt="Los Tejos" /></a>
    <a title="Los Tejos" href="https://www.instagram.com/?hl=es"><img src="IMG/Uiconstock-Socialmedia-Instagram.ico" width="100" height="100" / alt="Los Tejos" /></a>  
    <a title="Los Tejos" href="https://www.google.com/intl/es/gmail/about/"><img src="IMG/Cornmanthe3rd-Plex-Communication-gmail.ico" width="100" height="100" / alt="Los Tejos" /></a>  
    <a title="Los Tejos" href="https://www.google.es/?gws_rd=ssl"><img src="IMG/Google-Chrome-Google-Chrome.ico" width="100" height="100" / alt="Los Tejos" /></a>  
    
    
    <jsp:include page="INI/Pie.jsp"/>

</c:if>



<c:if  test="${usuario.tipo=='a'}">
</body>
</html>
</c:if>



