package com.mensajes;

public class Profesor extends Persona {

	public Profesor(String nombre, int edad) throws PersonaException {
		super(nombre, edad);
		
	}
	

	@Override
	public String toString() {
		return "Profesor [" + super.toString() + "]";
	}
	
	

}
