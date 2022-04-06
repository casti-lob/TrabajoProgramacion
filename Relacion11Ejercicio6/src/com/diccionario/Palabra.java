package com.diccionario;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Palabra {
	private String texto;
	private List<Significado> listaSignificados;
	
	public Palabra(String texto) {
		super();
		this.texto = texto;
		this.listaSignificados = new LinkedList<Significado>();
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) throws PalabraException {
		if(texto== null|| texto==""||texto==" ") {
			throw new PalabraException("El significado no puede ser nulo");
		}
		this.texto = texto;
	}

	public String getListaSignificados() {
		StringBuilder lista = new StringBuilder();
		for(Significado i: listaSignificados) {
			lista.append(i +"\n");
		}
		return lista.toString();
	}
	//añade un significado a la palabra
	public void setListaSignificados(String texto) throws SignificadoException, PalabraException {
		
		Significado s= new Significado(texto); // creamos el significado y lo añadimos a la lista
		Iterator<Significado> siguiente = this.listaSignificados.iterator();
		while(siguiente.hasNext()) {
			Significado s2=siguiente.next();
			if(s2.getTexto().equals(texto)) {
				
				throw new PalabraException("Significado repetido");
				
			}
		}
		this.listaSignificados.add(s);
	}

	@Override
	public int hashCode() {
		return Objects.hash(texto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Palabra other = (Palabra) obj;
		return Objects.equals(texto, other.texto);
	}

	@Override
	public String toString() {
		return "Palabra [texto=" + texto + "\n Lista Significados: \n" + getListaSignificados() + "]";
	}
	
	
	
	
}
