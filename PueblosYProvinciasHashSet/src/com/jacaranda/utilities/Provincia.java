package com.jacaranda.utilities;

import java.util.HashSet;
import java.util.Iterator;
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
	
	public boolean addPueblo(String nombrePueblo,String codigo, int numeroHabitantes, double rentaPerCapita, double superficie) throws ProvinciaException, PuebloException {
		boolean introducido= false;
		if(nombrePueblo==null) {
			throw new ProvinciaException("El nombre del pueblo no puede ser nulo");
		}
		codigo= this.codigo+codigo;
		Pueblo p= new Pueblo(nombrePueblo, codigo, numeroHabitantes, rentaPerCapita, superficie);
		if(pueblos.contains(p)) {
			throw new ProvinciaException("El pueblo ya existe");
		}
		for(Pueblo i:pueblos) {
			if(i.getNombre().equals(nombrePueblo.toUpperCase())) {
				throw new ProvinciaException("El nombre del pueblo ya existe");
			}
		}
		pueblos.add(p);
		introducido= true;
		return introducido;
		
	}
	
	public String listadoNombresPueblos() throws ProvinciaException {
		String lista="";
		if(pueblos.isEmpty()) {
			throw new ProvinciaException("La provincia no contiene ningun pueblo");
		}
		for(Pueblo i:pueblos) {
			lista+= i.getNombre()+"\n";
		}
		return lista;
	}
	
	public String listadoPueblos() throws ProvinciaException {
		String lista="";
		if(pueblos.isEmpty()) {
			throw new ProvinciaException("La provincia no contiene ningun pueblo");
		}
		for(Pueblo i:pueblos) {
			lista+= i.toString()+"\n";
		}
		return lista;
	}
	//Preguntar
	public boolean delPueblo(String pueblo) throws ProvinciaException {
		boolean borrado = false;
		if(pueblo ==null||pueblos.isEmpty()){
			throw new ProvinciaException("No existe la lista o el nombre es nulo");
		}
		Iterator<Pueblo> i= this.pueblos.iterator();
		while(i.hasNext()) {
			Pueblo p= i.next();
			if(p.getNombre().equalsIgnoreCase(pueblo)) {
				borrado =pueblos.remove(p);
			}
		}
		return borrado;
	}
	@Override
	public String toString() {
		return "Provincia [nombre=" + nombre + ", codigo=" + codigo + ", numeroHabitantes=" + numeroHabitantes
				+ ", rentaPerCapita=" + rentaPerCapita + ", superficie=" + superficie + ", pueblos=" + pueblos + "]";
	}
	
	
	
	
}
