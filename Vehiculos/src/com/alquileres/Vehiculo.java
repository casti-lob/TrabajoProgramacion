package com.alquileres;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Vehiculo {
	private String matricula;
	private Gama gamaVehiculo;
	private LocalDate fechaEntrada;
	private LocalDate fechaSalida;
	
	public Vehiculo(String matricula, String gamaVehiculo, LocalDate fechaSalida) throws VehiculoException {
		super();
		this.matricula = matricula;
		this.gamaVehiculo = Gama.valueOf(gamaVehiculo.toUpperCase());
		this.fechaEntrada= LocalDate.now();
		if(fechaSalida != null) {
			if(fechaSalida.isBefore(this.fechaEntrada)) {
				throw new VehiculoException("Fechas de salida debe de ser posterior a la fecha de entrada");
			}
			this.fechaSalida = fechaSalida;
		}else {
			this.fechaSalida=null;
		}
		
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public void setGamaVehiculo(String gamaVehiculo) {
		this.gamaVehiculo = Gama.valueOf(gamaVehiculo.toUpperCase());
	}

	public void setFechaEntrada(LocalDate fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Gama getGamaVehiculo() {
		return gamaVehiculo;
	}

	public LocalDate getFechaEntrada() {
		return fechaEntrada;
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		return Objects.equals(matricula, other.matricula);
	}

	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", gamaVehiculo=" + gamaVehiculo + ", fechaEntrada=" + fechaEntrada
				+ ", fechaSalida=" + fechaSalida + "]";
	}
	
	public double getPrecio() {
		if(this.fechaSalida==null) {
			this.fechaSalida=LocalDate.now();
		}
		double resultado = gamaVehiculo.getPrecio()*(int)fechaEntrada.until(fechaSalida, ChronoUnit.DAYS);
		return resultado;
	}
	
}
