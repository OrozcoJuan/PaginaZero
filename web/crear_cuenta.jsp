<%-- 
    Document   : crear_cuenta
    Created on : 12/04/2025, 8:33:21 a. m.
    Author     : NANA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ZERO - Crea tu cuenta</title>
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
                <a href="iniciar_sesion.jsp">Iniciar Sesión</a> 
            </div>
        </nav>
    </header>

    <main class="registro-container">
        <div class="registro-box">
            <h1>Crea tu cuenta</h1>
            <form action="RegistroCuentaServlet" method="post">
                <div class="form-row">
                    <div class="form-group">
                        <label for="usuario">Usuario:</label>
                        <input type="text" id="usuario" name="usuario" required>
                    </div>
                    <div class="form-group">
                        <label for="contrasena">Nueva contraseña:</label>
                        <input type="password" id="contrasena" name="contraseña" required>
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group">
                        <label for="confirma_contrasena">Confirma contraseña:</label>
                        <input type="password" id="confirma_contrasena" name="confirma_contrasena" required> 
                    </div>
                    <div class="form-group">
                        <label for="correo_electronico">Correo Electrónico:</label>
                        <input type="email" id="correo_electronico" name="correo_electronico" required>
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group">
                        <label for="primer_nombre">Primer Nombre:</label>
                        <input type="text" id="primer_nombre" name="primer_nombre" required>
                    </div>
                    <div class="form-group">
                        <label for="segundo_nombre">Segundo Nombre:</label>
                        <input type="text" id="segundo_nombre" name="segundo_nombre">
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group">
                        <label for="primer_apellido">Primer Apellido:</label>
                        <input type="text" id="primer_apellido" name="primer_apellido" required>
                    </div>
                    <div class="form-group">
                        <label for="segundo_apellido">Segundo Apellido:</label>
                        <input type="text" id="segundo_apellido" name="segundo_apellido">
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group">
                        <label for="identificacion">Identificación:</label>
                        <input type="text" id="identificacion" name="identificacion">
                    </div>
                    <div class="form-group">
                        <label for="fecha_nacimiento">Fecha de Nacimiento:</label>
                        <input type="date" id="fecha_nacimiento" name="fecha_nacimiento">
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group">
                        <label for="telefono">Teléfono:</label>
                        <input type="tel" id="telefono" name="telefono">
                    </div>
                    <div class="form-group">
                        <label for="pais">País:</label>
                        <input type="text" id="pais" name="pais">
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group">
                        <label for="ciudad">Ciudad:</label>
                        <input type="text" id="ciudad" name="ciudad">
                    </div>
                    <div class="form-group">
                        <label for="direccion">Dirección:</label>
                        <input type="text" id="direccion" name="direccion">
                    </div>
                </div>

                <button type="submit">Registrarse</button>
            </form>
            <p><a href="#">¿Hubo problemas? Envía su queja</a></p>
        </div>
    </main>

</body>
</html>
