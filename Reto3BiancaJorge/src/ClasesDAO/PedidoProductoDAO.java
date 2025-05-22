package ClasesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ClasesPK.PedidoProducto;
import Conexion.Conexion;

public class PedidoProductoDAO {

    public static void insertarProductoPedido(int idPedido, PedidoProducto pp) {
        String sqlDetalle = "INSERT INTO pedidoproducto (idPedido, idProducto, unidades, precio) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sqlDetalle)) {

            stmt.setInt(1, idPedido);
            stmt.setInt(2, pp.getIdProducto());
            stmt.setInt(3, pp.getUnidades());
            stmt.setDouble(4, pp.getPrecio());
            stmt.executeUpdate();

            String sqlStock = "UPDATE productos SET stock = stock - ? WHERE idproducto = ?";
            try (PreparedStatement stmtStock = conn.prepareStatement(sqlStock)) {
                stmtStock.setInt(1, pp.getUnidades());
                stmtStock.setInt(2, pp.getIdProducto());
                stmtStock.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println("Error al insertar producto en pedido.");
            e.printStackTrace();
        }
    }
}
