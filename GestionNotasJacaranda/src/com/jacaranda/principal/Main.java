package com.jacaranda.principal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

import com.jacaranda.gestion.Alumnado;
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
			switch (opc) {
			case 1: {

				break;
			}
			case 2: {

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
		} while (opc!=6);
	}

	public static void muestraMenu() {
		System.out.println(
				"1. Alta alumnado\n2.Alta modulo\n3.Registrar nota\n4.Listar notas todos los alumnos\n5.Listar todos los alumnos\n6.Salir");
	}
}
