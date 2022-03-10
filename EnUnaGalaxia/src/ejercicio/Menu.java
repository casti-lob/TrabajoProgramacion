package ejercicio;

import java.time.LocalDate;

public class Menu {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Personaje pp= new Personaje("ss", 0, 0, null);
	Personaje pp2= new Personaje("se", 0, 0, null);
	Personaje pp3= new Personaje("su", 0, 0, null);
	Pelicula peli= new Pelicula(null, LocalDate.of(2018,10,30), pp, pp2, pp3, 0);
	System.out.println(peli);
	}

}