package com.jacaranda.utilities;

public class Prueba {

	public static void main(String[] args) {
		
		try {
			Provincia a= new Provincia("Sez", "12");
			Pueblo p = new Pueblo("aaa", "11111");
			Pueblo p2= new Pueblo("Sevilla", "12345", 2, 20, 1);
			System.out.println(a.addPueblo("Sevilla", "345", 2, 0, 20));
			System.out.println(a.addPueblo("Sevill", "348", 2, 0, 10));
			System.out.println(a.listadoPueblos());
			System.out.println(a.setNUmeroHabitantes("Sevilla", 1));
			System.out.println(a.listadoPueblos());
			System.out.println(a);
			System.out.println(a.getInformacionPueblo("sevill"));
			System.out.println(a.numPueblos());
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
	}

}
