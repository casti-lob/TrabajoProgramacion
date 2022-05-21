package EjerciciosInicioJava.src;

import java.util.Scanner;

public class Ejercicio21 {
	
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Realiza un programa que sume los 100 números siguientes a un número entero y positivo introducido por teclado. 
		 * Se debe comprobar que el dato introducido es correcto (que es un número positivo).
		 */
		int numero;
		System.out.println("Introduce un número entero y positivo introducido por teclado");
		numero = Integer.parseInt(teclado.nextLine());
		while (comprobarDatosCorrectos(numero)== false) {
			System.out.println("El numero debe de ser positivo");
			System.out.println("Introduce un número entero y positivo introducido por teclado");
			numero = Integer.parseInt(teclado.nextLine());
		}
		System.out.println(suma_100_numeros(numero));
		
	}
	
	public static int suma_100_numeros(int numero) {
		int total=0, contador= numero+1;
		numero += 1;
		for (int i= 0;i<100;i+=1) {
			
			total +=contador;
			contador+=1;
		}
		return total;
	}
	
	public static boolean comprobarDatosCorrectos(int numero) {
		boolean resul = true;
		if (numero <0) {
			resul = false;
		}
		return resul;
	}
}
