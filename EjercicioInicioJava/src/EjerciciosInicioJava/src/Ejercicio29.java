package EjerciciosInicioJava.src;

import java.util.Scanner;

public class Ejercicio29 {
	public static Scanner teclado =new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Realiza un programa que pida un número por teclado y que luego muestre ese número al revés. 
		 * Utilizar cadenas para facilitar la tarea
		 */
		int numero;
		System.out.println("Introduce un numero");
		numero = Integer.parseInt(teclado.nextLine());
		System.out.println(numeroReves(numero));
		

	}
	public static String numeroReves(int numero) {
		String cadena="" , reves="";
		cadena+= numero;
		for(int i = cadena.length()-1; i >=0;i-=1) {
			reves += cadena.charAt(i);
		}
		return reves;
	}
}
