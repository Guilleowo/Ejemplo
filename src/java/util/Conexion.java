package util;

import static java.lang.Character.UnicodeBlock.forName;
import java.sql.*;

/**
 * 
 * @author APRENDIZ
 */
public class Conexion {

    public String driver, url, user, pass, bd;
    public Connection conexion;

    public Conexion() {

        driver = "com.mysql.jdbc.Driver";
        bd = "venta_vehiculos";
        url = "jdbc:mysql://localhost:3306/" + bd;
        user = "root";
        pass = "";

        try {
            Class.forName(driver).newInstance();
            conexion = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexion a BD OK!!");
        } catch (Exception e) {
            System.out.println("Error al conectarse" + e);
        }
    }

    public Connection ObtenerConexion() {
        return conexion;
    }

    public Connection CerrarConexion() throws SQLException {
        conexion.close();
        conexion = null;
        return conexion;
    }
    public static void main(String[] args) {
        new Conexion();
    }
    
}
