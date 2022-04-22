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
			
			System.out.println(registros);
			
		} catch (empleadoException e) {
			System.out.println(e.getMessage());		}
	}
	
	
}
