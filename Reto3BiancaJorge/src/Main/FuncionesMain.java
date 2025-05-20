package Main;

import java.util.Scanner;

import ClasesDAO.CategoriasDAO;
import ClasesDAO.ClientesDAO;
import ClasesDAO.ProductosDAO;
import ClasesPK.Categorias;
import ClasesPK.Clientes;
import ClasesPK.Productos;

public class FuncionesMain {
	
	public static void menuMantenimientos(Scanner sc) {
	    int opcion = -1;

	    while (opcion != 0) {
	        System.out.println("\n MANTENIMIENTO \n1. Gestión de categorías \n2. Gestión de productos \n3. Gestión de clientes \n0. Atras");
	        System.out.print("Opcion: ");
	        opcion = dimeEntero(sc);

	        switch (opcion) {
	            case 1:
	                insertarCategoria(sc);
	                break;
	            case 2:
	                insertarProducto(sc);
	                break;
	            case 3:
	                menuGestionClientes(sc);
	                break;
	        }
	    }
	}
	
	public static void insertarCategoria(Scanner sc) {
	    System.out.print("Introduce el nombre de la nueva categoria: ");
	    String nombre = sc.nextLine();

	    Categorias nueva = new Categorias(nombre);
	    CategoriasDAO.insertarCategoria(nueva);
	}

	public static void insertarProducto(Scanner sc) {
		int idC=FuncionesPK.Funciones.dimeEntero("idC", sc);
		System.out.println("nombCategoria");
		String nomb=sc.nextLine();
		double precio=FuncionesPK.Funciones.dimeDouble("precio", sc);
		System.out.println("descripcion");
		String desc=sc.nextLine();
		System.out.println("color");
		String color=sc.nextLine();
		System.out.println("talla");
		String talla=sc.nextLine();
		int stock=FuncionesPK.Funciones.dimeEntero("stock", sc);
		
		
		Productos p=new Productos(idC,nomb,precio,desc,color,talla,stock);
		ProductosDAO.insertarProducto(p);
	}

	public static void menuGestionClientes(Scanner sc) {
	    int opcion = -1;

	    while (opcion != 0) {
	        System.out.println("\n GESTION DE CLIENTES  \n1.Alta de nuevo cliente \n2.Buscar cliente por codigo y modificar \n0. Atras");
	        System.out.print("Opcion: ");
	        opcion = dimeEntero(sc);

	        switch (opcion) {
	            case 1:
	                altaCliente(sc);
	                break;
	            case 2:
	                modificarClientePorCodigo(sc);
	                break;
	        }
	    }
	}

	public static void altaCliente(Scanner sc) {
	    System.out.print("Nombre: ");
	    String nombre = sc.nextLine();
	    System.out.print("Direccion: ");
	    String direccion = sc.nextLine();
	    System.out.print("Codigo: ");
	    int codigo = dimeEntero(sc);

	    Clientes nuevo = new Clientes(nombre, direccion, codigo);
	    ClientesDAO.insertarCliente(nuevo);
	}

	
	public static void modificarClientePorCodigo(Scanner sc) {
	    System.out.print("Introduce el código del cliente: ");
	    int codigo = dimeEntero(sc);

	    Clientes cliente = ClientesDAO.buscarClientePorCodigo(codigo);

	    if (cliente == null) {
	        System.out.println("No se encontro ningun cliente con ese codigo.");
	        return;
	    }

	    System.out.println("Cliente actual:");
	    System.out.println("Nombre: " + cliente.getNombre());
	    System.out.println("Dirección: " + cliente.getDireccion());
	    System.out.println("Codigo: " + cliente.getCodigo());

	    System.out.print("Nuevo nombre: ");
	    String nuevoNombre = sc.nextLine();
	    System.out.print("Nueva dirección: ");
	    String nuevaDireccion = sc.nextLine();
	    System.out.print("Nuevo codigo: ");
	    int nuevoCodigo = dimeEntero(sc);

	    cliente.setNombre(nuevoNombre);
	    cliente.setDireccion(nuevaDireccion);
	    cliente.setCodigo(nuevoCodigo);

	    ClientesDAO.buscarYModificarCliente(cliente);
	}
	
	public static int dimeEntero(Scanner sc) {
	    int num = 0;
	    boolean valido = false;
	    while (!valido) {
	        try {
	            num = Integer.parseInt(sc.nextLine());
	            valido = true;
	        } catch (NumberFormatException e) {
	            System.out.print("Introduce un numero valido: ");
	        }
	    }
	    return num;
	}


		
}

