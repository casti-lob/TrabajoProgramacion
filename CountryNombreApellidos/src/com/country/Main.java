package com.country;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;




public class Main {
	public static List<Country> countrys = new LinkedList<Country>();
	public static List<City> city = new LinkedList<City>();
	
	public static void main(String[] args) throws CityException {
		countrys = new LinkedList<>();
		city = new LinkedList<City>();
		leerCountry("Fichero\\Country.txt");
		leerCity("Fichero\\City.txt");
		leerAddress("Fichero\\Address.txt");
		
		System.out.println(countrys);
		
		escribirPaises("Ficheros\\Country.txt");
		escribirCiudades("ficheros\\City.txt");
	}
	
	public static void leerCountry(String nombreFichero)  {
		String linea;
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			linea = filtroLectura.readLine();
			while (linea != null) {
				// System.out.println(linea);
				// proceso la linea que acabo de leer
				String[] campos = linea.split(",");
				
				Country c = new Country(Integer.parseInt(campos[0]),campos[1]);
				if(!countrys.contains(c)) {
					countrys.add(c);
				}
				

				// Leo otra linea
				linea = filtroLectura.readLine();
			}
			filtroLectura.close();
			flujoLectura.close();
		} catch (FileNotFoundException e) {
			System.out.println("No existe el fichero " + nombreFichero);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void leerCity(String nombreFichero)  {
		String linea;
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			linea = filtroLectura.readLine();
			while (linea != null) {
				// System.out.println(linea);
				// proceso la linea que acabo de leer
				String[] campos = linea.split(",");
				
				City c = new City(Integer.parseInt(campos[0]), campos[1]);
				boolean encontrado=false;
				Iterator<Country> siguiente = countrys.iterator();
				while(siguiente.hasNext()&&!encontrado) {
					Country i = siguiente.next();
					if(i.getCountry_id()==Integer.parseInt(campos[2])) {
						try {
							encontrado=true;
							i.setCities(c);
							city.add(c);
						} catch (CityException e) {
						
							System.out.println(e.getMessage());
						}
					}
				}
				

				// Leo otra linea
				linea = filtroLectura.readLine();
			}
			filtroLectura.close();
			flujoLectura.close();
		} catch (FileNotFoundException e) {
			System.out.println("No existe el fichero " + nombreFichero);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void leerAddress(String nombreFichero) throws CityException  {
		String linea;
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			linea = filtroLectura.readLine();
			while (linea != null) {
				// System.out.println(linea);
				// proceso la linea que acabo de leer
				String[] campos = linea.split(",");
				Address a = new Address(Integer.parseInt(campos[0]), campos[1]);
				boolean encontrado = false;
				Iterator<City> siguiente = city.iterator();
				while(siguiente.hasNext()&&!encontrado) {
					City c = siguiente.next();
					if(Integer.parseInt(campos[4])==c.getCity_id()) {
						Iterator<Country> siguienteC = countrys.iterator();
						boolean countryEncontrado = false;
						while(siguienteC.hasNext()&&!countryEncontrado) {
							Country cc = siguienteC.next();
							if(cc.setCities(c)) {
								countryEncontrado=true;
							}
						}
						encontrado=true;
					}
				}
				
					
			
			}
				// Leo otra linea
				linea = filtroLectura.readLine();
			
			
			filtroLectura.close();
			flujoLectura.close();
		} catch (FileNotFoundException e) {
			System.out.println("No existe el fichero " + nombreFichero);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	
	private static void escribirPaises(String nombre) {
		String cadena;
		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);

			Iterator<Country> siguiente = countrys.iterator();
			

			while (siguiente.hasNext()) {
				Country c= siguiente.next();
				
				StringBuilder lista = new StringBuilder();

				Iterator<City> cc = c.getCities().iterator();
				int totalDirecciones = 0;
				while (cc.hasNext()) {
					City cit = cc.next();
					totalDirecciones = totalDirecciones + cit.getNumero();
					lista.append("ciudad: " + cit.getCity() + " - total direcciones: " + cit.getNumero() + "\n");
				}

				cadena = "Pais: " + c.getCountry_id() + ", " + c.getCountry() + ", n de ciudades "
						+ c.getCities().size() + ", n de direcciones " + totalDirecciones + "\n"
						+ lista.toString();
				filtroEscritura.println(cadena);
			}

			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void escribirCiudades(String nombre) {

		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);

			Iterator<City> siguiente = city.iterator();
			

			while (siguiente.hasNext()) {
				City c = siguiente.next();
				filtroEscritura.println(c.toString());
			}

			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
