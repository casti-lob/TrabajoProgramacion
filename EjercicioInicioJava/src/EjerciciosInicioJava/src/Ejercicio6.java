package EjerciciosInicioJava.src;

import java.util.Scanner;

public class Ejercicio6 {
	
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * Programar un sistema de calefacción-refrigeración que compruebe en función del día y el mes la estación 
		 * en la que estamos y en función de la estación programe la temperatura: Invierno->19º, Primavera->20º, Verano->24º, Otoño→19º. 
		 * El método deberá recibir como parámetro el mes y el día actual, y el método deberá devolver los grados a los que 
		 * deberemos programar el sistema.
		 */
		
		// Consideramos Invierno(21-12 /19/3) Primavera (20-3/20-6) Verano (21-6/21-9) Otoño (22-9/20-12)
		
		int dia,mes;
		
		System.out.println("Introduce el dia actual");
		dia= Integer.parseInt(teclado.nextLine());
		//Comprobamos que los datos son correctos
		while(dia <1 || dia >31) {
			System.out.println("Los dias deben de estar comprendido entre 1 y 31");
			
			System.out.println("Introduce el dia actual");
			dia= Integer.parseInt(teclado.nextLine());
		}
		System.out.println("Introduce el mes actual");
		mes= Integer.parseInt(teclado.nextLine());
		//Comprobamos que los datos son correctos
		while(mes <1 || mes >12) {
			System.out.println("Los dias deben de estar comprendido entre 1 y 12");
			
			System.out.println("Introduce el mes actual");
			mes= Integer.parseInt(teclado.nextLine());
		}
		
		System.out.println(temperatura(mes,dia));
		
	}
	
	public static String temperatura(int mes, int dia) {
		String respuesta = null;
		if ((mes ==12 && dia >=21) || (mes ==3 && dia <=19)||(mes==1)||(mes==2)) {
			respuesta = "Invierno -> 19º";
		}else if ((mes == 3 && dia>=20) || mes <=6) {
			if (mes <6) {
				respuesta = "Primavera -> 20º";
			}else if (dia<=20) {
				respuesta = "Primavera -> 20º";
			}else {
				respuesta = "Verano -> 24º";
			}
		}else if (mes <=9 ) {
			if (mes <9) {
				respuesta = "Verano -> 24º";
			}else if(dia <=21) {
				respuesta = "Verano -> 24º";
			
			}else {
				respuesta="Otoño -> 19º";
			}
		}else {
			respuesta = "Otoño -> 19º";
		}
		
		return respuesta;
	}

}
