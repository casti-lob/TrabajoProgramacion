package EjerciciosInicioJava.src;

import java.util.Scanner;

public class Ejercicio31 {
	public static Scanner teclado =new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 *     43. Elabora un programa que codifique una cadena, de tal modo que en el resultado se 
		 *     inviertan cada 2 caracteres. Los caracteres intercambiados no pueden volver a intercambiarse. 
		 *     Ejemplo:
				Entrada -> Hola mundo
				Salida -> oHalm nuod
		 */
		String cadena;
		System.out.println("Introduce una cadena");
		cadena = teclado.nextLine();
		System.out.println(codificacionCadena(cadena));

	}
	public static String codificacionCadena(String cadena) {
		String codificacion ="";
		for(int i =1; i<cadena.length();i+=2) {
			codificacion += cadena.charAt(i);
			codificacion += cadena.charAt(i-1);
		}
		if(cadena.length()%2!=0) {
			codificacion+=cadena.charAt(cadena.length()-1);
		}
		return codificacion;
	}

}
