package com.jacaranda.utilities;

import java.util.Objects;

public class Pueblo {
	private String nombre;
	private String codigo;
	private int numeroHabitantes;
	private double rentaPerCapita;
	private double superficie;
	
	public Pueblo(String nombre, String codigo, int numeroHabitantes, double rentaPerCapita, double superficie) {
		super();
		setNombre(nombre);
		this.codigo = codigo;
		this.numeroHabitantes = numeroHabitantes;
		this.rentaPerCapita = rentaPerCapita;
		this.superficie = superficie;
	}

	public Pueblo(String nombre, String codigo) {
		super();
		setNombre(nombre);
		this.codigo = codigo;
	}
	
	private void setNombre(String nombre) {
		this.nombre= nombre.toUpperCase();
	}

	private void setCodigo(String codigo) throws PuebloException {
		
		if(codigo.length()!=5) {
			throw new PuebloException("El codigo debe de tener 5 dígitos");
		}
		for(int i=0;i>codigo.length();i++) {
			if(!Character.isDigit(codigo.charAt(i))) {
				throw new PuebloException("Solo puede tener numeros");
			}
		}
		this.codigo = codigo;
	}

	public int getNumeroHabitantes() {
		return numeroHabitantes;
	}

	public void setNumeroHabitantes(int numeroHabitantes) {
		this.numeroHabitantes = numeroHabitantes;
	}

	public double getRentaPerCapita() {
		return rentaPerCapita;
	}

	public void setRentaPerCapita(double rentaPerCapita) {
		this.rentaPerCapita = rentaPerCapita;
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
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

	
	
	

}
