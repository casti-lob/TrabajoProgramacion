package com.restaurante;

import java.util.Scanner;

public class Menu {
	static final int MAXPLATOS=100;
	static Plato[] listaPlatos = new Plato[MAXPLATOS];
	static int numeroPlatos=0;
	static Scanner teclado= new Scanner(System.in); 
	public static void main(String[] args) {
		int opc=0;
		
			do {
				try {
				menu();
				System.out.println("Introduce una opcion");
				opc=Integer.parseInt(teclado.nextLine());
				switch (opc) {
				case 1: {
					System.out.println(altaPlato());
					break;
				}case 2: {
					System.out.println(modificarPrecio());
					break;
				}case 3: {
					System.out.println(asignarVino());
					break;
				}case 4: {
					System.out.println(asignarVino());
					break;
				}
				case 5: {
					for (int i=0; i<numeroPlatos;i++) {
						System.out.println(listaPlatos[i]);
						}
					
					break;
				}
				case 6: {
					System.out.println("Cerrando Programa");
					break;
				}
				default:
					System.out.println("Opcion no contemplada");
				}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
			} while (opc!=6);
		

	}
	public static void menu() {
		System.out.println("1. Dar de alta un plato \n"+
				"2. Modificar el precio de un plato\n"+
				"3. Asignar un vino a un plato. \n"+
				"4. Mostrar información de un plato. \n"+
				"5. Mostrar información de todos los platos. \n"+
				"6. Salir.\n"
				);
	}
	public static String altaPlato() throws PlatoException {
		String nombre,mensaje="";
		int posicion=0;
		double precio;
		boolean encontrado=false;
		System.out.println("Introduce el nombre del plato");
		nombre=teclado.nextLine().toUpperCase();
		System.out.println("Introduce el precio del plato");
		precio= Double.parseDouble(teclado.nextLine());
		
		for (int i=0; i<numeroPlatos&& encontrado==false;i++) {
			if(listaPlatos[i].getNombre().equals(nombre)) {
				encontrado = true;
				posicion=-1;
			}
		}
		if(posicion==-1) {
			mensaje="Plato repetido";
		}else {
			listaPlatos[posicion] = new Plato(nombre, precio);
			numeroPlatos+=1;
			mensaje = "Plato añadido";
		}
		return mensaje;
	}
	
	public static String modificarPrecio() throws PlatoException {
		String nombre,mensaje="";
		int posicion=-1;
		double precio;
		boolean encontrado=false;
		System.out.println("Introduce el nombre del plato");
		nombre=teclado.nextLine().toUpperCase();
		
		for (int i=0; i<numeroPlatos&& encontrado==false;i++) {
			if(listaPlatos[i].getNombre().equals(nombre)) {
				encontrado = true;
				posicion= i;
			}
		}
		if(posicion==-1) {
			mensaje="Plato no encontrado";
		}else {
			System.out.println("Plato encontrado introduce el nuevo precio del plato");
			precio= Double.parseDouble(teclado.nextLine());
			listaPlatos[posicion].setPrecio(precio);
			
			mensaje = "Precio del plato modificado";
		}
		return mensaje;
	}
	
	public static String asignarVino() throws PlatoException, VinoException {
		String nombre,mensaje="";
		int posicion=-1;
		double precio;
		boolean encontrado=false;
		System.out.println("Introduce el nombre del plato");
		nombre=teclado.nextLine().toUpperCase();
		
		for (int i=0; i<numeroPlatos&& encontrado==false;i++) {
			if(listaPlatos[i].getNombre().equals(nombre)) {
				encontrado = true;
				posicion= i;
			}
		}
		if(posicion==-1) {
			mensaje="Plato no encontrado";
		}else {
			System.out.println("Plato encontrado introduce el nombre del vino");
			nombre=teclado.nextLine().toUpperCase();
			
			System.out.println("Introduce la graduacion del vino");
			precio= Double.parseDouble(teclado.nextLine());
			Vino añadirVino = new Vino(nombre, precio);
			listaPlatos[posicion].setVinoRecomendado(añadirVino);
			
			
			mensaje = "Vino añadido";
		}
		return mensaje;
	}
	/* No me ha dado tiempo a terminarlo
	static int posicionPlato() {
		String nombre="";
		int posicion=0;
		boolean encontrado= false;
		System.out.println("Introduce el nombre del plato");
		
		for (int i=0; i<numeroPlatos&& encontrado==false;i++) {
			if(listaPlatos[i].getNombre().equals(nombre)) {
				encontrado = true;
				posicion=-1;
			}
		}
		return posicion;
	}
	static String mostrarUnPlato() {
			
		}
	}
	*/
	
}
