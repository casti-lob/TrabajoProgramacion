package com.mensajes;

public class Main {

	public static void main(String[] args) {
		try {
			Profesor p = new Profesor("pepe", 5);
			Profesor p2 = new Profesor("Lucas", 5);
			System.out.println(p2.enviarMensaje(p, "hola"));
			System.out.println(p2.enviarMensaje(p, "pepe hola"));
			System.out.println(p2.enviarMensaje(p, "aaaa"));
			System.out.println(p2.enviarMensaje(p, "eeee"));
			System.out.println(p2.enviarMensaje(p, "llll hola"));
			System.out.println(p);
			System.out.println(p2);
			System.out.println(p.leerBuzon());
			System.out.println(p.busquedaFrase("hola"));
			Alumno a= new Alumno("jj", 5);
			Alumno a2= new Alumno("j", 18);
			System.out.println(a.enviarMensaje(p, "jjj"));
			System.out.println(p);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
