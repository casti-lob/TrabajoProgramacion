package com.jacaranda.utilities;

public class Prueba {

	public static void main(String[] args) {
		
		try {
			Provincia p = new Provincia("Sevilla", "12");
			p.addPueblo("z", "123", 1, 0, 0);
			System.out.println(p.delPueblo("z"));
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
	}

}
