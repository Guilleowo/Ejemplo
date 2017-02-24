<%@page import="modelo.BEAN.BeanVehiculo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar</title>
        <link rel='stylesheet' href='estilos.css'>
    </head>
    <body>
        <div class="leter">
            Actualizar Vehiculo
        </div>
        <form action="Vehiculo" method="post">

            <center>
                <%
                    BeanVehiculo BVehiculo = (BeanVehiculo) request.getAttribute("bvehiculo");
                    if (BVehiculo != null) {
                %>
                <table width="500" height="79" border="1">
                    <tr>
                        <th width="140" style="padding-right: 50px; padding-left: 50px;">
                            Placa: <br>
                            <input type="text" name="placa" value="<%=BVehiculo.getVehplaca()%>" contenteditable="true"><br><br>
                            Datos Personas: <br>
                            <input type="text" name="datid" value="<%=BVehiculo.getDatid()%>"><br><br>
                            Categoria: <br>
                            <input type="text" name="catid" value="<%=BVehiculo.getCatid()%>"><br><br>
                            Modelo: <br>
                            <input type="text" name="modelo" value="<%=BVehiculo.getVehmodelo()%>"><br><br>
                            Marca: <br>
                            <input type="text" name="marca" value="<%=BVehiculo.getVehmarca()%>"><br><br>
                            Estado: <br>
                            <input type="text" name="estado" value="<%=BVehiculo.getVehestado()%>"><br><br>
                            Precio: <br>
                            <input type="text" name="precio" value="<%=BVehiculo.getVehprecio()%>"><br><br>
                        </th>                       
                    </tr>
                </table><br><br>
                <% } else { %>

                <table width="500" height="79" border="1">
                    <tr>
                        <th width="140" style="padding-right: 50px; padding-left: 50px;">
                            Placa: <br>
                            <input type="text" name="placa"><br><br>
                            Datos Personas: <br>
                            <input type="text" name="datid"><br><br>
                            Categoria: <br>
                            <input type="text" name="catid"><br><br>
                            Modelo: <br>
                            <input type="text" name="modelo"><br><br>
                            Marca: <br>
                            <input type="text" name="marca"><br><br>
                            Estado: <br>
                            <input type="text" name="estado"><br><br>
                            Precio: <br>
                            <input type="text" name="precio"><br><br>
                        </th>                       
                    </tr>
                </table> 
                <br><br>
                <% } %>
            </center>
            <button style="padding-right: 30px; padding-left: 30px; padding-top: 10px; padding-bottom: 10px;">
                Actualizar
            </button><br><br>
            <input type="hidden" name="textOpcions" value="2">

             <input style="padding-right: 30px; padding-left: 30px; padding-top: 10px; padding-bottom: 10px;" type="button" value="Volver" OnClick="location.href = 'menu.jsp'">
            <br><br>
        </form>
        <div id="pie">
            <%if (request.getAttribute("error") != null) {%>
            ${error}
            <% } else { %>
            ${exito}
            <% } %>
        </div>
    </body>
</html>