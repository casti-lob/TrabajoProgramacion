package EjerciciosInicioJava.src;

import java.util.Scanner;

public class Ejercicio23 {
	public static Scanner teclado=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Pedir números hasta que se teclee uno negativo, y mostrar cuántos 
		 * números se han introducido.
		 */
		int num, cont=0;
		do {
			System.out.println("Introduce numeros");
			num=Integer.parseInt(teclado.nextLine());
			
			if (num>0) {
				cont = contador(cont);
			}
		} while (num>0);
		System.out.println(contador(cont));
	}
	public static int contador( int cont) {
		cont+=1;
		return cont;
	}
	
}
