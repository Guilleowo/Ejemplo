<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Vehiculo</title>
        <link rel='stylesheet' href='estilos.css'>
    </head>
    <body>
        <div id="cabezera" class="leter">
            Registrar<br><br>         
        </div>

        <div id="cuerpo">
            <form id="formulario2" method="post" action="Vehiculo">
                <table width="500" height="79" border="1">
                    <tr>
                        <th width="140" style="padding-right: 50px; padding-left: 50px;">
                            Placa: <br>
                            <input type="text" name="placa"><br><br>
                            Datos: <br>
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

                </table> <br><br>
                <button style="padding-right: 30px; padding-left: 30px; padding-top: 10px; padding-bottom: 10px;">
                    Registrar
                </button><br><br>
 
                <input type="hidden" name="textOpcions" value="1">


            </form>
        </div>

        <div id="pie">
            <% if (request.getAttribute("error") != null) {%>
            ${error}
            <%} else {%>
            ${exito}
            <%}%> 
        </div>
        <input style="padding-right: 30px; padding-left: 30px; padding-top: 10px; padding-bottom: 10px;" type="button" value="Volver" OnClick="location.href = 'menu.jsp'">    
</body>
</html>
 