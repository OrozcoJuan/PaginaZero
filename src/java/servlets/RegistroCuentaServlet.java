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
import java.sql.Date;

/**
 *
 * @author NANA
 */
@WebServlet("/RegistroCuentaServlet")
public class RegistroCuentaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cuenta cuenta = new Cuenta();
        cuenta.setUsuario(request.getParameter("usuario"));
        cuenta.setContraseña(request.getParameter("contraseña"));
        cuenta.setPrimerNombre(request.getParameter("primer_nombre"));
        cuenta.setSegundoNombre(request.getParameter("segundo_nombre"));
        cuenta.setPrimerApellido(request.getParameter("primer_apellido"));
        cuenta.setSegundoApellido(request.getParameter("segundo_apellido"));
        cuenta.setIdentificacion(request.getParameter("identificacion"));
        

        String fechaNacimientoStr = request.getParameter("fecha_nacimiento");
        if (fechaNacimientoStr != null && !fechaNacimientoStr.isEmpty()) {
            try {
                cuenta.setFechaNacimiento(Date.valueOf(fechaNacimientoStr));
            } catch (IllegalArgumentException e) {

                System.err.println("Formato de fecha de nacimiento inválido: " + fechaNacimientoStr);

                return; 
            }
        } else {

            cuenta.setFechaNacimiento(null); 
        }

        cuenta.setTelefono(request.getParameter("telefono"));
        cuenta.setCorreoElectronico(request.getParameter("correo_electronico"));
        cuenta.setPais(request.getParameter("pais"));
        cuenta.setCiudad(request.getParameter("ciudad"));
        cuenta.setDireccion(request.getParameter("direccion"));

        CuentaDAO cuentaDAO = new CuentaDAO();
        boolean registrado = cuentaDAO.insertar(cuenta); 

        if (registrado) {

            request.getSession().setAttribute("mensajeRegistro", "¡Cuenta registrada con éxito! Por favor, inicia sesión.");
            response.sendRedirect("iniciar_sesion.jsp"); 
        } else {

            request.setAttribute("errorRegistro", "No se pudo registrar la cuenta. Intente con otro usuario/correo.");
            request.getRequestDispatcher("crear_cuenta.jsp").forward(request, response);
        }
    }
}