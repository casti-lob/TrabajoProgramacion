package com.jacaranda.utilities;

import java.util.HashSet;
import java.util.Set;

public class Provincia {
	private String nombre;
	private String codigo;
	private int numeroHabitantes;
	private double rentaPerCapita;
	private double superficie;
	private Set<Pueblo> pueblos;
	
	public Provincia(String nombre, String codigo) throws ProvinciaException {
		super();
		setNombre(nombre);
		setCodigo(codigo);
		this.pueblos= new HashSet<Pueblo>();
		
	}

	private void setNombre(String nombre) throws ProvinciaException {
		if(nombre==null) {
			throw new ProvinciaException("El nombre no puede ser nulo");
		}
		this.nombre = nombre.toUpperCase();
	}

	private void setCodigo(String codigo) throws ProvinciaException {
		if(codigo==null) {
			throw new ProvinciaException("El codigo no puede ser nulo");
		}else if (codigo.length()!=2) {
			throw new ProvinciaException("El codigo debe de tener 2 caracteres");
		}
		for(int i=0; i<codigo.length();i++) {
			if(!Character.isDigit(codigo.charAt(i))) {
				throw new ProvinciaException("El codigo debe de ser numerico");
			}
		}
		this.codigo = codigo;
	}
	
	public boolean addPueblo(String nombrePueblo,String codigo, int numeroHabitantes, double rentaPerCapita, double superficie) {
		
	}
	
	
	
	
}
