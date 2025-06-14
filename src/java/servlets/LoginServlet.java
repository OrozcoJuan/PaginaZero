/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import dao.CuentaDAO;
import modelo.Cuenta;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

/**
 *
 * @author NANA
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String contraseña = request.getParameter("contraseña");

        CuentaDAO cuentaDAO = new CuentaDAO();
        Cuenta cuenta = cuentaDAO.obtenerPorCredenciales(usuario, contraseña);

        if (cuenta != null) {

            HttpSession session = request.getSession();
            session.setAttribute("usuarioLogueado", cuenta); 

            if (cuenta.getCorreoElectronico() != null && cuenta.getCorreoElectronico().endsWith("@zero.com")) {

                response.sendRedirect("admin_dashboard.jsp"); 
            } else {

                response.sendRedirect("catalogo.jsp"); 
            }
        } else {

            request.setAttribute("errorLogin", "Usuario o contraseña incorrectos.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("iniciar_sesion.jsp");
            dispatcher.forward(request, response);
        }
    }
}