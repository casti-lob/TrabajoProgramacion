package com.mensajes;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public abstract class Persona {
	private String nombre;
	private int edad;
	protected List<Mensaje> mensajesRecibidos;
	
	
	public Persona(String nombre, int edad) throws PersonaException {
		super();
		this.setNombre(nombre);
		this.setEdad(edad);
		this.mensajesRecibidos= new LinkedList<Mensaje>();
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	private void setNombre(String nombre) throws PersonaException {
		if(nombre==null) {
			throw new PersonaException("El nombre no puede ser nulo");
		}
		this.nombre = nombre;
	}

	private void setEdad(int edad) throws PersonaException {
		if(edad<1) {
			throw new PersonaException("La edad no puede ser menor que 1");
		}
		this.edad = edad;
	}
	public boolean enviarMensaje(Persona datos, String texto) throws MensajeException, AlumnoException {
		
		Mensaje m = new Mensaje(this.nombre, texto);
		
		
		return datos.mensajesRecibidos.add(m);
		
	}
	public String leerBuzon() throws PersonaException {
		if(mensajesRecibidos.isEmpty()) {
			throw new PersonaException("No tienes mensajes en el buzon");
		}
		StringBuilder lista = new StringBuilder();
		for(Mensaje i: mensajesRecibidos) {
			lista.append(i+"\n");
		}
		return lista.toString();
	}
	/*
	public String leerBuzonOrdenado() {
		return Arrays.sort(mensajesRecibidos);
	}
	*/
	
	public boolean borrarMensaje(int numero) throws PersonaException {
		boolean borrado= false;
		Iterator<Mensaje> siguiente = this.mensajesRecibidos.iterator();
		while(siguiente.hasNext()&& borrado==false) {
			Mensaje m= siguiente.next();
			if(m.getCodigo()==numero) {
				mensajesRecibidos.remove(m);
				borrado=true;
			}
		}
		if(borrado==false) {
			throw new PersonaException("Mensaje no encontrado");
		}
		return borrado;
	}
		//preguntar
	public String busquedaFrase(String texto) throws PersonaException {
		StringBuilder lista= new StringBuilder();
		boolean encontrado= false;
		for(Mensaje i:mensajesRecibidos) {
			if(i.getTexto().contains(texto)) {
				lista.append(i+"\n");
				encontrado= true;
			}
		}
		if(encontrado==false) {
			throw new PersonaException("No hay ningun texto con esa frase");
		}
		return lista.toString();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(edad, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return edad == other.edad && Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return nombre + ", edad=" + edad + ", mensajesRecibidos=" + mensajesRecibidos;
	}
	
	
	
	
}
	