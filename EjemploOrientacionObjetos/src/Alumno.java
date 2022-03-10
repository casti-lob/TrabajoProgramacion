
import java.util.Objects;

public class Alumno {
	private String nombre;
	private String dni;
	private String apellido;
	private double notaPrimerTrimestre=-1;
	private double notaSegundoTrimestre=-1;
	private double notaTercerTrimestre=-1;
	
	//Constructores
	public Alumno(String nombre, String dni, String apellido, double notaPrimerTrimestre, double notaSegundoTrimestre,
			double notaTercerTrimestre) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.apellido = apellido;
		this.notaPrimerTrimestre = notaPrimerTrimestre;
		this.notaSegundoTrimestre = notaSegundoTrimestre;
		this.notaTercerTrimestre = notaTercerTrimestre;
	}

	public Alumno(String dni, String apellido, double notaPrimerTrimestre, double notaSegundoTrimestre,
			double notaTercerTrimestre) {
		super();
		this.dni = dni;
		this.apellido = apellido;
		this.notaPrimerTrimestre = notaPrimerTrimestre;
		this.notaSegundoTrimestre = notaSegundoTrimestre;
		this.notaTercerTrimestre = notaTercerTrimestre;
	}

	public Alumno(String dni) {
		super();
		this.dni = dni;
	}

	public Alumno(String dni, double notaPrimerTrimestre, double notaSegundoTrimestre, double notaTercerTrimestre) {
		super();
		this.dni = dni;
		this.notaPrimerTrimestre = notaPrimerTrimestre;
		this.notaSegundoTrimestre = notaSegundoTrimestre;
		this.notaTercerTrimestre = notaTercerTrimestre;
	}
	
	
	//metodos getter y setter
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		System.out.println("introduce");
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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

	//comprobacion equals
	
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
	
	public double mediaNotas() {
		double resultado;
		resultado = (this.notaPrimerTrimestre+this.notaSegundoTrimestre+this.notaTercerTrimestre)/3;
		return Math.round(resultado*100)/100.0;
	}

	@Override
	public String toString() {
		return "Alumno " + nombre + ", dni= " + dni + ", apellido= " + apellido + ", notaPrimerTrimestre= "
				+ notaPrimerTrimestre + ", notaSegundoTrimestre= " + notaSegundoTrimestre + ", notaTercerTrimestre= "
				+ notaTercerTrimestre + ", mediaNotas= " + mediaNotas() ;
	}
	
	
	
	
}


