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
import modelo.BEAN.BeanUsuario;
import modelo.DAO.DaoUsuario;

/**
 *
 * @author APRENDIZ
 */
@WebServlet(name = "ServletUsuario", urlPatterns = {"/Validar"})
public class ServletUsuario extends HttpServlet {

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

        int opcion = Integer.parseInt(request.getParameter("textOpcion"));
        String usuid = request.getParameter("textid");
        String usulogin = request.getParameter("textusuario");
        String usupassword = request.getParameter("textclave");

        BeanUsuario BUser = new BeanUsuario(usuid, usulogin, usupassword);
        DaoUsuario DUser = new DaoUsuario(BUser);
        ResultSet rs;
  
        switch (opcion) {
            case 1://Agregar registro
                if (DUser.AgregarRegistro()) {
                    request.setAttribute("exito", "<script> alert('El usuario fue registrado correctamente')</script>");
                } else {
                    request.setAttribute("error", "<script> alert('El usuario no fue registrado con éxito')</script>");
                }
                request.getRequestDispatcher("registrar_usuario.jsp").forward(request, response);
                break;

            case 2://Validar usuario
                if (DUser.validar(usulogin, usupassword)) {
                    request.setAttribute("exito", "<script> alert('Datos Corectos')</script>");
                    request.getRequestDispatcher("menu.jsp").forward(request, response);
                } else {
                    request.setAttribute("error", "<script> alert('El usuario y/o contraseña son Erroneos')</script>");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
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
