package SaldosCuenta;

public class CuentaCorriente {
	
	private double saldo;
	private int nReintegro;
	private int nIngresos;
	
	//constructor
	
	public CuentaCorriente(double saldo) {
		super();
		this.saldo = saldo;
		this.nReintegro= nReintegro=0;
		this.nIngresos= nIngresos=0;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	private int getnReintegro() {
		return nReintegro;
	}

	private void setnReintegro(int nReintegro) {
		this.nReintegro = nReintegro;
	}

	private int getnIngresos() {
		return nIngresos;
	}

	private void setnIngresos(int nIngresos) {
		this.nIngresos = nIngresos;
	}
	
	public void ingresar(double cantidad) {
		this.saldo+=cantidad;
		this.nIngresos+=1;
	}
	
	public void reintegro(double cantidad) {
		
			this.saldo-=cantidad;
			this.nReintegro+=1;
		
		
	}

	@Override
	public String toString() {
		return "CuentaCorriente saldo=" + saldo + ", nReintegro=" + nReintegro + ", nIngresos=" + nIngresos ;
	}
	
	

}
