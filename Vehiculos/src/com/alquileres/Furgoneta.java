package com.alquileres;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Furgoneta extends Vehiculo {
	private int pma;
	private final double PRECIOPESO =0.5;
	
	public Furgoneta(int pma, String matricula, String gamaVehiculo, LocalDate fechaSalida) throws VehiculoException {
		super(matricula, gamaVehiculo, fechaSalida);
		// TODO Auto-generated constructor stub
		this.pma = pma;
		
	}

	public int getPma() {
		return pma;
	}

	public void setPma(int pma) {
		this.pma = pma;
	}

	public double getPRECIOPESO() {
		return PRECIOPESO;
	}
	
	@Override
	public double getPrecio() {
		return super.getPrecio()+ (this.pma*PRECIOPESO)*this.getFechaEntrada().until(getFechaSalida(), ChronoUnit.DAYS);
	}

	@Override
	public String toString() {
		return "Furgoneta [pma=" + pma + ", PRECIOPESO=" + PRECIOPESO + ", toString()=" + super.toString() + "]";
	}
	
	

}
