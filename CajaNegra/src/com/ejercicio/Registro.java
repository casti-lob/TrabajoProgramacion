package com.ejercicio;

import java.util.Objects;

public class Registro {
	private int nRegistro=0;
	private static int acumulador=1;
	private String prima;
	private int numEmpleado;
	
	public Registro() {
		super();
		this.nRegistro = acumulador++;
		this.numEmpleado=0;
		this.prima=null;
	}

	public int getnRegistro() {
		return nRegistro;
	}

	public int getNumEmpleado() {
		return numEmpleado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nRegistro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Registro other = (Registro) obj;
		return nRegistro == other.nRegistro;
	}
	
	
	public  void crearPrima(Empleado e) {
		if(e.getMesesTrabajo()>=12&& e.getDirectivo()=='+') {
			this.prima="P1";
			
		}else if(e.getMesesTrabajo()>=12&& e.getDirectivo()=='-') {
			this.prima="P2";
		}else if(e.getMesesTrabajo()<12&& e.getDirectivo()=='+') {
			this.prima="P3";
		}else {
			this.prima="P4";
		}
		this.numEmpleado= e.getNumEmpleado();
	}

	@Override
	public String toString() {
		return "Registro [nRegistro=" + nRegistro + ", prima=" + prima + ", numEmpleado=" + numEmpleado + "]";
	}
	
	
}
