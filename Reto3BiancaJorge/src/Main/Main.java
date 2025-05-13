package Main;

import java.util.Scanner;

import ClasesDAO.CategoriasDAO;

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
				if (numero==5) {
					System.out.println("Has salido del menu");
					break;
				}
				errorMenu(numero);
			} catch (Exception e) {
				e.printStackTrace();
				
			}
			
			
		} while (numero>0 && numero<6);	
		
		System.out.println("Nueva categoria");
		String n=sc.nextLine();
		CategoriasDAO.insertarCategoria(n);

	}
	public static void menu() {
		System.out.println("1. Mantenimientos \n2. Catalogo de Productos \n3. Pedidos \n4. Informes \n5. Salir");
	}
	public static void errorMenu(int numero) {
		if (!(numero>0 && numero<6)) {
			System.out.println("El numero no coincide con el menu");
		}
	}
	

}
