package EjerciciosInicioJava.src;

import java.util.Scanner;

public class Ejercicio20 {
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * M�todo que pida 5 n�meros e indica si alguno es m�ltiplo de 3.
		 */
		System.out.println(multiplo3());
		
	}
	public static String multiplo3() {
		int numero;
		String multiplos ="Numeros multiplos de 3: ";
		for(int i = 0; i<5;i+=1) {
			System.out.println("Introduce un numero para saber si es multiplo de 3");
			numero = Integer.parseInt(teclado.nextLine());
			if (numero%3==0) {
				multiplos+= Integer.toString(numero);
				multiplos+=", ";
				
			}
		
		}
		return multiplos;
	}

}
