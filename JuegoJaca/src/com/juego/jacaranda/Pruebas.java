package com.juego.jacaranda;

public class Pruebas {

	public static void main(String[] args) {
		try {
			Coordenada c = new Coordenada(9, 0);
			System.out.println(c);
			System.out.println(c.goRight());
			System.out.println(c);
			System.out.println(c.clone());
			
			
			
		} catch (coordenadaException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		

	}

}
