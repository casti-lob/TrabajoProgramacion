package EjerciciosInicioJava.src;

import java.util.Scanner;

public class Ejercicio19 {
	
	public static Scanner teclado= new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * M�todo que pida 15 n�meros y escribir la suma total.
		 */
		System.out.println(totalNumeros());

	}
	public static int totalNumeros() {
		int  total=0,numero;
		for (int i = 0;i!=15;i+=1) {
			System.out.println("Escribe un numero");
			numero= Integer.parseInt(teclado.nextLine());
			total += numero;
		}
		return total;
	}

}
