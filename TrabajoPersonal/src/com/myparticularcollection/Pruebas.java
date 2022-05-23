package com.myparticularcollection;

import java.time.LocalDate;

public class Pruebas {
	public static void main(String[] args) {
		
		try {
			Libro l = new Libro("sdf", LocalDate.now(), "terror", "pendiente", "sdd", 20);
				System.out.println(l);
				//l.ge
		} catch( Exception e) {
			System.out.println(e.getMessage());
		} 
	}
}
