package ejercicio5;

import java.util.Objects;

/**
 * Clase prueba
 * @author Jose Antonio Castillejo Lobato
 *@version 1.0
 *
 */

public class Equipo {
	private String nombre;
	private int partidosGanados;
	private String estadio;
	private String ciudad;
	
	/**
	 * Tenemos :
	 * @param nombre
	 * Que lo convertimos en mayuscula
	 * 
	 * @param estadio
	 * @param ciudad
	 */

	public Equipo(String nombre,String estadio,String ciudad) {
		super();
		setNombre(nombre.toUpperCase());
		this.partidosGanados=0;
		this.estadio = estadio;
		this.ciudad = ciudad;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getPartidosGanados() {
		return partidosGanados;
	}

	public void setPartidosGanados(int partidosGanados) {
		this.partidosGanados = partidosGanados;
	}
	
	
	public String getEstadio() {
		return estadio;
	}

	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}
	
	

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}
	
	

	@Override
	/**
	 * Establecemos que dos equipos son iguales si tienen el mismo nombre
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipo other = (Equipo) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Nombre "+nombre+" Ciudad "+ciudad+" Estadio "+estadio ;
	}
	
	
}
