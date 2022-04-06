package com.diccionario;

public class Menu {

	public static void main(String[] args) {
		try {
			menu();
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
	}

	public static void menu() {
		System.out.println("1 Añadir palabra \n 2 Buscar palabra \n 3 Borrar una palabra \n 4 Listado de palabras que empieze por ... \n 5 Salir");
	}
}
