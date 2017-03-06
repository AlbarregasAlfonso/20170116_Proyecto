
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:include page="../INI/Cabecera.jsp"/>

<br>
<br>
<br>
<br>
<br>
<br>

<h2>Productos <c:out value="${topventas}"/></h2>
<p>¡Aqui tienes todo lo que necesitas!</p>
<p>Compra todo lo que necesites</p>
<div class="row">


    <c:forEach  items="${productosFraccionado}" var="pc">
        <div class="col-md-2">
            <div class="thumbnail">
                <a href="${pageContext.request.contextPath}/Controllers?imagen=${pc.idProducto}">
                    <img class="thumbnail" src="${pageContext.request.contextPath}/IMG/${pc.idProducto}.1.jpg" alt="Lights" style="width:100%">
                    <div class="caption">
                        <h5><c:out value="${pc.denominacion}"/></h5>
                        <h3><fmt:formatNumber value="${pc.precioUnitario}" maxFractionDigits="2"/> €</h3>

                    </div>
                </a>
            </div>
        </div>
    </c:forEach>



</div>


<!--paginacion-->
<div class="container">


    <ul class="pager">
        <c:if test="${valor>10}">
            <li class="previous"><a href="Controllers?valor=<c:out value="${valor-18}"/>">Anterior</a></li>    
            </c:if>

        <li><a href="Controllers?valor=0">1</a></li>


        <c:forEach items="${paginacion}" var="paginacion" varStatus="status">          




            <c:if test="${status.last==false}">
                <li><a href="Controllers?valor=${paginacion}"><c:out value="${status.count+1}"/></a></li>

            </c:if>

            <c:if test="${status.last}">
                <c:set var="paginacionMax" value="${paginacion}"/>
            </c:if>




        </c:forEach>

        <c:if test="${valor<paginacionMax}">
            <li class="next"><a href="Controllers?valor=<c:out value="${valor}"/>">Siguiente</a></li>
            </c:if>
    </ul>
</div>

<!-- Footer -->
<footer class="text-center">
    <a class="up-arrow" href="#myPage" data-toggle="tooltip" title="TO TOP">
        <span class="glyphicon glyphicon-chevron-up"></span>
    </a><br><br>
</footer>


</body>
</html>