package com.jacaranda.tamano;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class TamanoMunicipioComunidad {

	private ArrayList<Comunidad> lista;

	public TamanoMunicipioComunidad() {
		lista = new ArrayList<>();
		
	}

	public ArrayList<Comunidad> getLista() {
		return lista;
	}
	public void introducirComunidad(Comunidad c) {
		if(!lista.contains(c)) {
			lista.add(c);
		}
	}

	@Override
	public String toString() {
		return "TamanoMunicipioComunidad [lista=" + lista + "]";
	}
	
	public void mapearJson(String nombre) {
		Gson gson = new Gson();
		this.lista= gson.fromJson(nombre,new TypeToken<ArrayList<Comunidad>>(){}.getType());
	}

	@Override
	public int hashCode() {
		return Objects.hash(lista);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TamanoMunicipioComunidad other = (TamanoMunicipioComunidad) obj;
		return Objects.equals(lista, other.lista);
	}
	
	public String obtenerComunidadesPorAno(int anno) {
		StringBuilder elementos= new StringBuilder();
		for(Comunidad i: lista) {
			elementos.append(i.obtenerMunicipioPorAno(anno));
		}
		return elementos.toString();
	}
	
	public String datosMunicipioAno(String comunidad,int ano) {
		StringBuilder elementos= new StringBuilder();
		boolean encontrado= false;
		Iterator<Comunidad>siguiente=lista.iterator();
		while(siguiente.hasNext()&&!encontrado) {
			Comunidad c = siguiente.next();
			if(c.getNombre().equals(comunidad)) {
				elementos.append(c.getNombre()+ ""+c.obtenerMunicipioPorAno(ano));
				encontrado= true;
			}
		}
		return elementos.toString();
	}
	
	public void anadirDato(String comunidad, String descripcion, int ano, int dato) throws MunicipiosException {
		boolean encontrado=false;
		Iterator<Comunidad> siguiente = lista.iterator();
		while(siguiente.hasNext()&&!encontrado) {
			Comunidad c = siguiente.next();
			if(c.getNombre().equals(comunidad)) {
				try {
					encontrado=true;
					c.existeDescripcion(descripcion, ano, dato);
				} catch (MunicipiosException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if(!encontrado) {
			throw new MunicipiosException("La comunidad no existe");
		}
	}
	
	public String comprobarValores(String comunidad,int ano) {
		boolean encontrado= false;
		int valor=0;
		String resul;
		Iterator<Comunidad>siguiente=lista.iterator();
		while(siguiente.hasNext()&&!encontrado) {
			Comunidad c = siguiente.next();
			if(c.getNombre().equals(comunidad)) {
				valor=c.obtenerValores(ano);
				encontrado= true;
			}
		}
		if(valor==0) {
			resul="El valor es igual";
		}else if(valor>0) {
			resul="El total no esta actualizado se deberian de añadir "+valor+" personas";
		}else {
			resul="El total no esta actualizado se deberian de quitar "+valor+" personas";

		}
		return resul;
	}
	
	public String persistirCambios() {
		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		String representacionBonita = prettyGson.toJson(lista);
		return representacionBonita;

	}
}
