package com.alquileres;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
	
	private static final int MAXVEHICULO=200;
	private static Vehiculo[] vehiculosExplotacion = new Vehiculo[MAXVEHICULO];
	private static int indiceLista;
	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) throws VehiculoException {
		int opc;
		try {
			
			do {
				menu();
				System.out.println("Introduce una opcion");
				opc= leerEntero();
				
				switch (opc) {
				case 1: {
					System.out.println(darAltaVehiculo());
					break;
				}case 2: {
					if(encontrarVehiculo()!=-1) {
						System.out.println(precioAlquiler());
					}else {
						System.out.println("Vehiculo no encontrado");
					}
					break;
				}case 3: {
					System.out.println("Cerrando el programa");
					break;
				}
				default:
					System.out.println("Error inesperado");
				}
				
			} while (opc!=3);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	public static int leerEntero() {
		int opc;
		opc= Integer.parseInt(teclado.nextLine());
		return opc;
	}
	
	public static void menu() {
		System.out.println("1. Alta de vehículo:\n"+
				"2. Cálculo de precio de alquiler\n"+
				"3. Salir.\n"
				
				);
	}
	//Metodo para seleccionar si un vehiculo es coche furgoneta o microbus
	public static int tipoVehiculo() {
		int vehiculo;
		System.out.println("Elige el tipo de vehiculo (1=coche 2=furgoneta o 3=microbus)");
		vehiculo=Integer.parseInt(teclado.nextLine());
		
		while (vehiculo!=1 && vehiculo!=2&&vehiculo!=3) {
			System.out.println("Tipo de vehiculo no aceptado");
			System.out.println("Elige el tipo de vehiculo (1=coche 2=furgoneta o 3=microbus)");
			vehiculo=Integer.parseInt(teclado.nextLine());
		};
		return vehiculo;
	}
	
	//metodo para dar de alta un vehiculo
	public static String darAltaVehiculo() throws VehiculoException {
		String respuesta="";
		if(tipoVehiculo()==1) {
			Vehiculo c = new Coche(matricula(),gama() ,fechaSalida() , carburante());
			vehiculosExplotacion[indiceLista]=c;
			respuesta= "Se ha introducido un coche";
		}else if(tipoVehiculo()==2){
			Vehiculo f = new Furgoneta(pma(), matricula(), gama(), fechaSalida());
			vehiculosExplotacion[indiceLista]=f;
			respuesta= "Se ha introducido una furgoneta";
		}else {
			Vehiculo m = new MicroBus(nplaza(), matricula(), gama(), fechaSalida());
			vehiculosExplotacion[indiceLista]=m;
			respuesta= "Se ha introducido un microBus";
		}
		indiceLista+=1;
		return respuesta;
	}
	
	
	public static int encontrarVehiculo() {
		boolean encontrado = false;
		int resultado=-1;//nos indica la posición del vehiculo y si da -1 es que no hay vehiculo
		matricula();
		for(int i=0;i<indiceLista&&encontrado==false;i++) {
			if(vehiculosExplotacion[i].getMatricula().equals(matricula())) {
				encontrado=true;
				resultado=i;
			}
		}
		return resultado;
	}
	public static double precioAlquiler() {
		return vehiculosExplotacion[encontrarVehiculo()].getPrecio();
	}
	
	public static String matricula() {
		String matricula;
		System.out.println("Introduce la matricula");
		return matricula= teclado.nextLine();
		
	}
	public static String gama() {
		String gama;
		System.out.println("Introduce la gama del vehiculo");
		return gama= teclado.nextLine();
		
	}
	public static String carburante() {
		String carburante;
		System.out.println("Introduce el carburante del vehiculo");
		return carburante= teclado.nextLine();
		
	}
	
	public static LocalDate fechaSalida() {
		LocalDate fechaSalida;
		System.out.println("Introduce la fecha de salida");
		fechaSalida= LocalDate.parse(teclado.nextLine());
		fechaSalida= LocalDate.parse("YYYY-MM-DD");
		
		return fechaSalida;
		
	}
	
	public static int pma() {
		int pma;
		System.out.println("Introduce el peso maximo autorizado");
		return pma= Integer.parseInt(teclado.nextLine());
		
	}
	public static int nplaza() {
		int nplaza;
		System.out.println("Introduce el numeros de plaza del microbus");
		return nplaza= Integer.parseInt(teclado.nextLine());
		
	}
	
}
