<%-- 
    Document   : catalogo
    Created on : 31/03/2025, 1:45:18 p. m.
    Author     : NANA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Cuenta" %>     

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ZERO - Catálogo de Productos</title>
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
                <li><a href="catalogo.jsp" class="active">Inicio</a></li>
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

    <main class="catalogo-container">
        <div class="top-controls">
            <div class="filter-search">
                <select class="filter-dropdown">
                    <option value="">Filtro</option>
                    <option value="marca1">Memorias</option>
                    <option value="tipo1">SSD</option>
                    <option value="tipo1">HDD</option>
                </select>
                <div class="search-box">
                    <input type="text" placeholder="search">
                    <button><img src="img/search_icon.png" alt="Buscar"></button>
                </div>
            </div>
            <div class="sort-dropdown">
                <select name="sortOrder">
                    <option value="relevante">Relevante</option>
                    <option value="precio_asc">De menor a mayor (Precios)</option>
                    <option value="precio_desc">De mayor a menor (Precios)</option>
                    <option value="nuevos">Productos nuevos</option>
                    <option value="antiguos">Productos antiguos</option>
                </select>
            </div>
        </div>

        <div class="pagination">
            <a href="#">&lt;</a>
            <a href="#" class="active">1</a>
            <a href="#">2</a>
            <a href="#">3</a>
            <a href="#">&gt;</a>
        </div>
    </main>

</body>
</html>
