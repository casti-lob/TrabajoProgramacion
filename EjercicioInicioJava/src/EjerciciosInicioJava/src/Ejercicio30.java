package EjerciciosInicioJava.src;

import java.util.Scanner;

public class Ejercicio30 {
	public static Scanner teclado=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Realizar un método que dada una cadena de entrada, comprueba si es una contraseña FUERTE o DÉBIL. 
		 * Se considera que una contraseña es fuerte si contiene 8 o más caracteres, y entre ellos al menos 
		 * hay una mayúscula, una minúscula, un signo de puntuación y un dígito.
		 */
		String contrasenna;
		System.out.println("Introduce la contraseña");
		contrasenna=teclado.nextLine();
		if(mayusContra(contrasenna)== true && minusculaContra(contrasenna)==true && digitosContra(contrasenna)==true) {
			System.out.println("La contraseña es FUERTE");
		}else {
			System.out.println("La contraseña es DÉBIL");
		}
		
		
	}
	public static boolean longContraseña(String contasenna) {
		boolean condicion;
		condicion= false;
		if (contasenna.length()>=8) {
			condicion=true;
		}
		return condicion;
	}
	public static boolean mayusContra(String contrasenna) {
		boolean condicion;
		int contador=0;
		condicion =false;
		do {
			if((int)contrasenna.charAt(contador)<=90 &&(int)contrasenna.charAt(contador)>=65) {
				condicion = true;
			}
			contador+=1;
		} while (condicion ==false && contador < contrasenna.length()-1);
	return condicion;
	}
	public static boolean minusculaContra(String contrasenna) {
		boolean condicion = false;
		int contador=0;
		do {
			if ((int)contrasenna.charAt(contador)<=122&&(int)contrasenna.charAt(contador)>=97) {
				condicion=true;
			}
			contador+=1;
			
		} while (condicion==false&&contador<contrasenna.length()-1);
		return condicion;
	}
	public static boolean digitosContra(String contrasenna) {
		boolean condicion = false;
		int contador =0;
		do {
			if (contrasenna.charAt(contador)<=57&& contrasenna.charAt(contador)>=48) {
				condicion= true;
			}
			contador+=1;
		} while (condicion==false&&contador<contrasenna.length()-1);
		
		return condicion;
	}
	

}
