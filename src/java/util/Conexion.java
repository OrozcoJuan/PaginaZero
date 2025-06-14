/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.SQLException;
/**
 *
 * @author NANA
 */
public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/zero";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "123456"; 
    private static Connection conexion;

    public static Connection getConexion() {
        if (conexion == null) {
            try {

                Class.forName("com.mysql.cj.jdbc.Driver");

                conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
                System.out.println("Conexión a la base de datos establecida correctamente.");
            } catch (ClassNotFoundException e) {
                System.err.println("Error: Driver JDBC de MySQL no encontrado.");
                e.printStackTrace();
            } catch (SQLException e) {
                System.err.println("Error al conectar a la base de datos: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return conexion;
    }

    public static void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar ResultSet: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public static void close(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar PreparedStatement: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection con) {
        if (con != null) {
            try {
                con.close();
                conexion = null; 
            } catch (SQLException e) {
                System.err.println("Error al cerrar Connection: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}