package com.ejercicio;

import java.util.Objects;

public class Empleado {
	private int numEmpleado;
	private String nombreEmpleado;
	private int mesesTrabajo;
	private char directivo;
	
	public Empleado(int numEmpleado, String nombreEmpleado, int mesesTrabajo, char directivo) throws empleadoException {
		super();
		this.setNumEmpleado(numEmpleado);
		this.setNombreEmpleado(nombreEmpleado);
		this.setMesesTrabajo(mesesTrabajo);
		this.setDirectivo(directivo);
	}

	public int getNumEmpleado() {
		return numEmpleado;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public int getMesesTrabajo() {
		return mesesTrabajo;
	}

	public char getDirectivo() {
		return directivo;
	}

	private void setNumEmpleado(int numEmpleado) throws empleadoException {
		if(numEmpleado== 0) {
			throw new empleadoException("No puede ser nulo");

		
		}else if(numEmpleado<1|| numEmpleado>999) {
			throw new empleadoException("no puede ser menor a 0 o mayor a 999");

		}
		this.numEmpleado = numEmpleado;
	}

	private void setNombreEmpleado(String nombreEmpleado) throws empleadoException {
		if(nombreEmpleado==null) {
			throw new empleadoException("El nombre del empleado no puede ser nulo");
		}else if(nombreEmpleado.length()<10||nombreEmpleado.length()>10){
			throw new empleadoException("El nombre del empleado tiene que ser de 10 digitos");

		}
		this.nombreEmpleado = nombreEmpleado;
	}

	private void setMesesTrabajo(int mesesTrabajo) throws empleadoException {
		if(mesesTrabajo== 0) {
			throw new empleadoException("No puede ser nulo los meses");

		
		}else if(mesesTrabajo<1|| mesesTrabajo>999) {
			throw new empleadoException("no puede ser menor a 0 o mayor a 999 los meses");

		}
		this.mesesTrabajo = mesesTrabajo;
	}

	private void setDirectivo(char directivo) throws empleadoException {
		if(directivo!='+'&& directivo!='-') {
			throw new empleadoException("Solo se aceptan(-,+) como valores en direcvios");

		}
		this.directivo = directivo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numEmpleado);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return numEmpleado == other.numEmpleado;
	}

	@Override
	public String toString() {
		return "Empleado [numEmpleado=" + numEmpleado + ", nombreEmpleado=" + nombreEmpleado + ", mesesTrabajo="
				+ mesesTrabajo + ", directivo=" + directivo + "]";
	}
	
	
	
}
