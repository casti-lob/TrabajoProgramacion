package com.simulacro;
/**
 * 
 * @author Jose Antonio Castillejo Lobato
 * @version 1.0
 */
public class Parking {
	private String nombre;
	private  int totalPlazas;
	private Categoria categoria;
	private int numberoPlazasOcupadas;
	private int codigo;
	private  double recaudacion;
	
	/**
	 * Constructor de la clase Parking con los siguientes parametros de entrada (nombre,categoria,totlaPlaza)
	 * Por defecto establece las variables numeroPlazaOcupadas y recaudacion a 0 y se genera un código de forma aleatoria
	 * @param nombre
	 * @param categoria
	 * @param totalPlazas
	 * @throws ParkingException
	 *Lanzamos la exception en caso de que nos den un numero de totalPlazas menor que 1 con el codigo 0001
	 */
	public Parking(String nombre, Categoria categoria, int totalPlazas) throws ParkingException {
		super();
		this.nombre = nombre;
		this.categoria= categoria;
		this.totalPlazas= totalPlazas;
		this.numberoPlazasOcupadas=0;
		this.recaudacion=0;
		this.codigo= (int) (Math.random()*999)+1;
		if(this.totalPlazas<1) {
			throw new ParkingException("0001 El numero total de plazas no puede ser menor a 1");
		}
		
	}
	
	/**
	 * Metodo para modificar la variable recaudación mediante el parametro de entrada 
	 * @param recaudacion
	 */
	private void setRecaudacion(double recaudacion) {
		this.recaudacion += recaudacion;
	}

	/**
	 * Metodo para mostrar una copia del nombre de la clase categoria que tiene asociada nuestra clase Parking
	 * @return copia
	 */
	private Categoria getCategoria() {
		Categoria copia= new Categoria(categoria.getNombre());
		return copia;
	}
	/**
	 * Metodo para rellenar el numero de plazas de la clase Parking
	 * @throws ParkingException
	 *Lanzamos la exception en caso de que nuestra clase Parking este completa con el codigo 0002
	 */
	public void entrarParking() throws ParkingException {
		if(this.numberoPlazasOcupadas== this.totalPlazas) {
			throw new ParkingException("0002 El parking esta completo");
		}else {
			this.numberoPlazasOcupadas+=1;
		}
		
	}
	/**
	 * Metodo para retirar la plaza ocupada del Parking y muestre al usuario cuanto debe de pagar en función de los minutos que reciba nuestro metodo
	 * y el precio por minutos que tenga la clase del Parking
	 * @param minutos
	 * @return precio
	 * @throws ParkingException
	 * Lanzamos la exception en caso de que los minutos recibidos sean menores que 1 con el codigo 0003 y en caso de que el Parking 
	 * este vacío y no se pueda retirar ninguna plaza de Parking con el codigo 0004
	 */
	public double cobrarYsalirDelParking(int minutos) throws ParkingException {
		double precio=0;
		if(minutos<0) {
			throw new ParkingException("0003 Los minutos no pueden ser menores que 1");
		}else if (this.numberoPlazasOcupadas==0) {
			throw new ParkingException("0004 El parking esta vacio");
		}else {
			this.numberoPlazasOcupadas-=1;
			setRecaudacion(minutos*(getCategoria().getPRECIOXMINUTO()));
			precio= minutos*getCategoria().getPRECIOXMINUTO();
		}
		return precio;
	}
	
	/**
	 * Metodo para clonar la clase Parking con el mismo nombre, categoria y total de plazas. Las demás variables se deja por defecto según el constructor 
	 * @param nombre
	 * @return clon
	 * @throws ParkingException
	 */
	public Parking clonarParking(String nombre) throws ParkingException {
		Parking clon = new Parking(nombre, getCategoria(), this.totalPlazas);
		return clon;
	}

	@Override
	public String toString() {
		return "Parking \n" + "nombre=" + nombre + ", totalPlazas=" + totalPlazas + ", categoria=" + categoria
				+ ", numberoPlazasOcupadas=" + numberoPlazasOcupadas + ", codigo=" + codigo + ", recaudacion="
				+ recaudacion + "]";
	}
	
	
	
}
