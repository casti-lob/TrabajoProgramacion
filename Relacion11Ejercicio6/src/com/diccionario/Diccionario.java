package com.diccionario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Diccionario {
	 private static HashMap<Character, Palabra> abecedario = new HashMap<>();
	
	public static void main(String[] args) {
		inicializarAbecedario();
		mostrarAbecedario();
		ponerPalabra("amanecer");
		ponerPalabra("casa");
		ponerPalabra("amar");
		mostrarAbecedario();
	}

	
	public static void inicializarAbecedario() {
		
		for(int i=65;i<91;i++) {
			Character obtenerLetra = (char)i;
			abecedario.put(obtenerLetra, null);
		}
	}
	
	public static void mostrarAbecedario() {
		System.out.println(abecedario);
		
	}
	
	public static void ponerPalabra(String palabra) {
		palabra= palabra.toUpperCase();
		Character inicial =palabra.charAt(0); 
		abecedario.put(inicial, new  Palabra(palabra));
	}
}
