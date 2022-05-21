package maquinaCafe;

public class Cafetera {
	public int depositoCafe;
	public int depositoLeche;
	public int depositoVasos;
	private double monedero;
	private double precioCafe;
	private double precioLeche;
	private double precioCafeConLeche;
	
	//Constructor
	

	public int getDepositoCafe() {
		return depositoCafe;
	}

	public Cafetera() {
		super();
		this.depositoCafe = depositoCafe=50;
		this.depositoLeche = depositoLeche=50;
		this.depositoVasos = depositoVasos=80;
		this.monedero = monedero=30.5;
		this.precioCafe = precioCafe=1;
		this.precioLeche = precioLeche=0.8;
		this.precioCafeConLeche = precioCafeConLeche=1.5;
	}

	public void setDepositoCafe(int depositoCafe) {
		this.depositoCafe = depositoCafe;
	}

	public int getDepositoLeche() {
		return depositoLeche;
	}

	public void setDepositoLeche(int depositoLeche) {
		this.depositoLeche = depositoLeche;
	}

	public int getDepositoVasos() {
		return depositoVasos;
	}

	public void setDepositoVasos(int depositoVasos) {
		this.depositoVasos = depositoVasos;
	}

	public double getMonedero() {
		return monedero;
	}

	public void setMonedero(double monedero) {
		this.monedero = monedero;
	}

	public double getPrecioCafe() {
		return precioCafe;
	}

	private void setPrecioCafe(double precioCafe) {
		this.precioCafe = precioCafe;
	}

	public double getPrecioLeche() {
		return precioLeche;
	}

	private void setPrecioLeche(double precioLeche) {
		this.precioLeche = precioLeche;
	}

	public double getPrecioCafeConLeche() {
		return precioCafeConLeche;
	}

	private void setPrecioCafeConLeche(double precioCafeConLeche) {
		this.precioCafeConLeche = precioCafeConLeche;
	}
	
	//metodos
	public void llenadoDepositos() {
		if(this.depositoCafe==0 || this.depositoLeche==0 || this.depositoVasos==0) {
			this.depositoCafe += 50-this.depositoCafe;
			this.depositoLeche+= 50-this.depositoLeche;
			this.depositoVasos+=80-this.depositoVasos;
		}
		
	}
	
	private void vaciarMonedero() {
		this.monedero=0;
	}
	
	public String servirCafe(int opc, double dineroIntroducido) {
		String respuesta;
		switch (opc) {
		case 1: {
				if(dineroIntroducido< this.precioCafe) {
					respuesta= "Dinero insuficiente";
				}else if(dineroIntroducido> this.precioCafe) {
					dineroIntroducido -= this.precioCafe;
					
					this.depositoCafe-=1;
					this.depositoVasos-=1;
					this.monedero+=this.precioCafe;
					respuesta= "Recoge tu cambio de "+ dineroIntroducido+" euros" +"\n"+"Prudicto servido";
				}else {
					this.depositoCafe-=1;
					this.depositoVasos-=1;
					this.monedero+=this.precioCafe;
					respuesta = "Producto servido";
				}
				break;
			}
		case 2:{
			if(dineroIntroducido< this.precioCafe) {
				respuesta= "Dinero insuficiente";
			}else if(dineroIntroducido> this.precioCafe) {
				dineroIntroducido -= this.precioCafe;
				
				this.depositoLeche-=1;
				this.depositoVasos-=1;
				this.monedero+=this.precioLeche;
				respuesta= "Recoge tu cambio de "+ dineroIntroducido+" euros" +"\n"+"Prudicto servido";
			}else {
				this.depositoLeche-=1;
				this.depositoVasos-=1;
				this.monedero+=this.precioLeche;
				respuesta = "Producto servido";
			}
			break;
		}
		case 3:{
			if(dineroIntroducido< this.precioCafe) {
				respuesta= "Dinero insuficiente";
			}else if(dineroIntroducido> this.precioCafe) {
				dineroIntroducido -= this.precioCafe;
			
			this.depositoCafe-=1;
			this.depositoLeche-=1;
			this.depositoVasos-=1;
			this.monedero+=this.precioCafeConLeche;
			respuesta= "Recoge tu cambio de "+ dineroIntroducido+" euros" +"\n"+"Prudicto servido";
			
			}else {
				this.depositoCafe-=1;
				this.depositoLeche-=1;
				this.depositoVasos-=1;
				this.monedero+=this.precioCafeConLeche;
				respuesta = "Producto servido";
			}
			break;
		}
		default:
			respuesta = "Error inesperado";
		}
		return respuesta;
		
	}

	@Override
	public String toString() {
		return " Estado de la Cafetera depositoCafe=" + depositoCafe + ", depositoLeche=" + depositoLeche + ", depositoVasos="
				+ depositoVasos + ", monedero=" + monedero + ", precioCafe=" + precioCafe + ", precioLeche="
				+ precioLeche + ", precioCafeConLeche=" + precioCafeConLeche ;
	}
	
	
}
