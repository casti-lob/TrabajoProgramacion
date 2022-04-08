package com.diccionario;

public class Menu {

	public static void main(String[] args) {
		try {
			PalabrasEmpiezan a= new PalabrasEmpiezan('a');
			a.addPalabra("andalu", "duerme mucho");
			a.addPalabra("andalu", "dice eeeee");
			System.out.println(a.listaPalabras());
			a.delPalabra("andalu");
			System.out.println(a.listaPalabras());
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
	}

	public static void menu() {
		System.out.println("1 A�adir palabra \n 2 Buscar palabra \n 3 Borrar una palabra \n 4 Listado de palabras que empieze por ... \n 5 Salir");
	}
}
