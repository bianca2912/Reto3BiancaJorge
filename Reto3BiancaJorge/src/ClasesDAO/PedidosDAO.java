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

    public static void crearPedido(Pedidos pedido, ArrayList<PedidoProducto> productos) {
        Connection conn = null;
        PreparedStatement stmtPedido = null;

        try {
            conn = Conexion.conectar();

            // Imprimir ID cliente para depuración
            System.out.println("ID cliente usado para el pedido: " + pedido.getIdCliente());

            // Insertar pedido
            String sqlPedido = "INSERT INTO pedidos (idcliente, preciototal, direccionEnvio, fecha) VALUES (?, ?, ?, NOW())";
            stmtPedido = conn.prepareStatement(sqlPedido, Statement.RETURN_GENERATED_KEYS);
            stmtPedido.setInt(1, pedido.getIdCliente());
            stmtPedido.setDouble(2, pedido.getPrecioTotal());
            stmtPedido.setString(3, pedido.getDireccionEnvio());
            stmtPedido.executeUpdate();

            ResultSet rs = stmtPedido.getGeneratedKeys();
            int idPedido = -1;
            if (rs.next()) {
                idPedido = rs.getInt(1);
                pedido.setIdPedido(idPedido);
            }

            for (PedidoProducto pp : productos) {
                PedidoProductoDAO.insertarProductoPedido(idPedido, pp);
            }

            System.out.println("Pedido guardado correctamente.");

        } catch (Exception e) {
            System.out.println("Error al guardar el pedido.");
            e.printStackTrace();

        } finally {
            try {
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
            "JOIN clientes c ON p.idcliente = c.idcliente " +
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
