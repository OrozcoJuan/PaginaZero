/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.CuentaDAO;
import modelo.Cuenta;
/**
 *
 * @author NANA
 */
@WebServlet("/RestablecerContrasenaServlet")
public class RestablecerContrasenaServlet extends HttpServlet {

    private CuentaDAO cuentaDAO = new CuentaDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("olvidar_contrasena.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usernameOrEmail = request.getParameter("username_email");
        String newPassword = request.getParameter("new_password");
        String confirmPassword = request.getParameter("confirm_password");

        if (usernameOrEmail == null || usernameOrEmail.trim().isEmpty() ||
            newPassword == null || newPassword.trim().isEmpty() ||
            confirmPassword == null || confirmPassword.trim().isEmpty()) {
            request.setAttribute("mensajeError", "Todos los campos son obligatorios.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("olvidar_contrasena.jsp");
            dispatcher.forward(request, response);
            return;
        }

        if (!newPassword.equals(confirmPassword)) {
            request.setAttribute("mensajeError", "La nueva contraseña y la confirmación no coinciden.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("olvidar_contrasena.jsp");
            dispatcher.forward(request, response);
            return;
        }

        if (newPassword.length() < 6) { 
            request.setAttribute("mensajeError", "La nueva contraseña debe tener al menos 6 caracteres.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("olvidar_contrasena.jsp");
            dispatcher.forward(request, response);
            return;
        }


        Cuenta cuenta = null;
        if (usernameOrEmail.contains("@")) { 
            cuenta = cuentaDAO.obtenerPorCorreo(usernameOrEmail);
        } else { 
            cuenta = cuentaDAO.obtenerPorUsuario(usernameOrEmail);
        }

        if (cuenta == null) {
            request.setAttribute("mensajeError", "Usuario o correo electrónico no encontrado.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("olvidar_contrasena.jsp");
            dispatcher.forward(request, response);
            return;
        }


        try {

            boolean exito = cuentaDAO.actualizarContrasena(cuenta.getId(), newPassword);

            if (exito) {

                request.setAttribute("mensajeExito", "¡Contraseña restablecida con éxito! Ya puedes iniciar sesión.");

                RequestDispatcher dispatcher = request.getRequestDispatcher("iniciar_sesion.jsp");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("mensajeError", "No se pudo restablecer la contraseña. Inténtalo de nuevo.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("olvidar_contrasena.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Excepción al intentar restablecer contraseña: " + e.getMessage());
            request.setAttribute("mensajeError", "Ocurrió un error interno al restablecer la contraseña. Por favor, inténtalo más tarde.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("olvidar_contrasena.jsp");
            dispatcher.forward(request, response);
        }
    }
}