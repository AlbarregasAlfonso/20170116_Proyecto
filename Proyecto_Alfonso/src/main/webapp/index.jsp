

 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="INI/Cabecera.jsp"/>
<jsp:include page="INI/InicioSesion.jsp"/>







<div id="myCarousel" class="carousel slide " data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
          <img src="IMG/1001.1.jpg" alt="New York" width="1000" height="600">
        <div class="carousel-caption">
            <h3><c:out value="${escuchador}"/></h3>
          <p>The atmosphere in New York is lorem ipsum.</p>
        </div>      
      </div>

      <div class="item">
          <img src="IMG/1002.1.jpg" alt="Chicago" width="1000" height="600">
        <div class="carousel-caption">
          <h3>Chicago</h3>
          <p>Thank you, Chicago - A night we won't forget.</p>
        </div>      
      </div>
    
      <div class="item">
          <img src="IMG/1003.1.jpg" alt="Los Angeles" width="1000" height="600">
        <div class="carousel-caption">
          <h3>LA</h3>
          <p>Even though the traffic was a mess, we had the best time playing at Venice Beach!</p>
        </div>      
      </div>
    </div>

    
    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
</div>
<div id="contact" class="container">
  <h3 class="text-center">Contacto</h3>
 

  <div class="row">
    <div class="col-md-4">
      
      <p><span class="glyphicon glyphicon-map-marker"></span>Badajoz, Es</p>
      <p><span class="glyphicon glyphicon-phone"></span>Telefono: +34 647749447</p>
      <p><span class="glyphicon glyphicon-envelope"></span>Email: alfonsotem@gmail.com</p>
    </div>
    <div class="col-md-8">
      <div class="row">
        <div class="col-sm-6 form-group">
          <input class="form-control" id="name" name="name" placeholder="Nombre" type="text" required>
        </div>
        <div class="col-sm-6 form-group">
          <input class="form-control" id="email" name="email" placeholder="Email" type="email" required>
        </div>
      </div>
      <textarea class="form-control" id="comments" name="comments" placeholder="Comentario" rows="5"></textarea>
      <br>
      <div class="row">
        <div class="col-md-12 form-group">
          <button class="btn pull-right" type="submit">Enviar</button>
        </div>
      </div>
    </div>
  </div>
  <br>
</div>


<c:out value="${usuario}"/>

<jsp:include page="INI/Pie.jsp"/>





