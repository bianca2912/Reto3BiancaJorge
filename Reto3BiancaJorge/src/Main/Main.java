package Main;

import java.util.Scanner;

import ClasesDAO.CategoriasDAO;
import ClasesDAO.ClientesDAO;
import ClasesDAO.PedidosDAO;
import ClasesDAO.ProductosDAO;
import ClasesPK.Categorias;
import ClasesPK.Clientes;
import ClasesPK.Pedidos;
import ClasesPK.Productos;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int numero=0,submenu=0,submenu2=0,submenu3=0,submenu4=0,submenu5=0;
		do {
			try {
				menu();
				numero=FuncionesPK.Funciones.dimeEntero("Elige un menu", sc);
				switch (numero) {
				case 1:
					do {
						try {
							subMenuMantenimiento();
							submenu=FuncionesPK.Funciones.dimeEntero("Elige un submenu", sc);
							switch (submenu) {
							case 1:
								System.out.println("Nueva categoria");
							 	String n=sc.nextLine();
								Categorias ca=new Categorias(n);
								CategoriasDAO.insertarCategoria(ca);
								break;
							case 2:
								int idC=FuncionesPK.Funciones.dimeEntero("idC", sc);
								System.out.println("nombCategoria");
								String nomb=sc.nextLine();
								double precio=FuncionesPK.Funciones.dimeDouble("precio", sc);
								System.out.println("desc,color,talla");
								String desc=sc.nextLine();
								String color=sc.nextLine();
								String talla=sc.nextLine();
								int stock=FuncionesPK.Funciones.dimeEntero("stock", sc);
								
								
								Productos p=new Productos(idC,nomb,precio,desc,color,talla,stock);
								ProductosDAO.insertarProducto(p);
								break;
							case 3:
								do {
									try {
										subMenu2Mantenimiento();
										submenu2=FuncionesPK.Funciones.dimeEntero("Elige otro submenu", sc);
										switch (submenu2) {
										case 1:
											System.out.println("nombre, direccion ");
											String nombC=sc.nextLine();
											String dirC=sc.nextLine();
											int instC=FuncionesPK.Funciones.dimeEntero("codigo", sc);
											
											Clientes c=new Clientes(nombC, dirC, instC);
											ClientesDAO.insertarCliente(c);
											break;
										case 2:
											
											int codC=FuncionesPK.Funciones.dimeEntero("codigo", sc);
											
											ClientesDAO.buscarClientePorCodigo(codC);
											break;

										}
										if (submenu2==0) {
											System.out.println("Has salido del submenu");
											break;
										}
									} catch (Exception e) {
										e.printStackTrace();
									}
								} while (submenu>0 && submenu<3);
								break;
							}
							if (submenu==0) {
								System.out.println("Has salido del submenu");
								break;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					} while (numero>0 && numero<4);					
						break;
				case 2:
					do {
						try {
							subMenuProductos();
							submenu3=FuncionesPK.Funciones.dimeEntero("Elige un submenu", sc);
							switch (submenu3) {
							case 1:
								System.out.println("submenu221");
								break;
							case 2:
								System.out.println("submenu222");
								break;

							}
							if (submenu3==0) {
								System.out.println("Has salido del submenu");
								break;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					} while (submenu3>0 && submenu3<3);		
					break;
				case 3:
					do {
						try {
							subMenuPedidos();
							submenu4=FuncionesPK.Funciones.dimeEntero("Elige un submenu", sc);
							switch (submenu4) {
							case 1:
								System.out.println("submenu333");
								break;
							case 2:
								System.out.println("submenu334");
								break;

							}
							if (submenu4==0) {
								System.out.println("Has salido del submenu");
								break;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					} while (submenu4>0 && submenu4<3);	
					break;
				case 4:
					do {
						try {
							subMenuInformes();
							submenu5=FuncionesPK.Funciones.dimeEntero("Elige un submenu", sc);
							switch (submenu5) {
							case 1:
								System.out.println("submenu444");
								break;
							case 2:
								System.out.println("submenu4445");
								break;
							case 3:
								System.out.println("submenu4446");
								break;

							}
							if (submenu5==0) {
								System.out.println("Has salido del submenu");
								break;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					} while (submenu5>0 && submenu5<4);	
					break;
				}
				if (numero==0) {
					System.out.println("Has salido del menu");
					break;
				}
				errorMenu(numero);
			} catch (Exception e) {
				e.printStackTrace();
				
			}
			
			
		} while (numero>0 && numero<5);	
		
	
	 	


		
		
		
	/*	ClientesDao
	 * 
	 * 
		System.out.println("nombre, direccion, codigo");
		String nombreC=sc.nextLine();
		String direccionC=sc.nextLine();
		int codigoC=sc.nextInt();
		ClientesDAO.insertarCliente(nombreC, direccionC, codigoC);
	*/
	/*
	 * MIRAR
	 * 
		System.out.println("idCliente, direccionEnvio, preciototal");
		int idC=sc.nextInt();
		String direccionE=sc.nextLine();
		double precioTotal=sc.nextDouble();
		PedidosDAO.crearPedido(null, null);
	*/
	/*	
		System.out.println("nombreProducto");
		String nombreP=sc.nextLine();
		ProductosDAO.buscarProductoPorNombre(nombreP);
		*/
	/*	
		System.out.println("nombre, talla, color");
		String nombreP=sc.nextLine();
		String tallaP=sc.nextLine();
		String colorP=sc.nextLine();
		ProductosDAO.buscarProductosConFiltros(nombreP, tallaP, colorP);
		*/
	}
	public static void menu() {
		System.out.println("1. Mantenimientos \n2. Catalogo de Productos \n3. Pedidos \n4. Informes \n0. Salir");
	}
	public static void subMenuMantenimiento() {
		System.out.println("1.1 Gestion de Categorias \n1.2 Gestion de Productos \n1.3.Gestion de Clientes \n0. Salir");
	}
	public static void subMenu2Mantenimiento() {
		System.out.println("1.3.1 Alta de nuevos Clientes \n1.3.2 Busqueda de Codigo \n0. Salir");
	}
	public static void subMenuProductos() {
		System.out.println("2.1 Listar productos \n2.2 Buscar productos \n0. Salir");
	}
	public static void subMenuPedidos() {
		System.out.println("3.1 Crear pedidos \n2.2 Ver pedidos \n0. Salir");
	}
	public static void subMenuInformes() {
		System.out.println("4.1 Bajo Stock \n4.2 Pedidos por cliente \n4.3 Producto mas vendido \n0. Salir");
	}
	public static void errorMenu(int numero) {
		if (!(numero>0 && numero<5)) {
			System.out.println("El numero no coincide con el menu");
		}
	}
	

}
