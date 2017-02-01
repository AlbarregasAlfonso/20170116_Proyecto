
<script>window.onload = initAll;
    var xhr = false;
    var statesArray = new Array();
    function initAll() {
        document.getElementById("searchField2").onkeyup = searchSuggest;
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
        var str = document.getElementById("searchField2").value;
        document.getElementById("searchField2").className = "";
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
                document.getElementById("searchField2").className = "error";
            }
            if (foundCt == 1) {
                document.getElementById("searchField2").value = document.getElementById("popups").firstChild.innerHTML;
                document.getElementById("popups").innerHTML = "";
            }
        }
    }
    function makeChoice(evt) {
        var thisDiv = (evt) ? evt.target : window.event.srcElement;
        document.getElementById("searchField2").value = thisDiv.innerHTML;
        document.getElementById("popups").innerHTML = "";
    }
//            function mas(){
////                alert('Hola');
////                alert(document.getElementById("popups").innerHTML);
//                //alert(document.formulario.nombre.value());
//            }
</script>

<div class="modal fade" id="RegistroCompra" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Para finalizar su compra debes de terminar su registro</h4>
            </div>
            <div class="modal-body">

                <form action="ControllersPagar" method="POST" class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="ejemplo_email_3" class="col-lg-2 control-label">Nombre</label>
                        <div class="col-lg-10">
                            <input type="text" name="nombre" class="form-control" id="ejemplo_email_3"
                                   placeholder="Nombre">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="ejemplo_email_3" class="col-lg-2 control-label">Apellidos</label>
                        <div class="col-lg-10">
                            <input type="text" name="apellidos" class="form-control" id="ejemplo_email_3"
                                   placeholder="Apellidos">
                        </div>
                    </div><div class="form-group">
                        <label for="ejemplo_email_3" class="col-lg-2 control-label">NIF</label>
                        <div class="col-lg-10">
                            <input type="text" name="nif" class="form-control" id="ejemplo_email_3"
                                   placeholder="XXXXXXXX-X">
                        </div>
                    </div><div class="form-group">
                        <label for="ejemplo_email_3" class="col-lg-2 control-label">Fecha Nacimiento</label>
                        <div class="col-lg-10">
                            <input type="text" name="fechaNac" class="form-control" id="ejemplo_email_3"
                                   placeholder="AAAA-MM-DD">
                        </div>
                    </div><div class="form-group">
                        <label for="ejemplo_email_3" class="col-lg-2 control-label">Nombre de la Dirección</label>
                        <div class="col-lg-10">
                            <input type="text" name="nombreDireccion" class="form-control" id="ejemplo_email_3"
                                   placeholder="ejemplo: casa">
                        </div>
                    </div><div class="form-group">
                        <label for="ejemplo_email_3" class="col-lg-2 control-label">Dirección</label>
                        <div class="col-lg-10">
                            <input type="text" name="direccion" class="form-control" id="ejemplo_email_3"
                                   placeholder="Av/..">
                        </div>
                    </div><div class="form-group">
                        <label for="ejemplo_email_3" class="col-lg-2 control-label">Telefono</label>
                        <div class="col-lg-10">
                            <input type="text" name="telefono" class="form-control" id="ejemplo_email_3"
                                   placeholder="Telefono">
                        </div>
                    </div><div class="form-group">
                        <label for="ejemplo_email_3" class="col-lg-2 control-label">Codigo Postal</label>
                        <div class="col-lg-10">
                            
                            <input type="text" name="codigoPostal" id="searchField2" autocomplete="off" class="form-control" 
                                   placeholder="XXXXXX">
                            <input class="form-control" type="hidden" value="" name="nombre" id="searchField" autocomplete="off" placeholder="Escriba el Producto"/><br/>
                    <a href="#" onclick="ControllersBusqudas"><div id="popups"></div></a>
                           
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-offset-1 col-lg-1">
                            <button type="submit" name="Enviar" class="btn btn-default" style="float:left">Enviar</button>
                        </div>
                    </div>
                </form>
            </div>
         
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
            </div>
        </div>

    </div>
</div>
