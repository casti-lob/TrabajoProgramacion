package com.diccionario;

public class Menu {

	public static void main(String[] args) {
		Diccionario d= new Diccionario();
		d.annadirPalabra("casa", "hogar");
		d.annadirPalabra("casa", "edificio");
		System.out.println(d);
		System.out.println(d.borrarSignificadoPalabra("casa", null));
		System.out.println(d.borrarPalabra("casa"));
		
		System.out.println(d);
			
	}

	
}
