package com.libreria;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Libro {
	private String titulo;
	private String autor;
	private String editorial;
	private LocalDate fechaEdicion;
	private String isbn;
	private static int codigo;
	private int codigoLibro;
	
	public Libro(String titulo, String autor, String editorial) throws LibroException {
		super();
		try {
			
		
		setTitulo(titulo);
		setAutor(autor);
		this.editorial = editorial;
		this.fechaEdicion= null;
		setIsbn();
		this.codigoLibro = codigo++;
		} catch (Exception e) {
			throw new LibroException("Error al crear el libro");
		}
	}

	public Libro(String titulo, String autor) throws LibroException {
		super();
		try {
			
		 
		setTitulo(titulo);
		setAutor(autor);
		this.editorial=null;
		this.fechaEdicion=null;
		setIsbn();
		this.codigoLibro= codigo++;
		}catch (Exception e) {
			throw new LibroException("Error al crear el libro");
		}
	}

	public String getEditorial() {
		return editorial;
	}
	
	private void setTitulo(String titulo) throws LibroException {
		if(titulo==null) {
			throw new LibroException("El titulo no puede ser nulo");
		}
		this.titulo = titulo;
	}

	private void setAutor(String autor) throws LibroException {
		if(autor==null) {
			throw new LibroException("El autor no puede ser nulo");
		}
		this.autor = autor;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public LocalDate getFechaEdicion() {
		return fechaEdicion;
	}

	public void setFechaEdicion(LocalDate fechaEdicion) {
		this.fechaEdicion = fechaEdicion;
	}

	public String getIsbn() {
		return isbn;
	}

	private void setIsbn() {
		this.isbn = tituloSinEspacios()+longitudCadena(this.titulo)+autorSinEspacios()+longitudCadena(this.autor);
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public int getCodigoLibro() {
		return codigoLibro;
	}
	
	private String tituloSinEspacios() {
		String solucion;
		this.titulo= this.titulo.replace(" ", "");
		solucion =this.titulo;
		if(longitudCadena(solucion)<3) { //En caso de que el titulo sea de tama?o menor que 3
			solucion= solucion.substring(0,longitudCadena(solucion));
		}else {
			solucion=solucion.substring(0,3);
		}
		return solucion;
		
		
	}
	private int longitudCadena(String cadena) {
		
		return cadena.length();
	}
	private String autorSinEspacios() {
		String solucion;
		this.autor= this.autor.replace(" ", "");
		solucion = this.autor;
		if(longitudCadena(solucion)<3) { //En caso de que el titulo sea de tama?o menor que 3
			solucion= solucion.substring(0,longitudCadena(solucion));
		}else {
			solucion=solucion.substring(longitudCadena(solucion)-3,longitudCadena(solucion));
		}
		return solucion;
		
		
	}
	
	public int numDiasEntreLibros(Libro other) {
		int dias; //No esta bien
		dias= (int) this.fechaEdicion.until(other.getFechaEdicion(),ChronoUnit.DAYS);
		return dias;
	}

	@Override
	public int hashCode() {
		return Objects.hash(isbn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(isbn, other.isbn);
	}

	@Override
	public String toString() {
		return "Libro : "+ titulo + ". Autor: " + autor + ". ISBN: " + isbn + ". C?digo: " + codigoLibro;
	}
	
	
	

}
