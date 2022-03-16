package com.libreria;

import java.time.LocalDate;
import java.util.Scanner;

public class Puebas {
	public static Scanner teclado= new Scanner(System.in);
	static final int MAXLIBROS=4;
	static Libro[] libreria = new Libro[MAXLIBROS];
	static int inidce=0;
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			for(int i=0;i<MAXLIBROS;i++) {
				if(inidce>1) {
					System.out.println("Introduce un libro digital");
					Libro ld=new LibroDigital(introducirTitulo(), introducirAutor(), introducirEditorial(),introducirPrecio(),introducirformato());			
					libreria[i] =ld;
					System.out.println("Libro Introducido");
					inidce+=1;

				}else {
					System.out.println("Introduce un libro");
					Libro l=new LibroPapel(introducirTitulo(), introducirAutor(), introducirEditorial(), introducirPeso(), introducirPrecio());			
					libreria[i] =l;
					inidce+=1;
					System.out.println("Libro Introducido");
					
				}
				
			}
			for(int i=0;i<MAXLIBROS;i++) {
				System.out.println(libreria[i]);
				
			}
			for(int i=2;i<MAXLIBROS;i++) {
				System.out.println(((LibroDigital)libreria[i]).comparadorPrecio(libreria[i-2]));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static String introducirAutor() {
		String autor;
		System.out.println("Introduce el autor");
		return autor= teclado.nextLine();
		
	}

	public static String introducirTitulo() {
		String titulo;
		System.out.println("Introduce el titulo");
		return titulo= teclado.nextLine();
	}
	
	public static String introducirEditorial() {
		String editorial;
		System.out.println("Introduce la editorial");
		return editorial= teclado.nextLine();
	}
	
	public static int introducirPeso() {
		int peso;
		System.out.println("Introduce el peso");
		return peso= Integer.parseInt(teclado.nextLine());
	}
	
	public static int introducirPrecio() {
		int precio;
		System.out.println("Introduce el precio");
		return precio= Integer.parseInt(teclado.nextLine());
	}
	public static String introducirformato() {
		String editorial;
		System.out.println("Introduce la editorial(epub/mobi/pdf)");
		return editorial= teclado.nextLine();
		
	}
	
}
