package EjerciciosInicioJava.src;

import java.util.Scanner;
public class Ejercicio25 {
	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Realiza un programa que vaya pidiendo n�meros hasta que se introduzca un n�mero negativo y nos diga cuantos 
		 * n�meros se han introducido,
		 *  la media de los impares y el mayor de los pares. 
		 *  El n�mero negativo s�lo se utiliza para indicar el final de la introducci�n de datos pero no se incluye en el c�mputo.
		 */
		int contador=0,num,totalImpar=0,mayorPar = 0;
		do {
			System.out.println("Introduce un numero");
			num= Integer.parseInt(teclado.nextLine());
			
				if(num>0) {
				contador+=1;
					if (num%2!=0) {
						totalImpar+=num;
					}else {
						mayorPar= mayorPar(num,mayorPar);
					}
			}
		} while (num>0);
		System.out.println("Se han introducido "+ contador+ " numeros");
		System.out.println("La media de los pares es "+Math.round((double)totalImpar/contador*100)/100.0);
		System.out.println("El mayor numero par introducido es "+mayorPar);
		
	}
	public static int mayorPar(int num, int mayorPar) {
		if (num > mayorPar){
			mayorPar= num;
		}
		return mayorPar;
	}
	
	

}
