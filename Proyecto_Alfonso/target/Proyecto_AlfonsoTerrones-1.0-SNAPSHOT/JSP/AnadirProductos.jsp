<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<jsp:include page="../INI/Cabecera.jsp"/>
<jsp:include page="../INI/RegistroCompra.jsp"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div class="row">
    <div class="col-sm-2">
        
    </div>
<div class="col-sm-8">
        
    

<div class="modal-body">
<br/>
<br/>
<br/>
    <form action="ControllersAdministrador2" method="POST" class="form-horizontal" role="form">
        <div class="form-group">
            <label for="ejemplo_email_3" class="col-lg-2 control-label">Denominacion</label>
            <div class="col-lg-10">
                <input type="text" name="denominacion" class="form-control" id="ejemplo_email_3"
                       placeholder="Nombre del producto">
            </div>
        </div>
        <div class="form-group">
            <label for="ejemplo_email_3" class="col-lg-2 control-label">Descripcion</label>
            <div class="col-lg-10">
                <input type="text" name="descripcion" class="form-control" id="ejemplo_email_3"
                       placeholder="Descripcion del producto">
            </div>
        </div>
        <div class="form-group">
            <label for="ejemplo_email_3" class="col-lg-2 control-label">Precio</label>
            <div class="col-lg-10">
                <input type="text" name="precio" class="form-control" id="ejemplo_email_3"
                       placeholder="€">
            </div>
        </div><div class="form-group">
            <label for="ejemplo_email_3" class="col-lg-2 control-label">Stock</label>
            <div class="col-lg-10">
                <input type="text" name="stock" class="form-control" id="ejemplo_email_3"
                       placeholder="">
            </div>
        </div><div class="form-group">
            <label for="ejemplo_email_3" class="col-lg-2 control-label">Oferta</label>
            <div class="col-lg-10">
                <input type="radio" name="oferta" value="s"  id="ejemplo_email_3"><label for="ejemplo_email_3" >Si</label>
                <input type="radio" name="oferta" value="n"  id="ejemplo_email_3"><label for="ejemplo_email_3" >No</label>
            </div>
        </div><div class="form-group">
            <label for="ejemplo_email_3" class="col-lg-2 control-label">En catalogo</label>
            <div class="col-lg-10">
                <input type="radio" name="catalogo" value="s"  ><label for="ejemplo_email_3" >Si</label>
                <input type="radio" name="catalogo" value="n"  ><label for="ejemplo_email_3" >No</label>
            </div>
        </div>
        
        
        
        <div class="form-group">
            <label for="ejemplo_email_3" class="col-lg-2 control-label">Categoria</label>
            <div class="col-lg-10">
                <select name="categoria" class="form-control">
                <option name="categoria" value="1">Procesadores</option>
                <option name="categoria" value="2">Placas Bases</option>
                <option name="categoria" value="3">Tarjetas Gráficas</option>
                <option name="categoria" value="4">Memoria Ram</option>
                <option name="categoria" value="5">Discos Duros HD</option>
                <option name="categoria" value="6">Discos Duros SSD</option>
                <option name="categoria" value="7">Unidades flash</option>
                <option name="categoria" value="8">Discos duros externos</option>
                <option name="categoria" value="9">Porttiles</option>
                <option name="categoria" value="10">Sockets</option>
                <option name="categoria" value="11">Cajas</option>
                <option name="categoria" value="12">Fuentes de alimentacion</option>
                <option name="categoria" value="13">Monitores</option>
                <option name="categoria" value="14">Teclados</option>
                <option name="categoria" value="15">Ratones</option>
                <option name="categoria" value="16">Otros periféricos</option>
                <option name="categoria" value="17">Tarjetas de red</option>
            </select>
            </div>
        </div>

        <br/>
        <div class="form-group">
            <div class="col-lg-offset-1 col-lg-1">
                <button type="submit" name="Enviar" class="btn btn-default" style="float:left">Enviar</button>
            </div>
        </div>
    </form>
</div>

</div>

<div class="col-sm-2">
</div>



</body>
</html>

