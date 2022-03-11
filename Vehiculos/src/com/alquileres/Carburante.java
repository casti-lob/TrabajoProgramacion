package com.alquileres;

public enum Carburante {
	GASOLINA(3.5),DIESEL(2.5);
	
	private double precio;

	private Carburante(double precio) {
		this.precio = precio;
	}

	public double getPrecio() {
		return precio;
	}
	
}
