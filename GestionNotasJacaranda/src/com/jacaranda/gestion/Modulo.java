package com.jacaranda.gestion;

import java.util.Objects;

public class Modulo {
	private String nombre;
	private int codigo;
	private static int codigoSiguiente=0;
	private int numHorasSemanales;
	private int creditos;
	public Modulo(String nombre, int numHorasSemanales, int creditos) throws ModuloException {
		super();
		this.setNombre(nombre);
		this.setNumHorasSemanales(numHorasSemanales);
		this.setCreditos(creditos);
		this.setCodigo();
	}
	public Modulo(String nombre) throws ModuloException {
		super();
		this.setNombre(nombre);
		this.setCodigo();
	}
	
	private void setNombre(String nombre) throws ModuloException {
		if(nombre.isBlank()||nombre==null) {
			throw new ModuloException("El nombre no pede ser nulo o estar vacio");
		}
		this.nombre = nombre;
	}
	private void setCodigo() {
		this.codigo= Modulo.codigoSiguiente++;
	}
	public int getNumHorasSemanales() {
		return numHorasSemanales;
	}
	public void setNumHorasSemanales(int numHorasSemanales) throws ModuloException {
		if(numHorasSemanales<1) {
			throw new ModuloException("Las horas semanales no pueden ser menores que 1");
		}
		this.numHorasSemanales = numHorasSemanales;
	}
	public int getCreditos() {
		return creditos;
	}
	public void setCreditos(int creditos) throws ModuloException {
		if(creditos<1) {
			throw new ModuloException("Los creditos no pueden ser menores que 1");
		}
		this.creditos = creditos;
	}
	public String getNombre() {
		return nombre;
	}
	public int getCodigo() {
		return codigo;
	}
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
		Modulo other = (Modulo) obj;
		return Objects.equals(nombre, other.nombre);
	}
	@Override
	public String toString() {
		return "Modulos [nombre=" + nombre + ", codigo=" + codigo + ", numHorasSemanales=" + numHorasSemanales
				+ ", creditos=" + creditos + "]";
	}
	
}
