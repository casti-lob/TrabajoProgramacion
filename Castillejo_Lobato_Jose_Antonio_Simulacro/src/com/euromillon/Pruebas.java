package com.euromillon;

public class Pruebas {

	public static void main(String[] args) {
		try {
			Combinacion c = new Combinacion(50, 2, 40, 40, 50, 8, 6);
			Combinacion c2 = new Combinacion(1, 9, 8, 40, 11, 8, 8);
			System.out.println(c.comprobarAciertos(c2));
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		
	}

}
