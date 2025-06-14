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
@WebServlet("/ActualizarCuentaServlet")
public class ActualizarCuentaServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cuenta usuarioLogueado = (Cuenta) session.getAttribute("usuarioLogueado");

        if (usuarioLogueado == null) {

            response.sendRedirect("iniciar_sesion.jsp");
            return;
        }


        String usuario = request.getParameter("usuario"); 
        String correoElectronico = request.getParameter("correo_electronico");
        String primerNombre = request.getParameter("primer_nombre");
        String segundoNombre = request.getParameter("segundo_nombre");
        String primerApellido = request.getParameter("primer_apellido");
        String segundoApellido = request.getParameter("segundo_apellido");
        String identificacion = request.getParameter("identificacion");
        String telefono = request.getParameter("telefono");
        String pais = request.getParameter("pais");
        String ciudad = request.getParameter("ciudad");
        String direccion = request.getParameter("direccion");

        Date fechaNacimiento = null;
        String fechaNacimientoStr = request.getParameter("fecha_nacimiento");
        if (fechaNacimientoStr != null && !fechaNacimientoStr.isEmpty()) {
            try {
                fechaNacimiento = Date.valueOf(fechaNacimientoStr);
            } catch (IllegalArgumentException e) {

                request.setAttribute("mensajeError", "Formato de fecha de nacimiento inválido.");
                request.getRequestDispatcher("editar_perfil.jsp").forward(request, response);
                System.err.println("Error de formato de fecha: " + e.getMessage());
                return;
            }
        }
        
        usuarioLogueado.setCorreoElectronico(correoElectronico);
        usuarioLogueado.setPrimerNombre(primerNombre);
        usuarioLogueado.setSegundoNombre(segundoNombre);
        usuarioLogueado.setPrimerApellido(primerApellido);
        usuarioLogueado.setSegundoApellido(segundoApellido);
        usuarioLogueado.setIdentificacion(identificacion);
        usuarioLogueado.setFechaNacimiento(fechaNacimiento);
        usuarioLogueado.setTelefono(telefono);
        usuarioLogueado.setPais(pais);
        usuarioLogueado.setCiudad(ciudad);
        usuarioLogueado.setDireccion(direccion);

        CuentaDAO cuentaDAO = new CuentaDAO();
        boolean actualizado = cuentaDAO.actualizar(usuarioLogueado); 
        if (actualizado) {

            session.setAttribute("usuarioLogueado", usuarioLogueado);
            request.setAttribute("mensajeExito", "¡Perfil actualizado con éxito!");

            request.getRequestDispatcher("perfil_cuenta.jsp").forward(request, response);
        } else {

            request.setAttribute("mensajeError", "Error al actualizar el perfil. Inténtalo de nuevo.");
            request.getRequestDispatcher("editar_perfil.jsp").forward(request, response);
        }
    }
}