package com.myparticularcollection;

import java.time.LocalDate;

public class Libro extends Elemento {
	
	private String autor;
	private int capitulos;
	private int progresoLectura;
	
	//Cosntructor
	public Libro(String nombre, LocalDate fechaEstreno, String genero, String estado, String autor,
			int capitulos) throws Exception {
		super(nombre, fechaEstreno, genero, estado);
		
		this.setAutor(autor);
		this.setCapitulos(capitulos);
	
		this.setProgresoLectura(0);//Por defecto comienza con 0 capitulos leidos para que aparezca en estado pendiente
		
	}
	
	//Get&Set

	public int getProgresoLectura() {
		return progresoLectura;
	}

	public void setProgresoLectura(int progresoLectura) throws Exception {
		//El progreso de lectura no es acumulativo sino que se va modificando el numero de capitulos leidos
		if(progresoLectura<0) {
			throw new LibroException("El progreso de lectura no puede ser menos de 1");
		}else if(progresoLectura>this.capitulos) {
			throw new LibroException("El progreso de lectura no puede ser mayor a los capitulos");
		}
		this.progresoLectura = progresoLectura;
		//Por defecto el estado esta pendiente
		
		if(this.progresoLectura>0&&this.progresoLectura< this.capitulos) {
			setEstado("ENPROGRESO");
		}else if(this.progresoLectura== this.capitulos) {
			setEstado("TERMINADO");
			
		}else {
			setEstado("PENDIENTE");
		}
	}

	

	public String getAutor() {
		return autor;
	}

	public int getCapitulos() {
		return capitulos;
	}

	

	private void setAutor(String autor) throws LibroException {
		if(autor==null||autor.isBlank()) {
			throw new LibroException("El autor no puede estar en blanco o ser nulo");
		}
		this.autor = autor;
	}

	private void setCapitulos(int capitulos) throws LibroException {
		if(capitulos<1) {
			throw new LibroException("No puede tener menos de 1 capitulo");
		}
		this.capitulos = capitulos;
	}
	
	

	@Override
	public String toString() {
		return super.toString()+", Autor:" + autor + ", Capitulos:" + capitulos + ", Capitulos leidos:"
				+ progresoLectura ;
	}
	
	
	
	

}
