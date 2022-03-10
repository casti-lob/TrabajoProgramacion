package com.jacaranda.sieteYmedia;

import java.util.Arrays;

public class Baraja {
	private int numCartas;
	private int siguiente;
	private Carta listCarta [];
	private final int CARTASMAX=40;
	
	//Constructor
	public Baraja() {
		super();
		this.numCartas=0;
		this.siguiente=0;
		this.listCarta= new Carta[CARTASMAX];
	}
	public Carta getSiguiente() throws BarajaException, CartaException {
		Carta copia;
		if(this.siguiente==CARTASMAX) {
			throw new BarajaException("No hay mas cartas");
		}else{
			copia = new Carta(listCarta[this.siguiente].getNumber(), listCarta[this.siguiente].getPalo());
			this.siguiente+=1;
		}
		return copia;
	}
	public void barajar() throws CartaException {
		int numero;
		int numeroPalos;
		int numeroCartasIntroducidas=0;
		boolean encontrado=false;
		String palos[]= {"","ORO","ESPADA","BASTO","COPA"};//el primer elemento esta vacio ya que el numero random nunca es 0
		while(this.numCartas< CARTASMAX){
			numero= (int) ((Math.random()*10)+1);
			numeroPalos=(int) ((Math.random()*4)+1);
			Carta nuevaCarta = new Carta(numero, palos[numeroPalos]);
			for(int i=0;i<numeroCartasIntroducidas&& encontrado==false;i++) {
				if(nuevaCarta.getNumber()==listCarta[i].getNumber()&&nuevaCarta.getPalo().equals(listCarta[i].getPalo())) {
					encontrado = true;
				}
			}
			if(encontrado == false) {
				listCarta[this.numCartas]= new Carta(nuevaCarta.getNumber(), nuevaCarta.getPalo());
				this.numCartas+=1;
				numeroCartasIntroducidas+=1;
			}else {
				encontrado= false;
			}
			
		}
	}
	
	
	public Carta getCarta() {
		return listCarta[siguiente];
	}
	@Override
	public String toString() {
		return "Baraja [numCartas=" + numCartas + ", listCarta=" + Arrays.toString(listCarta) + "]";
	}
	
	
	
}

