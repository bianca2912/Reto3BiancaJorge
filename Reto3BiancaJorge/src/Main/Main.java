package Main;

import java.util.Scanner;

import ClasesDAO.CategoriasDAO;
import ClasesDAO.ProductosDAO;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int numero=0,submenu=0,submenu2=0;
		do {
			try {
				menu();
				numero=FuncionesPK.Funciones.dimeEntero("Elige un menu", sc);
				switch (numero) {
				case 1:
					do {
						try {
							subMenuMantenimiento();
							submenu=FuncionesPK.Funciones.dimeEntero("Elige otro menu", sc);
							switch (submenu) {
							case 1:
								System.out.println("submenu1");
								break;
							case 2:
								System.out.println("submenu2");
								break;
							case 3:
								do {
									try {
										subMenu2Mantenimiento();
										submenu2=FuncionesPK.Funciones.dimeEntero("Elige otro menu", sc);
										switch (submenu2) {
										case 1:
											System.out.println("submenu21");
											break;
										case 2:
											System.out.println("submenu22");
											break;

										}
										if (submenu2==0) {
											System.out.println("Has salido del menu");
											break;
										}
									} catch (Exception e) {
										e.printStackTrace();
									}
								} while (numero>0 && numero<3);
								break;
							}
							if (submenu==0) {
								System.out.println("Has salido del menu");
								break;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					} while (numero>0 && numero<4);
					
					
					
					break;
				case 2:
					System.out.println("2");		
					break;
				case 3:
					System.out.println("3");
					break;
				case 4:
					System.out.println("4");
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
		
	/*	CategoriasDao
	 * 
	 	System.out.println("Nueva categoria");
		String n=sc.nextLine();
		CategoriasDAO.insertarCategoria(n);
	*/
		
	/*	ProductosDao
	 * 
		System.out.println("nombre, talla, color, stock, precio, idCategoria,desc");
		String nomb=sc.nextLine();
		String talla=sc.nextLine();
		String color=sc.nextLine();
		int stock=sc.nextInt();
		double precio=sc.nextDouble();
		int id=sc.nextInt();
		String desc=sc.nextLine();
		ProductosDAO.insertarProducto(nomb, talla, color, stock, precio, id,desc);
		//nombre, talla, color, stock, precio, idCategoria
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
	public static void errorMenu(int numero) {
		if (!(numero>0 && numero<5)) {
			System.out.println("El numero no coincide con el menu");
		}
	}
	

}
