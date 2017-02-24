
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar</title>
    </head>
    <body> 
        <div id="cabezera" class="leter">
            Registrate<br><br>      
            <link rel='stylesheet' href='estilos.css'>
        </div>
 
        <div id="cuerpo">
            <form id="formulario" method="post" action="Validar">
                <table width="500" height="79" border="1">
                    <tr>
                        <th width="140" style="padding-right: 50px; padding-left: 50px;">
                            Usuario: <br>
                            <input type="text" name="textusuario"><br><br>
                            Contraseña: <br>
                            <input type="password" name="textclave"><br><br>
                        </th>
                    </tr>
 
                </table> <br><br>
                <button style="padding-right: 30px; padding-left: 30px; padding-top: 10px; padding-bottom: 10px;">
                    Registrar
                </button><br><br>

                <input type="hidden" name="textOpcion" value="1">

 
            </form>
        </div>

        <div id="pie">
            <% if (request.getAttribute("error") != null) {%>
            ${error}
            <%} else {%>
            ${exito}
            <%}%> 
        </div>       
        <input style="padding-right: 30px; padding-left: 30px; padding-top: 10px; padding-bottom: 10px;" type="button" value="Volver" OnClick="location.href = 'index.jsp'">
</body>
</html>
