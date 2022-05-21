import java.util.Scanner;

public class Ejercicio23 {
	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Pedir números hasta que se teclee uno negativo, y mostrar cuántos números se han introducido.
		 */
		System.out.println(contadorNum());
		
	}
	
	public static int contadorNum() {
		int contador=0,num;
		do {
			System.out.println("Introduce un numero");
			num= Integer.parseInt(teclado.nextLine());
				if(num>0) {
				contador+=1;
			}
		} while (num>0);
		return contador;
	}

}
