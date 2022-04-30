package com.myparticularcollection;

import java.time.LocalDate;

public class Pruebas {
	public static void main(String[] args) {
		
		try {
			/*
			Pelicula p = new Pelicula(" d", LocalDate.now(), "accion", "pendiente", "alguien random", 15.50);
			System.out.println(p);
			p.setEstado("terminad");
			System.out.println(p);
			*/
			Usuario u = new Usuario("JDLA", "dlasdfjla");
			System.out.println(u.addLibro("it", LocalDate.now(), "terror", "pendiente", "ddd", 120));
			System.out.println(u.addPelicula("it", LocalDate.now(),"terror", "pendiente", "ddd",10));
			
		} catch( Exception e) {
			System.out.println(e.getMessage());
		} 
	}
}
