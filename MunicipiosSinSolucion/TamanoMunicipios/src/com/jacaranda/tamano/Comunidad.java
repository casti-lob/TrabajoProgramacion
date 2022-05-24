package com.jacaranda.tamano;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Comunidad {
	private String nombre;
	private Set<Municipio> listMunicipio;
	
	public Comunidad(String descrip) {
		this.nombre = descrip;
		listMunicipio=new HashSet<>();
		
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void introducirMunicipio(Municipio m) {
		listMunicipio.add(m);
	}

	public void setListMunicipio(Set<Municipio> listMunicipio) {
		this.listMunicipio = listMunicipio;
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
		Comunidad other = (Comunidad) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Comunidad [nombre=" + nombre + ", listMunicipio=" + listMunicipio + "]";
	}
	
	
	

	
}
