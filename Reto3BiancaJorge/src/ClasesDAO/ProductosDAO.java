package ClasesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ClasesPK.Productos;
import Conexion.Conexion;

public class ProductosDAO {
	public static void insertarProducto(Productos producto) {
	    String sql = "INSERT INTO producto (idCategoria, nombre, precio, descripcion, color, talla, stock) VALUES (?, ?, ?, ?, ?, ?, ?)";

	    try (Connection conn = Conexion.conectar();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setInt(1, producto.getIdCategoria());
	        stmt.setString(2, producto.getNombre());
	        stmt.setDouble(3, producto.getPrecio());
	        stmt.setString(4, producto.getDescripcion());
	        stmt.setString(5, producto.getColor());
	        stmt.setString(6, producto.getTalla());
	        stmt.setInt(7, producto.getStock());

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

	public static ArrayList<Productos> listarPorCategoria(int idCategoria) {
	    ArrayList<Productos> lista = new ArrayList<>();
	    String sql = "SELECT * FROM producto WHERE idCategoria = ?";

	    try (Connection conn = Conexion.conectar();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setInt(1, idCategoria);
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            Productos p = new Productos(
	                rs.getInt("id"),
	                rs.getInt("idCategoria"),
	                rs.getString("nombre"),
	                rs.getDouble("precio"),
	                rs.getString("descripcion"),
	                rs.getString("color"),
	                rs.getString("talla"),
	                rs.getInt("stock")
	            );
	            lista.add(p);
	        }

	    } catch (SQLException e) {
	        System.out.println("Error al listar productos por categor�a.");
	        e.printStackTrace();
	    }
	    return lista;

	}

	public static ArrayList<Productos> buscarProductosConFiltros(String nombre, String talla, String color) {
	    ArrayList<Productos> lista = new ArrayList<>();
	    StringBuilder sql = new StringBuilder("SELECT * FROM productos WHERE 1=1");

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

	        while (rs.next()) {
	            Productos p = new Productos(
	                rs.getInt("idProducto"),
	                rs.getInt("idCategoria"),
	                rs.getString("nombre"),
	                rs.getDouble("precio"),
	                rs.getString("descripcion"),
	                rs.getString("color"),
	                rs.getString("talla"),
	                rs.getInt("stock")
	            );
	            lista.add(p);
	        }

	    } catch (SQLException e) {
	        System.out.println("Error al buscar productos con filtros.");
	        e.printStackTrace();
	    }

	    return lista;
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
                    rs.getInt("idproducto"),                   
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
