import java.util.Objects;

public class Cita {
	private String nombre;
	private String lugar;
	
	public Cita(String nombre, String lugar) {
		super();
		this.nombre = nombre;
		this.lugar = lugar;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	
	public String escrituraCita() {
		return this.nombre+","+this.lugar;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cita other = (Cita) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Cita [nombre=" + nombre + ", lugar=" + lugar + "]";
	}
	
	
}
