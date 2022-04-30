package com.myparticularcollection;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Usuario {
	private String nombre;
	private String contrasena;
	private List<Elemento> lista;
	//Constructor
	public Usuario(String nombre, String contrasena) throws UsuarioException {
		super();
		this.setNombre(nombre);
		this.setContrasena(contrasena);
		this.lista= new ArrayList<>();
	}
	//Metodo para cambiar de contrasena
	public void ContrasenaNueva(String contrasenaOld, String contrasenaNew ) throws UsuarioException {
		if(contrasenaOld.equals(this.contrasena)) {
			this.contrasena= contrasenaNew;
		}else {
			throw new UsuarioException("Password o usuario incorrectos");
		}
	}
	
	public boolean addPelicula(String nombre, LocalDate fechaEstreno, String genero, String estado, String director,double duracion) throws Exception {
		boolean add = false, encontrado=false;
		
		Pelicula p = new Pelicula(nombre, fechaEstreno, genero, estado, director, duracion);
		
		Iterator<Elemento>siguiente= this.lista.iterator();
		while(siguiente.hasNext()&&!encontrado) {
			Elemento i = siguiente.next();
			if(i.getNombre().equalsIgnoreCase(p.getNombre())) {
				encontrado=true;
			}
		}
		if(encontrado) {
			throw new UsuarioException("La pelicula ya existe");
		}else {
			lista.add(p);
			add= true;
		}
		return add;
		
	}
	
	public boolean addSerie(String nombre, LocalDate fechaEstreno, String genero, String estado, String director,int capitulos) throws Exception {
		boolean add = false,encontrado=false;
		Serie s = new Serie(nombre, fechaEstreno, genero, estado, director, capitulos);
		Iterator<Elemento>siguiente= this.lista.iterator();
		while(siguiente.hasNext()&&!encontrado) {
			Elemento i = siguiente.next();
			if(i.getNombre().equalsIgnoreCase(s.getNombre())) {
				encontrado=true;
			}
		}
		if(encontrado) {
			throw new UsuarioException("La serie ya existe");
		}else {
			lista.add(s);
			add= true;
		}
		return add;
		
	}
	
	public boolean addLibro(String nombre, LocalDate fechaEstreno, String genero, String estado, String autor,int capitulos) throws Exception {
		boolean add = false, encontrado= false;
		Libro l = new Libro(nombre, fechaEstreno, genero, estado, autor, capitulos);
		Iterator<Elemento>siguiente= this.lista.iterator();
		while(siguiente.hasNext()&&!encontrado) {
			Elemento i = siguiente.next();
			if(i.getNombre().equalsIgnoreCase(l.getNombre())) {
				encontrado=true;
			}
		}
		if(encontrado) {
			throw new UsuarioException("El libro ya existe");
		}else {
			lista.add(l);
			add= true;
		}
		return add;
		
	}
	
	public boolean valorarElemento(String titulo, int valoracion) throws ElementoException, UsuarioException {
		boolean add=false;
		if(!lista.isEmpty()) {
			Iterator<Elemento> siguiente= this.lista.iterator();
			while(siguiente.hasNext()&&!add) {
				Elemento i= siguiente.next();
				if(i.getNombre().equalsIgnoreCase(titulo)) {
					i.setValoracion(valoracion);
					add=true;
				}
			}
		
		}else {
			throw new UsuarioException("La lista esta vacia");
		}
		return add;
	}
	/*
	 * en progreso
	 */
	public boolean actualizarProgresoElemento(String titulo, int capitulosLeidos) throws Exception {
		boolean add=false;
		if(!lista.isEmpty()) {
			Iterator<Elemento> siguiente = this.lista.iterator();
			while(siguiente.hasNext()&&!add) {
				Elemento a= siguiente.next();
				if(a.getNombre().equalsIgnoreCase(titulo)&& a instanceof Libro){
					a.setProgreso(capitulosLeidos);
					add=true;
					
				}
				else if(a.getNombre().equalsIgnoreCase(titulo)&& a instanceof Serie) {
					a.setProgreso(capitulosLeidos);
					add=true;
				}
				
			}
			
		}else {
			throw new UsuarioException("La lista esta vacia");
		}
		return add;
	}
	
	//hacer set get elemento usuario
	public String getNombre() {
		return nombre;
	}
	private void setNombre(String nombre) throws UsuarioException {
		if(nombre==null||nombre.isBlank()) {
			throw new UsuarioException("El numbre del usuario no puede ser nulo o estar en blanco");
		}
		this.nombre = nombre;
	}
	public String getContrasena() {
		return contrasena;
	}
	private void setContrasena(String contrasena) throws UsuarioException {
		if(contrasena==null||contrasena.isBlank()) {
			throw new UsuarioException("La contasena del usuario no puede ser nulo o estar en blanco");

		}else if(contrasena.length()<3) {//Debe de ser mayor que 3 la langitud de la contrasena
			throw new UsuarioException("La contrasena tiene que tenener un minimo de 3 coracteres");

		}
		this.contrasena = contrasena;
	}
	
	public String listaPeliculas() throws UsuarioException {
		StringBuilder elementos = new StringBuilder();
		if(lista.isEmpty()) {
			throw new UsuarioException("No hay elemetos en la lista");
		}
		for(Elemento i: lista) {
			if(i instanceof Pelicula) {
				elementos.append(i+"\n");
			}
			
		}
		return elementos.toString();
	}
	
	public String listaSerie() throws UsuarioException {
		StringBuilder elementos = new StringBuilder();
		if(lista.isEmpty()) {
			throw new UsuarioException("No hay elemetos en la lista");
		}
		for(Elemento i: lista) {
			if(i instanceof Serie) {
				elementos.append(i+"\n");
			}
			
		}
		return elementos.toString();
	}
	
	public String listaLibros() throws UsuarioException {
		StringBuilder elementos = new StringBuilder();
		if(lista.isEmpty()) {
			throw new UsuarioException("No hay elemetos en la lista");
		}
		for(Elemento i: lista) {
			if(i instanceof Libro) {
				elementos.append(i+"\n");
			}
			
		}
		return elementos.toString();
	}
	
	
	
	public String listaOrdenada() throws UsuarioException {
		StringBuilder elementos = new StringBuilder();
		if(lista.isEmpty()) {
			throw new UsuarioException("No hay elemetos en la lista");
		}
		Collections.sort(lista);
		for(Elemento i :lista) {
			elementos.append(i+"\n");
		}
		return elementos.toString();
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
		Usuario other = (Usuario) obj;
		return Objects.equals(nombre, other.nombre);
	}
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", contrasena=" + contrasena + "]";
	}
	
	
	
}
