package com.jacaranda.utilities;

import java.util.Objects;

public class Pueblo implements Comparable<Pueblo>{
	private String nombre;
	private String codigo;
	private int numeroHabitantes;
	private double rentaPerCapita;
	private double superficie;
	
	public Pueblo(String nombre, String codigo, int numeroHabitantes, double rentaPerCapita, double superficie) throws PuebloException {
		super();
		setNombre(nombre);
		setCodigo(codigo);
		setNumeroHabitantes(numeroHabitantes);
		setRentaPerCapita(rentaPerCapita);
		setSuperficie(superficie);
	}

	public Pueblo(String nombre, String codigo) throws PuebloException {
		super();
		setNombre(nombre);
		setCodigo(codigo);
		this.numeroHabitantes=0;
		this.rentaPerCapita=0;
		this.superficie=0;
	}
	
	private void setNombre(String nombre) throws PuebloException {
		if (nombre== null) {
			throw new PuebloException("El nombre no puede ser nulo");
		}
		this.nombre= nombre.toUpperCase();
	}

	private void setCodigo(String codigo) throws PuebloException {
		if(codigo==null) {
			throw new PuebloException("El codigo no puede ser nulo");
		}
		else if(codigo.length()!=5) {
			throw new PuebloException("El codigo debe de tener 5 digitos");
		}
		for(int i=0;i<codigo.length();i++) {
			if(!Character.isDigit(codigo.charAt(i))) {
				throw new PuebloException("Solo puede tener numeros");
			}
		}
		this.codigo = codigo;
	}

	public int getNumeroHabitantes() {
		return numeroHabitantes;
	}

	public void setNumeroHabitantes(int numeroHabitantes) throws PuebloException {
		if(numeroHabitantes<1) {
			throw new PuebloException("El numero de habitantes no puede ser 0 o negativo");
		}
		this.numeroHabitantes = numeroHabitantes;
	}

	public double getRentaPerCapita() {
		return rentaPerCapita;
	}

	public void setRentaPerCapita(double rentaPerCapita) throws PuebloException {
		if(rentaPerCapita<0) {
			throw new PuebloException("No puede ser negativo la renta per capita");
		}
		this.rentaPerCapita = rentaPerCapita;
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) throws PuebloException {
		if(superficie<0) {
			throw new PuebloException("La superficie no puede ser negativa");
		}
		this.superficie = superficie;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pueblo other = (Pueblo) obj;
		return Objects.equals(codigo, other.codigo);
	}

	@Override
	public int compareTo(Pueblo other) {
		
		return this.nombre.compareTo(other.getNombre());
	}

	@Override
	public String toString() {
		return "Pueblo [nombre=" + nombre + ", codigo=" + codigo + ", numeroHabitantes=" + numeroHabitantes
				+ ", rentaPerCapita=" + rentaPerCapita + ", superficie=" + superficie + "]";
	}
	
	
	
	

}
