/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import dao.ProductoDAO;
import modelo.Producto;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NANA
 */
@WebServlet(name = "CatalogoServlet", urlPatterns = {"/CatalogoServlet"})
public class CatalogoServlet extends HttpServlet {
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     try {
         ProductoDAO productoDAO = new ProductoDAO();
         
         List<Producto> productos = productoDAO.obtenerTodos(); 
         
         request.setAttribute("productos", productos);

         RequestDispatcher dispatcher = request.getRequestDispatcher("/catalogo.jsp");
         dispatcher.forward(request, response);
     } catch (SQLException ex) {
         Logger.getLogger(CatalogoServlet.class.getName()).log(Level.SEVERE, null, ex);
     }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response); 
    }
}
