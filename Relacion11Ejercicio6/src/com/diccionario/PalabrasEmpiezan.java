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
	
	public String listaPalabras() {
		StringBuilder lista = new StringBuilder();
		for(Palabra i: listaPalabras) {
			lista.append(i.getTexto()+" "+ i.getListaSignificados());
		}
		return lista.toString();
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
