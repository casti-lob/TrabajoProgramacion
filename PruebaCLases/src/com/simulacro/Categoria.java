package com.simulacro;
/**
 * 
 * @author Jose Antonio Castillejo Lobato
 *@version 1.0
 */
public class Categoria {
	private String nombre;
	private final double PRECIOXMINUTO=1;
	
	/**
	 * Constructor en donde se solicita el nombre de la categoría mediante 
	 * @param nombre
	 */
	public Categoria(String nombre) {
		super();
		this.nombre = nombre;
	}
	/**
	 * Metodo para mostrar el precio por minuto 
	 * @return PRECIOXMINUTO
	 */
	public double getPRECIOXMINUTO() {
		return PRECIOXMINUTO;
	}
	/**
	 *  Metodo para mostrar el nombre  
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		return  nombre + ", Precio por minuto=" + PRECIOXMINUTO ;
	}

	
	
	
	
	
}
