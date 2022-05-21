package EjerciciosInicioJava.src;

import java.util.Scanner;

public class Ejercicio5 {
	
	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * Realiza un m�todo que reciba una hora por par�metro y que muestre luego buenos d�as, buenas tardes
		 *  o buenas noches seg�n la hora. Se utilizar�n los tramos de 6 a 12, de 13 a 20 y de 21 a 5. respectivamente. 
		 *  S�lo se tienen en cuenta las horas.
		 */
		
		int hora;
		
		System.out.println("Que hora es?");
		hora = Integer.parseInt(teclado.nextLine());
		
		while(hora<5 || hora >21) {
			System.out.println("Hora no contemplada");
			System.out.println("Que hora es?");
			hora = Integer.parseInt(teclado.nextLine());
		}
		
		System.out.println(saludo(hora));
	}
	
	public static String saludo (int hora) {
		String respuesta;
		if (hora <= 12 && hora >=6){
			respuesta = "Buenos d�as";
		}else if(hora <=20&& hora>=13){
			respuesta ="Buenas tardes";
		}else {
			respuesta = "Buenas noches";
		}
		
		return respuesta;
	}
}
