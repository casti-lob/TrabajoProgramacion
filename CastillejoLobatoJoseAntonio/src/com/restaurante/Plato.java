package com.restaurante;

import java.util.Objects;

public class Plato {
	private String nombre;
	private double precio;
	private Vino vinoRecomendado;
	private final double IVA=1.21;
	private boolean vinoAnnadido;
	
	//Constructor
	public Plato(String nombre) {
		super();
		this.nombre = nombre;
		this.precio= 0;
		this.vinoAnnadido=false;
	}

	public Plato(String nombre, double precio) throws PlatoException {
		super();
		this.nombre = nombre;
		setPrecio(precio);
		this.vinoAnnadido=false;
	}

	public double getPrecioBase() {
		return precio;
	}

	public void setPrecio(double precio) throws PlatoException {
		if(precio <=0) {
			throw new PlatoException("El precio no puede ser menor o igual a 0");
		}
		this.precio = precio;
	}
	//Mostramos una copia del vino recomendado
	public Vino getVinoRecomendado() throws VinoException {
		Vino copia = new Vino(vinoRecomendado.getNombre(),vinoRecomendado.getGraduacion());
		return copia;
	}
	//Para introducir un vino solo con nombre 
	public void setVinoRecomendadoNombre(Vino vinoRecomendado) {
		this.vinoRecomendado = new Vino(vinoRecomendado.getNombre());
		this.vinoAnnadido=true;
	}
	//Para introducir un vino con todos los parametros
	public void setVinoRecomendado(Vino vinoRecomendado) throws VinoException {
		this.vinoRecomendado = new Vino(vinoRecomendado.getNombre(),vinoRecomendado.getGraduacion());
		this.vinoAnnadido=true;
	}
	public String getNombre() {
		return nombre;
	}
	//Mostrar precio on el iva
	public double getPrecioVentaPublico() {
		double  precioConIva=getPrecioBase()*IVA;
		return precioConIva;
	}
	
	//Incrementacion del precio
	public void incrementaPrecio(double incremento) {
		this.precio = getPrecioBase()+incremento;
	}
	//Muestra la graduacion del vino recomendado
	public double getGradosVinosRecomendado() {
		return this.vinoRecomendado.getGraduacion();
	}
	
	public double getIVA() {
		return IVA;
	}

	//UN plato es igual si tienen el mismo nombre
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plato other = (Plato) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		if(vinoAnnadido==false) {
			return "Nombre: "+nombre +"precio sin iva: "+precio+" precio con iva "+getPrecioVentaPublico()+" Sin recomendacions para el vino ";
		}
		return "Nombre: "+nombre +"precio sin iva: "+precio+" precio con iva "+getPrecioVentaPublico()+" Vino "+ vinoRecomendado.getNombre()+" con graduacion "+getGradosVinosRecomendado();
	}
	
	
	
}
