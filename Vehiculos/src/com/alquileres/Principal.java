package com.alquileres;

public class Principal {

	public static void main(String[] args) throws VehiculoException {
		Vehiculo a = new MicroBus(12, "1452", "alta", null);
		System.out.println(a);
		System.out.println(a.getPrecio());

	}

}
