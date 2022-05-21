package EjerciciosInicioJava.src;

import java.util.Scanner;

public class Ejercicio3 {
	
	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		     3. Escribir un método que reciba un carácter y devuelva el tipo que es. Debe devolver
				una de las se imprimir los siguientes mensajes según corresponda.
				
		        ◦ Letra mayúscula
		        ◦ Letra minuscula
		        ◦ Dígito entre 0 y 9
		        ◦ Signo de puntuación
		        ◦ Espacio en blanco
		        ◦ Paréntesis () o llaves {}
		        ◦ Otro carácter
		 */
		
		char caracter;
		System.out.println("Introduce el caracter que quieras");
		caracter = teclado.nextLine().charAt(0);
		String solucion;
		int ascii = (int) caracter;
		
		if(ascii<=90 && ascii>=65) {
			solucion = "Letra mayúscula";
		}else if(ascii <=97 && ascii >=97) {
			solucion = "Letra minuscula";
		}else if(ascii <=57 && ascii >=48) {
			solucion="Dígito entre 0 y 9";
		}else if(ascii ==46) {
			solucion="Signo de puntuación";
		}else if(ascii==32) {
			solucion ="Espacio en blanco";
		}else if (ascii<=41 && ascii >=40 || ascii==123 || ascii ==125) {
			solucion="Paréntesis () o llaves {}";
		}else {
			solucion="Otro carácter";
		}
		
		System.out.println(solucion);
	}

}
