package com.diccionario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Diccionario {
	private HashMap<String,HashSet<String> > palabras;
	
	
	
	public Diccionario() {
		super();
		this.palabras = new HashMap<>();
	}
	
	
	
	public  boolean annadirPalabra(String palabra, String significado) {
		boolean resultado=true;
		//Tengo que averiguar si la palabra ya esta en el diccionario
		HashSet<String> valor = this.palabras.get(palabra);//esto consigue la lista de significados
		
		if(this.palabras.get(palabra)==null) {
			HashSet<String> significados = new HashSet<>();
			significados.add(significado);
			if(this.palabras.put(palabra, significados)==null) {
				resultado=false;
			}
		}else {//Si la palabra ya esta en el diccionario
			resultado = valor.add(significado); //metemos la lista de significado y si son repetidos pues nos da un false
		}
		
		return resultado;
		
	}
	public boolean borrarPalabra(String palabra) {
		HashSet<String> valor = this.palabras.get(palabra);
		return palabras.remove(palabra,valor);
	}
	
	public boolean borrarSignificadoPalabra(String palabra, String significado) {
		HashSet<String> valor = this.palabras.get(palabra);
		return valor.remove(significado);
	}



	@Override
	public String toString() {
		return "Diccionario [palabras=" + palabras + "]";
	}
	
}
