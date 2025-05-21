package Main;

import java.util.ArrayList;
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
	        System.out.println("\n GESTION DE CLIENTES \n1.Alta de nuevo cliente \n2.Buscar cliente por codigo y modificar \n0. Atras");
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

	    if (cliente != null) {
	    	 System.out.println("Cliente actual:");
	  	    System.out.println("Nombre: " + cliente.getNombre());
	  	    System.out.println("Dirección: " + cliente.getDireccion());
	  	    System.out.println("Codigo: " + cliente.getCodigo());
	    }else {
	        System.out.println("No se encontro ningun cliente con ese codigo.");
	    	System.out.print("Nuevo nombre: ");
		    String nuevoNombre = sc.nextLine();
		    System.out.print("Nueva direccion: ");
		    String nuevaDireccion = sc.nextLine();
		    System.out.print("Nuevo codigo: ");
		    int nuevoCodigo = dimeEntero(sc);
		    
		    Clientes nuevo = new Clientes(nuevoNombre, nuevaDireccion, nuevoCodigo);
		    ClientesDAO.insertarCliente(nuevo);
	    }
 
	    
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

	public static void menuCatalogo(Scanner sc) {
	    int opcion = -1;

	    while (opcion != 0) {
	        System.out.println("\nCATÁLOGO DE PRODUCTOS");
	        System.out.println("1. Listar productos por categoria");
	        System.out.println("2. Buscar productos por nombre, talla y color");
	        System.out.println("0. Atras");
	        System.out.print("Elige opcion: ");
	        opcion = dimeEntero(sc);

	        switch (opcion) {
	            case 1:
	                listarProductosPorCategoria(sc);
	                break;
	            case 2:
	                buscarProductosPorFiltros(sc);
	                break;
	        }
	    }
	}
	
	
	public static void listarProductosPorCategoria(Scanner sc) {
	    ArrayList<Categorias> categorias = CategoriasDAO.listarCategorias();

	    if (categorias.isEmpty()) {
	        System.out.println("No hay categorias registradas.");
	        return;
	    }

	    System.out.println("Categorias disponibles:");
	    for (Categorias c : categorias) {
	        System.out.println(c.getIdCategoria() + " - " + c.getNombre());
	    }

	    System.out.print("Introduce el ID de la categoria: ");
	    int idCategoria = dimeEntero(sc);

	    ArrayList<Productos> productos = ProductosDAO.listarPorCategoria(idCategoria);

	    if (productos.isEmpty()) {
	        System.out.println("No hay productos en esta categoria.");
	        return;
	    }

	    System.out.println("\nProductos de la categoria:");
	    for (Productos p : productos) {
	        System.out.println("Nombre: " + p.getNombre());
	        System.out.println("Precio: " + p.getPrecio());
	        System.out.println("Descripcion: " + p.getDescripcion());
	        System.out.println("Color: " + p.getColor());
	        System.out.println("Talla: " + p.getTalla());
	        System.out.println("Stock: " + p.getStock());
	        System.out.println("------------");
	    }
	}


	public static void buscarProductosPorFiltros(Scanner sc) {
	    System.out.print("Nombre (puede dejarse vacio): ");
	    String nombre = sc.nextLine();
	    System.out.print("Talla (puede dejarse vacia): ");
	    String talla = sc.nextLine();
	    System.out.print("Color (puede dejarse vacio): ");
	    String color = sc.nextLine();

	    ArrayList<Productos> productos = ProductosDAO.buscarProductosConFiltros(nombre, talla, color);

	    if (productos.isEmpty()) {
	        System.out.println("No se encontraron productos con esos filtros.");
	        return;
	    }

	    for (Productos p : productos) {
	        System.out.println("Nombre: " + p.getNombre());
	        System.out.println("Precio: " + p.getPrecio());
	        System.out.println("Descripcion: " + p.getDescripcion());
	        System.out.println("Color: " + p.getColor());
	        System.out.println("Talla: " + p.getTalla());
	        System.out.println("Stock: " + p.getStock());

	        Categorias cat = CategoriasDAO.buscarCategoriaPorId(p.getIdCategoria());
	        if (cat != null) {
	            System.out.println("Categoría: " + cat.getNombre());
	        }
	        System.out.println("------------");
	    }
	}

		
}

