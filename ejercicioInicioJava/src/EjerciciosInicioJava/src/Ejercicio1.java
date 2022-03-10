package EjerciciosInicioJava.src;

import java.util.Scanner;

public class Ejercicio1 {
	public static Scanner teclado=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1,num2;
		System.out.println("Introduce el primer numero");
		num1= Integer.parseInt(teclado.nextLine());
		System.out.println("Introduce el segundo numero");
		num2= Integer.parseInt(teclado.nextLine());
		
		System.out.println(esMultiplo(num1, num2));

	}
	public static boolean esMultiplo(int num1,int num2) {
		boolean multiplo = false;
		if(num1 % num2==0) {
			multiplo= true;
		}
		return multiplo;
	}
}
