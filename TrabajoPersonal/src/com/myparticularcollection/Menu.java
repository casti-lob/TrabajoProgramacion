package com.myparticularcollection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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
		//Conexión BBDD
		try {
			Connection c = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/ORCLCDB.localdomain", "proyectoPersonal", "proyectoPersonal");
			
			
			DatabaseMetaData infoBD= c.getMetaData();
			System.out.println("Base de datos: " + infoBD.getDatabaseProductName());
			System.out.println("Version: " + infoBD.getDatabaseProductVersion());

		//Interaccion
		
			do {
				try {
				menu();
				
				switch (opc()) {
				case 1: {
					System.out.println(crearUsuario());
					break;
				}case 2: {
					System.out.println(anadirPelicula(c));
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
					
					break;
				}case 7: {
					System.out.println("Hasta pronto");
					repetir = false;
					break;
				}
				default:
					System.out.println("Error inesperado");
				}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} while (repetir);
			
			
		} catch (Exception ex) {
			System.out.println(ex);
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
	
	public static boolean anadirPelicula(Connection c) throws Exception {
		String nombre, contrasena;
		int opcion;
		boolean iniciada=false;
		System.out.println("Introduzca el nombre de usuario");
		nombre = teclado.nextLine();
		System.out.println("Introduzca la contrasena(tiene que tener una longitud mayor a 3)");
		contrasena= teclado.nextLine();
		Iterator<Usuario> siguiente = listaUsuario.iterator();
		while(siguiente.hasNext()||iniciada==false) {
			Usuario u = siguiente.next();
			if(u.getNombre().equals(nombre)&&u.getContrasena().equals(contrasena)) {
				System.out.println("UNA OPCION : 1 AÑADIR PELI/ 2 BORRAR PELI / 3 MODIFICAR PELI");
				opcion= Integer.parseInt(teclado.nextLine());
				switch (opcion) {
				case 1: {
					pelicula(u,c);
					break;
				}case 2: {
					deletePelicula(u,c);
					break;
				}case 4: {
					valorarPelicula(u, c);
					break;
				}
				default:
					System.out.println("Opcion no contemplada");
				}
				
				iniciada=true;
				
			}
		}
		return iniciada;
	}
	public static void pelicula(Usuario u,Connection c) throws Exception {
		String nombre,genero,estado,director;
		LocalDate fechaEstreno=LocalDate.now();
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
		u.addPelicula(nombre, fechaEstreno, genero, estado, director, duracion);
		//Procedemos a introducir la pelicula a la bbdd
		
		Statement instruccion = (Statement) c.createStatement();
		String query ="insert into pelicula values('"+nombre+"','"+director+"','"+fechaEstreno+"','"+genero+",0,'"+estado+"',"+duracion+")";
		if(!instruccion.execute(query)){
			System.out.println("error en la sentencia: "+query);
			
		}else {
			System.out.println("Registro insertado");
		}
		
	}
	
	public static void deletePelicula(Usuario u,Connection c) throws SQLException {
		String nombre;
		System.out.println("Introduce la pelicula que quieres eliminar");
		nombre= teclado.nextLine();
		for(Elemento i: u.getLista()) {
			if(i instanceof Pelicula&& i.getNombre().equals(nombre)) {
				Statement instruccion = (Statement) c.createStatement();
				String query ="delete from pelicula p where p.nombre ='"+nombre+"'";
				if(!instruccion.execute(query)){
					System.out.println("error en la sentencia: "+query);
					
				}else {
					System.out.println("Registro insertado");
				}
			}
		}
	}
	
	public static void valorarPelicula(Usuario u,Connection c) throws SQLException {
		String nombre;
		int valoracion;
		System.out.println("Introduce la pelicula que quieres eliminar");
		nombre= teclado.nextLine();
		for(Elemento i: u.getLista()) {
			if(i instanceof Pelicula&& i.getNombre().equals(nombre)) {
				System.out.println("Introduce una valoracion");
				valoracion= Integer.parseInt(teclado.nextLine());
				try {
					i.setValoracion(valoracion);
				} catch (ElementoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Statement instruccion = (Statement) c.createStatement();
				String query ="update pelicula p set p.valoracion ="+valoracion;
				if(!instruccion.execute(query)){
					System.out.println("error en la sentencia: "+query);
					
				}else {
					System.out.println("Registro insertado");
				}
			}
		}
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
