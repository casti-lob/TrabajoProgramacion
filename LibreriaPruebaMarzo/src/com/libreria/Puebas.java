package com.libreria;

public class Puebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Libro l = new LibroDigital("eee", "llllll", null, 50, "pdf");
			System.out.println(l);
			Libro l2 = new LibroPapel("It", "King", "Tauro", 200, 12.2);
			System.out.println(l2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
