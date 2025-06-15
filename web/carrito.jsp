<%--
    Document   : carrito
    Created on : 05/04/2025, 8:30:00 p. m.
    Author     : NANA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Cuenta" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ZERO - Mi Carrito</title>
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

    <main class="carrito-container">
        <h1>Mi Carrito de Compras</h1>

        <table class="carrito-table">
            <thead>
                <tr>
                    <th>Producto</th>
                    <th>Cantidad</th>
                    <th>Precio Unitario</th>
                    <th>Subtotal</th>
                    <th>Acción</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <img src="img/productos/ssd_ejemplo.jpg" alt="SSD Ejemplo">
                        SSD NVMe 1TB UltraFast
                    </td>
                    <td>1</td>
                    <td>$120.000</td>
                    <td>$120.000</td>
                    <td>
                        <button class="btn-vaciar" onclick="alert('Eliminar item - (No funcional sin Servlet)')">Eliminar</button>
                    </td>
                </tr>
                <tr>
                    <td>
                        <img src="img/productos/ram_ejemplo.jpg" alt="RAM Ejemplo">
                        Memoria RAM DDR4 16GB
                    </td>
                    <td>2</td>
                    <td>$80.000</td>
                    <td>$160.000</td>
                    <td>
                        <button class="btn-vaciar" onclick="alert('Eliminar item - (No funcional sin Servlet)')">Eliminar</button>
                    </td>
                </tr>

            </tbody>
        </table>

        <div class="total-section">
            Total: $280.000 
        </div>

        <div class="acciones-carrito">
            <button class="btn-continuar" onclick="location.href='catalogo.jsp'">Seguir Comprando</button>
            <button class="btn-checkout" onclick="alert('Funcionalidad de pago no implementada')">Proceder al Pago</button>
            <button class="btn-vaciar" onclick="alert('Vaciar Carrito - (No funcional sin Servlet)')">Vaciar Carrito</button>
        </div>
    </main>

</body>
</html>
