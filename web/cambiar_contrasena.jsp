<%--
    Document   : cambiar_contrasena
    Created on : 07/04/2025, 8:48:20 p. m. 
    Author     : NANA
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ZERO - Cambiar Contraseña</title>
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
                <%
                    modelo.Cuenta usuarioLogueado = (modelo.Cuenta) session.getAttribute("usuarioLogueado");
                    if (usuarioLogueado != null) {
                %>
                    <a href="perfil_cuenta.jsp" class="active"><img src="img/user_icon.png" alt="Usuario"> <%= usuarioLogueado.getUsuario() %></a>
                    <a href="LogoutServlet">Cerrar Sesión</a>
                <% } else { %>
                    <a href="crear_cuenta.jsp">Crea tu cuenta</a>
                <% } %>
            </div>
        </nav>
    </header>
    <main class="login-container">
        <div class="login-box">
            <h1>Cambiar Contraseña</h1>

            <% String mensajeError = (String) request.getAttribute("mensajeError"); %>
            <% String mensajeExito = (String) request.getAttribute("mensajeExito"); %>

            <% if (mensajeError != null) { %>
                <div class="mensaje-error" style="color: red; text-align: center; margin-bottom: 10px;"><%= mensajeError %></div>
            <% } %>
            <% if (mensajeExito != null) { %>
                <div class="mensaje-exito" style="color: green; text-align: center; margin-bottom: 10px;"><%= mensajeExito %></div>
            <% } %>

            <form action="CambiarContrasenaServlet" method="post">
                <div class="form-group">
                    <label for="current_password">Contraseña Actual:</label>
                    <input type="password" id="current_password" name="current_password" required>
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
                    <button type="submit">Cambiar Contraseña</button>
                    <button type="button" class="btn-cancelar" onclick="location.href='perfil_cuenta.jsp'">Cancelar</button>
                </div>
            </form>
        </div>
    </main>

    </body>
</html>