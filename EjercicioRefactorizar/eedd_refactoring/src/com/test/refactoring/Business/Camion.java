package com.test.refactoring.Business;

public class Camion {

	private String matricula;
	private String color;
	private String combustible;
	private String tipoCarnet;
	private String nombre_conductor;
	private String dniConductor;
	
	public Camion() {
		super();
	}
	
	public Camion(String matricula, String color, String combustible, String tipoCarnet, String nombre_conductor, String dniConductor) {
		super();
		this.matricula = matricula;
		this.color = color;
		this.combustible = combustible;
		this.tipoCarnet = tipoCarnet;
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

	public String getTipoCarnet() {
		return tipoCarnet;
	}

	public void setTipoCarnet(String tipoCarnet) {
		this.tipoCarnet = tipoCarnet;
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
		System.out.println("La aceleración del camión se realizará progresivamente para conservar sus neumáticos");
		
		//TO DO
		//Incluir lógica de movimiento
	}
	
	public void Detener() {
		System.out.println("CUIDADO!! La detención de un vehículo de gran tamaño puede ocasionar accidentes de tráfico");
	}

	@Override
	public String toString() {
		return "Camion [matricula=" + matricula + ", color=" + color + ", combustible=" + combustible + ", tipoCarnet="
				+ tipoCarnet + ", nombre_conductor=" + nombre_conductor + ", dniConductor=" + dniConductor + "]";
	}
	
}
