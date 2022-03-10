package calculosRectangulo;

import java.util.Objects;

public class Rectangulo {
	private double longitud;
	private double ancho;
	
	//constructor
	public Rectangulo() {
		super();
		this.longitud =1;
		this.ancho = 1;
	}
	
	//metodos gets & sets
	
	public boolean getLongitud() {
		boolean cambiosRealizados ;
		if(this.longitud==-1) {
			cambiosRealizados=false;
		}else {
			cambiosRealizados= true;
		}
		return cambiosRealizados;
	}

	public void setLongitud(double longitud) {
		if(longitud>0 && longitud<20) {
			this.longitud = longitud;
		}else {
			this.longitud = -1;
		}
		
	}

	public boolean getAncho() {
		boolean cambiosRealizados;
		if(this.ancho==-1) {
			cambiosRealizados= false;
		}else {
			cambiosRealizados=true;
		}
		return cambiosRealizados;
	}

	public void setAncho(double ancho) {
		if(ancho>0 && ancho<20) {
			this.ancho = ancho;
		}else {
			this.ancho = -1;
		}

	}
	
	@Override
	public int hashCode() {
		return Objects.hash(ancho, longitud);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rectangulo other = (Rectangulo) obj;
		return Double.doubleToLongBits(ancho) == Double.doubleToLongBits(other.ancho)
				&& Double.doubleToLongBits(longitud) == Double.doubleToLongBits(other.longitud);
	}
	//metodo calculo perimetro
	public double perimetro() {
		double p;
		p= (this.ancho*2)+(this.longitud*2);
		return p;
	}
	//metodo calculo area
	public double area() {
		double a;
		a= this.ancho*this.ancho;
		return a;
	}

	@Override
	public String toString() {
		return "El rectangulo con longitud=" + longitud + "y ancho=" + ancho + " \n "+ "Su perimetro =" + perimetro() + " \n "+ "Y su Area="
				+ area();
	}
	
	
	
}
