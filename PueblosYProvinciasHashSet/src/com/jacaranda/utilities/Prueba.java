package com.jacaranda.utilities;

public class Prueba {

	public static void main(String[] args) {
		
		try {
			Provincia a= new Provincia("Sez", "12");
			Pueblo p = new Pueblo("aaa", "11111");
			Pueblo p2= new Pueblo("Sevilla", "12345", 2, 20, 1);
			System.out.println(a.addPueblo("Sevilla", "345", 2, 0, 0));
			System.out.println(a.addPueblo("Sevill", "348", 2, 0, 0));
			System.out.println(a.delPueblo("Sevilla"));
			System.out.println(a.listadoPueblos());
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
	}

}
