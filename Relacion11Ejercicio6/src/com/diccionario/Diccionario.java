package com.diccionario;

import java.util.ArrayList;
import java.util.List;

public class Diccionario {
	public static List<PalabrasEmpiezan> abecedario = new ArrayList<PalabrasEmpiezan>();
	
	public static void main(String[] args) {
		inicializarAbecedario();
		
		
		
	}
	
	public static String mostrarAbecedario() {
		StringBuilder lista = new StringBuilder();
		for(PalabrasEmpiezan i: abecedario) {
			lista.append(i+", ");
		}
		return lista.toString();
	}
	
	public static void inicializarAbecedario() {
		
		for(int i=65;i<91;i++) {
			Character obtenerLetra = (char)i;
			PalabrasEmpiezan abc= new PalabrasEmpiezan(obtenerLetra);
			abecedario.add(abc);
		}
	}
	
}
