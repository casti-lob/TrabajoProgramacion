package src;

import java.util.Objects;

public class Fecha {
	private int dia;
	private int mes;
	private int anno;
	public Fecha(int dia, int mes, int anno) {
		super();
		this.dia = dia;
		this.mes = mes;
		this.anno = anno;
	}
	public Fecha(Fecha String) {
		super();
		Fecha fecha= new Fecha(dia, mes, anno);
	}
	@Override
	public String toString() {
		return "Fecha [dia=" + dia + ", mes=" + mes + ", anno=" + anno + "]";
	}
	
	public boolean bisiestro() {
		boolean esBisiesto;
		if(anno%4==0) {
			if(anno%100==0) {
				if(anno%400==0) {
					esBisiesto=true;
				}else {
					esBisiesto=false;
				}
			}else {
				esBisiesto=true;
			}
		}else {
			esBisiesto= false;
		}
		return esBisiesto;
	}
	//Metodo para comprobar fecha
	
	
	@Override
	public int hashCode() {
		return Objects.hash(anno, dia, mes);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fecha other = (Fecha) obj;
		return anno == other.anno && dia == other.dia && mes == other.mes;
	}
	public void addDias(int dia) {
		this.dia = dia;
	}
	public int getDia() {
		return dia;
	}
	public String getDiaString() {
		String diaString="";
		diaString+=this.dia;
		return diaString;
	}
	public int getMes() {
		return mes;
	}
	public String getMesString() {
		String mesString="";
		mesString+=this.mes;
		return mesString;
	}
	public int getAnno() {
		return anno;
	}
	//metodo para sacar el mes en letras
	public String mesFormatoLargo() {
		
		String mes;
		switch (getMesString()) {
		case "1": {
			mes="Enero";
			break;
		}case "2": {
			mes="Febrero";
			break;
		}case "3": {
			mes="Marzo";
			break;
		}case "4": {
			mes="Abril";
			break;
		}case "5": {
			mes="Mayo";
			break;
		}case "6": {
			mes="Junio";
			break;
		}case "7": {
			mes="Julio";
			break;
		}case "8": {
			mes="Agosto";
			break;
		}case "9": {
			mes="Septiembre";
			break;
		}case "10": {
			mes="Octubre";
			break;
		}case "11": {
			mes="Noviembre";
			break;
		}case "12": {
			mes="Diciembre";
			break;
		}
		default:
			throw new IllegalArgumentException("Error" );
		}
		return mes;
	}
	public String getFechaFormatoLargo() {
		return getDiaString()+"/"+mesFormatoLargo()+"/"+getAnno();
	}
	
	
}
