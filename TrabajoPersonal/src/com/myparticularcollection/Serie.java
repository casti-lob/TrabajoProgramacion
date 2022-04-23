package com.myparticularcollection;

import java.time.LocalDate;

public class Serie extends Elemento {
	private String director;
	private int capitulos;
	private int progresoSerie;
	
	//Cosntructor
	public Serie(String nombre, LocalDate fechaEstreno, String genero, String estado, String director,
			int capitulos) throws Exception {
		super(nombre, fechaEstreno, genero, estado);
		
		this.setDirector(director);
		this.setCapitulos(capitulos);
	
		this.setProgreso(0);//Por defecto comienza con 0 capitulos leidos para que aparezca en estado pendiente
		
	}
	
	//Get&Set

	public int getProgresoSerie() {
		return progresoSerie;
	}

	@Override
	protected void setProgreso(int capitulos) throws Exception {
		//El progreso de lectura no es acumulativo sino que se va modificando el numero de capitulos leidos
		if(progresoSerie<0) {
			throw new LibroException("El progreso de lectura no puede ser menos de 1");
		}else if(progresoSerie>this.capitulos) {
			throw new LibroException("El progreso de lectura no puede ser mayor a los capitulos");
		}
		this.progresoSerie = capitulos;
		//Por defecto el estado esta pendiente
		
		if(this.progresoSerie>0&&this.progresoSerie< this.capitulos) {
			setEstado("ENPROGRESO");
		}else if(this.progresoSerie== this.capitulos) {
			setEstado("TERMINADO");
			
		}else {
			setEstado("PENDIENTE");
		}
	}
	

	public String getDirector() {
		return director;
	}

	public int getCapitulos() {
		return capitulos;
	}

	

	private void setDirector(String director) throws  SerieException {
		if(director==null||director.isBlank()) {
			throw new SerieException("El director no puede estar en blanco o ser nulo");
		}
		this.director = director;
	}

	private void setCapitulos(int capitulos) throws  SerieException {
		if(capitulos<1) {
			throw new SerieException("No puede tener menos de 1 capitulo");
		}
		this.capitulos = capitulos;
	}
	
	

	@Override
	public String toString() {
		return super.toString()+", Autor:" + director + ", Capitulos:" + capitulos + ", Capitulos vistos:"
				+ progresoSerie ;
	}
	
	
}
