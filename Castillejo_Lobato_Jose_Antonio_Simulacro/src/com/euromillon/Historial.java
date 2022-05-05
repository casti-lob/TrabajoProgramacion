package com.euromillon;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Historial {
	private HashMap<LocalDate, Combinacion> combinacionGanadora;

	public Historial() {
		super();
		combinacionGanadora = new HashMap<>();

	}

	public boolean addSorteo(LocalDate fecha, Combinacion numero) {
		boolean resultado = false;
		if (!combinacionGanadora.containsKey(fecha)) {
			combinacionGanadora.put(fecha, numero);
			resultado = true;
		}
		return resultado;
	}

	public void actualizarSorteo(LocalDate fecha, Combinacion numero) throws HistorialException {

		if (combinacionGanadora.containsKey(fecha)) {
			combinacionGanadora.put(fecha, numero);
		} else {
			throw new HistorialException("La combinacion no existe");
		}
	}

	public void borrarInf(LocalDate fecha) throws HistorialException {
		if (combinacionGanadora.get(fecha) != null) {
			combinacionGanadora.remove(fecha);

		} else {
			throw new HistorialException("La combinacion no existe");
		}
	}

	public int nAciertos(LocalDate fecha, Combinacion numero) throws HistorialException {
		if (combinacionGanadora.get(fecha) != null) {
			Combinacion comb = this.combinacionGanadora.get(numero);
			return comb.comprobarAciertos(numero);
		} else {
			throw new HistorialException("La combinacion no existe");
		}
	}

	public String getResultadosAsc() {
		// List<String> lista = (List<String>) combinacionGanadora;
		StringBuilder resultado = new StringBuilder();
		ArrayList<LocalDate> clave = new ArrayList<LocalDate>(this.combinacionGanadora.keySet());
		Collections.sort(clave);

		for (LocalDate fecha : clave) {
			resultado.append(fecha + ":" + this.combinacionGanadora.get(fecha).toString());
		}
		return resultado.toString();
	}

	public String getResultadosDesc() {
		// List<String> lista = (List<String>) combinacionGanadora;
		StringBuilder resultado = new StringBuilder();
		ArrayList<LocalDate> clave = new ArrayList<LocalDate>(this.combinacionGanadora.keySet());
		ComprobadorDescendente orden = new ComprobadorDescendente();
		Collections.sort(clave, orden);

		for (LocalDate fecha : clave) {
			resultado.append(fecha + ":" + this.combinacionGanadora.get(fecha).toString());
		}
		return resultado.toString();
	}

	public String getResultadosMes(int mes) {
		// List<String> lista = (List<String>) combinacionGanadora;
		StringBuilder resultado = new StringBuilder();
		ArrayList<LocalDate> clave = new ArrayList<LocalDate>(this.combinacionGanadora.keySet());
		Collections.sort(clave);
		Iterator<LocalDate> siguiente = clave.iterator();
		boolean encontrado = false;
		 while(siguiente.hasNext()&&!encontrado) {
			 LocalDate fecha = siguiente.next();
			if (fecha.getMonthValue() == mes) {
				resultado.append(fecha + ":" + this.combinacionGanadora.get(fecha).toString());

			}else if(fecha.getMonthValue()>mes) {
				encontrado= true;
			}
		}
		return resultado.toString();
	}
	
}
