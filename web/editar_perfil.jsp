<%-- 
    Document   : editar_perfil
    Created on : 14/04/2025, 8:41:01 p. m.
    Author     : NANA
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Cuenta"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ZERO - Editar Perfil</title>
    <link rel="stylesheet" href="css/estilos.css">
</head>
<body>
    <header>
        <nav>
            <div class="logo">
                <a href="catalogo.jsp"><img src="img/logo_zero.png" alt="ZERO Logo"></a>
                <span>ZERO</span>
            </div>
            <ul class="nav-links">
                <li><a href="catalogo.jsp">Inicio</a></li>
                <li><a href="#">¿Quiénes somos?</a></li>
                <li><a href="#">Ayuda</a></li>
            </ul>
            <div class="user-actions">
                <a href="carrito.jsp"><img src="img/carrito_icon.png" alt="Carrito"> </a>
                <%
                    Cuenta usuarioLogueado = (Cuenta) session.getAttribute("usuarioLogueado");
                    if (usuarioLogueado != null) {
                %>
                    <a href="perfil_cuenta.jsp" class="active"><img src="img/user_icon.png" alt="Usuario"> <%= usuarioLogueado.getUsuario() %></a>
                    <a href="LogoutServlet">Cerrar Sesión</a>
                <% } else { %>
                    <a href="iniciar_sesion.jsp">Iniciar Sesión</a>
                <% } %>
            </div>
        </nav>
    </header>

    <main class="editar-perfil-container">
        <h1>Editar Mi Perfil</h1>

        <%
            Cuenta usuarioParaEditar = (Cuenta) session.getAttribute("usuarioLogueado");

            String mensajeExito = (String) request.getAttribute("mensajeExito");
            String mensajeError = (String) request.getAttribute("mensajeError");

            if (mensajeExito != null) {
        %>
                <div class="mensaje-exito"><%= mensajeExito %></div>
        <%
            }
            if (mensajeError != null) {
        %>
                <div class="mensaje-error"><%= mensajeError %></div>
        <%
            }

            if (usuarioParaEditar != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String fechaNacimientoFormato = (usuarioParaEditar.getFechaNacimiento() != null) ? sdf.format(usuarioParaEditar.getFechaNacimiento()) : "";
        %>
        <form action="ActualizarCuentaServlet" method="post">
            <div class="form-grid">
                <div class="form-group">
                    <label for="usuario">Usuario:</label>
                    <input type="text" id="usuario" name="usuario" value="<%= usuarioParaEditar.getUsuario() %>" required readonly>
                </div>
                <div class="form-group">
                    <label for="correo_electronico">Correo Electrónico:</label>
                    <input type="email" id="correo_electronico" name="correo_electronico" value="<%= usuarioParaEditar.getCorreoElectronico() != null ? usuarioParaEditar.getCorreoElectronico() : "" %>" required>
                </div>
                <div class="form-group">
                    <label for="primer_nombre">Primer Nombre:</label>
                    <input type="text" id="primer_nombre" name="primer_nombre" value="<%= usuarioParaEditar.getPrimerNombre() != null ? usuarioParaEditar.getPrimerNombre() : "" %>" required>
                </div>
                <div class="form-group">
                    <label for="segundo_nombre">Segundo Nombre:</label>
                    <input type="text" id="segundo_nombre" name="segundo_nombre" value="<%= usuarioParaEditar.getSegundoNombre() != null ? usuarioParaEditar.getSegundoNombre() : "" %>">
                </div>
                <div class="form-group">
                    <label for="primer_apellido">Primer Apellido:</label>
                    <input type="text" id="primer_apellido" name="primer_apellido" value="<%= usuarioParaEditar.getPrimerApellido() != null ? usuarioParaEditar.getPrimerApellido() : "" %>" required>
                </div>
                <div class="form-group">
                    <label for="segundo_apellido">Segundo Apellido:</label>
                    <input type="text" id="segundo_apellido" name="segundo_apellido" value="<%= usuarioParaEditar.getSegundoApellido() != null ? usuarioParaEditar.getSegundoApellido() : "" %>">
                </div>
                <div class="form-group">
                    <label for="identificacion">Identificación:</label>
                    <input type="text" id="identificacion" name="identificacion" value="<%= usuarioParaEditar.getIdentificacion() != null ? usuarioParaEditar.getIdentificacion() : "" %>">
                </div>
                <div class="form-group">
                    <label for="fecha_nacimiento">Fecha de Nacimiento:</label>
                    <input type="date" id="fecha_nacimiento" name="fecha_nacimiento" value="<%= fechaNacimientoFormato %>">
                </div>
                <div class="form-group">
                    <label for="telefono">Teléfono:</label>
                    <input type="tel" id="telefono" name="telefono" value="<%= usuarioParaEditar.getTelefono() != null ? usuarioParaEditar.getTelefono() : "" %>">
                </div>
                <div class="form-group">
                    <label for="pais">País:</label>
                    <input type="text" id="pais" name="pais" value="<%= usuarioParaEditar.getPais() != null ? usuarioParaEditar.getPais() : "" %>">
                </div>
                <div class="form-group">
                    <label for="ciudad">Ciudad:</label>
                    <input type="text" id="ciudad" name="ciudad" value="<%= usuarioParaEditar.getCiudad() != null ? usuarioParaEditar.getCiudad() : "" %>">
                </div>
                <div class="form-group">
                    <label for="direccion">Dirección:</label>
                    <input type="text" id="direccion" name="direccion" value="<%= usuarioParaEditar.getDireccion() != null ? usuarioParaEditar.getDireccion() : "" %>">
                </div>
            </div>

            <div class="form-actions">
                <button type="submit" class="btn-guardar">Guardar Cambios</button>
                <button type="button" class="btn-cancelar" onclick="location.href='perfil_cuenta.jsp'">Cancelar</button>
            </div>
        </form>
        <%
            } else {
        %>
            <p class="mensaje-error">No hay una sesión de usuario activa para editar.</p>
            <p style="text-align: center;"><a href="iniciar_sesion.jsp">Inicia sesión aquí</a>.</p>
        <%
            }
        %>
    </main>
</body>
</html>