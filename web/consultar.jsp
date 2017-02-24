<%@page import="java.util.ArrayList"%>
<%@page import="modelo.DAO.DaoVehiculo"%>
<%@page import="modelo.BEAN.BeanVehiculo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar</title>
        <link rel='stylesheet' href='estilos.css'>
    </head> 
    <body>
        <div class="leter">
            Consultar Vehiculo
        </div>
        <div align="center">
            <center>
                <form action="Vehiculo" method="post" name="form1">
                    <table width="500" height="79" border="1">
                        <tr> 
                            <th width="344" style="padding-right: 50px; padding-left: 50px;">
                                Número Placa:<br>
                                <input type="text" size="15" name="placa"><br>

                            </th>
                        </tr>

                    </table><br><br>
                    <button style="padding-right: 30px; padding-left: 30px; padding-top: 10px; padding-bottom: 10px;">
                        Consultar
                    </button><br><br>
                    <input type="hidden" name="textOpcions" value="3">

                </form>
                <input style="padding-right: 30px; padding-left: 30px; padding-top: 10px; padding-bottom: 10px;" type="button" value="Volver" OnClick="location.href = 'menu.jsp'">
                <br>
                <br>
                <form name="form2">
                    <table border="1">

                        <tr style="height: 30px;">
                            <th style="width: 150px; text-align: center;">
                                PLACA
                                </td>
                            <td style="width: 150px; text-align: center;">
                                DATOS
                            </td>
                            <td style="width: 150px; text-align: center;">
                                CATEGORIA
                            </td>
                            <td style="width: 150px; text-align: center;">
                                MODELO
                            </td>
                            <td style="width: 150px; text-align: center;">
                                MARCA
                            </td>
                            <td style="width: 150px; text-align: center;">
                                ESTADO
                            </td>
                            <td style="width: 150px; text-align: center;">
                                PRECIO
                            </td>
                        </tr>
                        <%
                            BeanVehiculo BV = new BeanVehiculo();
                            DaoVehiculo DV = new DaoVehiculo();
                            ArrayList<BeanVehiculo> listavehiculos = DV.listar();
                            for (int i = 0; i < listavehiculos.size(); i++) {
                                BV = listavehiculos.get(i);
                        %>
                        <tr>
                            <td><center><%=BV.getVehplaca()%></center></td>
                        <td><center><%=BV.getDatid()%></center></td>
                        <td><center><%=BV.getCatid()%></center></td>
                        <td><center><%=BV.getVehmodelo()%></center></td>
                        <td><center><%=BV.getVehmarca()%></center></td>
                        <td><center><%=BV.getVehestado()%></center></td>
                        <td><center><%=BV.getVehprecio()%></center></td>
                        </tr>
                        <% } %>
                    </table>
                </form>
            </center>
        </div>
    <center>
        <div id="pie">
            <%if (request.getAttribute("error") != null) { %>
            ${error}
            <% } else { %>
            ${exito}
            <% }%> 
        </div>
    </center>
</body>
</html>

