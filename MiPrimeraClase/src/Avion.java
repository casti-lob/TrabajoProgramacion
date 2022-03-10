import java.util.Objects;

public class Avion {
	private String idAvion;
	private String compannia;
	private int capacidad;
	private int numVuelos;
	private double kmVolados;
	
	
	
	//Constructores
	
	public Avion(String idAvion, int capacidad) {
		super();
		this.idAvion = idAvion;
		this.capacidad = capacidad;
		this.numVuelos=0;
		this.kmVolados=0;
	}


	public Avion(String idAvion, String compannia , int capacidad) {
		super();
		this.idAvion = idAvion;
		this.compannia = compannia;
		this.capacidad = capacidad;
		this.numVuelos=0;
		this.kmVolados=0;
		
	}

	//get&set
	public int getNumVuelos() {
		return numVuelos;
	}


	private void setNumVuelos(int numVuelos) {
		this.numVuelos = numVuelos;
	}


	public double getTotalKm() {
		return kmVolados;
	}


	private void setTotalKm(double kmVolados) {
		this.kmVolados = kmVolados;
	}


	public String getCompannia() {
		return compannia;
	}


	public void setCompannia(String compannia) {
		this.compannia = compannia;
	}


	public String getIdAvion() {
		return idAvion;
	}


	public int getCapacidad() {
		return capacidad;
	}
	
	// equals
	
	@Override
	public int hashCode() {
		return Objects.hash(idAvion);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Avion other = (Avion) obj;
		return Objects.equals(idAvion, other.idAvion);
	}
	//metodo media de km por vuelos
	public double getMediaKm () {
		double resultado;
		resultado= this.kmVolados/ this.numVuelos;
		return resultado;
	}
	//
	public boolean asignarVuelo(int capacidad,double kilometros) {
		boolean asignado;
		if(capacidad >0 || capacidad <=this.capacidad || kilometros >0 ) {
			asignado = true;
			this.numVuelos+=1;
			this.kmVolados+= kilometros;
			
		}else {
			asignado =false;
		}
		return asignado;
	}
	//toString

	@Override
	public String toString() {
		return "Avion [idAvion=" + idAvion + ", numVuelos=" + numVuelos + ", kmVolados=" + kmVolados + ", compannia="
				+ compannia + ", kmPorVuelo()=" + getMediaKm() + "]";
	}
	
	
	
	
}
