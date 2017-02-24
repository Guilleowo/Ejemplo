<%-- 
    Document   : Select
    Created on : 20-sep-2016, 8:36:29
    Author     : APRENDIZ
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta Select</title>
    </head>
    <body>
        <h1>Consultar Usuario</h1>
        
        <%  
        try{
            Connection conexion = null;
            Statement st = null;
            ResultSet rs = null;
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/venta_vehiculos";
            String user = "root";
            String pass = "";
            conexion = DriverManager.getConnection(url, user, pass);
            
            if(!conexion.isClosed()){
                st = conexion.createStatement();
                rs = st.executeQuery("select * from usuario");
                out.println("<select name = 'select'>");
                out.println("<option>Seleccione..</option>");
                
                while(rs.next()){
                    String usuid = rs.getString("USUID");
                    String usulogin = rs.getString("USULOGIN");
                    
                    out.println("<option value'"+usuid+"'>"+usulogin+"</option>");
                    
                }
                out.println("</select>");
                conexion.close();
            }else{
                out.println("error");
            }
            
        }catch (Exception e){
            out.println("Error"+e);
            e.printStackTrace();
        }
        
        %>
    </body>
</html>
