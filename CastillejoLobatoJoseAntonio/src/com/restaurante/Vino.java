package com.restaurante;

import java.util.Objects;

public class Vino {
	private String nombre;
	private double graduacion;
	
	//constructor solo con el nombre
	public Vino(String nombre) {
		super();
		this.nombre = nombre;
		this.graduacion=0;
	}
	//constructor con todos los parametros
	public Vino(String nombre, double graduacion) throws VinoException {
		super();
		this.nombre = nombre;
		setGraduacion(graduacion);
	}
	
	//Get&Set
	public String getNombre() {
		return nombre;
	}
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getGraduacion() {
		return graduacion;
	}
	private void setGraduacion(double graduacion) throws VinoException {
		if(graduacion<0) { //Lanzamos una exception en caso de que la graduacion sea 0
			throw new VinoException("El vino no puede tener una graduacion menor que 0");
		}
		this.graduacion = graduacion;
	}
	//equals cuando tengan el mismo nombre
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vino other = (Vino) obj;
		return Objects.equals(nombre, other.nombre);
	}
	@Override
	public String toString() {
		return "Vino [nombre=" + nombre + ", graduacion=" + graduacion + "]";
	}
	
	
	
	
	
	

}
