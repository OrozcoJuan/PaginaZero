/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import java.util.*;
import modelo.Cuenta;
import util.Conexion;

/**
 *
 * @author NANA
 */
public class CuentaDAO {

    public CuentaDAO() {

    }

    public Cuenta obtenerPorCredenciales(String usuario, String contraseña) {
        Cuenta cuenta = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM cuenta WHERE usuario = ? AND contraseña = ?";
        try {
            con = Conexion.getConexion();
            stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2, contraseña);
            rs = stmt.executeQuery();
            if (rs.next()) {
                cuenta = mapearCuenta(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener cuenta por credenciales: " + e.getMessage());
            e.printStackTrace();
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return cuenta;
    }


    public boolean insertar(Cuenta cuenta) {
        Connection con = null;
        PreparedStatement stmt = null;
        String sql = "INSERT INTO cuenta (usuario, contraseña, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, identificacion, fecha_nacimiento, telefono, correo_electronico, pais, ciudad, direccion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            con = Conexion.getConexion();
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cuenta.getUsuario());
            stmt.setString(2, cuenta.getContraseña());
            stmt.setString(3, cuenta.getPrimerNombre());
            stmt.setString(4, cuenta.getSegundoNombre());
            stmt.setString(5, cuenta.getPrimerApellido());
            stmt.setString(6, cuenta.getSegundoApellido());
            stmt.setString(7, cuenta.getIdentificacion());

            if (cuenta.getFechaNacimiento() != null) {
                stmt.setDate(8, new java.sql.Date(cuenta.getFechaNacimiento().getTime()));
            } else {
                stmt.setNull(8, java.sql.Types.DATE);
            }

            stmt.setString(9, cuenta.getTelefono());
            stmt.setString(10, cuenta.getCorreoElectronico());
            stmt.setString(11, cuenta.getPais());
            stmt.setString(12, cuenta.getCiudad());
            stmt.setString(13, cuenta.getDireccion());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar cuenta: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            Conexion.close(stmt);
            Conexion.close(con);
        }
    }

    public List<Cuenta> obtenerTodos() {
        List<Cuenta> cuentas = new ArrayList<>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM cuenta";
        try {
            con = Conexion.getConexion();
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                cuentas.add(mapearCuenta(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener todas las cuentas: " + e.getMessage());
            e.printStackTrace();
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return cuentas;
    }


    public boolean actualizar(Cuenta cuenta) {
        Connection con = null;
        PreparedStatement stmt = null;
        String sql = "UPDATE cuenta SET primer_nombre=?, segundo_nombre=?, primer_apellido=?, segundo_apellido=?, " +
                     "identificacion=?, fecha_nacimiento=?, telefono=?, correo_electronico=?, pais=?, ciudad=?, direccion=? " +
                     "WHERE id=?";

        try {
            con = Conexion.getConexion();
            stmt = con.prepareStatement(sql);

            stmt.setString(1, cuenta.getPrimerNombre());
            stmt.setString(2, cuenta.getSegundoNombre());
            stmt.setString(3, cuenta.getPrimerApellido());
            stmt.setString(4, cuenta.getSegundoApellido());
            stmt.setString(5, cuenta.getIdentificacion());

            if (cuenta.getFechaNacimiento() != null) {
                stmt.setDate(6, new java.sql.Date(cuenta.getFechaNacimiento().getTime()));
            } else {
                stmt.setNull(6, java.sql.Types.DATE);
            }

            stmt.setString(7, cuenta.getTelefono());
            stmt.setString(8, cuenta.getCorreoElectronico());
            stmt.setString(9, cuenta.getPais());
            stmt.setString(10, cuenta.getCiudad());
            stmt.setString(11, cuenta.getDireccion());
            stmt.setInt(12, cuenta.getId());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar la cuenta: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            Conexion.close(stmt);
            Conexion.close(con);
        }
    }

    public boolean eliminar(int id) {
        Connection con = null;
        PreparedStatement stmt = null;
        String sql = "DELETE FROM cuenta WHERE id = ?";
        try {
            con = Conexion.getConexion();
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar cuenta: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            Conexion.close(stmt);
            Conexion.close(con);
        }
    }

    public Cuenta obtenerPorId(int id) {
        Cuenta cuenta = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM cuenta WHERE id = ?";
        try {
            con = Conexion.getConexion();
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                cuenta = mapearCuenta(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener cuenta por ID: " + e.getMessage());
            e.printStackTrace();
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return cuenta;
    }

    private Cuenta mapearCuenta(ResultSet rs) throws SQLException {
        Cuenta cuenta = new Cuenta();
        cuenta.setId(rs.getInt("id"));
        cuenta.setUsuario(rs.getString("usuario"));
        cuenta.setContraseña(rs.getString("contraseña"));
        cuenta.setPrimerNombre(rs.getString("primer_nombre"));
        cuenta.setSegundoNombre(rs.getString("segundo_nombre"));
        cuenta.setPrimerApellido(rs.getString("primer_apellido"));
        cuenta.setSegundoApellido(rs.getString("segundo_apellido"));
        cuenta.setIdentificacion(rs.getString("identificacion"));


        java.sql.Date sqlDate = rs.getDate("fecha_nacimiento");
        cuenta.setFechaNacimiento(sqlDate != null ? new java.util.Date(sqlDate.getTime()) : null);

        cuenta.setTelefono(rs.getString("telefono"));
        cuenta.setCorreoElectronico(rs.getString("correo_electronico"));
        cuenta.setPais(rs.getString("pais"));
        cuenta.setCiudad(rs.getString("ciudad"));
        cuenta.setDireccion(rs.getString("direccion"));
        return cuenta;
    }

    public boolean actualizarContrasena(int id, String nuevaContrasena) {
        Connection con = null;
        PreparedStatement ps = null;
        boolean filasAfectadas = false;

        String sql = "UPDATE cuenta SET contraseña = ? WHERE id = ?";

        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, nuevaContrasena);
            ps.setInt(2, id);

            int rowsAffected = ps.executeUpdate();
            filasAfectadas = (rowsAffected > 0);

            if (filasAfectadas) {
                System.out.println("DEBUG: Contraseña actualizada correctamente en la BD para ID: " + id);
            } else {
                System.out.println("DEBUG: No se encontró la cuenta con ID: " + id + " o la contraseña no fue actualizada.");
            }

        } catch (SQLException e) {
            System.err.println("Error al actualizar la contraseña: " + e.getMessage());
            e.printStackTrace();
        } finally {
            Conexion.close(ps);
            Conexion.close(con);
        }
        return filasAfectadas;
    }

    public Cuenta obtenerPorUsuario(String usuario) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Cuenta cuenta = null;

        String sql = "SELECT * FROM cuenta WHERE usuario = ?";

        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            rs = ps.executeQuery();

            if (rs.next()) {
                cuenta = mapearCuenta(rs);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener cuenta por usuario: " + e.getMessage());
            e.printStackTrace();
        } finally {
            Conexion.close(rs);
            Conexion.close(ps);
            Conexion.close(con);
        }
        return cuenta;
    }

    public Cuenta obtenerPorCorreo(String correo) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Cuenta cuenta = null;

        String sql = "SELECT * FROM cuenta WHERE correo_electronico = ?";

        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            rs = ps.executeQuery();

            if (rs.next()) {
                cuenta = mapearCuenta(rs);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener cuenta por correo: " + e.getMessage());
            e.printStackTrace();
        } finally {
            Conexion.close(rs);
            Conexion.close(ps);
            Conexion.close(con);
        }
        return cuenta;
    }
}