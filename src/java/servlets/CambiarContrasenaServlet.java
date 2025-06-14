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
import jakarta.servlet.http.HttpSession;

import dao.CuentaDAO; 
import modelo.Cuenta; 
/**
 *
 * @author NANA
 */
@WebServlet("/CambiarContrasenaServlet")
public class CambiarContrasenaServlet extends HttpServlet {

    private CuentaDAO cuentaDAO = new CuentaDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("cambiar_contrasena.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Cuenta usuarioLogueado = (Cuenta) session.getAttribute("usuarioLogueado");

        if (usuarioLogueado == null) {
            response.sendRedirect("iniciar_sesion.jsp"); 
            return;
        }

        String currentPassword = request.getParameter("current_password");
        String newPassword = request.getParameter("new_password");
        String confirmPassword = request.getParameter("confirm_password");

        if (currentPassword == null || currentPassword.trim().isEmpty() ||
            newPassword == null || newPassword.trim().isEmpty() ||
            confirmPassword == null || confirmPassword.trim().isEmpty()) {
            request.setAttribute("mensajeError", "Todos los campos son obligatorios.");

            RequestDispatcher dispatcher = request.getRequestDispatcher("cambiar_contrasena.jsp");
            dispatcher.forward(request, response);
            return;
        }

        Cuenta cuentaEnDB = cuentaDAO.obtenerPorId(usuarioLogueado.getId()); 

        if (cuentaEnDB == null) {
            request.setAttribute("mensajeError", "Error al obtener la información de su cuenta.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("cambiar_contrasena.jsp");
            dispatcher.forward(request, response);
            return;
        }

        if (!currentPassword.equals(cuentaEnDB.getContraseña())) {
            request.setAttribute("mensajeError", "La contraseña actual es incorrecta.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("cambiar_contrasena.jsp");
            dispatcher.forward(request, response);
            return;
        }

        if (!newPassword.equals(confirmPassword)) {
            request.setAttribute("mensajeError", "La nueva contraseña y la confirmación no coinciden.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("cambiar_contrasena.jsp");
            dispatcher.forward(request, response);
            return;
        }
        
        if (newPassword.length() < 6) { 
            request.setAttribute("mensajeError", "La nueva contraseña debe tener al menos 6 caracteres.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("cambiar_contrasena.jsp");
            dispatcher.forward(request, response);
            return;
        }

        try {
            boolean exito = cuentaDAO.actualizarContrasena(usuarioLogueado.getId(), newPassword);

            if (exito) {

                usuarioLogueado.setContraseña(newPassword); 
                session.setAttribute("usuarioLogueado", usuarioLogueado);

                String mensaje = java.net.URLEncoder.encode("¡Contraseña cambiada con éxito!", "UTF-8");
                response.sendRedirect("perfil_cuenta.jsp?mensajeExito=" + mensaje);

            } else {
                request.setAttribute("mensajeError", "No se pudo cambiar la contraseña. Inténtalo de nuevo.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("cambiar_contrasena.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Excepción al intentar cambiar contraseña: " + e.getMessage());
            request.setAttribute("mensajeError", "Ocurrió un error interno al cambiar la contraseña. Por favor, inténtalo más tarde.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("cambiar_contrasena.jsp");
            dispatcher.forward(request, response);
        }
    }
}