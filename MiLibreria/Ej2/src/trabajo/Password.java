                      package trabajo;

import java.util.Objects;

import java.util.concurrent.ThreadLocalRandom;

public class Password {
	private String contrasenna;
	private static final int LONGITUD=8;
	private int longitud;
	
	/*
	 * Constructores
	 */
	public Password() {
		super();
		this.longitud=LONGITUD;
		this.contrasenna= generarPassword();
		
	}
	public Password(int longitud) {
		super();
		this.longitud = longitud;
		this.contrasenna= generarPassword();
	}
	
	/*
	 * Get & Set
	 */
	
	
	private void setContrasenna(String contrasenna) {
		this.contrasenna = contrasenna;
	}
	private int getLongitud() {
		return longitud;
	}
	private void setLongitud(int longitud) {
		this.longitud = longitud;
	}
	/*
	 * Metodo para devolver la longitud
	 */
	public int getLONGITUD() {
		return LONGITUD;
	}
	/*
	 * Metodo para averiguar si es fuerte para eso de be de cumplir
	 * (+2 Mayusculas +1 minuscula +5numeros
	 */
	private boolean masDosMayus() {
		boolean respuesta = false;
		char caracter;
		int contadorMayus=0;
		for(int i = 0;i<contrasenna.length();i++) {
			caracter= contrasenna.charAt(i);
			if(Character.isUpperCase(caracter)) {
				contadorMayus++;
			}	
		}
		if(contadorMayus>2) {
			respuesta= true;
		}
		return respuesta;
	}
	private boolean masUnaMinus() {
		boolean respuesta = false;
		char caracter;
		int contadorMinus=0;
		for(int i = 0;i<contrasenna.length();i++) {
			caracter= contrasenna.charAt(i);
			if(Character.isLowerCase(caracter)) {
				contadorMinus++;
			}	
		}
		if(contadorMinus>1) {
			respuesta= true;
		}
		return respuesta;
	}
	
	private boolean masCincoNum() {
		boolean respuesta = false;
		char caracter;
		int contadorNum=0;
		for(int i = 0;i<contrasenna.length();i++) {
			caracter= contrasenna.charAt(i);
			if(Character.isDigit(caracter)) {
				contadorNum++;
			}	
		}
		if(contadorNum>5) {
			respuesta= true;
		}
		return respuesta;
	}
	public boolean esFuerte() {
		boolean estado;
		if (masDosMayus()==true && masUnaMinus()==true&& masCincoNum()==true) {
			estado=true;
		}else {
			estado = false;
		}
		return estado;
	}
	
	/*
	 * Metodo para generar contrase�a aleatoria
	 */
	private String generarPassword() {
		contrasenna="";
		ThreadLocalRandom random= ThreadLocalRandom.current();
		
			for(int i =0;i<this.longitud;i++) {
				int caracter = random.nextInt(48,122);
				contrasenna +=(char)caracter;
			}
		
		
		return contrasenna;
	}
	/*
	 * Metodo para devolver contrase�a
	 */
	public String getPassword() {
		return this.contrasenna;
	}
	@Override
	public int hashCode() {
		return Objects.hash(contrasenna);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Password other = (Password) obj;
		return Objects.equals(contrasenna, other.contrasenna);
	}
	@Override
	public String toString() {
		return "Su password es " + getPassword();
	}
	
	
}
