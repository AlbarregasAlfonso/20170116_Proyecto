
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../INI/Cabecera.jsp"/>




<div class="row">
    <div class="col-sm-2" >
        <br/> <br/> <br/> <br/> <br/> <br/>



        <form method="POST" action="ControllersBusquedaAvan">
            <h3><c:out value="${categoria}"/></h3>
            <c:if test="${categoria==1 || categoria==9}">
                
                 <h3>Tipo</h3>
            <select name="tipo" class="form-control">
                <option name="tipo" value="i3">i3</option>
                <option name="tipo" value="i5">i5</option>
                <option name="tipo" value="i7">i7</option>
            </select>
                
            </c:if>

            <h3>Precio</h3>
            <select name="desde" class="form-control">
                <option name="desde" value="0">Desde</option>
                <option name="desde" value="0">0</option>
                <option name="desde" value="41.3">50</option>
                <option name="desde" value="82.6">100</option>
                <option name="desde" value="165.2">200</option>
                <option name="desde" value="248">300</option>
                <option name="desde" value="413.22">500</option>
                <option name="desde" value="578.5">700</option>
                <option name="desde" value="826.4">1000</option>
                  <option name="desde" value="1074.38">1300</option>
                  <option name="desde" value="1322.3">1600</option>
            </select>
            <select name="hasta" class="form-control">
                <option name="hasta" value="1400">Hasta</option>
                <option name="hasta" value="0">0</option>
                <option name="hasta" value="41.3">50</option>
                <option name="hasta" value="82.6">100</option>
                <option name="hasta" value="165.2">200</option>
                <option name="hasta" value="248">300</option>
                <option name="hasta" value="413.22">500</option>
                <option name="hasta" value="578.5">700</option>
                <option name="hasta" value="826.4">1000</option>
                <option name="hasta" value="1074.38">1300</option>
                <option name="hasta" value="1322.3">1600</option>
            </select>

            <input type="hidden" name="categoria" value="${categoria}" />
            <input type="hidden" name="valor" value="0"/>

            <div class="form-group">
                <div class="col-lg-offset-1 col-lg-1">
                    <button type="submit" name="Buscar" class="btn btn-default" style="float:left">Buscar</button>
                </div>
            </div>


        </form>





    </div>
    <div class="col-sm-10" >



        <div class="container">
            <h2>Productos</h2>
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
                <li class="previous"><a href="Controllers?valor=<c:out value="${valor-12}"/>">Previous</a></li>
                <li class="next"><a href="Controllers?valor=<c:out value="${valor}"/>">Next</a></li>
            </ul>




        </div>

        <!-- Footer -->
        <footer class="text-center">
            <a class="up-arrow" href="#myPage" data-toggle="tooltip" title="TO TOP">
                <span class="glyphicon glyphicon-chevron-up"></span>
            </a><br><br>
        </footer>

    </div>
</body>
</html>