package com.libreria;

public class LibroPapel extends Libro {
	private double peso;
	private double precio;
	
	public LibroPapel(String titulo, String autor, String editorial, double peso, double precio) throws LibroException {
		super(titulo, autor, editorial);
		this.peso = peso;
		this.precio = precio;
		
	}
	
	public double getPeso() {
		return peso;
	}

	public double getPrecio() {
		return precio;
	}

	@Override
	public String toString() {
		return "Autor: "+super.getAutor()+". ISBN: "+super.getIsbn()+" Código: "+super.getCodigoLibro()+". Precio: "+this.precio+" Peso: "+this.peso+". Libro: "+super.getTitulo();
	}
	
	
	
	

}
