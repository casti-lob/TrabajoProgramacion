package com.simulacro;

import java.util.Scanner;
/**
 * 
 * @author josel
 *@version 1.0
 */
public class Menus {
	public static Scanner teclado = new Scanner(System.in);
	/**
	 * Metodo main en donde se crea un Parking y su categoria y hay un bucle que pregunta las opciones segun el menú
	 * 1: Para introducir un coche en el Parking
	 * 2:Para sacar y cobrar a un coche
	 * 3:Para mostrar la información del Parking
	 * 4:Para salir del programa
	 * @param args
	 * @throws ParkingException
	 * Atrapamos las exception con codigo 0001, 0002, 0003, 0004
	 */
	public static void main(String[] args) throws ParkingException {
		// TODO Auto-generated method stub
		int opc;
		Categoria nuestraCategoria = new Categoria("Centro");
		Parking nuestroParking = new Parking("Centro Sevilla", nuestraCategoria, 5);
		do {
			menu();
			System.out.println("Introduce la opcion");
			opc= Integer.parseInt(teclado.nextLine());
			try {
				switch (opc) {
				case 1: {
					nuestroParking.entrarParking();
					System.out.println("Su coche ocupa una plaza del Parking");
					break;
				}case 2: {
					int minutos;
					System.out.println("Introduce los minutos que ha ocupado la plaza");
					minutos= Integer.parseInt(teclado.nextLine());
					System.out.println("Tiene que pagar; "+nuestroParking.cobrarYsalirDelParking(minutos));
					break;
				}case 3: {
					System.out.println(nuestroParking);
					break;
				}case 4: {
					System.out.println("Cerrando Programa");
					break;
				}
				default:
					System.out.println("Opcion no contemplada");
				}
			} catch (Exception e) {
				// TODO: handle exception
				int codigo= Integer.parseInt(e.getMessage().substring(0,4));
				if(codigo==1) {
					System.out.println("El numero total de plazas no puede ser menor a 1");
				}else if(codigo ==2) {
					System.out.println("El parking esta completo");
				}else if(codigo ==3) {
					System.out.println("Los minutos no pueden ser menores que 1");
				}else if(codigo==4) {
					System.out.println("El parking esta vacio");
				}
			}
			
		} while (opc!=4);
	}
	/**
	 * Metodo para mostrar el menú
	 */
	public static void menu() {
		System.out.println("1.- Entrar al parking"+"\n"+
				"2.- Salir de parking"+"\n"+	
				"3.- Mostrar información del parking."+"\n"+
				"4.- Salir del programa."+"\n"
	
				);
	}
}
