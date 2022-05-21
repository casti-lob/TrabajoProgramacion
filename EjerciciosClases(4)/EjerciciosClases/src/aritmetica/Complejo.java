package aritmetica;

import java.util.Objects;

public class Complejo {
	private int parteReal;
	private int parteImaginaria;
	
	public Complejo(int parteReal, int parteImaginaria) {
		super();
		this.parteReal = parteReal;
		this.parteImaginaria = parteImaginaria;
	}

	public int getParteReal() {
		return parteReal;
	}

	public void setParteReal(int parteReal) {
		this.parteReal = parteReal;
	}

	public int getParteImaginaria() {
		return parteImaginaria;
	}

	public void setParteImaginaria(int parteImaginaria) {
		this.parteImaginaria = parteImaginaria;
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(parteImaginaria, parteReal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Complejo other = (Complejo) obj;
		return parteImaginaria == other.parteImaginaria && parteReal == other.parteReal;
	}
	
	public String infoNumComplejo() {
		String info="El numero complejo es "+"\n"+"Parte real: "+this.parteReal + " Parte imaginaria: "+this.parteImaginaria;
		return info;
	}
	
	public Complejo suma(Complejo c2){
		Complejo resultado = new Complejo(0,0);
		resultado.setParteReal(this.getParteReal()+c2.getParteReal());
		resultado.setParteImaginaria(this.getParteImaginaria()+c2.getParteImaginaria());
		
		return resultado;
		
	}
	public Complejo resta(Complejo c2) {
		Complejo resultado = new Complejo(0,0);
		resultado.setParteReal(c2.getParteReal()-this.getParteReal());
		resultado.setParteImaginaria(c2.getParteImaginaria()-this.getParteImaginaria());
		
		return resultado;
		
		
	}

	@Override
	public String toString() {
		if(parteImaginaria>0) {
			return "Complejo= "+ parteReal + " + " + parteImaginaria + "i";
		}else if(parteImaginaria==0) {
			return " "+parteReal;
		}else {
			return "Complejo= "+ parteReal + " " + parteImaginaria + "i";

		}
	}
	
}
