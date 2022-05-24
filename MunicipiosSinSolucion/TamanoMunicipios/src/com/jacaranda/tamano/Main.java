package com.jacaranda.tamano;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Main {
	public static TamanoMunicipioComunidad t = new TamanoMunicipioComunidad();
	public static void main(String[] args) {
		
		String fichero = leerFichero("Fichero//tamanoMunicipioComunidad.json");
		System.out.println("*****************");
		t.mapearJson(fichero);
		System.out.println(t);
		
		
		
	}
	
	
	
	private static String leerFichero(String nombreFichero) {
		String linea;
		StringBuilder resultado = new StringBuilder();
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			linea = filtroLectura.readLine();
			while (linea != null) {
				resultado.append(linea);
				//System.out.println(linea);
				linea = filtroLectura.readLine();
			}
			filtroLectura.close();
			flujoLectura.close();
		} catch(FileNotFoundException e){
			System.out.println("No existe el fichero " + nombreFichero);
		}
		catch(IOException e){
		System.out.println( e.getMessage());
		}
		return resultado.toString();
	}
}
