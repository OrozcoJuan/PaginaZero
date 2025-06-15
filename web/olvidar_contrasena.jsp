<%--
    Document   : olvidar_contrasena
    Created on : 17/04/2025, 03:48:05 p. m.
    Author     : NANA
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ZERO - Olvidé Contraseña</title>
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
                <li><a href="#">Inicio</a></li>
                <li><a href="#">¿Quiénes somos?</a></li>
                <li><a href="#">Ayuda</a></li>
            </ul>
            <div class="user-actions">
                <a href="carrito.jsp"><img src="img/carrito_icon.png" alt="Carrito"> <span>0</span></a>
                <a href="crear_cuenta.jsp">Crea tu cuenta</a>
            </div>
        </nav>
    </header>
    <main class="login-container">
        <div class="login-box">
            <h1>Restablecer Contraseña</h1>

            <% String mensajeError = (String) request.getAttribute("mensajeError"); %>
            <% String mensajeExito = (String) request.getAttribute("mensajeExito"); %>

            <% if (mensajeError != null) { %>
                <div class="mensaje-error" style="color: red; text-align: center; margin-bottom: 10px;"><%= mensajeError %></div>
            <% } %>
            <% if (mensajeExito != null) { %>
                <div class="mensaje-exito" style="color: green; text-align: center; margin-bottom: 10px;"><%= mensajeExito %></div>
            <% } %>

            <form action="RestablecerContrasenaServlet" method="post">
                <p style="text-align: center; margin-bottom: 20px;">Por favor, ingresa tu nombre de usuario o correo electrónico para restablecer tu contraseña.</p>

                <div class="form-group">
                    <label for="username_email">Usuario o Correo Electrónico:</label>
                    <input type="text" id="username_email" name="username_email" required>
                </div>
                <div class="form-group">
                    <label for="new_password">Nueva Contraseña:</label>
                    <input type="password" id="new_password" name="new_password" required>
                </div>
                <div class="form-group">
                    <label for="confirm_password">Confirmar Nueva Contraseña:</label>
                    <input type="password" id="confirm_password" name="confirm_password" required>
                </div>
                <div class="form-actions">
                    <button type="submit">Restablecer Contraseña</button>
                    <button type="button" class="btn-cancelar" onclick="location.href='iniciar_sesion.jsp'">Cancelar</button>
                </div>
            </form>
        </div>
    </main>
    </body>
</html>