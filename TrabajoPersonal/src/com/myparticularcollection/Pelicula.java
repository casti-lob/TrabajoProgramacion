package com.myparticularcollection;

import java.time.LocalDate;

public class Pelicula extends Elemento {
	private String director;
	private double duracion;
		//Constructor
		public Pelicula(String nombre, LocalDate fechaEstreno, String genero, String estado, String director,
			double duracion) throws Exception {
		super(nombre, fechaEstreno, genero, estado);
		this.setDirector(director);
		this.setDuracion(duracion);
		
	}
		//Get&Set
		public String getDirector() {
			return director;
		}
		

		private void setDirector(String director) throws PeliculaException {
			if(director==null|| director.isBlank()) {
				throw new PeliculaException("El director no puede ser nulo o estar en blanco");
			}

			this.director = director;
		}
		private void setDuracion(double duracion) throws PeliculaException {
			if(duracion<1) {
				throw new PeliculaException("La duracion no puede ser menor que 1");
			}

			this.duracion = duracion;
		}
		public double getDuracion() {
			return duracion;
		}
		
		//Sobrescribe el estado del elemento
		@Override
		public void setEstado(String estado) throws Exception {
			if(estado==null|| estado.isBlank()) {
				throw new ElementoException("El estado no puede ser nulo o estar en blanco");
			}
			super.setEstado(estado);
		}

		@Override
		public String toString() {
			return super.toString() +", Director: "+this.director+ ", Duracion: "+this.duracion ;
		}
		
		
}
