package com.jacaranda.sieteYmedia;

import java.util.Objects;

public class Carta {
	private int number;
	private String palo;
	
	//Constructor
	public Carta(int number, String palo) throws CartaException {
		super();
		if(number >10 || number<1) {
			throw new CartaException("El numero de la carta no puede ser menor a 1 o superior a 10");
		}if (!palo.toUpperCase().equals("ORO")&&!palo.toUpperCase().equals("COPA")&&!palo.toUpperCase().equals("ESPADA")&&!palo.toUpperCase().equals("BASTO")){
			throw new CartaException("Palo no aceptado");
		}else {
			this.number = number;
			this.palo = palo;
		}
		
	}
	
	//Metodo para obtener valor, si el numero esta entre 1 y 7 
	//vale su numero si no 0.5
	public double getValor() {
		double valor;
		if(this.number>=1 && this.number<=7) {
			valor= this.number;
		}else {
			valor =0.5;
		}
		return valor;
	}

	/*
	 * Una carta es igual si tiene el mismo numero y palo
	 */
	@Override
	public int hashCode() {
		return Objects.hash(number, palo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carta other = (Carta) obj;
		return number == other.number && Objects.equals(palo, other.palo);
	}
	
	//Metodo para mostrar nombre y palo
	public int getNumber() {
		return number;
	}
	
	public String getPalo() {
		return palo;
	}
	
	@Override
	public String toString() {
		String number="";
		switch (this.number) {
		case 1: {
		}case 2: {
		}case 3: {
		}case 4: {
		}case 5: {
		}case 6: {
		}case 7: {
			number = String.valueOf(this.number);
			break;
		}case 8: {
			number="Sota";
			break;
		}case 9: {
			number="Caballo";
			break;
		}case 10: {
			number="Rey";
			break;
		}
		default:
			System.out.println("Error inesperado");
		}
		return "Carta [number=" + number + ", palo=" + palo + "]";
	}
	
	
	
	
	
	

}
