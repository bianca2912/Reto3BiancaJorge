package ClasesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ClasesPK.PedidoProducto;
import ClasesPK.Pedidos;
import Conexion.Conexion;

public class PedidosDAO {

    public static Pedidos crearPedido(Pedidos pedido, ArrayList<PedidoProducto> productos) {
        Connection conn = null;
        PreparedStatement stmtPedido = null;
        PreparedStatement stmtDetalle = null;

        try {
            conn = Conexion.conectar();

            // Insertar pedido
            String sqlPedido = "INSERT INTO pedidos (idCliente, preciototal,direccionEnvio,  fecha) VALUES (?, ?, ?, NOW())";
            stmtPedido = conn.prepareStatement(sqlPedido, Statement.RETURN_GENERATED_KEYS);
            stmtPedido.setInt(1, pedido.getIdCliente());
            stmtPedido.setDouble(2, pedido.getPrecioTotal());
            stmtPedido.setString(3, pedido.getDireccionEnvio());            
            stmtPedido.executeUpdate();

            ResultSet rs = stmtPedido.getGeneratedKeys();
            int idPedido = -1;
            if (rs.next()) {
                pedido.setIdPedido( rs.getInt(1));
            }
            return pedido;

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
    

    
    public static ArrayList<String> verPedidosDelMes() {
        ArrayList<String> lista = new ArrayList<>();
        String sql =
            "SELECT p.id, p.fecha, c.nombre AS cliente, p.preciototal, p.direccionEnvio, " +
            "cat.nombre AS categoria, prod.nombre AS producto, pp.unidades " +
            "FROM pedidos p " +
            "JOIN clientes c ON p.idCliente = c.id " +
            "JOIN pedidoproducto pp ON pp.idPedido = p.id " +
            "JOIN productos prod ON prod.idproducto = pp.idProducto " +
            "JOIN categorias cat ON cat.idCategoria = prod.idCategoria " +
            "WHERE MONTH(p.fecha) = MONTH(CURDATE()) AND YEAR(p.fecha) = YEAR(CURDATE()) " +
            "ORDER BY p.fecha DESC";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            int ultimoPedido = -1;
            String infoPedido = "";

            while (rs.next()) {
                int pedidoId = rs.getInt("id");

                if (pedidoId != ultimoPedido) {
                    if (!infoPedido.isEmpty()) {
                        lista.add(infoPedido);
                        infoPedido = "";
                    }

                    infoPedido += "Fecha: " + rs.getString("fecha") + "\n";
                    infoPedido += "Cliente: " + rs.getString("cliente") + "\n";
                    infoPedido += "Precio total: " + rs.getDouble("preciototal") + " €\n";
                    infoPedido += "Direccion envio: " + rs.getString("direccionEnvio") + "\n";
                }

                infoPedido += "- Producto: " + rs.getString("producto");
                infoPedido += " | Categoria: " + rs.getString("categoria");
                infoPedido += " | Unidades: " + rs.getInt("unidades") + "\n";

                ultimoPedido = pedidoId;
            }

            if (!infoPedido.isEmpty()) {
                lista.add(infoPedido);
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar pedidos del mes.");
            e.printStackTrace();
        }

        return lista;
    }

}
