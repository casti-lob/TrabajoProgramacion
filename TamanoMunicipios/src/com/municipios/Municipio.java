package com.municipios;
import java.util.HashSet;
import java.util.Iterator;
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
	
	public String datosPorAnno(int anno) {
		boolean encontrado =false;
		StringBuilder lista = new StringBuilder();
		int dato=0;
		Iterator<Datos>siguiente= datos.iterator();
		while(siguiente.hasNext()&&!encontrado) {
			Datos d= siguiente.next();
			if(d.getAno()==anno) {
				lista.append(this.descrip+" Dato= "+d.getDato()+"\n");
				encontrado=true;
			}
			
		}
		return lista.toString();
	}
	
	public void anadirDato(int ano, int dato) {
		boolean anoEncontrado=false;
		Iterator<Datos> siguiente=datos.iterator();
		while(siguiente.hasNext()&&!anoEncontrado) {
			Datos d = siguiente.next();
			if(d.getAno()==ano) {
				d.setDato(dato);
				anoEncontrado=true;
			}
		}
		if(!anoEncontrado) {
			Datos nuevoDato = new Datos(ano, dato);
			datos.add(nuevoDato);
		}
	}
		
	public int SumaValores(int ano) {
		int valor=0;
		for(Datos i:datos) {
			if(i.getAno()==ano) {
				valor+=i.getDato();
			}
		}
		return valor;
	}
	
	
	
	
	
	
}