

import java.util.Scanner;

public class Menu {
	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Alumno a1= new Alumno("Manuel","28821541J","Lopez",3,6,7);
		Alumno a2= new Alumno("Manuel","28821541J","Lopez",3,6,7);
		Alumno a3= new Alumno("Manuel","28821541J","Lopez",3,6,7);
		Alumno a4= new Alumno("Manuel","28821541J","Lopez",3,6,7);
		System.out.println(a1.toString());
		System.out.println(a2.toString());
		System.out.println(a3.toString());
		System.out.println(a4.toString());
		System.out.println(a1.equals(a4));
	}

}
