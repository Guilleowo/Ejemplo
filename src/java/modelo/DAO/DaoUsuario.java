package modelo.DAO;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.BEAN.BeanUsuario;
import util.Conexion;
import util.InterfaceCRUD;

public class DaoUsuario extends Conexion implements InterfaceCRUD {
 
    private Connection conexion = null;
    private Statement st = null;
    private ResultSet rs = null;

    public boolean encontrado = false;
    public boolean listo = false;

    public String usuid;
    public String usulogin;
    public String usupassword;

    public DaoUsuario(BeanUsuario BUser) {

        super();

        try {
            conexion = this.ObtenerConexion();
            st = conexion.createStatement();

            usuid = BUser.getUsuid();
            usulogin = BUser.getUsulogin();
            usupassword = BUser.getUsupassword();

        } catch (Exception ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public DaoUsuario() {

    }

        public boolean validar(String usulogin, String usupassword) {
        try {
            conexion = this.ObtenerConexion();
            st = conexion.createStatement();
            rs = st.executeQuery("select * from usuario where usulogin= '" + usulogin + "' and usupassword= '" + usupassword + "'");

            if (rs.next()) {
                encontrado = true;
            }
            this.CerrarConexion();

        } catch (Exception e) {
        } 
        return encontrado;
    } 

    @Override
    public boolean AgregarRegistro() {
 
        try {
            st.executeUpdate("insert into usuario(USULOGIN, USUPASSWORD) values('" + usulogin + "', '" + usupassword + "');");
            listo = true;
        } catch (Exception ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listo;
    }

    @Override
    public boolean ActualizarRegistro() {
        try {
            st.executeUpdate("update usuario set usulogin = '" + usulogin + "' ,usupassword= '" + usupassword + "' where usuid='" + usuid + "';");
        } catch (Exception ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listo;
    }

}
