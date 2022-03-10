package ejercicio2;

public class Producto {
	static int contadorCodigo=1;
	private int codigo;
	private String descricpion;
	static final double IVA=0.20;
	private double precio;
	
	//constructores
	
	public Producto( String descricpion, double precio) throws ProductoException {
		super();
		this.codigo = contadorCodigo++;
		this.descricpion = setDescricpion(descricpion);
		this.precio = setPrecio(precio);
		
	}

	public Producto(double precio) throws ProductoException {
		super();
		this.codigo = contadorCodigo++;
		this.precio = setPrecio(precio);
	}
	
	//Get & Set
	public static int getContadorCodigo() {
		return contadorCodigo;
	}

	private static void setContadorCodigo(int contadorCodigo) {
		Producto.contadorCodigo = contadorCodigo;
	}

	public int getCodigo() {
		return codigo;
	}

	private void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricpion() {
		return descricpion;
	}

	public String setDescricpion(String descricpion) {
		this.descricpion = descricpion;
		return descricpion;
	}

	public double getPrecio() {
		return precio;
	}

	public double setPrecio(double precio) throws ProductoException {
		if (precio<0) {
			throw new ProductoException("Tiene que ser mayor a 0");
		}else {
			this.precio = precio;
			return precio;
		}
		
		
	}

	public static double getIva() {
		return IVA;
	}
	
	//Calculo precio con iva
	
	public double precioConIva() {
		double iva = IVA+1, precioFinal;
		precioFinal= this.precio*iva;
		return precioFinal;
		
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", descricpion=" + descricpion + ", precio=" + precio + "]";
	}
}
	
	