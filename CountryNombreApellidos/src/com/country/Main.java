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
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;




public class Main {
	public static Scanner teclado = new Scanner(System.in);
	public static HashMap<Integer, Country> countrys;
	public static void main(String[] args) throws CityException {
		countrys = new HashMap<>();
		leerCountry("Fichero\\Country.txt");
		leerCity("Fichero\\City.txt");
		//leerAddress("Fichero//Address.txt");
		System.out.println(countrys);
		
		anadirCountry();

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
				if(!countrys.containsKey(Integer.parseInt(campos[0]))) {
					countrys.put(Integer.parseInt(campos[0]), c);
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
	
	public static void leerCity(String nombreFichero) throws CityException  {
		String linea;
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			linea = filtroLectura.readLine();
			while (linea != null) {
				// System.out.println(linea);
				// proceso la linea que acabo de leer
				String[] campos = linea.split(",");
				City c = new City(Integer.parseInt(campos[0]),campos[1]);
				if(countrys.containsKey(Integer.parseInt(campos[2]))){
					Country existente = countrys.get(Integer.parseInt(campos[2]));
					existente.setCities(Integer.parseInt(campos[0]), campos[1]);
				}else {
					throw new CityException("La ciudad no corresponde a ningun pais");
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
	/*
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
				Address a = new Address(Integer.parseInt(campos[0]),campos[1]);
				
				if(countrys.containsValue(campos[3])){
					
					Country existente = countrys.get(Integer.parseInt(campos[2]));
					HashMap<Integer, HashSet<City>> ciudades;
					ciudades= existente.getCities();
					HashSet<City> aux= ciudades.get(Integer.parseInt(campos[5]));
					Iterator<City> siguiente = aux.iterator();
					City ciudadEncontrar = null;
					boolean encontrado = false;
					while(siguiente.hasNext()&&!encontrado) {
						City i = siguiente.next();
						if(i.getNumero()==Integer.parseInt(campos[5])) {
							encontrado = true;
							ciudadEncontrar= i;
						}
					}
					if(encontrado) {
						ciudadEncontrar.setAddress(Integer.parseInt(campos[0]), campos[2]);
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
	}*/
	
	private static void anadirCountry() {
		String nombre;
		System.out.println("Añade nombre");
		nombre = teclado.nextLine();
		Country c = new Country(8888, nombre);
		if(!countrys.containsKey(c.getCountry_id())) {
			escribirCountry("Fichero\\Country.txt");
		}
	}
	
	private static void escribirCountry(String nombre) {
		String cadena;
		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);
			// proceso el fichero
				
			for(Entry<Integer, Country> entry:countrys.entrySet()){
				filtroEscritura.println(((Country) entry).formatoCountry());
			}

				

			
			// fin del proceso
			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
