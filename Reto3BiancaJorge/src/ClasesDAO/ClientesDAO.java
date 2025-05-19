package ClasesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ClasesPK.Clientes;
import Conexion.Conexion;

public class ClientesDAO {

	    public static void insertarCliente(Clientes cliente) {
	        String sql = "INSERT INTO clientes (nombre, direccion, codigo) VALUES (?, ?, ?)";

	        try (Connection conn = Conexion.conectar();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {

	            stmt.setString(1, cliente.getNombre());
	            stmt.setString(2, cliente.getDireccion());
	            stmt.setInt(3, cliente.getCodigo());

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

	    public static void buscarYModificarCliente(Clientes cliente) {
	        String sqlBuscar = "SELECT * FROM clientes WHERE id = ?";

	        try (Connection conn = Conexion.conectar();
	             PreparedStatement stmt = conn.prepareStatement(sqlBuscar)) {

	            stmt.setInt(1, cliente.getIdCliente());
	            ResultSet rs = stmt.executeQuery();

	            if (rs.next()) {
	                String sqlUpdate = "UPDATE clientes SET nombre = ?, direccion = ?, codigo = ? WHERE id = ?";
	                try (PreparedStatement stmtUpdate = conn.prepareStatement(sqlUpdate)) {
	                    stmtUpdate.setString(1, cliente.getNombre());
	                    stmtUpdate.setString(2, cliente.getDireccion());
	                    stmtUpdate.setInt(3, cliente.getCodigo());
	                    stmtUpdate.setInt(4, cliente.getIdCliente());

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
	            System.out.println("Error al buscar o modificar cliente.");
	            e.printStackTrace();
	        }
	    }
	    
	    public static Clientes buscarClientePorCodigo(int codigo) {
	        Clientes cliente = null;
	        String sql = "SELECT * FROM clientes WHERE codigo = ?";

	        try (Connection conn = Conexion.conectar();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {

	            stmt.setInt(1, codigo);
	            ResultSet rs = stmt.executeQuery();

	            if (rs.next()) {
	                cliente = new Clientes(
	                    rs.getString("nombre"),
	                    rs.getString("direccion"),
	                    rs.getInt("codigo")
	                );
	            }

	        } catch (SQLException e) {
	            System.out.println("Error al buscar cliente por codigo.");
	            e.printStackTrace();
	        }

	        return cliente;
	    }

	}