package com.libreria;

public class LibroDigital extends Libro {
	
	private double precio;
	private Formato formatoLibro;
	
	public LibroDigital(String titulo, String autor, String editorial, double precio, String formatoLibro) throws LibroDigitalException, LibroException {
		super(titulo, autor, editorial);
		setPrecio(precio);
		setFormatoLibro(formatoLibro);
		
	}

	private void setPrecio(double precio) throws LibroDigitalException {
		if(precio==0) {
			throw new LibroDigitalException("El campo precio no puede ser nulo");
		}
		this.precio = precio;
	}

	private void setFormatoLibro(String formatoLibro) throws LibroDigitalException {
		if(formatoLibro==null) {
			throw new LibroDigitalException("El campo formato no puede ser nulo");
		}
		this.formatoLibro =Formato.valueOf(formatoLibro.toUpperCase());
	}

	@Override
	public String toString() {
		return super.toString()+" Precio: "+this.precio+" Formato: "+this.formatoLibro;
	}
	
	
	
	
	
	

}
