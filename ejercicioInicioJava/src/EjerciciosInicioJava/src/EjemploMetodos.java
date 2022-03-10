package EjerciciosInicioJava.src;

import java.util.Scanner;

public class EjemploMetodos {
	public static Scanner teclado= new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double notaPractica,notaProblema,notaExamen;
		char respuesta;
		
		do {
			System.out.println("Introduce la nota practica");
			notaPractica = Double.parseDouble(teclado.nextLine());
			
		while (notaPractica <0 || notaPractica>10) {
				
			System.out.println("Error la nota no puede tener esos valores");
				
			System.out.println("Introduce la nota de la parte pr�ctica");
			notaPractica = Double.parseDouble(teclado.nextLine());
			}
		
			System.out.println("Introduce la nota del Problema");
			notaProblema = Double.parseDouble(teclado.nextLine());
			
			while(notaProblema <0 || notaProblema>10) {
				System.out.println("Error la nota no puede tener esos valores");
				System.out.println("Introduce la nota de los problemas");
				notaProblema = Double.parseDouble(teclado.nextLine());
			}
			
			
			System.out.println("Introduce la nota del Examen");
			notaExamen = Double.parseDouble(teclado.nextLine());
			
			while(notaExamen <0 || notaExamen>10) {
				System.out.println("Error la nota no puede tener esos valores");
				System.out.println("Introduce la nota de la parte te�rica");
				notaExamen = Double.parseDouble(teclado.nextLine());
			}
			
			System.out.println("La media de su nota es : "+ media(notaPractica,notaProblema,notaExamen));
			
			System.out.println("Quiere introducir otra nota o no(S/N)");
			respuesta = teclado.nextLine().charAt(0);
			
			
			while(respuesta != 'S'&& respuesta!='N') {
				System.out.println("Opci�n no contemplada");
				System.out.println("Quiere introducir otra nota o no(S/N)");
				respuesta = teclado.nextLine().charAt(0);
			}
			
		} while (respuesta=='S');
		
		System.out.println("Programa finalizado");
	}
	
	
	
	private static double media(double notaPractica,double notaProblema, double notaExamen) {
		double resultado = 0.1* notaPractica + 0.5* notaExamen+ 0.4* notaProblema; 
		return resultado;
	}

}
