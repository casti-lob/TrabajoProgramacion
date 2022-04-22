
package com.jacaranda.principal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import com.jacaranda.gestion.Alumnado;
import com.jacaranda.gestion.AlumnadoException;
import com.jacaranda.gestion.Modulo;
import com.jacaranda.gestion.ModuloException;
import com.jacaranda.gestion.Nota;

public class Main {

	public static LinkedList<Alumnado> listadoAlumnado = new LinkedList<>();
	public static HashSet<Modulo> listaModulos = new HashSet<>();
	public static ArrayList<Nota> listaNota = new ArrayList<>();
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) throws AlumnadoException, NumberFormatException, ModuloException {
		int opc;
		leerFichero("Fichero//Alumnado.txt");
		leerModulo("Fichero//Modulo.txt");
		do {

			muestraMenu();
			opc = Integer.parseInt(teclado.nextLine());
			try {
				switch (opc) {

				case 1: {
					String nombre, dni, correo;
					System.out.println("Introduce el nombre");
					nombre = teclado.nextLine();
					System.out.println("Introduce el dni");
					dni = teclado.nextLine();
					System.out.println("Introduce el correo");
					correo = teclado.nextLine();
					listadoAlumnado.add(new Alumnado(nombre, dni,correo));
					escribirEnFichero("Fichero//Alumnado.txt");
					
					break;
				}
				case 2: {
					String nombre;
					int nHoras, creditos;
					System.out.println("Introduce el nombre del modulo");
					nombre = teclado.nextLine();
					System.out.println("Introduce el numero de horas");
					nHoras= Integer.parseInt(teclado.nextLine());
					System.out.println("Introduce los creditos del modulo");
					creditos= Integer.parseInt(teclado.nextLine());
					listaModulos.add(new Modulo(nombre, nHoras, creditos));
					escribirModulo("Fichero//Modulo.txt");
					break;
				}
				case 3: {
					
					break;
				}
				case 4: {
					for (Nota nota : listaNota) {
						System.out.println(nota);
					}
					break;
				}
				case 5: {
					for (Alumnado i : listadoAlumnado) {
						System.out.println(i);
					}
					break;
				}
				case 6: {
					// Escribir los datos que hay en memoria en el fichero
					
					break;
				}

				default:
					System.out.println("NO permitida");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (opc != 6);
	}

	public static void muestraMenu() {
		System.out.println(
				"1. Alta alumnado\n2.Alta modulo\n3.Registrar nota\n4.Listar notas todos los alumnos\n5.Listar todos los alumnos\n6.Salir");
	}
/*
	public static void altaAlumno() throws AlumnadoException {
		String nombre, dni, correo;
		System.out.println("Introduce el nombre");
		nombre = teclado.nextLine();
		System.out.println("Introduce el dni");
		dni = teclado.nextLine();
		System.out.println("Introduce el correo");
		correo = teclado.nextLine();
		Alumnado a = new Alumnado(nombre, dni,correo);
		if (listadoAlumnado.isEmpty()) {
			listadoAlumnado.add(a);
			escribirEnFichero("Fichero//Alumnado.txt");
		} else {
			boolean add = false;
			Iterator<Alumnado> siguiente = listadoAlumnado.iterator();
			while (siguiente.hasNext() || add) {
				Alumnado i = siguiente.next();
				if (i.equals(a)) {
					add = true;
					escribirEnFichero("Fichero//Alumnado.txt");
				}
			}
			if (add == false) {
				listadoAlumnado.add(a);
				
				
			}
		}
	}
	*/
	/*
	public static void altaAsignatura() throws ModuloException {
		String nombre;
		System.out.println("Introduce el nombre");
		nombre = teclado.nextLine();
		Modulo m = new Modulo(nombre);
		// listaModulos.add(m);
	}
	*/
	public static void leerFichero(String nombreFichero) throws AlumnadoException {
		String linea;
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			linea = filtroLectura.readLine();
			while (linea != null) {
				// System.out.println(linea);
				// proceso la linea que acabo de leer
				String[] campos = linea.split(",");

				Alumnado alu = new Alumnado(campos[0], campos[1], campos[2]);
				listadoAlumnado.add(alu);

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

	private static void escribirEnFichero(String nombre) {
		String cadena;
		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);
			//proceso el fichero
			for(Alumnado alu:listadoAlumnado) {
				
				filtroEscritura.println(alu.aluEscribir());
		
			}
			//fin del proceso
			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void leerModulo(String nombreFichero) throws NumberFormatException, ModuloException {
		String linea;
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			linea = filtroLectura.readLine();
			while (linea != null) {
				// System.out.println(linea);
				// proceso la linea que acabo de leer
				String[] campos = linea.split(",");

				Modulo mod = new Modulo(campos[0], Integer.parseInt(campos[2]),Integer.parseInt(campos[3]));
				listaModulos.add(mod);

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
	private static void escribirModulo(String nombre) {
		String cadena;
		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);
			//proceso el fichero
			for(Modulo mod:listaModulos) {
				
				filtroEscritura.println(mod.moduloEscribir());
		
			}
			//fin del proceso
			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
