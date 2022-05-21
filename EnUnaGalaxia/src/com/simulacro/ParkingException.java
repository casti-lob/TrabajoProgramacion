package com.simulacro;
/**
 * 
 * @author Jose Antonio Castillejo Lobato
 *@version 1.0
 */
public class ParkingException extends Exception {
	/**
	 * Constructor de la clase ParkingException que hereda de la clase Exception sin ningún parametro de entrada
	 */
	public ParkingException() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 *  Constructor de la clase ParkingException que hereda de la clase Exception con el mensaje como parametro de entrada
	 * @param message
	 */
	public ParkingException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}
