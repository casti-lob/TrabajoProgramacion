package com.jacaranda.baraja;

public class BarajaEspannola extends Baraja {
	
	public BarajaEspannola() {
		super(40);
	}
	
	

	@Override
	public String generarPalo() {
		// TODO Auto-generated method stub
		int numeroPalos;
		numeroPalos=(int) ((Math.random()*4));
		return PalosBarajaEspannola.values()[numeroPalos].toString();
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
	
		StringBuilder resultado=new StringBuilder("Baraja Espa�ola\n");
		for(int i =0 ;i<super.numCartas;i++) {
			if(super.listCarta[i].getNumber()<=7) {
				resultado.append(super.listCarta[i].getNumber());
				
			}else {
				if(super.listCarta[i].getNumber()==8) {
					resultado.append("SOTA");
				}
				else if(super.listCarta[i].getNumber()==9) {
					resultado.append("CABALLO");
				}
				else {
					resultado.append("REY");
				}
			}
			resultado.append("" + super.listCarta[i].getPalo()+"\n");
		}
		return resultado.toString();
	}
	
	

}
