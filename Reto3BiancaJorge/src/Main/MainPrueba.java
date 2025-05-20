package Main;

import java.util.Scanner;

public class MainPrueba {
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    boolean salir = false;

	    while (!salir) {
	        System.out.println("\nMENÚ PRINCIPAL \n1. Mantenimientos \n2. Pedidos \n0. Salir");
	        System.out.print("Elige una opción: ");
	        int numero = FuncionesMain.dimeEntero(sc);

	        switch (numero) {
	            case 1:
	                FuncionesMain.menuMantenimientos(sc);
	                break;
	            case 2:
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


	


