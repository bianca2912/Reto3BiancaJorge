package ClasesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

}
