package ejercicio;

import java.time.LocalDate;

/**
	 * 
	 *@author Jose Antonio Castillejo Lobato
	 *@version 1.0
	 */
public class Pelicula {
	private String nombre;
	private LocalDate estreno;
	public static final int MAXIMOPERSONAJES=3;
	private Personaje Personaje;
	private Personaje Personaje2;
	private Personaje Personaje3;
	private static Personaje[] arrayPersonajes = new Personaje[MAXIMOPERSONAJES];
	private static int indicePersonajes =-1;
	private int contador=1;
	
	/**
	 * Constructor con las siguientes variables de entrada, para introducir el personaje,
	 * en el array hay que crearlo antes
	 * @param nombre
	 * @param estreno
	 * @param personaje
	 * @param personaje2
	 * @param personaje3
	 * @param contador
	 */
	public Pelicula(String nombre, LocalDate estreno, ejercicio.Personaje personaje, ejercicio.Personaje personaje2,
			ejercicio.Personaje personaje3, int contador) {
		super();
		this.nombre = nombre;
		this.estreno = estreno;
		setPersonaje(personaje);
		setPersonaje2(personaje2);
		setPersonaje3(personaje3);
		this.contador = contador;
	}
	
	/**
	 * Metodo en donde recibe un objeto personaje y lo introduce en la lista
	 * @param personaje
	 */
	public void setPersonaje(Personaje personaje) {
		arrayPersonajes [indicePersonajes+=contador] = new Personaje(personaje.getNombre(), personaje.getEstatura(),personaje.getPeso(), personaje.getEspecie());
	}
	/**
	 * Metodo en donde recibe un objeto personaje y lo introduce en la lista
	 * @param personaje2
	 */
	public void setPersonaje2(Personaje personaje2) {
		arrayPersonajes [indicePersonajes+=contador] = new Personaje(personaje2.getNombre(), personaje2.getEstatura(),personaje2.getPeso(), personaje2.getEspecie());
	}
	/**
	 * Metodo en donde recibe un objeto personaje y lo introduce en la lista
	 * @param personaje3
	 */
	public void setPersonaje3(Personaje personaje3) {
		arrayPersonajes [indicePersonajes+=contador] = new Personaje(personaje3.getNombre(), personaje3.getEstatura(),personaje3.getPeso(), personaje3.getEspecie());
	}

	private String getNombre() {
		return nombre;
	}

	private LocalDate getEstreno() {
		return estreno;
	}
	
	
	public String nombre(Pelicula p1,Pelicula p2) {
		if(LocalDate(p1.getEstreno()))
	}
	
	

	
	
}