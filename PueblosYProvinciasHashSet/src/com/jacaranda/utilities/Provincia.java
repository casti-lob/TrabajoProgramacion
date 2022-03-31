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
		this.superficie=0;
		this.numeroHabitantes=0;
		this.rentaPerCapita=0;
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
		this.superficie+=superficie;
		this.numeroHabitantes+=numeroHabitantes;
		this.rentaPerCapita+= rentaPerCapita;
		introducido= true;
		return introducido;
		
	}
	
	public String listadoNombresPueblos() throws ProvinciaException {
		StringBuilder lista= new StringBuilder();
		if(pueblos.isEmpty()) {
			throw new ProvinciaException("La provincia no contiene ningun pueblo");
		}
		for(Pueblo i:pueblos) {
			lista.append( i.toString()+"\n");
		}
		return lista.toString();
	}
	
	public String listadoPueblos() throws ProvinciaException {
		StringBuilder lista= new StringBuilder();
		if(pueblos.isEmpty()) {
			throw new ProvinciaException("La provincia no contiene ningun pueblo");
		}
		for(Pueblo i:pueblos) {
			
			lista.append( i.toString()+"\n");
		}
		return lista.toString();
	}
	
	public boolean delPueblo(String pueblo) throws ProvinciaException {
		boolean borrado = false, encontrado=false;
		if(pueblos.isEmpty()) {
		Pueblo a=null;
		Iterator<Pueblo> siguiente= pueblos.iterator();
		while(siguiente.hasNext()||encontrado==false) {
			a= siguiente.next();
			if(a.getNombre().equalsIgnoreCase(pueblo)) {
				pueblos.remove(a);
				encontrado= true;
				borrado= true;
				this.numeroHabitantes -= a.getNumeroHabitantes();
				this.superficie-= a.getSuperficie();
		
		}
		
		}
	}
		return borrado;
	}
	public boolean setSuperficie(String pueblo, double superficie) throws ProvinciaException, PuebloException {
		boolean actualizado= false;
		double diferencia;
		if(pueblo== null) {
			throw new ProvinciaException("El nombre de pueblo no puede ser nulo");
		}
		boolean encontrado=false;
		Iterator<Pueblo> siguiente = pueblos.iterator();
		Pueblo p =null;
		while(siguiente.hasNext()||encontrado==false) {
			p= siguiente.next();
			if(p.getNombre().equalsIgnoreCase(pueblo)) {
				diferencia = superficie-p.getSuperficie();
				
					this.superficie+=diferencia;
					p.setSuperficie(superficie);
					encontrado= true;
				}
				
				actualizado= true;
			}
		
		return actualizado;
	}
	
	public boolean setNUmeroHabitantes(String pueblo, int numeroHabitantes) throws ProvinciaException, PuebloException {
		boolean actualizado= false;
		int diferencia;
		if(pueblo== null) {
			throw new ProvinciaException("El nombre de pueblo no puede ser nulo");
		}
		boolean encontrado = false;
		Pueblo p= null;
		Iterator<Pueblo> siguiente = pueblos.iterator();
		while(siguiente.hasNext()&& encontrado==false) {
			p= siguiente.next();
			if(p.getNombre().equalsIgnoreCase(pueblo)) {
				diferencia = numeroHabitantes-p.getNumeroHabitantes();
				encontrado= true;
					this.numeroHabitantes+=diferencia;
					p.setNumeroHabitantes(numeroHabitantes);
				}
				
				actualizado= true;
			}
		return actualizado;
	}
	
	public int numPueblos() {
		
		return pueblos.size();
	}
	
	public double getRentaPerCapita() {
		return this.rentaPerCapita;
	}
	
	
	public void setRentaPerCapita(double rentaPerCapita) {
		this.rentaPerCapita = rentaPerCapita;
	}
	
	
	public String getNombre() {
		return nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public int getNumeroHabitantes() {
		return numeroHabitantes;
	}

	public double getSuperficie() {
		return superficie;
	}
	
	public String getInformacionPueblo(String pueblo) {
		String salida=null;
		
			Pueblo p = null;
			boolean encontrado= false;
			Iterator<Pueblo> siguiente = pueblos.iterator();
			while(siguiente.hasNext()&& encontrado==false) {
				p= siguiente.next();
				if (p.getNombre().equalsIgnoreCase(pueblo)) {
					salida = p.toString();
					encontrado= true;
				}
			}
		
		return salida;
	}
	@Override
	public String toString() {
		return "Provincia [nombre=" + nombre + ", codigo=" + codigo + ", numeroHabitantes=" + numeroHabitantes
				+ ", rentaPerCapita=" + rentaPerCapita + ", superficie=" + superficie + ", pueblos=" + pueblos + "]";
	}
	
	
	
	
}
