package maquinaCafe;

import java.util.Scanner;

public class Menu {
	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cafetera c1 = new Cafetera(); 
		int opc;
		double dineroIntroducir;
		do {
			menu();
			System.out.println("Introduce una opcion");
			opc=Integer.parseInt(teclado.nextLine());
			
			if (opc <1 || opc>5) {
				System.out.println("Opcion no contemplada");
				System.out.println("Introduce una opcion");
				opc=Integer.parseInt(teclado.nextLine());
			}
			switch (opc) {
			case 1: {
				System.out.println("Tiene que introducir "+c1.getPrecioCafe()+" euros");
				System.out.println("Poner el dinero");
				dineroIntroducir= Double.parseDouble(teclado.nextLine());
				System.out.println(c1.servirCafe(opc, dineroIntroducir ));
				break;
			}
			case 2:{
				System.out.println("Tiene que introducir "+c1.getPrecioLeche()+" euros");
				System.out.println("Poner el dinero");
				dineroIntroducir= Double.parseDouble(teclado.nextLine());
				System.out.println(c1.servirCafe(opc, dineroIntroducir ));
				break;
			}
			case 3:{
				System.out.println("Tiene que introducir "+c1.getPrecioCafeConLeche()+" euros");
				System.out.println("Poner el dinero");
				dineroIntroducir= Double.parseDouble(teclado.nextLine());
				System.out.println(c1.servirCafe(opc, dineroIntroducir ));
				break;
			}
			case 4:{
				System.out.println(c1.toString());
				break;
			}
			default:
				System.out.println("Error inesperado");;
			}
			c1.llenadoDepositos();
		} while (opc!=5);
		System.out.println("Gracias por su visita");
	}
	
	public static void menu() {
		System.out.println("1. Servir café solo ");
		System.out.println("2. Servir leche ");
		System.out.println("3. Servir café con leche ");
		System.out.println("4. Consultar estado máquina");
		System.out.println("5. Apagar máquina y salir");
	}
}
