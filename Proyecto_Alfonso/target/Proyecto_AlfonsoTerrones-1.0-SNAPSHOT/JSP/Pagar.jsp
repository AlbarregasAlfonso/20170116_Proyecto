<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="../INI/Cabecera.jsp"/>
<jsp:include page="../INI/RegistroCompra.jsp"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>



<script>
    $(document).ready(function () {
        $('[data-toggle="tooltip"]').tooltip();
    });
</script>

<script>window.onload = initAll;
    var xhr = false;
    var statesArray = new Array();
    function initAll() {
        document.getElementById("searchField1").onkeyup = searchSuggest;
        if (window.XMLHttpRequest) {
            xhr = new XMLHttpRequest();
        } else {
            if (window.ActiveXObject) {
                try {
                    xhr = new ActiveXObject("Microsoft.XMLHTTP");
                } catch (e) {
                }
            }
        }
        if (xhr) {
            xhr.onreadystatechange = setStatesArray;
            xhr.open("GET", "Codigos.xml", true);
            xhr.send(null);
        } else {
            alert("Sorry, but I couldn't create an XMLHttpRequest");
        }
    }
    function setStatesArray() {
        if (xhr.readyState == 4) {
            if (xhr.status == 200) {
                if (xhr.responseXML) {
                    var allStates = xhr.responseXML.getElementsByTagName("item");
                    for (var i = 0; i < allStates.length; i++) {
                        statesArray[i] = allStates[i].getElementsByTagName("label")[0].firstChild;
                    }
                }
            } else {
                alert("There was a problem with the request " + xhr.status);
            }
        }
    }
    function searchSuggest() {
        var str = document.getElementById("searchField1").value;
        document.getElementById("searchField1").className = "";
        if (str != "") {
            document.getElementById("popups").innerHTML = "";
            for (var i = 0; i < statesArray.length; i++) {
                var thisState = statesArray[i].nodeValue;
                if (thisState.toLowerCase().indexOf(str.toLowerCase()) == 0) {
                    var tempDiv = document.createElement("div");
                    tempDiv.innerHTML = thisState;
                    tempDiv.onclick = makeChoice;
                    tempDiv.className = "suggestions";
                    document.getElementById("popups").appendChild(tempDiv);
                }
            }
            var foundCt = document.getElementById("popups").childNodes.length;
            if (foundCt == 0) {
                document.getElementById("searchField1").className = "error";
            }
            if (foundCt == 1) {
                document.getElementById("searchField1").value = document.getElementById("popups").firstChild.innerHTML;
                document.getElementById("popups").innerHTML = "";
            }
        }
    }
    function makeChoice(evt) {
        var thisDiv = (evt) ? evt.target : window.event.srcElement;
        document.getElementById("searchField1").value = thisDiv.innerHTML;
        document.getElementById("popups").innerHTML = "";
    }
//            function mas(){
////                alert('Hola');
////                alert(document.getElementById("popups").innerHTML);
//                //alert(document.formulario.nombre.value());
//            }
</script>

<div class="row">
    <div class="col-sm-1" >

    </div>
    <div class="col-sm-3" >


        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
         <br/>
        <br/>
 
        <ul class="nav nav-tabs">
            <li class="active"><a data-toggle="tab" href="#nuevadireccion">Añadir dirección</a></li>
            <li><a data-toggle="tab" href="#finalizarCompra">Finalizar Compra</a></li>

        </ul>

        <div class="tab-content">
            <div id="nuevadireccion" class="tab-pane fade in active">
                <h2>Nueva dirección</h2>
                <form action="ControllersPagar" class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="ejemplo_email_3" class="col-lg-2 control-label">Nombre de la Direccion</label>
                        <div class="col-lg-5">
                            <input type="text" name="nombreDireccion" class="form-control" id="ejemplo_email_3"
                                   placeholder="Casa..Trabajo.." required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="ejemplo_email_3" class="col-lg-2 control-label">Dirección</label>
                        <div class="col-lg-5">
                            <input type="text" name="direccion" class="form-control" id="ejemplo_email_3"
                                   placeholder="Direccion" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="ejemplo_email_3" class="col-lg-2 control-label">Codigo Postal</label>
                        <div class="col-lg-5">
                            <input type="text"   name="codigoPostal" id="searchField1" autocomplete="off" class="form-control" id="ejemplo_email_3"
                                   placeholder="XXXXXX" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="ejemplo_email_3" class="col-lg-2 control-label">Telefono</label>
                        <div class="col-lg-5">
                            <input type="text" name="telefono" class="form-control" id="ejemplo_email_3"
                                   placeholder="XXX XX XX XX" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-offset-2 col-lg-10">
                            <button type="submit" name="EnviarDesdePago" class="btn btn-default">Enviar</button>
                        </div>
                    </div>

                </form>
            </div>
            <div id="finalizarCompra" class="tab-pane fade">
                <h2>Cuenta corriente</h2>
                <form action="ControllersPagar" class="form-horizontal" role="form">
                    <div class="form-group">

                        <div class="form-group">
                            <label for="ejemplo_email_3" class="col-lg-2 control-label">Número de tarjeta</label>
                            <div class="col-lg-4">
                                <input type="text" name="nombreDireccion" required class="form-control" id="ejemplo_email_3"
                                       placeholder="XXXX XXXX XXXX XXXX">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="ejemplo_email_3" class="col-lg-2 control-label">Fecha de caducidad</label>
                            <div class="col-lg-2">
                                <input type="text" name="nombreDireccion" required class="form-control" id="ejemplo_email_3"
                                       placeholder="MM/AA">
                            </div>
                        </div>

                        <button type="submit" name="Enviar2" value="Enviar2" class="btn btn-default">Finalizar</button>
                    </div>
                    <h2>Direcciones de envio</h2>
                    <c:forEach items="${direcciones}" var="di">

                        <li><input type="radio" name="direccionDeEnvio" value="${di.idDireccion}"/>
                            <a href="#" data-toggle="tooltip" data-placement="<c:out value="${di.nombreDireccion}"/>" title="<c:out value="${di.nombreDireccion}"/>
                               <c:out value="${di.nombre}"/>
                               <c:out value="${di.pueblo.nombre}"/>
                               <c:out value="${di.provincia.nombre}"/>
                               <c:out value="${di.pueblo.codigoPostal}"/>
                               <c:out value="${di.telefono}"/>"><c:out value="${di.nombreDireccion}"/></a></li>
                        <br/>
                    </c:forEach>
                </form>
            </div>
        </div>

        <br/>
        <br/>
        <c:if test="${mensaje!=null}">
            <div class="content">
                <h5><div class="alert alert-danger">
                        <strong>Cuidado!</strong> <c:out value="${mensaje}"/>.
                    </div>
                </h5>
            </div>
        </c:if>
    </div>

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
                            <!--<td>< c:out value="$ {lp.producto.precioConIva-lp.producto.precioUnitario}"/></td>-->
                            <td><fmt:formatNumber value="${lp.producto.precioConIva-lp.producto.precioUnitario}" maxFractionDigits="2"/></td>
                            <td><fmt:formatNumber value="${lp.producto.precioConIva}" maxFractionDigits="2"/></td>
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


                        <th><fmt:formatNumber value="${totalPrecio+5}" maxFractionDigits="2"/></th>

                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>


</body>
</html>