
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!--<script >
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

    function sendRequest() {
        request = getRequestObject();
        request.onreadystatechange = handleResponse;

       

//                    alert(document.formulario.nombre.value);
//                    alert('hola');
            request.open("GET", "Controllers?user=" + document.formulario.user.value + "&clave=" + document.formulario.clave.value + "&Enviar=iniciarSesion", true);
            request.send(null);
 


   
    
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


</script>-->





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
                <form action="Controllers" method="GET">
                    <div class="form-group">
                        <label for="usrname"><span class="glyphicon glyphicon-user"></span> Username</label>
                        <input type="text" class="form-control" id="name" name="user" placeholder="Enter email">
                    </div>
                    <div class="form-group">
                        <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Password</label>
                        <input type="password" class="form-control" id="name" name="clave" placeholder="Enter password">
                    </div>
       
                    <input type="submit" name="Enviar" value="iniciarSesion">
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>

            </div>
        </div>

    </div>
</div> 