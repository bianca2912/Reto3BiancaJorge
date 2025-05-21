package Main;

import java.util.Scanner;

public class MainPrueba {
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    boolean salir = false;

	    while (!salir) {
	        System.out.println("MENU \n1. Mantenimientos \n2. Catalogo de Productos \n3. Pedidos \n4. Informes \n0. Salir");
	        System.out.print("Elige una opcion: ");
	        int numero = FuncionesMain.dimeEntero(sc);

	        switch (numero) {
	            case 1:
	                FuncionesMain.menuMantenimientos(sc);
	                break;
	            case 2:
	                FuncionesMain.menuCatalogo(sc);
	                break;
	            case 3:
	            	FuncionesMain.menuPedidos(sc);
	                break;
	            case 4:
	            	System.out.println("4");
	                break;
	            case 0:
	                salir = true;
	                System.out.println("Saliendo del programa...");
	                break;
	            default:
	                System.out.println("Opcion no valida.");
	        }
	    }

	    sc.close();
	}
}


	


