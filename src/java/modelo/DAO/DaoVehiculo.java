package modelo.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.BEAN.BeanVehiculo;
import util.*;
import util.InterfaceCRUD;

public class DaoVehiculo extends Conexion implements InterfaceCRUD {

    public Connection conexion = null;
    public Statement st = null;
    public ResultSet rs = null;

    public boolean encontrado = false;
    public boolean listo = false;

    public String vehplaca;
    public String datid;
    public String catid;
    public String vehmodelo;
    public String vehmarca;
    public String vehestado;
    public String vehprecio;

    public DaoVehiculo(BeanVehiculo BVehi) {

        super();

        try {
            conexion = this.ObtenerConexion();
            st = conexion.createStatement();

            vehplaca = BVehi.getVehplaca();
            datid = BVehi.getDatid();
            catid = BVehi.getCatid();
            vehmodelo = BVehi.getVehmodelo();
            vehmarca = BVehi.getVehmarca();
            vehestado = BVehi.getVehestado();
            vehprecio = BVehi.getVehprecio();

        } catch (Exception ex) {
            Logger.getLogger(DaoVehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public boolean AgregarRegistro() {
        try {
            st.executeUpdate("insert into vehiculo values('" + vehplaca + "', '" + datid + "', '" + catid + "', '" + vehmodelo + "', '" + vehmarca + "', '" + vehestado + "', '" + vehprecio + "');");
            listo = true;
        } catch (Exception ex) {
            Logger.getLogger(DaoVehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listo;
    }

    @Override
    public boolean ActualizarRegistro() {
        try {
            st.executeUpdate("update vehiculo set datid = '" + datid + "', catid = '" + catid + "', vehmodelo = '" + vehmodelo + "', vehmarca = '" + vehmarca + "', vehestado = '" + vehestado + "', vehprecio = '" + vehprecio + "' where vehplaca = '" + vehplaca + "';");
            listo = true;
        } catch (Exception ex) {
            Logger.getLogger(DaoVehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listo;
    }

    public static BeanVehiculo ConsultarRegistro(String vehplaca) {
        BeanVehiculo Bvehiculo = null;
 
        try {
            Conexion conex = new Conexion();
            Connection con = conex.ObtenerConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from vehiculo where vehplaca ='"+vehplaca+"';");
            
            while (rs.next()) {
                Bvehiculo = new BeanVehiculo(vehplaca, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                
            }
            rs.close();
            st.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Bvehiculo;
    }

    public ArrayList<BeanVehiculo> listar() {
        Conexion conex = new Conexion();
        ArrayList<BeanVehiculo> listavehiculos = new ArrayList<BeanVehiculo>();

        try {

            st = conex.ObtenerConexion().createStatement();
            rs = st.executeQuery("select * from vehiculo");

            while (rs.next()) {
                vehplaca = rs.getString("VEHPLACA");
                datid = rs.getString("DATID");
                catid = rs.getString("CATID");
                vehmodelo = rs.getString("VEHMODELO");
                vehmarca = rs.getString("VEHMARCA");
                vehestado = rs.getString("VEHESTADO");
                vehprecio = rs.getString("VEHPRECIO");

                BeanVehiculo Bvehiculo = new BeanVehiculo();

                Bvehiculo.setVehplaca(vehplaca);
                Bvehiculo.setDatid(datid);
                Bvehiculo.setCatid(catid);
                Bvehiculo.setVehmodelo(vehmodelo);
                Bvehiculo.setVehmarca(vehmarca);
                Bvehiculo.setVehestado(vehestado);
                Bvehiculo.setVehprecio(vehprecio);

                listavehiculos.add(Bvehiculo);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listavehiculos;
    }

    public DaoVehiculo() {

    }

}
