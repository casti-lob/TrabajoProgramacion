package com.euromillon;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Historial {
	private HashMap<LocalDate, Combinacion> combinacionGanadora;

	public Historial() {
		super();
		combinacionGanadora= new HashMap<>();
		
	}
	
	public boolean addSorteo(LocalDate fecha, Combinacion numero) {
		boolean resultado= false;
		if(!combinacionGanadora.containsKey(fecha)) {
			combinacionGanadora.put(fecha, numero);
			resultado=true;
		}
		return resultado;
	}
	
	public void actualizarSorteo(LocalDate fecha,Combinacion numero) throws HistorialException {
		
		if(combinacionGanadora.containsKey(fecha)) {
			combinacionGanadora.put(fecha, numero);
		}else {
			throw new HistorialException("La combinacion no existe");
		}
	}
	
	public void borrarInf(LocalDate fecha) throws HistorialException {
		if(combinacionGanadora.get(fecha) != null) {
			combinacionGanadora.remove(fecha);
		
		}else {
			throw new HistorialException("La combinacion no existe");
		}
	}
	
	public int nAciertos(LocalDate fecha, Combinacion numero) throws HistorialException {
		if (combinacionGanadora.get(fecha)!=null) {
			Combinacion comb = this.combinacionGanadora.get(numero);
			return comb.comprobarAciertos(numero);
		}else {
			throw new HistorialException("La combinacion no existe");
		}
	}
	
	/*
	public String ordenDesc() {
		List<String> lista = (List<String>) combinacionGanadora;
		
	}
	*/
}
