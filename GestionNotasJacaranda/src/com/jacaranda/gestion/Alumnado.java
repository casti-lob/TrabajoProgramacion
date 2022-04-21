package com.jacaranda.gestion;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Alumnado {
	private String nombre;
	private String dni;
	private String correoE;
	public Alumnado(String nombre, String dni) throws AlumnadoException {
		super();
		this.setNombre(nombre);
		this.setDni(dni);
	}
	public Alumnado(String nombre, String dni, String correoE) throws AlumnadoException {
		super();
		this.setNombre(nombre);
		this.setDni(dni);
		this.setCorreoE(correoE);
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) throws AlumnadoException {
		if(nombre.isBlank()||nombre==null) {
			throw new AlumnadoException("El nombre no pede ser nulo o estar vacio");
		}
		this.nombre = nombre;
	}
	public String getCorreoE() {
		return correoE;
	}
	public void setCorreoE(String correoE) throws AlumnadoException {
		
	        Pattern patronEmail = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)(\\.[A-Za-z]{2,})$");
	   
	        Matcher mEmail = patronEmail.matcher(correoE.toLowerCase());
	        if (mEmail.matches()){
	        	this.correoE = correoE;
	        }else {
	        	throw new AlumnadoException("El correo no es valido");
	        }
		
		
	}
	public String getDni() {
		return dni;
	}
	
	private void setDni(String dni) throws AlumnadoException {
		if(dni.isBlank()||dni==null) {
			throw new AlumnadoException("El dni no puede ser nulo o estar en blanco");
		}else if(dni.length()!=9) {
			throw new AlumnadoException("El dni tiene que ser de 9 caracteres");
		}
		this.dni = dni;
	}
	@Override
	public String toString() {
		return "Alumnado [nombre=" + nombre + ", dni=" + dni + ", correoE=" + correoE + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumnado other = (Alumnado) obj;
		return Objects.equals(dni, other.dni);
	}
	
	
}
