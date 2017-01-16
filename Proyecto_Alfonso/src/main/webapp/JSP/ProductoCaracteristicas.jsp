
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../INI/Cabecera.jsp"/>




        <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>

            <!-- Wrapper for slides -->
            <div class="carousel-inner" role="listbox">


                <div class="item active">
                    <img src="IMG/${imagen}.1.jpg" alt="" width="1000" height="600">
                    <div class="carousel-caption">
                        <h3><c:out value="${NombreProducto}"/></h3>
                    </div>      
                </div>

                <c:forEach begin="1" items="${imagenes}" var="imagenes">

                    <img src="${imagenes.image}" alt="" style="width:100%">
                    <div class="item">
                        <img src="IMG/${imagenes.image}" alt="Chicago" width="1000" height="600">
                        <div class="carousel-caption">
                            <h3><c:out value="${NombreProducto}"/></h3>
                        </div>      
                    </div>
                </c:forEach>
            </div>
</div>  <!-- Tipo de letra -->


            <!-- Left and right controls -->
            <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>


<div class="container">
  <h2><c:out value="${NombreProducto}"/></h2>
  <p>Caracteristicas del producto</p>
  <table class="table">
    <thead>
      <tr>
        <th>Descripcion</th>
        <th>Caracteristica</th>
      </tr>
    </thead>
    <c:forEach begin="1" items="${ProductoCaracteristicas}" var="productos">
    <tbody>
      <tr>
        <td><c:out value="${productos.nombreCaracteristica}"/></td>
        <td><c:out value="${productos.descripcion}"/></td>
      </tr>      
        
    </tbody>
    </c:forEach>
  </table>
</div>
  
<div class="container">
  <button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo">Más informacion</button>
  <div id="demo" class="collapse">
    <c:out value="${DescripcionProducto}"/>
  </div>
  
    <a href="${pageContext.request.contextPath}/ControllersCarrito"><button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo">Enviar</button></a>

 
  
</div>
              

        <script>
            $(document).ready(function () {
                // Initialize Tooltip
                $('[data-toggle="tooltip"]').tooltip();

                // Add smooth scrolling to all links in navbar + footer link
                $(".navbar a, footer a[href='#myPage']").on('click', function (event) {

                    // Make sure this.hash has a value before overriding default behavior
                    if (this.hash !== "") {

                        // Prevent default anchor click behavior
                        event.preventDefault();

                        // Store hash
                        var hash = this.hash;

                        // Using jQuery's animate() method to add smooth page scroll
                        // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
                        $('html, body').animate({
                            scrollTop: $(hash).offset().top
                        }, 900, function () {

                            // Add hash (#) to URL when done scrolling (default click behavior)
                            window.location.hash = hash;
                        });
                    } // End if
                });
            })
        </script>

    </body>
</html>