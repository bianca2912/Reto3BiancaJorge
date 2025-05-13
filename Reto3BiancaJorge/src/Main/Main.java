package Main;

import java.util.Scanner;

import ClasesDAO.CategoriasDAO;
import ClasesDAO.ProductosDAO;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int numero=0;
		do {
			try {
				menu();
				numero=FuncionesPK.Funciones.dimeEntero("Elige un menu", sc);
				switch (numero) {
				case 1:
					System.out.println("1");
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
	 * System.out.println("Nueva categoria");
		String n=sc.nextLine();
		CategoriasDAO.insertarCategoria(n);
	*/
		System.out.println("nombre, talla, color, stock, precio, idCategoria");
		String nomb=sc.nextLine();
		String talla=sc.nextLine();
		String color=sc.nextLine();
		int stock=sc.nextInt();
		double precio=sc.nextDouble();
		int id=sc.nextInt();
		ProductosDAO.insertarProducto(nomb, talla, color, stock, precio, id);
		//nombre, talla, color, stock, precio, idCategoria

	}
	public static void menu() {
		System.out.println("1. Mantenimientos \n2. Catalogo de Productos \n3. Pedidos \n4. Informes \n0. Salir");
	}
	public static void subMenuMantenimiento() {
		System.out.println("1. Mantenimientos \n2. Catalogo de Productos \n3. Pedidos \n4. Informes \n0. Salir");
	}
	public static void errorMenu(int numero) {
		if (!(numero>0 && numero<5)) {
			System.out.println("El numero no coincide con el menu");
		}
	}
	

}
