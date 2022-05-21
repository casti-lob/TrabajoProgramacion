package EjerciciosInicioJava.src;

import java.util.Scanner;

public class Ejercicio27 {
	public static Scanner teclado =new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Pedir 10 sueldos. Mostrar su suma y cuantos hay mayores de 1000�.
		 */
		
		System.out.println(sueldosSuperiores());
	}
	public static int sueldosSuperiores() {
		int sueldo, limite=1000, contador=0;
		for(int i=0;i<10;i+=1) {
			System.out.println("Itroduce el sueldo");
			sueldo=Integer.parseInt(teclado.nextLine());
			if(sueldo>limite) {
				contador +=1;
			}
		}
		return contador;
		
	}

}
