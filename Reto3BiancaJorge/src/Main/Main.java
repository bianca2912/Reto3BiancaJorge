package Main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int numero=0;
		do {
			menu();
			numero=FuncionesPK.Funciones.dimeEntero("Elige un menu", sc);
		} while (numero>0);

	}
	public static void menu() {
		System.out.println("1. Mantenimientos \n2. Catalogo de Productos \n3. Pedidos \n4. Informes \n5. Salir");
	}

}
