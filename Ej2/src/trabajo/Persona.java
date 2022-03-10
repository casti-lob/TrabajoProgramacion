package trabajo;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Persona {
	private String nombre;
	private int edad;
	private String dni;
	private Password password;
	private char sexo;
	private double peso;
	private double altura;
	
	//Constructores
	
	
	public Persona() throws PersonaException {
		super();
		this.nombre="";
		setEdad(edad);
		this.sexo='M';
		this.peso=0;
		this.altura=0;
		this.password=new Password();
		this.dni=generarLetraDni();
		
	}
	
	
	public Persona(String nombre, int edad, char sexo) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
		this.peso=0;
		this.altura=0;
		this.password=new Password();
		this.dni= generarLetraDni();
	}
	
	

	public Persona(String nombre, int edad, String dni, char sexo, double peso, double altura) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.dni = dni;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
		this.password= new Password();
	}
	
	//Get & Set

	private String getNombre() {
		return nombre;
	}


	private void setNombre(String nombre) {
		this.nombre = nombre;
	}


	private int getEdad() {
		return edad;
	}


	public void setEdad(int edad) throws PersonaException{
		if(edad<0||edad>120) {
			throw new PersonaException("Esa edad no corresponde a ti mi perita jugosa");
		}
		
		this.edad = edad; 
	}


	private String getDni() {
		return dni;
	}



	private Password getPassword() {
		return password;
	}


	private void setPassword(Password password) {
		this.password = new Password();
	}


	private char getSexo() {
		return sexo;
	}


	private void setSexo(char sexo) throws PersonaException {
		if(sexo!='H'&& sexo!='M') {
			throw new PersonaException("Mal el sexo");
		}
		this.sexo = sexo;
	}


	private double getPeso() {
		return peso;
	}


	private void setPeso(double peso) {
		this.peso = peso;
	}


	private double getAltura() {
		return altura;
	}


	private void setAltura(double altura) {
		this.altura = altura;
	}

	//Generacion del DNI
	private String generarNumerosDni() {
		dni="";
		ThreadLocalRandom random= ThreadLocalRandom.current();
		for(int i =0;i<8;i++) {
			int caracter = random.nextInt(48,57);
			dni +=(char)caracter;
		}
		return dni;
	}
	private String generarLetraDni() {
		String letra="TRWAGMYFPDXBNJZSQVHLCKE";
		String dni= generarNumerosDni();
		int calculo= Integer.parseInt(dni);
		dni+=letra.charAt(calculo%23);
		return dni;
	}
	
	//Calculo del IMC
	
	public int calcularIMC() {
		int imc;
		imc=(int) ((int)this.peso/(this.altura*2));
		int resultado;
		if(imc<20) {
			resultado=-1;
		}else if(imc>=20 && imc<=25) {
			resultado=0;
		}else {
			resultado=1;
		}
		return resultado;
	}
	
	//Metodo para indicar si es mayor de edad
	public boolean esMayorDeEdad() {
		boolean respuesta;
		if(this.edad>17) {
			respuesta= true;
		}else {
			respuesta=false;
		}
		return respuesta;
	}
	
	//Metodo para comprobar el sexo
	
	public boolean comprobarSexo(char sexo) {
		//es verdadero si el sexo introducido es el mismo del objeto
		boolean respuesta=true;
		if(sexo!=this.sexo) {
			respuesta= false;
		}
		return respuesta;
	}

	//equals
	
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
		Persona other = (Persona) obj;
		return Objects.equals(dni, other.dni);
	}


	@Override
	public String toString() {
		return  nombre + ", " + edad +" a�os, dni=" + dni + ", password=" + password + ", sexo="
				+ sexo + ", peso=" + peso + ", altura=" + altura + ", IMC=" + calcularIMC()
				+ ", �es Mayor De Edad? = " + esMayorDeEdad() ;
	}
	
	
	//toString
	
	
}
