package com.test.refactoring.Business;

public class motocicleta {
	
	private String matricula;
	private String color;
	private String combustible;
	private Integer cilindrada;
	private String nombre_conductor;
	private String dniConductor;
	
	public motocicleta(String matricula, String color, String combustible, Integer cilindrada, String nombre_conductor,
			String dniConductor) {
		super();
		this.matricula = matricula;
		this.color = color;
		this.combustible = combustible;
		this.cilindrada = cilindrada;
		this.nombre_conductor = nombre_conductor;
		this.dniConductor = dniConductor;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCombustible() {
		return combustible;
	}

	public void setCombustible(String combustible) {
		this.combustible = combustible;
	}

	public Integer getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(Integer cilindrada) {
		this.cilindrada = cilindrada;
	}

	public String getNombre_conductor() {
		return nombre_conductor;
	}

	public void setNombre_conductor(String nombre_conductor) {
		this.nombre_conductor = nombre_conductor;
	}

	public String getDniConductor() {
		return dniConductor;
	}

	public void setDniConductor(String dniConductor) {
		this.dniConductor = dniConductor;
	}
	
	public void Acelerar(Integer velocidad) {
		//TO DO
	}
	
	public void Detener() {
		//TO DO
	}

	@Override
	public String toString() {
		return "motocicleta [matricula=" + matricula + ", color=" + color + ", combustible=" + combustible
				+ ", cilindrada=" + cilindrada + ", nombre_conductor=" + nombre_conductor + ", dniConductor="
				+ dniConductor + "]";
	}	

}
