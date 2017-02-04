<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<jsp:include page="../INI/Cabecera.jsp"/>
<jsp:include page="../INI/RegistroCompra.jsp"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script>
    function cambiarCantidad(id, signo) {
//alert($('#cantidad' + id).val());
//alert($('#stock' + id).val());

    if($('#cantidad' + id).val() != $('#stock' + id).val()){

        $.ajax({
            url: "ControllersCarrito",
            method: "GET",
            data: {
                idProducto: $('#prod' + id).val(),
                signo: signo,
            },
            success: function (results) {

                if (results != null) { //esto es lo que recibo del controlador, si ha ido bien o mal

                    if ($('#cantidad' + id).val() < parseInt($('#stock' + id).val())) {
                        $('#cantidad' + id).val(parseInt($('#cantidad' + id).val()) + parseInt(1));
                        $('#total').val(parseInt($('#total').val()) + parseInt($('#precio' + id).val()));
                    }




                } else {
                    alert('Algo fallo');
                }
            }
        })};
    }
    ;
    function cambiarCantidadMenos(id, signo) {
        $.ajax({
            
            data: {
                idProducto: $('#prod' + id).val(),
                signo: signo,
            },
            url: "ControllersCarrito",
            method: "GET",
            success: function (results) {

                if (results != null) { //esto es lo que recibo del controlador, si ha ido bien o mal

                    if ($('#cantidad' + id).val() > 1) {
                        $('#cantidad' + id).val(parseInt($('#cantidad' + id).val()) - parseInt(1));
                        $('#total').val(parseInt($('#total').val()) - parseInt($('#precio' + id).val()));

                    }

                } else {
                    alert('Algo fallo');
                }
            }
        });
    }
    ;</script>

<div class="container">
    <h2><c:out value="Carrito"/></h2>
    <p>Caracteristicas del producto</p>
    <table class="table">
        <thead>
            <tr>
                <th>Imagen</th>
                <th>Caracteristica</th>
                <th>precio</th>
                <th></th>
                <th>Cantidad</th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <c:set var="totalPrecio" value="0"/>
        <c:set var="contador" value="0"/>

        <c:forEach items="${productosCarrito}" var="lp">
            <tbody>


                <tr>

                    <td><img src="${pageContext.request.contextPath}/IMG/${lp.producto.idProducto}.1.jpg" alt="Lights" style="width:20%"></td>
                    <td><c:out value="${lp.producto.denominacion}"/></td>
                    <td><c:out value="${lp.producto.precioUnitario}"/></td>
                    <td> 
                        <input type="button" style="background-color: white; border:none" onclick="cambiarCantidadMenos(${contador}, 'menos');" value="-"/>
                    </td>
                    <td>
                        <input style="background-color: white; border:none" type="text" id="cantidad${contador}" value="${lp.cantidad}"/>

                    </td>
                    <td>
                        <c:if test="${lp.cantidad!=lp.producto.stock}">
                            <input type="button" style="background-color: white; border:none" onclick="cambiarCantidad(${contador}, 'mas');" value="+"/>  

                            <input type="hidden" value="${lp.producto.stock}" id="stock${contador}"/>
                        </c:if>                       
                    </td>
                    <td><a href="${pageContext.request.contextPath}/ControllersCarrito?idpedido=${lp.idPedido}&idProducto=${lp.producto.idProducto}&borramos=borramos" style="font-size:24px" class="fa" >&#xf00d;</a></td>
                    <c:set var="totalPrecio" value="${totalPrecio+(lp.producto.precioUnitario*lp.cantidad)}"/>
                    <c:set var="idPedido" value="${lp.idPedido}"/>
                </tr>                    

            <input style="background-color: white; border:none" type="hidden" id="precio${contador}" value="${lp.producto.precioUnitario}"/>

            <input style="background-color: white; border:none" type="hidden" id="prod${contador}" value="${lp.producto.idProducto}"/>

            <input style="background-color: white; border:none" type="hidden" id="totalCantidad" value="${totalPrecio}"/>

            <c:set value="${contador+1}" var="contador"/>

        </c:forEach>

        <tr>
            <td></td>
            <td></td>
            <td></td>


            <c:if test="${sessionScope.apellido==false}">
                
                

                <td><a href="" data-toggle="modal" data-target="#RegistroCompra"><button type="button" class="btn btn-info">Comprar</button></a></td>

            </c:if>

            <c:if test="${sessionScope.apellido==true}">

                <td><a href="${pageContext.request.contextPath}/ControllersPagar?idPedido=${idPedido}"><button type="button" class="btn btn-success">Comprar</button></a></td>

            </c:if>

            <td>Total</td>


            <td>    <input style="background-color: white; border:none" type="text" id="total" value="${totalPrecio}"/></td>   
        </tr>


        </tbody>
    </table>

</div>

<jsp:include page="../INI/Pie.jsp"/>