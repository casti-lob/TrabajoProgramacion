package EjerciciosInicioJava.src;

import java.util.Scanner;

public class Ejercicio26 {
	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Crea un programa que permita sumar N n�meros. El usuario decide cu�ndo termina de 
		 * introducir n�meros al indicar la palabra �fin�.
		 */
		System.out.println(sumarNumeros());
		
	}
	
	public static double sumarNumeros() {
		double num,total=0;
		String condicion="null";
		do {
			System.out.println("Introduce un numero");
			num=Double.parseDouble(teclado.nextLine());
			total += num;
			System.out.println("Para continuar no introduzca (fin)");
			condicion= teclado.nextLine();
		} while (condicion.equalsIgnoreCase("fin")== false); // Tambien se puede con condicion.compareTo("fin")!=0
		return total;
	}
}
