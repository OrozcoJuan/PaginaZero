<%-- 
    Document   : perfil_cuenta
    Created on : 25/04/2025, 2:40:51 p. m.
    Author     : NANA
--%>

<%@page import="modelo.Cuenta"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ZERO - Mi Cuenta</title>
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
                <a href="carrito.jsp"><img src="img/carrito_icon.png" alt="Carrito">
                </a>
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

    <main class="perfil-container">
        <% if (usuarioLogueado != null) { %>
            <h1>Mi Perfil de Cuenta</h1>
            <div class="perfil-details-grid">
                <div class="detail-item">
                    <strong>Usuario:</strong> <span><%= usuarioLogueado.getUsuario() %></span>
                </div>
                <div class="detail-item">
                    <strong>Correo Electrónico:</strong> <span><%= usuarioLogueado.getCorreoElectronico() %></span>
                </div>
                <div class="detail-item">
                    <strong>Primer Nombre:</strong> <span><%= usuarioLogueado.getPrimerNombre() %></span>
                </div>
                <div class="detail-item">
                    <strong>Segundo Nombre:</strong> <span><%= usuarioLogueado.getSegundoNombre() != null ? usuarioLogueado.getSegundoNombre() : "N/A" %></span>
                </div>
                <div class="detail-item">
                    <strong>Primer Apellido:</strong> <span><%= usuarioLogueado.getPrimerApellido() %></span>
                </div>
                <div class="detail-item">
                    <strong>Segundo Apellido:</strong> <span><%= usuarioLogueado.getSegundoApellido() != null ? usuarioLogueado.getSegundoApellido() : "N/A" %></span>
                </div>
                <div class="detail-item">
                    <strong>Identificación:</strong> <span><%= usuarioLogueado.getIdentificacion() != null ? usuarioLogueado.getIdentificacion() : "N/A" %></span>
                </div>
                <div class="detail-item">
                    <strong>Fecha de Nacimiento:</strong> <span><%= usuarioLogueado.getFechaNacimiento() != null ? usuarioLogueado.getFechaNacimiento().toString() : "N/A" %></span>
                </div>
                <div class="detail-item">
                    <strong>Teléfono:</strong> <span><%= usuarioLogueado.getTelefono() != null ? usuarioLogueado.getTelefono() : "N/A" %></span>
                </div>
                <div class="detail-item">
                    <strong>País:</strong> <span><%= usuarioLogueado.getPais() != null ? usuarioLogueado.getPais() : "N/A" %></span>
                </div>
                <div class="detail-item">
                    <strong>Ciudad:</strong> <span><%= usuarioLogueado.getCiudad() != null ? usuarioLogueado.getCiudad() : "N/A" %></span>
                </div>
                <div class="detail-item">
                    <strong>Dirección:</strong> <span><%= usuarioLogueado.getDireccion() != null ? usuarioLogueado.getDireccion() : "N/A" %></span>
                </div>
            </div>
                <%
    String mensajeExito = request.getParameter("mensajeExito");
    if (mensajeExito != null && !mensajeExito.isEmpty()) {
        mensajeExito = java.net.URLDecoder.decode(mensajeExito, "UTF-8");
%>
    <div style="color: green; text-align: center; margin-top: 20px; font-weight: bold;">
        <%= mensajeExito %>
    </div>
<%
    }
%>
            <div class="perfil-actions">
                <button onclick="location.href='editar_perfil.jsp'">Editar Perfil</button> 
                <button onclick="location.href='cambiar_contrasena.jsp'">Cambiar Contraseña</button> 
            </div>
        <% } else { %>
            <p class="no-login-message">Por favor, <a href="iniciar_sesion.jsp">inicia sesión</a> para ver tu perfil.</p>
        <% } %>
    </main>
</body>
</html>
