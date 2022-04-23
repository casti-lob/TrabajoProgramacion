package com.myparticularcollection;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Menu {
	public static Set<Usuario> listaUsuario= new HashSet<Usuario>();
	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		boolean repetir= true;
		try {
			do {
				menu();
				
				switch (opc()) {
				case 1: {
					System.out.println(crearUsuario());
					break;
				}case 2: {
					System.out.println(anadirPelicula());
					break;
				
				}case 3: {
					System.out.println(anadirSerie());
					break;
				
				}case 4: {
					System.out.println(anadirLibro());
					break;
				
				}case 5: {
					System.out.println(listaOrdenada());
					break;
				
				}case 6: {
					System.out.println("Hasta pronto");
					repetir = false;
					break;
				}
				default:
					System.out.println("Error inesperado");
				}
			} while (repetir);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void menu() {
		System.out.println("1. Crear un usuario \n 2.Anadir una pelicula \n 3.Anadir una serie \n 4.Anadir un libro \n 5.Mostrar lista ordenada \n 6.Salir" );
	}
	
	public static int opc() {
		int opcion;
		System.out.println("Introduce una opcion numerica");
		opcion= Integer.parseInt(teclado.nextLine());
		return opcion;
	}
	
	public static boolean crearUsuario() throws UsuarioException, MenuException {
		String nombre, contrasena;
		System.out.println("Introduzca el nombre de usuario");
		nombre = teclado.nextLine();
		System.out.println("Introduzca su contrasena");
		contrasena= teclado.nextLine();
		Usuario u= new Usuario(nombre, contrasena);
		
		return listaUsuario.add(u);
	}
	
	public static boolean anadirPelicula() throws Exception {
		String nombre, contrasena;
		boolean iniciada=false;
		System.out.println("Introduzca el nombre de usuario");
		nombre = teclado.nextLine();
		System.out.println("Introduzca la contrasena(tiene que tener una longitud mayor a 3)");
		contrasena= teclado.nextLine();
		Iterator<Usuario> siguiente = listaUsuario.iterator();
		while(siguiente.hasNext()||iniciada==false) {
			Usuario u = siguiente.next();
			if(u.getNombre().equals(nombre)&&u.getContrasena().equals(contrasena)) {
				
				pelicula(u);
				iniciada=true;
				
			}
		}
		return iniciada;
	}
	public static void pelicula(Usuario u) throws Exception {
		String nombre,genero,estado,director;
		LocalDate fechaEstreno;
		double duracion;
		System.out.println("Introduce el nombre de la pelicula");
		nombre= teclado.nextLine();
		System.out.println("Introduce el genero");
		genero= teclado.nextLine();
		System.out.println("Introduce el estado");
		estado= teclado.nextLine();
		System.out.println("Introduce el director");
		director= teclado.nextLine();
		System.out.println("Introduce la duracion");
		duracion= Double.parseDouble(teclado.nextLine());
		u.addPelicula(nombre, LocalDate.now(), genero, estado, director, duracion);
	}
	
	public static boolean anadirSerie() throws Exception {
		String nombre,contrasena;
		boolean iniciada=false;
		int posicion;
		System.out.println("Introduzca el nombre de usuario");
		nombre = teclado.nextLine();
		System.out.println("Introduzca la contrasena(tiene que tener una longitud mayor a 3)");
		contrasena= teclado.nextLine();
		Iterator<Usuario> siguiente = listaUsuario.iterator();
		while(siguiente.hasNext()||iniciada==false) {
			Usuario u = siguiente.next();
			if(u.getNombre().equals(nombre)&&u.getContrasena().equals(contrasena)) {
				
				serie(u);
				iniciada=true;
				
			}
		}
		return iniciada;
	}
	
	public static void serie(Usuario u) throws Exception {
		String nombre,genero,estado,director;
		LocalDate fechaEstreno;
		int capitulos;
		double duracion;
		System.out.println("Introduce el nombre de la pelicula");
		nombre= teclado.nextLine();
		System.out.println("Introduce el genero");
		genero= teclado.nextLine();
		System.out.println("Introduce el estado");
		estado= teclado.nextLine();
		System.out.println("Introduce el director");
		director= teclado.nextLine();
		System.out.println("Introduce la duracion");
		duracion= Double.parseDouble(teclado.nextLine());
		System.out.println("Introduce los capitulos que tiene");
		capitulos= Integer.parseInt(teclado.nextLine());
		u.addSerie(nombre, LocalDate.now(), genero, estado, director, capitulos);
	}
	
	public static boolean anadirLibro() throws Exception {
		String nombre,contrasena;
		boolean iniciada=false;
		int posicion;
		System.out.println("Introduzca el nombre de usuario");
		nombre = teclado.nextLine();
		System.out.println("Introduzca la contrasena(tiene que tener una longitud mayor a 3)");
		contrasena= teclado.nextLine();
		Iterator<Usuario> siguiente = listaUsuario.iterator();
		while(siguiente.hasNext()||iniciada==false) {
			Usuario u = siguiente.next();
			if(u.getNombre().equals(nombre)&&u.getContrasena().equals(contrasena)) {
				
				libro(u);
				iniciada=true;
				
			}
		}
		return iniciada;
	}
	
	public static void libro(Usuario u) throws Exception {
		String nombre,genero,estado,director;
		LocalDate fechaEstreno;
		int capitulos;
		double duracion;
		System.out.println("Introduce el nombre de la pelicula");
		nombre= teclado.nextLine();
		System.out.println("Introduce el genero");
		genero= teclado.nextLine();
		System.out.println("Introduce el estado");
		estado= teclado.nextLine();
		System.out.println("Introduce el director");
		director= teclado.nextLine();
		System.out.println("Introduce la duracion");
		duracion= Double.parseDouble(teclado.nextLine());
		System.out.println("Introduce los capitulos que tiene");
		capitulos= Integer.parseInt(teclado.nextLine());
		u.addLibro(nombre, LocalDate.now(), genero, estado, director, capitulos);
	}
	
	public static String listaOrdenada() throws Exception {
		String nombre, contrasena,salida = "Usuario no encontrado";
		boolean iniciada=false;
		System.out.println("Introduzca el nombre de usuario");
		nombre = teclado.nextLine();
		System.out.println("Introduzca la contrasena(tiene que tener una longitud mayor a 3)");
		contrasena= teclado.nextLine();
		Iterator<Usuario> siguiente = listaUsuario.iterator();
		while(siguiente.hasNext()||iniciada==false) {
			Usuario u = siguiente.next();
			if(u.getNombre().equals(nombre)&&u.getContrasena().equals(contrasena)) {
				
				salida= u.listaOrdenada();
				iniciada=true;
				
			}
		}
		
		
		return salida;
	}
}
