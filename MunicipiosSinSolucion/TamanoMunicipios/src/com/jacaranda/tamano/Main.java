package com.jacaranda.tamano;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
		String descripcion;
		int dato;
		
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
				System.out.println("Introduce la comunidad");
				comunidad= teclado.nextLine();
				System.out.println("Introduce la descripcion");
				descripcion= teclado.nextLine();
				System.out.println("Introduce el año");
				ano= Integer.parseInt(teclado.nextLine());
				System.out.println("Introduce el dato");
				dato=Integer.parseInt(teclado.nextLine());
				try {
					t.anadirDato(comunidad, descripcion, ano, dato);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				System.out.println("Introduce la comunidad");
				comunidad=teclado.nextLine();
				System.out.println("Introduce el año");
				ano= Integer.parseInt(teclado.nextLine());
				System.out.println(t.comprobarValores(comunidad, ano));
				break;
			case 5:
				String boleano;
				String nombre;
				System.out.println("¿Quieres guardar los datos?(S/N)");
				boleano= teclado.nextLine();
				while(!boleano.equalsIgnoreCase("s")&&!boleano.equalsIgnoreCase("n")) {
					System.out.println("No se aceptan los valores");
					System.out.println("¿Quieres guardar los datos?(S/N)");
					boleano= teclado.nextLine();
				}
				if(boleano.equalsIgnoreCase("s")) {
					System.out.println("Introduce el nombre del fichero");
					nombre=teclado.nextLine();
					nombre="Fichero//"+nombre+".json";
					escribirEnFichero(nombre, t.persistirCambios());
					
				}
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
				+"2.Mostrar los datos de una comunidad y un año.\n"
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
	
	private static void escribirEnFichero(String nombre, String lista) {
		String cadena;
		try {
		FileWriter flujoEscritura=new FileWriter(nombre);
		PrintWriter filtroEscritura=new PrintWriter(flujoEscritura);
		filtroEscritura.println(lista);
		filtroEscritura.close();
		flujoEscritura.close();
		} catch (IOException e) {
		System.out.println(e.getMessage());
		}
		}
	
	
	
	
}
