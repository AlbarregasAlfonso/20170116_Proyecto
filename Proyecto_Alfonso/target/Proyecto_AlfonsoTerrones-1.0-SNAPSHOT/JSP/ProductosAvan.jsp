
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../INI/Cabecera.jsp"/>




<div class="row">
    <div class="col-sm-1"></div>

    <div class="col-sm-2" >
        <br/> <br/> <br/> <br/> <br/> <br/>



        <form method="POST" action="ControllersBusquedaAvan">

            <c:if test="${categoria==1 || categoria==9}">


                <h3>Bits</h3>
                <select name="bits" class="form-control">
                    <option name="bits" value=""></option>
                    <option name="bits" value="32bits">32bits</option>
                    <option name="bits" value="64bits">64bits</option>
                </select>


                <h3>Tipo</h3>
                <select name="tipo" class="form-control">
                    <option name="tipo" value=""></option>
                    <option name="tipo" value="i3">i3</option>
                    <option name="tipo" value="i5">i5</option>
                    <option name="tipo" value="i7">i7</option>
                </select>

                <h3>Velocidad</h3>
                <select name="velocidad" class="form-control">
                    <option name="velocidad" value=""></option>
                    <option name="velocidad" value="3.2G">3.2 Ghz</option>
                    <option name="velocidad" value="3.4G">3.4 Ghz</option>
                    <option name="velocidad" value="3.5G">3.5 Ghz</option>
                    <option name="velocidad" value="3.7G">3.7 Ghz</option>
                    <option name="velocidad" value="4.0G">4.0 Ghz</option>
                </select>



            </c:if>

            <c:if test="${categoria==2}">

                <h3>Socket</h3>
                <select name="socket" class="form-control">
                    <option name="socket" value=""></option>
                    <option name="socket" value="Intel 1150">Intel 1150</option>
                    <option name="socket" value="Intel 2011-3">Intel 2011-3</option>
                    <option name="socket" value="AMD FM2">AMD FM2</option>
                    <option name="socket" value="AMD AM3">AMD AM3</option>
                </select>

                <h3>Chipset</h3>
                <select name="chipset" class="form-control">
                    <option name="chipset" value=""></option>
                    <option name="chipset" value="AMD A58 FCH">AMD A58 FCH</option>
                    <option name="chipset" value="Intel® Z97">Intel® Z97</option>
                    <option name="chipset" value="Intel ® X99 ">Intel ® X99 </option>
                    <option name="chipset" value="Chipset AMD A88X">Chipset AMD A88X</option>
                </select>

                <h3>Marca</h3>
                <select name="marca" class="form-control">
                    <option name="marca" value=""></option>
                    <option name="marca" value="Gigabyte">Gigabyte</option>
                    <option name="marca" value="MSI">MSI</option>
                    <option name="marca" value="Asus">Asus</option>
                    <option name="marca" value="Asrock">Asrock</option>
                </select>




            </c:if>


            <c:if test="${categoria==3}">



                <h3>Marca</h3>
                <select name="marca" class="form-control">
                    <option name="marca" value=""></option>
                    <option name="marca" value="Gigabyte">Gigabyte</option>
                    <option name="marca" value="MSI">MSI</option>
                    <option name="marca" value="Asus">Asus</option>
                    <option name="marca" value="PNY">PNY</option>
                    <option name="marca" value="Sapphire">Sapphire</option>

                </select>

                <h3>Tipo de memoria</h3>
                <select name="tipomemoria" class="form-control">
                    <option name="tipomemoria" value=""></option>
                    <option name="tipomemoria" value="GDDR5">GDDR5</option>
                    <option name="tipomemoria" value="GDDR3">GDDR3</option>

                </select>

                <h3>Interfaz de memoria</h3>
                <select name="inmemoria" class="form-control">
                    <option name="inmemoria" value=""></option>
                    <option name="inmemoria" value="64-bit">64-bit</option>
                    <option name="inmemoria" value="128 bits">128 bits</option>
                    <option name="inmemoria" value="256 bits">256 bits</option>

                </select>

                <h3>Tamaño memoria</h3>
                <select name="tamemoria" class="form-control">
                    <option name="tamemoria" value=""></option>
                    <option name="tamemoria" value="1024 MB">1024 MB</option>
                    <option name="tamemoria" value="2048 MB">2048 MB</option>
                    <option name="tamemoria" value="4096 MB">4096 MB</option>

                </select>

            </c:if>          


            <c:if test="${categoria==4}">


                <h3>Marca</h3>
                <select name="marca" class="form-control">
                    <option name="marca" value=""></option>
                    <option name="marca" value="Kingston">Kingston</option>
                    <option name="marca" value="G.Skill">G.Skill</option>
                    <option name="marca" value="Crucial">Crucial</option>
                </select>



                <h3>Voltaje</h3>
                <select name="voltaje" class="form-control">
                    <option name="voltaje" value=""></option>
                    <option name="voltaje" value="1.2 V">1.2 V</option>
                    <option name="voltaje" value="1.35 V">1.35 V</option>
                    <option name="voltaje" value="1.65 V">1.65 V</option>
                </select>

                <h3>Capacidad</h3>
                <select name="capacidad" class="form-control">
                    <option name="capacidad" value=""></option>
                    <option name="capacidad" value="8 GBs">8 GBs</option>
                    <option name="capacidad" value="2 GBs">2 GBs</option>
                    <option name="capacidad" value="2x8 GBs">2x8 GBs</option>

                </select>

                <h3>Tipo</h3>
                <select name="tipomemo" class="form-control">
                    <option name="tipomemo" value=""></option>
                    <option name="tipomemo" value="DDR3">DDR3</option>
                    <option name="tipomemo" value="DDR4">DDR4</option>
                </select>


            </c:if>

            <c:if test="${categoria==5}">


                <h3>Marca</h3>
                <select name="marca" class="form-control">
                    <option name="marca" value=""></option>
                    <option name="marca" value="Seagate">Seagate</option>
                    <option name="marca" value="Western">Western</option>
                    <option name="marca" value="Toshiba">Toshiba</option>
                </select>

                <h3>Velocidad</h3>
                <select name="velocidad" class="form-control">
                    <option name="velocidad" value=""></option>
                    <option name="velocidad" value="5400 RPM">5400 RPM</option>
                    <option name="velocidad" value="7200 RPM">7200 RPM</option>          
                </select>

                <h3>Capacidad</h3>
                <select name="capacidad" class="form-control">
                    <option name="capacidad" value=""></option>
                    <option name="capacidad" value="1 TBs">1 TBs</option>
                    <option name="capacidad" value="2 TBs">2 TBs</option>
                    <option name="capacidad" value="4 TBs">4 TBs</option>
                    <option name="capacidad" value="8 TBs">8 TBs</option>

                </select>

                <h3>Tamaño</h3>
                <select name="tamano" class="form-control">
                    <option name="tamano" value=""></option>
                    <option name="tamano" value="2.5 pulgadas">2.5 pulgadas</option>
                    <option name="tamano" value="3.5 pulgadas">3.5 pulgadas</option>
                </select>


            </c:if>

            <c:if test="${categoria==6}">


                <h3>Marca</h3>
                <select name="marca" class="form-control">
                    <option name="marca" value=""></option>
                    <option name="marca" value="Corsair">Corsair</option>
                    <option name="marca" value="OCZ">OCZ</option>
                    <option name="marca" value="Toshiba">Toshiba</option>
                    <option name="marca" value="Samsung">Samsung</option>
                </select>


                <h3>Capacidad</h3>
                <select name="capacidad" class="form-control">
                    <option name="capacidad" value=""></option>
                    <option name="capacidad" value="120 GB">120 GB</option>
                    <option name="capacidad" value="128 GB">128 GB</option>
                    <option name="capacidad" value="4 TBs">240 GB</option>
                    <option name="capacidad" value="8 TBs">480 GB</option>

                </select>


            </c:if>


            <c:if test="${categoria==7}">


                <h3>Marca</h3>
                <select name="marca" class="form-control">
                    <option name="marca" value=""></option>
                    <option name="marca" value="Sandisk">Sandisk</option>
                    <option name="marca" value="Verbatim">Verbatim</option>
                    <option name="marca" value="EMTEC ">EMTEC</option>
                    <option name="marca" value="Sandisk">Sandisk</option>
                    <option name="marca" value="Corsair">Corsair</option>
                </select>

                <h3>Tipo</h3>
                <select name="tipo" class="form-control">
                    <option name="tipo" value=""></option>
                    <option name="tipo" value="2.0">2.0</option>
                    <option name="tipo" value="3.0">3.0</option>

                </select>


                <h3>Capacidad</h3>
                <select name="capacidad" class="form-control">
                    <option name="capacidad" value=""></option>
                    <option name="capacidad" value="128 GB">128 GB</option>
                    <option name="capacidad" value="64 GB">64 GB</option>
                    <option name="capacidad" value="32 GB">32 GB</option>
                    <option name="capacidad" value="16 GB">16 GB</option>

                </select>


            </c:if>

            <c:if test="${categoria==8}">


                <h3>Marca</h3>
                <select name="marca" class="form-control">
                    <option name="marca" value=""></option>
                    <option name="marca" value="Intenso">Intenso</option>
                    <option name="marca" value="Toshiba">Toshiba</option>
                    <option name="marca" value="Samsung">Samsung</option>
                    <option name="marca" value="Seagate">Seagate</option>
                    <option name="marca" value="WD">WD</option>
                </select>

                <h3>Pulgadas</h3>
                <select name="pulgadas" class="form-control">
                    <option name="pulgadas" value=""></option>
                    <option name="pulgadas" value="2.5">2.5</option>
                    <option name="pulgadas" value="3.5">3.5</option>

                </select>


                <h3>Capacidad</h3>
                <select name="capacidad" class="form-control">
                    <option name="capacidad" value=""></option>
                    <option name="capacidad" value="1 TB">1 TB</option>
                    <option name="capacidad" value="1 TB">2 TB</option>
                    <option name="capacidad" value="3 TB">3 TB</option>
                    <option name="capacidad" value="4 TB">4 TB</option>
                    <option name="capacidad" value="5 TB">5 TB</option>

                </select>


            </c:if>

            <c:if test="${categoria==11}">


                <h3>Marca</h3>
                <select name="marca" class="form-control">
                    <option name="marca" value=""></option>
                    <option name="marca" value="Cyclops">Cyclops</option>
                    <option name="marca" value="Anidees">Anidees</option>
                    <option name="marca" value="Fractal ">Fractal </option>
                    <option name="marca" value="Corsair">Corsair</option>
                    <option name="marca" value="Chieftec">Chieftec</option>
                    <option name="marca" value="Lian">Lian</option>
                </select>

                <h3>USB</h3>
                <select name="usb" class="form-control">
                    <option name="usb" value=""></option>
                    <option name="usb" value="2.0">2.0</option>
                    <option name="usb" value="3.0">3.0</option>

                </select>


                <h3>Capacidad</h3>
                <select name="capacidad" class="form-control">
                    <option name="capacidad" value=""></option>
                    <option name="capacidad" value="Más de 21 cm">Más de 21 cm</option>
                    <option name="capacidad" value="De 0 a 18.99 cm">De 0 a 18.99 cm</option>


                </select>


            </c:if>


            <c:if test="${categoria==12}">


                <h3>Marca</h3>
                <select name="marca" class="form-control">
                    <option name="marca" value=""></option>
                    <option name="marca" value="Thermaltake">Thermaltake</option>
                    <option name="marca" value="Chieftec">Chieftec</option>
                    <option name="marca" value="Talius">Talius</option>
                    <option name="marca" value="Tacens">Tacens</option>
                    <option name="marca" value="Chieftec">Chieftec</option>

                </select>

                <h3>Modular</h3>
                <select name="modular" class="form-control">
                    <option name="modular" value=""></option>
                    <option name="modular" value="Si">Si</option>
                    <option name="modular" value="No">No</option>

                </select>


                <h3>Vatios</h3>
                <select name="vatios" class="form-control">
                    <option name="vatios" value=""></option>

                    <option name="vatios" value="300W">300W</option>
                    <option name="vatios" value="450W">450W</option>
                    <option name="vatios" value="500W">500W</option>
                    <option name="vatios" value="600W">600W</option>
                    <option name="vatios" value="750W">750W</option>



                </select>


            </c:if>

            <c:if test="${categoria==13}">


                <h3>Marca</h3>
                <select name="marca" class="form-control">
                    <option name="marca" value=""></option>
                    <option name="marca" value="Philips">Philips</option>
                    <option name="marca" value="Acer">Acer</option>
                    <option name="marca" value="LG">LG</option>
                    <option name="marca" value="HP">HP</option>
                    <option name="marca" value="Asus">Asus</option>
                    <option name="marca" value="BENQ">BENQ</option>
                    <option name="marca" value="Apple">Apple</option>

                </select>

                <h3>Formato</h3>
                <select name="formato" class="form-control">
                    <option name="formato" value=""></option>
                    <option name="formato" value="16:9">16:9</option>
                    <option name="formato" value="5:4">5:4</option>

                </select>


                <h3>Resolucion</h3>
                <select name="resolucion" class="form-control">
                    <option name="resolucion" value=""></option>
                    <option name="resolucion" value="1280 x 1024">1280 x 1024</option>
                    <option name="resolucion" value="1366 x 768">1366 x 768</option>
                    <option name="resolucion" value="1600 x 900">1600 x 900</option>
                    <option name="resolucion" value="1920 x 1080">1920 x 1080</option>
                </select>

                <h3>Pulgadas</h3>
                <select name="pulgadas" class="form-control">
                    <option name="pulgadas" value=""></option>
                    <option name="pulgadas" value="18.5 pulgadas">18.5 pulgadas</option>
                    <option name="pulgadas" value="19 pulgadas">19 pulgadas</option>
                    <option name="pulgadas" value="19,5 pulgadas">19,5 pulgadas</option>                   
                    <option name="pulgadas" value="21.5 pulgadas">21.5 pulgadas</option>
                </select>


            </c:if>

            <c:if test="${categoria==14}">


                <h3>Marca</h3>
                <select name="marca" class="form-control">
                    <option name="marca" value=""></option>
                    <option name="marca" value="Aerocool">Aerocool</option>
                    <option name="marca" value="BG ">BG </option>
                    <option name="marca" value="Cherry">Cherry</option>
                    <option name="marca" value="Lenovo">Lenovo</option>
                    <option name="marca" value="Kloner">Kloner</option>
                    <option name="marca" value="Logitech">Logitech</option>
                    <option name="marca" value="Gigabyte">Gigabyte</option>

                </select>
                
                <h3>Bluetooh</h3>
                <select name="bluetooh" class="form-control">
                    
                    <option name="bluetooh" value=""></option>
                    <option name="bluetooh" value="mbrica">Bluetooh</option>
                    <option name="bluetooh" value="Cable">Cable</option>
                    
                </select>
             



            </c:if>


             <c:if test="${categoria==15}">


                <h3>Marca</h3>
                <select name="marca" class="form-control">
                    <option name="marca" value=""></option>
                    <option name="marca" value="BG">BG</option>
                    <option name="marca" value="Cherry">Cherry</option>
                    <option name="marca" value="Energy">Energy</option>
                    <option name="marca" value="Gigabyte">Gigabyte</option>
                    <option name="marca" value="Lenovo">Lenovo</option>
                    <option name="marca" value="Logitech">Logitech</option>

                </select>

                <h3>Tipo</h3>
                <select name="tipo" class="form-control">
                    <option name="tipo" value=""></option>
                    <option name="tipo" value="ser">Láser</option>
                    <option name="tipo" value="ptico">Óptico</option>

                </select>


                <h3>Forma de conexión</h3>
                <select name="conexion" class="form-control">
                    <option name="conexion" value=""></option>
                    <option name="conexion" value="Cable">Cable</option>
                    <option name="conexion" value="mbrico">Inalámbrico</option>
                    
                </select>

        


            </c:if>
                
                <c:if test="${categoria==17}">


                <h3>Marca</h3>
                <select name="marca" class="form-control">
                    <option name="marca" value=""></option>
                    <option name="marca" value="Asus">Asus</option>
                    <option name="marca" value="Edimax">Edimax</option>
                    <option name="marca" value="StarTech">StarTech</option>
                    <option name="marca" value="TP-LINK">TP-LINK</option>
                    <option name="marca" value="Intel">Intel</option>

                </select>

                <h3>Velocidad</h3>
                <select name="velocidad" class="form-control">
                    <option name="velocidad" value=""></option>
                    <option name="velocidad" value="10/100/1000Mbps">10/100/1000Mbps</option>
                    <option name="velocidad" value="802.11 b/g/n">802.11 b/g/n</option>
                    

                </select>

            </c:if>



            <h3>Precio</h3>
            <select name="desde" class="form-control">
                <option name="desde" value="0">Desde</option>
                <option name="desde" value="41.3">50</option>
                <option name="desde" value="82.6">100</option>
                <option name="desde" value="165.2">200</option>
                <option name="desde" value="248">300</option>
                <option name="desde" value="413.22">500</option>
                <option name="desde" value="578.5">700</option>
                <option name="desde" value="826.4">1000</option>
                <option name="desde" value="1074.38">1300</option>
                <option name="desde" value="1322.3">1600</option>
            </select>
            <select name="hasta" class="form-control">
                <option name="hasta" value="1400">Hasta</option>
                <option name="hasta" value="41.3">50</option>
                <option name="hasta" value="82.6">100</option>
                <option name="hasta" value="165.2">200</option>
                <option name="hasta" value="248">300</option>
                <option name="hasta" value="413.22">500</option>
                <option name="hasta" value="578.5">700</option>
                <option name="hasta" value="826.4">1000</option>
                <option name="hasta" value="1074.38">1300</option>
                <option name="hasta" value="1322.3">1600</option>
            </select>

            <input type="hidden" name="categoria" value="${categoria}" />
            <input type="hidden" name="valor" value="0"/>
            <br>
            <div class="form-group">
                <div class="col-lg-offset-1 col-lg-1">
                    <button type="submit" name="Buscar" class="btn btn-default" style="float:left">Buscar</button>
                </div>
            </div>


        </form>





    </div>
    <div class="col-sm-9" >



        <div class="container">
            <h2>Productos</h2>
            <p>¡Aqui tienes todo lo que necesitas!</p>
            <p>Compra todo lo que necesites</p>
            <div class="row">


                <c:forEach  items="${productosFraccionado}" var="pc">
                    <div class="col-md-3">
                        
                            <a href="${pageContext.request.contextPath}/Controllers?imagen=${pc.idProducto}">
                                <img class="thumbnail" src="${pageContext.request.contextPath}/IMG/${pc.idProducto}.1.jpg" alt="Lights" style="width:100%">
                                <div class="caption">
                                    <p><c:out value="${pc.denominacion}"/></p>
                                    <p><c:out value="${pc.precioUnitario} €"/></p>
                                </div>
                            </a>
                       
                    </div>
                </c:forEach>



            </div>
        </div>



        <!-- Footer -->
        <footer class="text-center">
            <a class="up-arrow" href="#myPage" data-toggle="tooltip" title="TO TOP">
                <span class="glyphicon glyphicon-chevron-up"></span>
            </a><br><br>
        </footer>

    </div>
</div>
</body>
</html>