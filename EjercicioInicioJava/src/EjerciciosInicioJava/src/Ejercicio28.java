package EjerciciosInicioJava.src;

import java.util.Scanner;

public class Ejercicio28 {
	public static Scanner teclado=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Escribe un programa que muestre los n primeros t�rminos de la serie de Fibonacci. 
		 * El primer t�rmino de la serie de Fibonacci es 0, el segundo es 1 y el resto se calcula sumando los dos anteriores, 
		 * por lo que tendr�amos que los t�rminos son 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144� 
		 * El n�mero n se debe introducir por teclado.
		 */
		int cantidad;
		System.out.println("Introduce la cantidad de numeros que quieres sacar de la serie de Fibonacci");
		cantidad = Integer.parseInt(teclado.nextLine());
		System.out.println(serieFibonacci(cantidad));
	}
	public static String serieFibonacci(int cantidad) {
		int r1=0, r2=1, total;
		String serie ="0, 1";
		for (int i =2; i< cantidad;i+=1) {
			total = r1+r2;
			serie +=", "+ total;
			r1 = r2;
			r2= total;
			
		}
		return serie;
		
	}
}
