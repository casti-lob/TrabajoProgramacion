package com.jacaranda.equipo;

import java.util.HashSet;
import java.util.Set;

import com.jacaranda.jugadores.ALumno;

public class Equipo {
	private String nombre;
	private Set<ALumno> listado;
	
	public Equipo(String nombre) {
		super();
		this.nombre = nombre;
		this.listado= new HashSet<ALumno>();
		
	}
	public void addAlumno(ALumno a) throws EquipoException {
		if(listado.contains(a)|| a==null) {
			throw new EquipoException("Ya existe el alumno o es nulo");
		}
		listado.add(a);
		
	}
	
	/* Opcion 2 addAlumno
	 * public void addAlumno(ALumno a) throws EquipoException {
		if(!listado.add(a)|| a==null) {
			throw new EquipoException("Ya existe el alumno o es nulo");
		}
	 */
	public int numAlumnos() {
		return listado.size();
	}
	
	public void deleteAlumno(ALumno a) throws EquipoException {
		if(!listado.contains(a)||listado==null) {
			throw new EquipoException("Alumno nulo o no encontrado");
		}
		listado.remove(a);
	}
	public boolean buscarAlumno(ALumno a) throws EquipoException {
		boolean resul= true;
		if(!listado.contains(a)) {
			
			throw new EquipoException("null");
		}
		return resul;
	}
	
	public String mostrarAlumno() {
		StringBuilder lista = new StringBuilder();
		for(ALumno a:listado) {
			lista.append(a+"\n");
		}
		return lista.toString();
		
	}
	
	public Equipo unionEquipo(Equipo other) {
		Equipo resultado = new Equipo("");
		for(ALumno a:this.listado) {
			if(other.listado.contains(a)) {
				try {
					resultado.addAlumno(a);
				} catch (EquipoException e) {
					e.printStackTrace();
				}
			}
		}
		return resultado;
	}
	
	public Equipo unionNuevoEquipo(Equipo other) {
		Equipo resultado = new Equipo("Nuevo Equipo");
		for(ALumno a:this.listado) {
			if(other.listado.contains(a)) {
				try {
					resultado.addAlumno(a);
				} catch (EquipoException e) {
					e.printStackTrace();
				}
			}
		}
		return resultado;
	}
	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", listado=" + listado + "]";
	}
	
}
