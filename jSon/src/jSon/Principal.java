package jSon;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Principal {

	public static void main(String[] args) {
		String fichero = leerFichero("Ficheros//prueba.json");
		System.out.println("*****************");
		System.out.println(fichero);
		Gson gson = new Gson();
		
		Persona p1 = gson.fromJson(fichero, Persona.class);
		System.out.println(p1);
		
		ArrayList<Persona> personas =gson.fromJson(fichero, (new TypeToken<ArrayList<Persona>>(){}).getType());
		for (Persona p:personas) {
			System.out.println(p.toString());
		}
		Persona p2= new Persona("adf", "dafs", 20);
		personas.add(p2);
		
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
				System.out.println(linea);
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
	
	private static void escribirEnFicheroPorLineas(String nombre) {
		String cadena;
		try {
		FileWriter flujoEscritura=new FileWriter(nombre);
		PrintWriter filtroEscritura=new PrintWriter(flujoEscritura);
		
		
		filtroEscritura.close();
		flujoEscritura.close();
		} catch (IOException e) {
		System.out.println(e.getMessage());
		}
		}

}
