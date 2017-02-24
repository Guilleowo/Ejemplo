/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.BEAN.BeanVehiculo;
import modelo.DAO.DaoVehiculo;

/**
 *
 * @author APRENDIZ
 */
@WebServlet(name = "ServletVehiculo", urlPatterns = {"/Vehiculo"})
public class ServletVehiculo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        int opcion = Integer.parseInt(request.getParameter("textOpcions"));
        String vehplaca = request.getParameter("placa");
        String datid = request.getParameter("datid");
        String catid = request.getParameter("catid");
        String vehmodelo = request.getParameter("modelo");
        String vehmarca = request.getParameter("marca");
        String vehestado = request.getParameter("estado");
        String vehprecio = request.getParameter("precio");

        BeanVehiculo BUser = new BeanVehiculo(vehplaca, datid, catid, vehmodelo, vehmarca, vehestado, vehprecio);
        DaoVehiculo DVeh = new DaoVehiculo(BUser);
        ResultSet rs;

        switch (opcion) {
            case 1://Agregar vehiculo
                if (DVeh.AgregarRegistro()) {
                    request.setAttribute("exito", "<script> alert('El vehiculo fue registrado correctamente')</script>");
                } else {
                    request.setAttribute("error", "<script> alert('El vehiculo no fue registrado con éxito')</script>");
                }
                request.getRequestDispatcher("registrar_vehiculo.jsp").forward(request, response);
                break;

            case 2://Actualizar vehiculo
                if (DVeh.ActualizarRegistro()) {
                    request.setAttribute("exito", "<script> alert('El vehiculo fue actualizado correctamente')</script>");
                } else {
                    request.setAttribute("error", "<script> alert('El vehiculo no fue actualizado correctamente')</script>");
                }
                request.getRequestDispatcher("actualizar_vehiculo.jsp").forward(request, response);
                break;

            case 3://Consultar Vehiculo
                BeanVehiculo bvehiculo = DaoVehiculo.ConsultarRegistro(vehplaca);
                if (bvehiculo !=null){
                    request.setAttribute("bvehiculo", bvehiculo);
                    request.getRequestDispatcher("actualizar_vehiculo.jsp").forward(request, response);
                }else{
                    request.setAttribute("error", "<script> alert('No se encontró el vehiculo')</script>");
                    request.getRequestDispatcher("consultar.jsp").forward(request, response);
                    
                }
                break;
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
