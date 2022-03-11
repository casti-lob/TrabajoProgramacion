package com.alquileres;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class MicroBus extends Vehiculo {
	
	private int numPlazas;
	private final double PRECIOPLAZA=5;
	
	public MicroBus(int numPlazas, String matricula, String gamaVehiculo, LocalDate fechaSalida) throws VehiculoException {
		super(matricula, gamaVehiculo, fechaSalida);
		this.numPlazas = numPlazas;
	}

	public int getNumPlazas() {
		return numPlazas;
	}

	public void setNumPlazas(int numPlazas) {
		this.numPlazas = numPlazas;
	}

	public double getPRECIOPLAZA() {
		return PRECIOPLAZA;
	}
	
	public double getPrecio() {
		return super.getPrecio()+(this.numPlazas*PRECIOPLAZA)*this.getFechaEntrada().until(getFechaSalida(), ChronoUnit.DAYS);
	}

	@Override
	public String toString() {
		return "MicroBus [numPlazas=" + numPlazas + ", PRECIOPLAZA=" + PRECIOPLAZA + ", toString()=" + super.toString()
				+ "]";
	}
	
	
}
