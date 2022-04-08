package com.diccionario;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class PalabrasEmpiezan {
	private Character letra;
	private List<Palabra> listaPalabras;
	
	public PalabrasEmpiezan(char letra) {
		super();
		this.letra = letra;
		this.listaPalabras = new LinkedList<>();
	}

	public char getLetra() {
		return letra;
	}
	
	public void addPalabra(String palabra, String significado) throws SignificadoException, PalabraException, PalabrasEmpiezanException {
		
		if(palabra.charAt(0)== this.letra) {
			boolean encontrado=false;
			Iterator<Palabra> siguiente= listaPalabras.iterator();
			while(siguiente.hasNext()&&!encontrado) {
				Palabra p = siguiente.next();
				if(listaPalabras.contains(p)) {
					encontrado= true;
					p.setListaSignificados(significado);
				}	
			}
			if(!encontrado) {
				Palabra p2 = new Palabra(palabra);
				listaPalabras.add(p2);
				p2.setListaSignificados(significado);
			}
		}else {
			throw new PalabrasEmpiezanException("La palabra no empieza por la letra");
		}
	}
	
	private int buscarPosicion(Palabra p) {
		boolean encontrado = false;
		int posicion=0, elementoPosicion=0;
		Iterator<Palabra> siguiente = listaPalabras.iterator();
		
		while(siguiente.hasNext()&&!encontrado) {
			Integer elemento = listaPalabras.get(siguiente.next());
			if()
		}
	}
	
	public String listaPalabras() throws PalabrasEmpiezanException {
		if(listaPalabras.isEmpty()) {
			throw new PalabrasEmpiezanException("No hay elemento en la lista");
		}
		StringBuilder lista = new StringBuilder();
		for(Palabra i: listaPalabras) {
			lista.append(i.getTexto()+" "+ i.getListaSignificados());
		}
		return lista.toString();
	}
	
	public void delPalabra(String palabra) throws PalabrasEmpiezanException {
		if(palabra==null) {
			throw new PalabrasEmpiezanException("La palabra no puede ser nula");
		}
		boolean encontrado=false;
		Iterator<Palabra> siguiente = listaPalabras.iterator();
		while(siguiente.hasNext()&& !encontrado) {
			Palabra p = siguiente.next();
			if(p.getTexto().equals(palabra)) {
				listaPalabras.remove(p);
				encontrado= true;
			}
		}
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(letra);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PalabrasEmpiezan other = (PalabrasEmpiezan) obj;
		return Objects.equals(letra, other.letra);
	}
	
	@Override
	public String toString() {
		return "PalabrasEmpiezan letra=" + letra ;
	}
	
	
	
	
}
