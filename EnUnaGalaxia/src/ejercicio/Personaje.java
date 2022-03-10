package ejercicio;
/**
 * 
 * @author Jose Antonio Castillejo Lobato
 *@version 1.0
 */
public class Personaje {
	private final int VALORMINPODER=1;
	private final int VALORMAXPODER=100;
	private String nombre;
	private int poder;
	private double estatura;
	private double peso;
	private String especie;
	private Pelicula primeraPelicula;
	
	/**
	 * Primer constructor con las siguientes variables de entrada
	 * @param nombre
	 * @param estatura
	 * @param peso
	 * @param especie
	 */
	//constructores
	public Personaje(String nombre, double estatura, double peso, String especie) {
		super();
		this.nombre = nombre;
		this.estatura = estatura;
		this.peso = peso;
		this.especie = especie;
	}
	
	/**
	 * Segundo constructor con las siguientes variables de entrada
	 * @param nombre
	 * @param poder
	 * @param estatura
	 * @param peso
	 * @param especie
	 * @param primeraPelicula
	 */
	public Personaje(String nombre, int poder, double estatura, double peso, String especie, Pelicula primeraPelicula) {
		super();
		this.nombre = nombre;
		this.poder = poder;
		this.estatura = estatura;
		this.peso = peso;
		this.especie = especie;
		this.primeraPelicula = primeraPelicula;
	}

	//Get&Set
	/**
	 * Metodo que devuelve el nombre del personaje
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Metodo que actualiza el nombre del personaje por la variable de entrada que pongamos
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Metodo que devuelve el poder del personaje
	 * @return poder
	 */
	public int getPoder() {
		return poder;
	}
	/**
	 *  Metodo que actualiza el poder del personaje por la variable de entrada que pongamos
	 * @param poder
	 */
	public void setPoder(int poder) {
		this.poder = poder;
	}
	/**
	 * Metodo que devuelve la estatura del personaje
	 * @return estatura
	 */
	public double getEstatura() {
		return estatura;
	}
	/**
	 *  Metodo que actualiza la estatura del personaje por la variable de entrada que pongamos
	 * @param estatura
	 */
	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}
	/**
	 * Metodo que devuelve el peso del personaje
	 * @return peso
	 */
	public double getPeso() {
		return peso;
	}
	/**
	 *  Metodo que actualiza el peso del personaje por la variable de entrada que pongamos
	 * @param peso
	 */
	public void setPeso(double peso) {
		this.peso = peso;
	}
	/**
	 * Metodo que devuelve la especie del personaje
	 * @return especie
	 */
	public String getEspecie() {
		return especie;
	}
	/**
	 *  Metodo que actualiza la especie del personaje por la variable de entrada que pongamos
	 * @param especie
	 */
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	/**
	 * Metodo que devuelve la primera pelicula del personaje
	 * @return primeraPelicula
	 */
	public Pelicula getPrimeraPelicula() {
		return primeraPelicula;
	}
	/**
	 *  Metodo que actualiza la primera pelicula del personaje por la variable de entrada que pongamos
	 * @param primeraPelicula
	 */
	public void setPrimeraPelicula(Pelicula primeraPelicula) {
		this.primeraPelicula = primeraPelicula;
	}
	/**
	 * Metodo que devuelve el valor minimo de poder que se acepta
	 * @return VALORMINPODER
	 */
	public int getVALORMINPODER() {
		return VALORMINPODER;
	}
	/**
	 *  Metodo que devuelve el valor maximo de poder que se acepta
	 * @return VALORMAXPODER
	 */
	public int getVALORMAXPODER() {
		return VALORMAXPODER;
	}

	@Override
	public String toString() {
		return "Personaje \n"+"nombre=" + nombre + ", poder=" + poder + ", estatura=" + estatura + ", peso=" + peso
				+ ", especie=" + especie;
	}
/*
	public static Pelicula setPelicula() {
		
		boolean encontrado= false;
		for (int i=0;i<Personaje ;i++) {
		}
	
	}
	*/
	
}