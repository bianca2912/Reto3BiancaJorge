package ClasesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ClasesPK.Productos;
import Conexion.Conexion;

public class ProductosDAO {
    public static void insertarProducto(String nombre, String talla, String color, int stock, double precio, int idCategoria,String descripcion) {
        String sql = "INSERT INTO productos (nombre, talla, color, stock, precio, idCategoria, descripcion) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nombre);
            stmt.setString(2, talla);
            stmt.setString(3, color);
            stmt.setInt(4, stock);
            stmt.setDouble(5, precio);
            stmt.setInt(6, idCategoria);
            stmt.setString(7, descripcion);

            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("Producto insertado correctamente.");
            } else {
                System.out.println("No se pudo insertar el producto.");
            }

        } catch (SQLException e) {
            System.out.println("Error al insertar producto.");
            e.printStackTrace();
        }
    }

    public static void listarPorCategoria(int idCategoria) {
        String sql = "SELECT * FROM producto WHERE idCategoria = ?";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idCategoria);
            ResultSet rs = stmt.executeQuery();

            boolean hayResultados = false;
            while (rs.next()) {
                hayResultados = true;
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Talla: " + rs.getString("talla"));
                System.out.println("Color: " + rs.getString("color"));
                System.out.println("Stock: " + rs.getInt("stock"));
                System.out.println("Precio: " + rs.getDouble("precio"));
                System.out.println("Descripcion: " + rs.getString("descripcion"));
                System.out.println("-------------");
            }

            if (!hayResultados) {
                System.out.println("No hay productos en esta categoria.");
            }

        } catch (SQLException e) {
            System.out.println("Error al listar productos.");
            e.printStackTrace();
        }
    }

    public static void buscarProductosConFiltros(String nombre, String talla, String color) {
        StringBuilder sql = new StringBuilder("SELECT * FROM producto WHERE 1=1");

        if (!nombre.isEmpty()) sql.append(" AND nombre LIKE ?");
        if (!talla.isEmpty()) sql.append(" AND talla = ?");
        if (!color.isEmpty()) sql.append(" AND color = ?");

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql.toString())) {

            int index = 1;
            if (!nombre.isEmpty()) stmt.setString(index++, "%" + nombre + "%");
            if (!talla.isEmpty()) stmt.setString(index++, talla);
            if (!color.isEmpty()) stmt.setString(index++, color);

            ResultSet rs = stmt.executeQuery();

            boolean hayResultados = false;
            while (rs.next()) {
                hayResultados = true;
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Talla: " + rs.getString("talla"));
                System.out.println("Color: " + rs.getString("color"));
                System.out.println("Stock: " + rs.getInt("stock"));
                System.out.println("Precio: " + rs.getDouble("precio"));
                System.out.println("Descripcion: " + rs.getString("descripcion"));
                System.out.println("-------------");
            }

            if (!hayResultados) {
                System.out.println("No se encontraron productos con esos filtros.");
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar productos.");
            e.printStackTrace();
        }
    }
    
    public static Productos buscarProductoPorNombre(String nombre) {
        Productos producto = null;
        String sql = "SELECT * FROM productos WHERE nombre LIKE ? LIMIT 1";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + nombre + "%");
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                producto = new Productos(
                    rs.getInt("id"),                   
                    rs.getInt("idCategoria"),           
                    rs.getString("nombre"),             
                    rs.getDouble("precio"),            
                    rs.getString("descripcion"),       
                    rs.getString("color"),             
                    rs.getString("talla"),            
                    rs.getInt("stock")                
                );
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar producto por nombre.");
            e.printStackTrace();
        }

        return producto;
    }
}
