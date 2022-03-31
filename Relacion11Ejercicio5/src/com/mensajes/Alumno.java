package com.mensajes;

public class Alumno extends Persona {

	public Alumno(String nombre, int edad) throws PersonaException {
		super(nombre, edad);
		
	}
	
	@Override
	public boolean enviarMensaje(Persona datos, String texto) throws MensajeException, AlumnoException {
		boolean enviado= false;
		Mensaje m = new Mensaje(this.getNombre(), texto);
		if(this.getEdad()<18 && !(datos instanceof Profesor)) {
			throw new AlumnoException("Eres menor de edad no puedes mandar mensajes a alumnos");
		}else {
		 datos.mensajesRecibidos.add(m);
		 enviado=true;
		}
		return enviado;
	}
	
	@Override
	public String toString() {
		return "Alumno [" + super.toString() + "]";
	}
	
}
