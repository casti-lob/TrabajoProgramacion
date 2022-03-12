package com.alquileres;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Coche extends Vehiculo {
	private Carburante carburanteVehiculo;
	
	public Coche(String matricula, String gamaVehiculo, LocalDate fechaSalida, String carburanteVehiculo)
			throws VehiculoException {
		super(matricula, gamaVehiculo, fechaSalida);
		if(this.carburanteVehiculo== null) {
			this.carburanteVehiculo=Carburante.DIESEL;
		}else {
		this.carburanteVehiculo = Carburante.valueOf(carburanteVehiculo.toUpperCase());
		}
	}

	public String getCarburanteVehiculo() {
		return carburanteVehiculo.toString();
	}

	public void setCarburanteVehiculo(String carburanteVehiculo) {
		this.carburanteVehiculo = Carburante.valueOf(carburanteVehiculo.toUpperCase());
	}

	@Override
	public String toString() {
		return "Coche [carburanteVehiculo=" + carburanteVehiculo + ", toString()=" + super.toString() + "]";
	}
	
	@Override
	public double getPrecio() {
		
		return super.getPrecio()+this.carburanteVehiculo.getPrecio()*this.getFechaEntrada().until(getFechaSalida(), ChronoUnit.DAYS);
	}
	
	
	
	
}
