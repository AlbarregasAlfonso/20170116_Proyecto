<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../INI/Cabecera.jsp"/>
<jsp:include page="../INI/RegistroCompra.jsp"/>

<!--<div class="col-sm-1">

    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <div class="content">

        <div class="alert alert-success" class="content">
            <strong>Success!</strong>< c:out value="$ {mensaje}"/>
        </div>

    </div>

</div>-->



<div class="col-sm-8">
    <div class="container">
        <h2><c:out value="Carrito"/></h2>
        <p>Desglose de su producto</p>
        <table class="table">
            <thead>
                <tr>
                    <th>Imagen</th>
                    <th>Caracteristica</th>
                    <th>precio unitario</th>
                    <th>incremento del IVA</th>
                    <th>Precio con iva</th>
                    <th>Cantidad</th>
                    <th></th>
                </tr>
            </thead>
            <c:set var="totalPrecio" value="0"/>
            <!--        < c:set var="contador" value="0"/>
            -->
            <c:forEach items="${productosCarritoDeglose}" var="lp">
                <tbody>
                    <tr>
                        <td><img src="${pageContext.request.contextPath}/IMG/${lp.producto.idProducto}.1.jpg" alt="Lights" style="width:10%"></td>
                        <td><c:out value="${lp.producto.denominacion}"/></td>
                        <td><c:out value="${lp.producto.precioUnitario}"/></td>
                        <td><c:out value="${lp.producto.precioConIva-lp.producto.precioUnitario}"/></td>
                        <td><c:out value="${lp.producto.precioConIva}"/></td>
                        <td><c:out value="${lp.cantidad}"/></td>
                        <c:set var="totalPrecio" value="${totalPrecio+(lp.producto.precioConIva*lp.cantidad)}"/>
                    </tr>                    
                </c:forEach>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>Gastos de envio</td>

                    <td>5</td>   
                </tr>    
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <th>Total</th>

                    <th><c:out value="${totalPrecio+5}"/></th>   
                </tr>
            </tbody>
        </table>



        


    </div>
</div>
 <div class="col-sm-1">

    <div class="container">
        <button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo">¿Direccion de envio?</button>
        <div id="demo" class="collapse">

            <div class="container">
                <div class="panel-group" id="accordion">

                    <c:forEach items="${direcciones}" var="di">

                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h1 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#<c:out value="${di.idDireccion}"/>"><c:out value="${di.nombreDireccion}"/></a>
                                </h1>
                            </div>
                            <div id="<c:out value="${di.idDireccion}"/>" class="panel-collapse collapse">
                                <div class="panel-body"> <c:out value="${di.nombreDireccion}"/>
                                    <c:out value="${di.nombre}"/>
                                    <c:out value="${di.pueblo.nombre}"/>
                                    <c:out value="${di.provincia.nombre}"/>
                                    <c:out value="${di.pueblo.codigoPostal}"/>
                                    <c:out value="${di.telefono}"/></div>
                                <input type="radio" name="direccionDeEnvio" value="${di.idDireccion}"/> Enviar a esta dirección
                            </div>
                        </div>

                    </c:forEach>

                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">Otra dirección</a>
                            </h4>
                        </div>
                        <div id="collapse2" class="panel-collapse collapse">
                            <div class="panel-body">

                                <form action="ControllersPagar" class="form-horizontal" role="form">
                                    <div class="form-group">
                                        <label for="ejemplo_email_3" class="col-lg-2 control-label">Nombre de la Direccion</label>
                                        <div class="col-lg-10">
                                            <input type="text" name="nombreDireccion" class="form-control" id="ejemplo_email_3"
                                                   placeholder="Casa..Trabajo..">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="ejemplo_email_3" class="col-lg-2 control-label">Dirección</label>
                                        <div class="col-lg-10">
                                            <input type="text" name="direccion" class="form-control" id="ejemplo_email_3"
                                                   placeholder="Direccion">
                                        </div>
                                    </div><div class="form-group">
                                        <label for="ejemplo_email_3" class="col-lg-2 control-label">Codigo Postal</label>
                                        <div class="col-lg-10">
                                            <input type="text" name="codigoPostal" class="form-control" id="ejemplo_email_3"
                                                   placeholder="XXXXXX">
                                        </div>
                                    </div><div class="form-group">
                                        <label for="ejemplo_email_3" class="col-lg-2 control-label">Telefono</label>
                                        <div class="col-lg-10">
                                            <input type="text" name="telefono" class="form-control" id="ejemplo_email_3"
                                                   placeholder="XXX XX XX XX">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-lg-offset-2 col-lg-10">
                                            <button type="submit" name="EnviarDesdePago" class="btn btn-default">Enviar</button>
                                        </div>
                                    </div>
                                </form>


                            </div>
                        </div>
                    </div>





                </div> 
            </div>
        </div>
    </div>
     
     <a href="${pageContext.request.contextPath}/ControllersPagar?idPedido=${idPedido}"><button type="button" class="btn btn-success">Finalizar Comprar</button></a>


</div>
</body>
</html>