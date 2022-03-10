package com.test.refactoring.Business;

public class Coche {
	
	private String matricula;
	private String color;
	private String combustible;
	private Integer numPlazas;
	private String nombre_conductor;
	private String dniConductor;
	
	public Coche() {
		super();
	}
	
	public Coche(String matricula, String color, String combustrible, Integer numPlazas, String nombre_conductor, String dniConductor) {
		super();
		this.matricula = matricula;
		this.color = color;
		this.combustible = combustrible;
		this.numPlazas =  numPlazas;
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

	public Integer getNumPlazas() {
		return numPlazas;
	}

	public void setNumPlazas(Integer numPlazas) {
		this.numPlazas = numPlazas;
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
		if (velocidad > 0 && velocidad < 120) {
			System.out.println("El coche está acelerando y llegará la velocidad de " + velocidad.intValue() + " km/h");
		} else {
			System.out.println("La velocidad indicada no está permitida en un coche según la DGT");
		}
	}
	
	public void Detener() {
		System.out.println("El coche se detendrá en breve, asegúrese de buscar un lugar adecuado para estacionar");
	}

	@Override
	public String toString() {
		return "Coche [matricula=" + matricula + ", color=" + color + ", combustible=" + combustible + ", numPlazas="
				+ numPlazas + ", nombre_conductor=" + nombre_conductor + ", dniConductor=" + dniConductor + "]";
	}

}
