
package com.jacaranda.principal;

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

	public static LinkedList<Alumnado> listadoAlumnado= new LinkedList<>();
	public static HashSet<Module> listaModulos=new HashSet<>();
	public static ArrayList<Nota> listaNota=new ArrayList<>();
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		int opc;
		do {
			
			muestraMenu();
			opc = Integer.parseInt(teclado.nextLine());
			try {
			switch (opc) {
			
				
			
			case 1: {
				altaAlumno();
				break;
			}
			case 2: {
				altaAsignatura();
				break;
			}
			case 3: {

				break;
			}
			case 4: {
				for(Nota nota:listaNota) {
					System.out.println(nota);
				}
				break;
			}case 5: {
				for(Alumnado i:listadoAlumnado) {
					System.out.println(i);
				}
				break;
			}
			
			default:
				System.out.println("NO permitida");
			}
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (opc!=6);
	}

	public static void muestraMenu() {
		System.out.println(
				"1. Alta alumnado\n2.Alta modulo\n3.Registrar nota\n4.Listar notas todos los alumnos\n5.Listar todos los alumnos\n6.Salir");
	}
	
	public static void altaAlumno() throws AlumnadoException {
		String nombre,dni;
		System.out.println("Introduce el nombre");
		nombre= teclado.nextLine();
		System.out.println("Introduce el dni");
		dni= teclado.nextLine();
		Alumnado a = new Alumnado(nombre, dni);
		if(listadoAlumnado.isEmpty()) {
			listadoAlumnado.add(a);
		}else {
			boolean add= false;
			Iterator<Alumnado> siguiente= listadoAlumnado.iterator();
			while(siguiente.hasNext()||add) {
				Alumnado i=siguiente.next();
				if(i.equals(a)) {
					add=true;
				}
			}
			if(add==false) {
				listadoAlumnado.add(a);
			}
		}
	}
	
	public static void altaAsignatura() throws ModuloException {
		String nombre;
		System.out.println("Introduce el nombre");
		nombre= teclado.nextLine();
		Modulo m = new Modulo(nombre);
		listaModulos.add(m);
	}
}
