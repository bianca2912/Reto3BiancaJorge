package Conexion;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

public class Conexion {
	    public static Connection conectar() {
	        try {
	            Connection conn = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/tienda", "izquierdo", "izquierdo");
	            return conn;
	        } catch (SQLException e) {
	            System.out.println("Error de conexión");
	            e.printStackTrace();
	            return null;
	        }
	    }
	}


