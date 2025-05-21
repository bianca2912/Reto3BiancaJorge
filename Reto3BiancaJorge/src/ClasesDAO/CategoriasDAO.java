package ClasesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import ClasesPK.Categorias;
import Conexion.Conexion;

public class CategoriasDAO {

	public static void insertarCategoria(Categorias categoria) {
        String sql = "INSERT INTO categorias (nombre) VALUES (?)";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, categoria.getNombre());
            int filas = stmt.executeUpdate();

            if (filas > 0) {
                System.out.println("Categoria insertada correctamente.");
            } else {
                System.out.println("No se pudo insertar la categoria.");
            }

        } catch (SQLException e) {
            System.out.println("Error al insertar categoria.");
            e.printStackTrace();
        }   
    }
	
	public static ArrayList<Categorias> listarCategorias() {
	    ArrayList<Categorias> lista = new ArrayList<>();
	    String sql = "SELECT * FROM categorias"; 
	    try (Connection conn = Conexion.conectar();
	         PreparedStatement stmt = conn.prepareStatement(sql);
	         ResultSet rs = stmt.executeQuery()) {

	        while (rs.next()) {
	            Categorias c = new Categorias(
	                rs.getString("nombre")
	            );
	            lista.add(c);
	        }

	    } catch (SQLException e) {
	        System.out.println("Error al listar categorías.");
	        e.printStackTrace();
	    }

	    return lista;
	}
	
	public static Categorias buscarCategoriaPorId(int id) {
	    Categorias categoria = null;
	    String sql = "SELECT * FROM categorias WHERE id = ?";

	    try (Connection conn = Conexion.conectar();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setInt(1, id);
	        ResultSet rs = stmt.executeQuery();

	        if (rs.next()) {
	            categoria = new Categorias(rs.getString("nombre"));
	        }

	    } catch (SQLException e) {
	        System.out.println("Error al buscar categoria.");
	        e.printStackTrace();
	    }

	    return categoria;
	}


}

