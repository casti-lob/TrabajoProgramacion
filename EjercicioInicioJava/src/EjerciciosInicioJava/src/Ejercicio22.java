package EjerciciosInicioJava.src;

import java.util.Scanner;

public class Ejercicio22 {
	public static Scanner teclado=new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Leer un número y mostrar su cuadrado, repetir el proceso hasta que 
		 * se introduzca un número negativo.
		 */
		int num;
		
		do {
			System.out.println("Introduce numeros");
			num= Integer.parseInt(teclado.nextLine());
			if(num>0) {
				
				System.out.println(raizCuadrada(num));
			}
			
		} while (num >0);
		
		
	}
	public static double raizCuadrada (int num) {
		double resul = Math.sqrt(num);
		return Math.round(resul*100)/100.0;
	}

}
