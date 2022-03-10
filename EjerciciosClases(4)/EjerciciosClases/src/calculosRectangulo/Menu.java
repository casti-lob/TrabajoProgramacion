package calculosRectangulo;

import java.awt.Rectangle;
import java.util.Scanner;

public class Menu {
	public static Scanner teclado= new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangulo r = new Rectangulo();
		double longitud, ancho;
		System.out.println("Introduce la longitud del rectangulo");
		longitud= Double.parseDouble(teclado.nextLine());
		r.setLongitud(longitud);
		
		
		while(r.getLongitud()==false){
			System.out.println("Los valores no pueden ser menores de 1 o mayores que 20");
			System.out.println("Introduce la longitud del rectangulo");
			longitud= Double.parseDouble(teclado.nextLine());
			r.setLongitud(longitud);
		}
		
		System.out.println("Introduce la ancho del rectangulo");
		ancho= Double.parseDouble(teclado.nextLine());
		r.setAncho(ancho);
		
		while(r.getAncho()==false) {
			System.out.println("Los valores no pueden ser menores de 1 o mayores que 20");
			System.out.println("Introduce la ancho del rectangulo");
			ancho= Double.parseDouble(teclado.nextLine());
			r.setAncho(ancho);
		}
		
		System.out.println(r.toString());
		
	}

}
