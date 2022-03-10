package EjerciciosInicioJava.src;

import java.util.Scanner;

public class Ejercicio24 {
	public static Scanner teclado= new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Programa que reciba 10 n�meros y nos indique cu�l de ellos es el m�ximo (el mayor).
		 */
		System.out.println("El maximo de los numero introducidos es "+mayorNum());
	}
	
	//metodo para pedir
	public static int mayorNum() {
		int num, mayor=-9999999;
		for (int i=0;i<10;i+=1) {
			System.out.println("Introduzca un numero");
			num= Integer.parseInt(teclado.nextLine());
			if (num> mayor) {
				mayor = num;
			}
		}
		return mayor;
		
	}

}
