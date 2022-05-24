package com.jacaranda.tamano;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Municipio {

	private String  descrip;
	private Set<Datos> datos;
	
	public Municipio(String descrip) {
		super();
		this.descrip = descrip;
		this.datos = new HashSet<>();
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public Set<Datos> getDatos() {
		return datos;
	}

	public void introducirDatos(Datos d) {
		datos.add(d);
	}

	@Override
	public int hashCode() {
		return Objects.hash(datos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Municipio other = (Municipio) obj;
		return Objects.equals(datos, other.datos);
	}

	@Override
	public String toString() {
		return "Municipio [descrip=" + descrip + ", datos=" + datos + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
