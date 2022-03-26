package com.jacaranda.utilities;

public class Prueba {

	public static void main(String[] args) {
		try {
			Pueblo p = new Pueblo("aaa", "11111");
			Pueblo p2= new Pueblo("Sevilla", "12345", 2, 20, 1);
			System.out.println(p2);
		} catch (PuebloException e) {
			
			System.out.println(e.getMessage());
		}
		
	}

}
