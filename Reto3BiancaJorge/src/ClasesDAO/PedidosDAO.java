package ClasesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import ClasesPK.PedidoProducto;
import ClasesPK.Pedidos;
import Conexion.Conexion;

public class PedidosDAO {

    public static void crearPedido(Pedidos pedido, ArrayList<PedidoProducto> productos) {
        Connection conn = null;
        PreparedStatement stmtPedido = null;
        PreparedStatement stmtDetalle = null;

        try {
            conn = Conexion.conectar();

            // Insertar pedido
            String sqlPedido = "INSERT INTO pedidos (idCliente, direccionEnvio, preciototal, fecha) VALUES (?, ?, ?, NOW())";
            stmtPedido = conn.prepareStatement(sqlPedido, Statement.RETURN_GENERATED_KEYS);
            stmtPedido.setInt(1, pedido.getIdCliente());
            stmtPedido.setString(2, pedido.getDireccionEnvio());
            stmtPedido.setDouble(3, pedido.getPrecioTotal());
            stmtPedido.executeUpdate();

            ResultSet rs = stmtPedido.getGeneratedKeys();
            int idPedido = -1;
            if (rs.next()) {
                idPedido = rs.getInt(1);
            }

            // Insertar detalle del pedido
            String sqlDetalle = "INSERT INTO pedidoproducto (idPedido, idProducto, unidades, precio) VALUES (?, ?, ?, ?)";
            stmtDetalle = conn.prepareStatement(sqlDetalle);

            for (PedidoProducto pp : productos) {
                stmtDetalle.setInt(1, idPedido);
                stmtDetalle.setInt(2, pp.getIdProducto());
                stmtDetalle.setInt(3, pp.getUnidades());
                stmtDetalle.setDouble(4, pp.getPrecio());
                stmtDetalle.executeUpdate();

                // Actualizar stock
                String sqlStock = "UPDATE productos SET stock = stock - ? WHERE id = ?";
                try (PreparedStatement stmtStock = conn.prepareStatement(sqlStock)) {
                    stmtStock.setInt(1, pp.getUnidades());
                    stmtStock.setInt(2, pp.getIdProducto());
                    stmtStock.executeUpdate();
                }
            }

        } catch (Exception e) {
            System.out.println("Error al guardar el pedido.");
            e.printStackTrace();

        } finally {
            try {
                if (stmtDetalle != null) stmtDetalle.close();
                if (stmtPedido != null) stmtPedido.close();
                if (conn != null) conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
