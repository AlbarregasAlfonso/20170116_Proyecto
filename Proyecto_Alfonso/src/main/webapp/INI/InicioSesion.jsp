
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>z


<script >
    var request;

    function getRequestObject() {
        if (window.ActiveXObject) {
            return(new ActiveXObject("Microsoft.XMLHTTP"));
        } else if (window.XMLHttpRequest) {
            return(new XMLHttpRequest());
        } else {
            return(null);
        }
    }

    function sendRequest(numero) {
        request = getRequestObject();
        request.onreadystatechange = handleResponse;

        if (numero !== 0) {

//                    alert(document.formulario.nombre.value);
//                    alert('hola');
            request.open("POST", "Controllers?user=" + document.formulario.user.value + "&clave=" + document.formulario.clave.value + "&Enviar=iniciarSesion", true);
            request.send(null);


        } else {

            request.open("GET", "message-data_1.html", true);
            request.send(null);
        }
    }

    function handleResponse() {
        if (request.readyState == 4) {
            document.getElementById("message").innerHTML = request.responseText;

            if (document.getElementById("message").innerHTML === 'Bienvenido') {

                $('#inicioSesion').modal('hide');
                  location.reload(true);
                  

            }
        }
    }


</script>



<div class="modal fade" id="inicioSesion" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header" style="padding:35px 50px;">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4><span class="glyphicon glyphicon-lock"></span> Login</h4>
                <h4><div id="message"></div></h4>
            </div>
            <div class="modal-body" style="padding:40px 50px;">
                <form name="formulario">
                    <div class="form-group">
                        <label for="usrname"><span class="glyphicon glyphicon-user"></span> Username</label>
                        <input type="text" class="form-control" id="name" name="user" placeholder="Enter email">
                    </div>
                    <div class="form-group">
                        <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Password</label>
                        <input type="text" class="form-control" id="name" name="clave" placeholder="Enter password">
                    </div>
                    <div class="checkbox">
                        <label><input type="checkbox" value="" checked>Remember me</label>
                    </div>
                    <button type="button" onclick="sendRequest(1)" name="Enviar" value="iniciarSesion" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span> Login</button>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>

                <p>Not a member? <a href="#">Sign Up</a></p>
                <p>Forgot <a href="#">Password?</a></p>
            </div>
        </div>

    </div>
</div> 