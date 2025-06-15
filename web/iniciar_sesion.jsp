<%--
    Document   : iniciar_sesion
    Created on : 12/04/2025, 11:48:05 a. m.
    Author     : NANA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ZERO - Iniciar Sesión</title>
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
                <a href="carrito.jsp"><img src="img/carrito_icon.png" alt="Carrito"> <span>0</span></a>
                <a href="crear_cuenta.jsp">Crea tu cuenta</a> 
            </div>
        </nav>
    </header>

    <main class="login-container">
        <div class="login-imagen">
            <img src="img/imagen_compania.jpg" alt="Imagen de la compañía"> 
        </div>
        <div class="login-box">
            <h1>Iniciar Sesión</h1>
            
            <%
                String mensajeRegistro = (String) session.getAttribute("mensajeRegistro");
                if (mensajeRegistro != null && !mensajeRegistro.isEmpty()) { 
            %>
                <div style="color: green; text-align: center; margin-bottom: 10px; padding: 5px; border: 1px solid green; background-color: #e6ffe6; border-radius: 5px;">
                    <%= mensajeRegistro %>
                </div>
            <%
                    session.removeAttribute("mensajeRegistro"); 
                }
            %>

            <%
                String mensajeRestablecimientoExito = (String) request.getAttribute("mensajeExito");
                if (mensajeRestablecimientoExito != null && !mensajeRestablecimientoExito.isEmpty()) {
            %>
                <div style="color: green; text-align: center; margin-bottom: 10px; padding: 5px; border: 1px solid green; background-color: #e6ffe6; border-radius: 5px;">
                    <%= mensajeRestablecimientoExito %>
                </div>
            <%
                }
            %>
            
            <form action="LoginServlet" method="post"> 
                <div class="form-group">
                    <label for="usuario">Usuario:</label>
                    <input type="text" id="usuario" name="usuario" required>
                </div>
                <div class="form-group">
                    <label for="contrasena">Contraseña:</label>
                    <input type="password" id="contrasena" name="contraseña" required>
                </div>
                <button type="submit">Entrar</button>

                <p class="login-links">
                    <a href="RestablecerContrasenaServlet">¿Has olvidado la contraseña?</a>
                    <br>
                    <span>¿No tiene cuenta? <a href="crear_cuenta.jsp">Regístrese</a></span>
                </p>
            </form>

            <%
                String errorLogin = (String) request.getAttribute("errorLogin");
                if (errorLogin != null && !errorLogin.isEmpty()) {
            %>
                <p style="color: red; text-align: center; margin-top: 10px;"><%= errorLogin %></p>
            <%
                }
            %>
        </div>
    </main>
</body>
</html>