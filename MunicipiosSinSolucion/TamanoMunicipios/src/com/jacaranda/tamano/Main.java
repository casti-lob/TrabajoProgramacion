package com.jacaranda.tamano;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Main {
	public static TamanoMunicipioComunidad t = new TamanoMunicipioComunidad();
	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String fichero = leerFichero("Fichero//tamanoMunicipioComunidad.json");
		System.out.println("*****************");
		t.mapearJson(fichero);
		System.out.println(t);
		int opc=0;
		int ano=0;
		String comunidad;
		
		do {
			menu();
			System.out.println("Introduce la opción");
			opc = Integer.parseInt(teclado.nextLine());
			switch (opc) {
			case 1:
				
				System.out.println("Introduce el año que quieras sacar todos los datos");
				ano= Integer.parseInt(teclado.nextLine());
				while(comprobacionAno(ano)==false) {
					System.out.println("Año no contemplado");
					System.out.println("Introduce el año que quieras sacar todos los datos");
					ano= Integer.parseInt(teclado.nextLine());
				}
				System.out.println(t.obtenerComunidadesPorAno(ano));
				break;
			case 2:
				System.out.println("Introduce el año que quieras sacar la informacion");
				ano= Integer.parseInt(teclado.nextLine());
				while(comprobacionAno(ano)==false) {
					System.out.println("Año no contemplado");
					System.out.println("Introduce el año que quieras sacar todos los datos");
					ano= Integer.parseInt(teclado.nextLine());
				}
				System.out.println("Introduce la comunidad");
				comunidad = teclado.nextLine();
				System.out.println(t.datosMunicipioAno(comunidad, ano));//Se recomienda para porbar la siguiente comunidad (Asturias  Principado de)
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				System.out.println("¿Quieres guardar los datos?");
				break;


			default:
				System.out.println("Opcion no contemplada");
			}
		} while (opc!=5);
		
		
		
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
	
	private static void menu() {
		System.out.println("1.Mostrar los datos de todas las comunidades por año.\n"
				+"2.Mostrar los datos de una comunidad y un año."
				+"3.Añadir un dato\n"
				+"4.Comprobar que el valor de Total es la suma de todos los valores\n"
				+"5.Salir"
				);
	}
	
	private static boolean comprobacionAno(int ano) {
		boolean valido=false;
		if(ano>1980&&ano<2050) {//Establecemos el rango de años permitidos
			valido=true;
		}
		return valido;
	}
	
	
	
	
}
