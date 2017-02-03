
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../INI/Cabecera.jsp"/>


        <div class="container">
           
            <h2>Productos <c:out value="${topventas}"/></h2>
            <p>¡Aqui tienes todo lo que necesitas!</p>
            <p>Compra todo lo que necesites</p>
            <div class="row">


                <c:forEach  items="${productosFraccionado}" var="pc">
                    <div class="col-md-3">
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

        <!--paginacion-->
        <div class="container">


            <ul class="pager">
                <li class="previous"><a href="Controllers?valor=<c:out value="${valor-18}"/>">Previous</a></li>
                <li class="next"><a href="Controllers?valor=<c:out value="${valor}"/>">Next</a></li>
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