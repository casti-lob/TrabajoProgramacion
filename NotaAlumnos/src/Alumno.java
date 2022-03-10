import java.util.Objects;

public class Alumno {

	private String nombre;
	private String dni;
	private String apellidos;
	private double notaPrimerTrimestre;
	private double notaSegundoTrimestre;
	private double notaTercerTrimestre;
	
	public Alumno(String dni){
		this.dni = dni;
		this.notaPrimerTrimestre=-1;
		this.notaSegundoTrimestre=-1;
		this.notaTercerTrimestre=-1;
	}
	
	public Alumno(String nombre, String dni, String apellidos) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.apellidos = apellidos;
		this.notaPrimerTrimestre=-1;
		this.notaSegundoTrimestre=-1;
		this.notaTercerTrimestre=-1;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public double getNotaPrimerTrimestre() {
		return notaPrimerTrimestre;
	}

	public void setNotaPrimerTrimestre(double notaPrimerTrimestre) {
		this.notaPrimerTrimestre = notaPrimerTrimestre;
	}

	public double getNotaSegundoTrimestre() {
		return notaSegundoTrimestre;
	}

	public void setNotaSegundoTrimestre(double notaSegundoTrimestre) {
		this.notaSegundoTrimestre = notaSegundoTrimestre;
	}

	public double getNotaTercerTrimestre() {
		return notaTercerTrimestre;
	}

	public void setNotaTercerTrimestre(double notaTercerTrimestre) {
		this.notaTercerTrimestre = notaTercerTrimestre;
	}

	public String getDni() {
		return dni;
	}

	
	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", dni=" + dni + ", apellidos=" + apellidos + ", notaPrimerTrimestre="
				+ notaPrimerTrimestre + ", notaSegundoTrimestre=" + notaSegundoTrimestre + ", notaTercerTrimestre="
				+ notaTercerTrimestre + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(dni, other.dni);
	}

	public int obtenerNotaFinal() {
		int resultado = (int) ((this.notaPrimerTrimestre+this.notaSegundoTrimestre+this.notaTercerTrimestre)/3);
		return resultado;
	}
}
