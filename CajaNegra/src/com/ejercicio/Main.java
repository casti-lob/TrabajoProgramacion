package com.ejercicio;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
	static Set<Registro> registros=new  HashSet<Registro>();
	
	public static void main(String[] args) {
		
		try {
			Empleado e = new Empleado(001, "1234567891",12, '-');
			introducirRegistro(e);
			System.out.println(registros);
			
		} catch (empleadoException e) {
			System.out.println(e.getMessage());		}
	}
	public static void introducirRegistro(Empleado e) {
		Registro r= new Registro();
		r.crearRegistro(e);
		registros.add(r);
	}
	
}
