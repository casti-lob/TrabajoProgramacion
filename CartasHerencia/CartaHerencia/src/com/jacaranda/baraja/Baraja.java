package com.jacaranda.baraja;

import java.util.Arrays;

public abstract class Baraja implements Repartible {
	protected int numCartas;
	private int siguiente;
	protected Carta[] listCarta ;
	
	
	//Constructor
	public Baraja(int numCartas) {
		super();
		this.numCartas=numCartas;
		this.siguiente=0;
		this.listCarta = new Carta[numCartas];
		barajar();
	}
	
	
	private int generarNumero() {
		int numero;
		numero= (int) ((Math.random()*(numCartas/4))+1);
		return numero;
	}
	
	protected abstract String generarPalo();
	/*{
		int numeroPalos;
		numeroPalos=(int) ((Math.random()*4)+1);
		String palos[]= {"","ORO","ESPADA","BASTO","COPA"};
		return palos[numeroPalos];
	}*/
	
	public void barajar(){
		int numeroCartasBarajadas = 0;
		while(numeroCartasBarajadas<this.numCartas) {
			int numeroCarta=generarNumero();
			String palo = generarPalo();
			Carta cartaGenerada = new Carta(numeroCarta, palo);
			boolean encontrado = false;
			for(int i = 0;i<numeroCartasBarajadas&& encontrado==false;i++) {
				if(cartaGenerada.equals(listCarta[i])) {
					encontrado=true;
				}
			}
			if(encontrado==false) {
				listCarta[numeroCartasBarajadas]=cartaGenerada;
				numeroCartasBarajadas++;
				
			}
		}
		System.out.println("hola");
	}
	
	
	
	@Override
	public String toString() {
		return "Baraja [numCartas=" + numCartas + ", listCarta=" + Arrays.toString(listCarta) + "]";
	}
	@Override
	public Carta getSiguiente() {
		// TODO Auto-generated method stub
		Carta copia;
		if(this.siguiente== this.numCartas) {
			this.siguiente=0;
		}
		copia = new Carta(listCarta[this.siguiente].getNumber(), listCarta[this.siguiente].getPalo());
		this.siguiente+=1;
		
		return copia;
		
	}


	
	
	
	
}

