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
        try {
            Connection conn = Conexion.conectar();

            // Insertar el pedido (tabla pedido)
            String sqlPedido = "INSERT INTO pedido (idCliente, direccionEnvio, total, fecha) VALUES (?, ?, ?, NOW())";
            PreparedStatement stmtPedido = conn.prepareStatement(sqlPedido, Statement.RETURN_GENERATED_KEYS);
            stmtPedido.setInt(1, pedido.getIdCliente());
            stmtPedido.setString(2, pedido.getDireccionEnvio());
            stmtPedido.setDouble(3, pedido.getPrecioTotal());
            stmtPedido.executeUpdate();

            ResultSet rs = stmtPedido.getGeneratedKeys();
            int idPedido = -1;
            if (rs.next()) {
                idPedido = rs.getInt(1);
            }

            // Insertar productos del pedido
            String sqlDetalle = "INSERT INTO pedido_producto (idPedido, idProducto, cantidad, precioUnidad) VALUES (?, ?, ?, ?)";
            PreparedStatement stmtDetalle = conn.prepareStatement(sqlDetalle);

            for (ClasesPK.PedidoProducto pp : productos) {
                stmtDetalle.setInt(1, idPedido);
                stmtDetalle.setInt(2, pp.getIdProducto());
                stmtDetalle.setInt(3, pp.getUnidades());
                stmtDetalle.setDouble(4, pp.getPrecio());
                stmtDetalle.executeUpdate();

                // Actualizar stock del producto
                String sqlStock = "UPDATE producto SET stock = stock - ? WHERE id = ?";
                PreparedStatement stmtStock = conn.prepareStatement(sqlStock);
                stmtStock.setInt(1, pp.getUnidades());
                stmtStock.setInt(2, pp.getIdProducto());
                stmtStock.executeUpdate();
                stmtStock.close();
            }

            stmtDetalle.close();
            stmtPedido.close();
            conn.close();

            System.out.println("Pedido guardado correctamente con total: " + pedido.getPrecioTotal() + "€");

        } catch (Exception e) {
            System.out.println("Error al guardar el pedido.");
            e.printStackTrace();
        }
    }
}