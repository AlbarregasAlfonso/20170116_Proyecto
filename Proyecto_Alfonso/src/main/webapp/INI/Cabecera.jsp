
<%-- 
    Document   : Cabecera.jsp
    Created on : 20-dic-2016, 8:35:05
    Author     : alfonso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Theme Made By www.w3schools.com - No Copyright -->
        <title>ATPC</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="CSS/Style.css" rel="stylesheet" type="text/css"/>
        <script src="JS/JS.js" type="text/javascript"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script type="text/javascript" src="../jquery.js"></script>
        <script src="../JS/Script.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                setTimeout(function () {
                    $(".content").fadeOut(3500);
                }, 1000);
            });
        </script>

        <style>
            body, #searchfield {
                font: 1.2em arial, helvetica, sans-serif;
            }
            .suggestions {
                background-color: #FFF;
                padding: 2px 6px;
                border: 1px solid #000;
            }
            .suggestions:hover {
                background-color: #69F;
            }
            #popups {
                position: absolute;
            }
            #searchField.error {
                background-color: #FFC;
            }
        </style>

        <script>window.onload = initAll;
            var xhr = false;
            var statesArray = new Array();
            function initAll() {
                document.getElementById("searchField").onkeyup = searchSuggest;
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
                    xhr.open("GET", "us-states.xml", true);
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
                var str = document.getElementById("searchField").value;
                document.getElementById("searchField").className = "";
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
                        document.getElementById("searchField").className = "error";
                    }
                    if (foundCt == 1) {
                        document.getElementById("searchField").value = document.getElementById("popups").firstChild.innerHTML;
                        document.getElementById("popups").innerHTML = "";
                    }
                }
            }
            function makeChoice(evt) {
                var thisDiv = (evt) ? evt.target : window.event.srcElement;
                document.getElementById("searchField").value = thisDiv.innerHTML;
                document.getElementById("popups").innerHTML = "";
            }
//            function mas(){
////                alert('Hola');
////                alert(document.getElementById("popups").innerHTML);
//                //alert(document.formulario.nombre.value());
//            }
        </script>



    </head>
    <body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">

        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>                        
                    </button>
                    <a class="navbar-brand" href="#myPage">Logo</a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav navbar-right">
                        <!--<li><h4><div id="message"></div></h4><li>-->
                        <li><a class="content" style="font-size:24px" class="fa" ><c:out value="${mensaje}"/></a></li>

                        <li><a href="Controllers?valor=0">Productos</a></li>  


                        <c:if test="${sessionScope.carrito=='abierto'}">
                            <li><a href="${pageContext.request.contextPath}/ControllersCarrito?Vercarrito=ver" style="font-size:24px" class="fa" >&#xf218;</a></li>
                            </c:if>

                        <c:if test="${sessionScope.usuario==null}">

                            <li><a href="" data-toggle="modal" data-target="#Registro">Registro</a></li>
                            <li><a href="" data-toggle="modal" data-target="#inicioSesion">Inicio de sesión</a></li>

                        </c:if>

                        <c:if test="${sessionScope.usuario!=null}">

                            <li><a href="${pageContext.request.contextPath}/Controllers?cerrarsesion=cerrar" style="font-size:24px" class="fa" >&#xf011;</a></li>


                            <c:if  test="${usuario.tipo=='a'}">

                                <li><a href="${pageContext.request.contextPath}/ControllersAdministrador?menu=menu">Bloquear Usuarios</a></li>

                            </c:if>

                            <c:if  test="${usuario.tipo=='u'}">

                                <li><a href="" data-toggle="modal" data-target="#Registro">Panel de control</a></li>
                                <li><a href="" data-toggle="modal" data-target="#inicioSesion">cerrar sesion</a></li>
                                </c:if>

                        </c:if>

                        <li><a href="#nada">-----</a></li>
                        <li class="dropdown">
                            <a class="glyphicon glyphicon-search" data-toggle="dropdown" href="#">
                                <span class="caret"></span></a>
                            <ul class="dropdown-menu">

                                <!--                                <li><input type="text" placeholder="Escriba el Producto"></li>-->
                                <li><a href="#">Busqueda avanzada</a></li>
                            </ul>
                        </li>

                    </ul>
                </div>
            </div>
                        
                          
            <form action="ControllersBusqudas">

                <input class="form-control" type="text" value="" name="nombre" id="searchField" autocomplete="off" placeholder="Escriba el Producto"/><br/>
                <a href="#" onclick="ControllersBusqudas"><div id="popups"></div></a>

            </form>
             
        </nav>

        <!-- ///////////////////////Alert Registro ////////////////////////// -->
        <!-- Modal -->

        <jsp:include page="Registro.jsp"/>


        <!-- ///////////////////////Alert Registro ////////////////////////// -->

        <!-- ///////////////////////Alert Registro ////////////////////////// -->
        <!-- Modal -->


        <jsp:include page="InicioSesion_nuevo.jsp"/>



        <!-- ///////////////////////Alert Registro ////////////////////////// -->