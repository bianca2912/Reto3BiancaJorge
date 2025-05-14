package ClasesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Conexion.Conexion;

public class ClientesDAO {

	  public static void insertarCliente(String nombre, String direccion, String email) {
	        if (nombre.isEmpty() || direccion.isEmpty() || email.isEmpty()) {
	            System.out.println("Los campos no pueden estar vacios.");
	            return;
	        }

	        String sql = "INSERT INTO cliente (nombre, direccion, email) VALUES (?, ?, ?)";

	        try (Connection conn = Conexion.conectar();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {

	            stmt.setString(1, nombre);
	            stmt.setString(2, direccion);
	            stmt.setString(3, email);

	            int filas = stmt.executeUpdate();

	            if (filas > 0) {
	                System.out.println("Cliente insertado correctamente.");
	            } else {
	                System.out.println("No se pudo insertar el cliente.");
	            }

	        } catch (SQLException e) {
	            System.out.println("Error al insertar cliente.");
	            e.printStackTrace();
	        }
	    }

	    public static void buscarYModificarCliente(int id, String nuevoNombre, String nuevaDireccion, String nuevoEmail) {
	        String sqlBuscar = "SELECT * FROM cliente WHERE id = ?";

	        try (Connection conn = Conexion.conectar();
	             PreparedStatement stmt = conn.prepareStatement(sqlBuscar)) {

	            stmt.setInt(1, id);
	            ResultSet rs = stmt.executeQuery();

	            if (rs.next()) {
	                String sqlUpdate = "UPDATE cliente SET nombre = ?, direccion = ?, email = ? WHERE id = ?";
	                try (PreparedStatement stmtUpdate = conn.prepareStatement(sqlUpdate)) {
	                    stmtUpdate.setString(1, nuevoNombre);
	                    stmtUpdate.setString(2, nuevaDireccion);
	                    stmtUpdate.setString(3, nuevoEmail);
	                    stmtUpdate.setInt(4, id);

	                    int filas = stmtUpdate.executeUpdate();
	                    if (filas > 0) {
	                        System.out.println("Cliente actualizado correctamente.");
	                    } else {
	                        System.out.println("No se pudo actualizar el cliente.");
	                    }
	                }

	            } else {
	                System.out.println("No se encontro ningun cliente con ese ID.");
	            }

	        } catch (SQLException e) {
	            System.out.println("Error al buscar/modificar cliente.");
	            e.printStackTrace();
	        }
	    }
	}
