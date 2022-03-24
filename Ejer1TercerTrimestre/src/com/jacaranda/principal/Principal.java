package com.jacaranda.principal;

import com.jacaranda.equipo.Equipo;
import com.jacaranda.jugadores.ALumno;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ALumno a =new ALumno("JOSE","555");
		ALumno c=new ALumno("javi", null);
		Equipo e =new Equipo("Sevilla");
		try {
			e.addAlumno(a);
			System.out.println("Alumno añadido");
			System.out.println(e);
			System.out.println(e.numAlumnos());
			
			System.out.println("Eliminado");
			System.out.println(e);
			System.out.println(e.mostrarAlumno());
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
		}
	}

}
