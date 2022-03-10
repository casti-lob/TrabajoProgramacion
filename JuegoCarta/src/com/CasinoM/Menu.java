package com.CasinoM;

import java.util.Scanner;

public class Menu {
	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) throws CartaException, BarajaException {
		// TODO Auto-generated method stub
		System.out.println("Bienvenido al juego del 7 y medio");
		Baraja barajaEnJuego = new Baraja();
		barajaEnJuego.barajar();
		double puntosJugador=0,puntosBanc=0;
		char opc = ' ';
		try {
			
		
		do {
			
			puntosJugador+= barajaEnJuego.getCarta().getValor();
			System.out.println(barajaEnJuego.getSiguiente());
			
			
			System.out.println("Tienes un total de "+puntosJugador+" puntos acumulados");
			
			if(puntosJugador<7.5) {
				System.out.println("Quieres otra carta s/n");
				opc = teclado.nextLine().charAt(0);
			}
			
			
		} while (opc=='s'&&puntosJugador<7.5);
		
		if(puntosJugador>7.5) {
			System.out.println("Lo siento pero te has pasado y por lo tango la banca gana");
		}else {
			while(puntosBanc<=puntosJugador) {
				puntosBanc+=barajaEnJuego.getCarta().getValor();
				System.out.println(barajaEnJuego.getSiguiente());
				
				System.out.println("Tienes un total de "+puntosBanc+" puntos acumulados");
			}
			if(puntosBanc>=puntosJugador) {
				System.out.println("La banca ha ganado");
			}else {
				System.out.println("El jugador ha ganado");
			}
		}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	
}
