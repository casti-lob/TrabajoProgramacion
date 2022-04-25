package com.jacaranda.gestion;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class Nota {
	private double nota;
	private LocalDate fecha;
	private Alumnado alumno;
	private Modulo modulo;
	
	public Nota(double nota, LocalDate fecha, Alumnado alumno, Modulo modulo) throws notaException {
		super();
		this.setNota(nota);
		this.setFecha(fecha);
		this.alumno = alumno;
		this.modulo = modulo;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) throws notaException {
		if(nota<0) {
			throw new notaException("La nota no puede ser menor a 0");
		}
		this.nota = nota;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) throws notaException {
		if(fecha==null) {
			throw new notaException("La fecha no puede ser nula");
		}
		this.fecha = fecha;
	}

	public String getAlumno() {
		return alumno.getDni();
	}

	public String getModulo() {
		return modulo.getNombre();
	}
	

	@Override
	public String toString() {
		return "Nota [nota=" + nota + ", fecha=" + fecha + ", alumno=" + alumno + ", modulo=" + modulo + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(alumno, fecha, modulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nota other = (Nota) obj;
		return Objects.equals(alumno, other.alumno) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(modulo, other.modulo);
	}
	
	
	
	
}
