package aritmetica;

import java.util.Scanner;

public class Menu {
	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		int opc ,parteReal, parteImaginaria;
		do {
			menu();
			System.out.println("Escriba una opcion");
			opc= Integer.parseInt(teclado.nextLine());
			
			while(opc <1|| opc>3) {
				System.out.println("Opcion no contemplada");
				menu();
				System.out.println("Escriba una opcion");
				opc= Integer.parseInt(teclado.nextLine());
			}
			switch (opc) {
			case 1: {
				System.out.println("Primer numero:");
				System.out.println("Introduce la parte real");
				parteReal= Integer.parseInt(teclado.nextLine());
				System.out.println("Introduce la parte imaginaria");
				parteImaginaria= Integer.parseInt(teclado.nextLine());
				Complejo c1= new Complejo(parteReal, parteImaginaria);
				
				System.out.println("Segundo numero:");
				System.out.println("Introduce la parte real");
				parteReal= Integer.parseInt(teclado.nextLine());
				System.out.println("Introduce la parte imaginaria");
				parteImaginaria= Integer.parseInt(teclado.nextLine());
				Complejo c2= new Complejo(parteReal, parteImaginaria);
				
				if(c1.equals(c2)) {
					System.out.println("Los dos numeros complejos son iguales y no se puede hacer la operacion");
				}else {
					System.out.println(c1.suma(c2));
				}
				break;
			}
			case 2: {
				System.out.println("Primer numero:");
				System.out.println("Introduce la parte real");
				parteReal= Integer.parseInt(teclado.nextLine());
				System.out.println("Introduce la parte imaginaria");
				parteImaginaria= Integer.parseInt(teclado.nextLine());
				Complejo c1= new Complejo(parteReal, parteImaginaria);
				
				System.out.println("Segundo numero:");
				System.out.println("Introduce la parte real");
				parteReal= Integer.parseInt(teclado.nextLine());
				System.out.println("Introduce la parte imaginaria");
				parteImaginaria= Integer.parseInt(teclado.nextLine());
				Complejo c2= new Complejo(parteReal, parteImaginaria);
				
				if(c1.equals(c2)) {
					System.out.println("Los dos numeros complejos son iguales y no se puede hacer la operacion");
				}else {
					System.out.println(c1.resta(c2));
				}
				break;
			}
			}
		} while (opc!=3);
		System.out.println("Cerrando sistema");
	}
	
	public static void menu() {
		System.out.println("1. Sumar complejos");
		System.out.println("2. Restar complejos:");
		System.out.println("3. Salir");
	}

}
