package com.myparticularcollection;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Elemento implements Comparable<Elemento> {
	private String nombre;
	private LocalDate fechaEstreno;
	private String genero;
	private int valoracion;
	private Estado director;
	
	//Constructor
	public Elemento(String nombre, LocalDate fechaEstreno, String genero, String estado) throws Exception {
		super();
		this.setNombre(nombre);
		this.setFechaEstreno(fechaEstreno);
		this.setGenero(genero);
		this.setValoracion(0);
		this.setEstado(estado);
	}
	
	//Get&Set
	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) throws ElementoException {
		if(nombre==null || nombre.isBlank()) {
			throw new ElementoException("El nombre no puede ser nulo o estar en blanco");
		}
		this.nombre = nombre;
	}

	public LocalDate getFechaEstreno() {
		return fechaEstreno;
	}

	private void setFechaEstreno(LocalDate fechaEstreno) throws ElementoException {
		if(fechaEstreno==null) {
			throw new ElementoException("La fecha no puede ser nula");
		}
		this.fechaEstreno = fechaEstreno;
	}

	public String getGenero() {
		return genero;
	}
	
	private void setGenero(String genero) throws ElementoException {
		if(genero==null||genero.isBlank()) {
			throw new ElementoException("El genero no puede ser nulo o estar en blanco");
		}
		this.genero = genero;
	}

	public void setEstado(String estado) throws Exception {
		if(estado==null|| estado.isBlank()) {
			throw new ElementoException("El estado no puede ser nulo o estar en blanco");
		}
		try {
			this.director = Estado.valueOf(estado.toUpperCase());
		} catch (Exception e) {
			throw new Exception("Estado no aceptiado (PENDIENTE,ENPROGRESO,TERMINADO)");
		}	
	}
	
	
	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) throws ElementoException {
		if(valoracion<0||valoracion>10) {
			throw new ElementoException("La valoracion tiene que ser entre 0 y 10");
		}
		this.valoracion = valoracion;
	}

	//Comparamos por la valoración del elemento
	@Override
	public int compareTo(Elemento o) {
		return this.valoracion-o.valoracion;
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
		Elemento other = (Elemento) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return nombre + " Fecha de estreno: " + fechaEstreno + ", Genero: " + genero + ", Valoracion: "
				+ valoracion + ", Estado:" + director;
	}
	
	
	
	
}
