package ClasesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import Conexion.Conexion;

public class CategoriasDAO {

    public static void insertarCategoria() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el nombre de la nueva categoria: ");
        String nombre = sc.nextLine();
        
        if (nombre.isEmpty()) {
            System.out.println("El nombre no puede estar vacio.");
            return;
        }

        String sql = "INSERT INTO categoria (nombre) VALUES (?)";

        try (Connection conn = Conexion.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

               stmt.setString(1, nombre);
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
   
    
}

