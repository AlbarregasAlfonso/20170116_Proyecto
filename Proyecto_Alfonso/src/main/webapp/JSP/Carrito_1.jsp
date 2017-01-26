<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../INI/Cabecera.jsp"/>
<jsp:include page="../INI/RegistroCompra.jsp"/>

<script>
    
    
    function cambiarCantidad(id,signo){

    $.ajax({

        url: "ControllersCarrito",
        method: "GET",
        data: {

            idProducto: $('#prod'+id).val(),
            signo: signo,
        },
        success: function (results) {

            if (results != null) { //esto es lo que recibo del controlador, si ha ido bien o mal
               $('#cantidad'+id).val(parseInt($('#cantidad'+id).val())+parseInt(1));
            } else {
                alert('Algo fallo');
            }
        }
    });
};


};


</script>

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
                        <c:if test="${contador!=1}">
                            <a href="${pageContext.request.contextPath}/ControllersCarrito?signo=menos&idProducto=${lp.producto.idProducto}&cantidad=${lp.cantidad}" style="font-size:24px" class="fa" >&#xf104;</a>
                        </c:if>  
                    </td>
                    <td>
                        <input style="background-color: white;border: none" type="button" id="cantidad${contador}" value="${lp.cantidad}"/>
                    </td>
            <!---->
<!--                    <td>< c:out value="$ {lp.cantidad}"/></td>-->
<!--                    <input id="articuloCantidad$ {contador}" type="text" value="$ {lp.cantidad}"/>-->
                    <td>
                        <c:if test="${lp.cantidad!=lp.producto.stock}">
<!--                        <a href="$ {pageContext.request.contextPath}/ControllersCarrito?signo=mas&idProducto=$ {lp.producto.idProducto}&cantidad=$ {lp.cantidad}" style="font-size:24px" class="fa" >&#xf105;</a>-->
                            <input type="button"  onclick="cambiarCantidad(${contador},'mas');" value="mas"/>  
                            <input type="button"  onclick="cambiarCantidadAMenos(${contador},'mas');" value="menos"/>    
                            <a href="#" onclick="cambiarCantidad(${contador},'mas');" style="font-size:24px" class="fa">&#xf105;</a>
                            <input id="prod${contador}" type="hidden" value="${lp.producto.idProducto}"/>
                        </c:if>                       
                    </td>
                    <td><a href="${pageContext.request.contextPath}/ControllersCarrito?idpedido=${lp.idPedido}&idProducto=${lp.producto.idProducto}&borramos=borramos" style="font-size:24px" class="fa" >&#xf00d;</a></td>
                    <c:set var="totalPrecio" value="${totalPrecio+(lp.producto.precioUnitario*lp.cantidad)}"/>
                    <c:set var="idPedido" value="${lp.idPedido}"/>
                </tr>                    
<!--                <input type="text" id="prueba"/>-->
                
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

                <td><c:out value="${totalPrecio}"/></td>   
            </tr>


        </tbody>
    </table>

</div>

<jsp:include page="../INI/Pie.jsp"/>