/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import modelo.Producto;
import util.Conexion; 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author NANA
 */
public class ProductoDAO {

    public ProductoDAO() {
    }


    public boolean insertar(Producto producto) {
        Connection con = null;
        PreparedStatement ps = null;

        String sql = "INSERT INTO producto (nombre, unidades, precio, capacidad_almacenamiento, "
                   + "ram, memoria_gpu, modelo, nucleos_cpu, nucleos_gpu, arquitectura, "
                   + "descripcion, marca_id, tipo_id, imagen) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 

        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);

            int i = 1; 
            ps.setString(i++, producto.getNombre());
            ps.setInt(i++, producto.getCantidadDisponible()); 
            ps.setDouble(i++, producto.getPrecio());
            ps.setInt(i++, producto.getCapacidadAlmacenamiento());
            ps.setInt(i++, producto.getRam());
            ps.setInt(i++, producto.getMemoriaGpu());
            ps.setString(i++, producto.getModelo());
            ps.setInt(i++, producto.getNucleosCpu());
            ps.setInt(i++, producto.getNucleosGpu());
            ps.setString(i++, producto.getArquitectura());
            ps.setString(i++, producto.getDescripcion());
            ps.setInt(i++, producto.getMarcaId());
            ps.setInt(i++, producto.getTipoId());
            ps.setString(i++, producto.getImagen());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar producto: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            Conexion.close(ps);
            Conexion.close(con);
        }
    }


    public List<Producto> obtenerTodos() throws SQLException {
        List<Producto> productos = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;

        String sql = "SELECT id, nombre, unidades, precio, capacidad_almacenamiento, "
                   + "ram, memoria_gpu, modelo, nucleos_cpu, nucleos_gpu, arquitectura, "
                   + "descripcion, marca_id, tipo_id, imagen FROM producto";
        return null;
    }
}
    



