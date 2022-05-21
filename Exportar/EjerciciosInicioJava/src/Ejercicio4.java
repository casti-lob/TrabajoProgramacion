import java.util.Scanner;

public class Ejercicio4 {
	
	public static Scanner teclado=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Calcular las calificaciones de un alumno con un método que reciba la nota de la parte práctica, 
		la nota de los problemas y la parte teórica. La nota final se calcula según el siguiente criterio: 
		la parte práctica vale el 10%; la parte de problemas vale el 50% y la parte teórica el 40%. 
		Las notas deben estar entre 0 y 10, si no lo están, deberá devolver un mensaje de error. 
		Realiza el método que calcule la media de tres notas y te devuelva la nota del boletín 
		(insuficiente, suficiente, bien, notable o sobresaliente).
		*/
		
		double nPractica, nProblemas, nTeorica, total;
		
		System.out.println("Introduce la nota de la parte práctica");
		nPractica = Double.parseDouble(teclado.nextLine());
		
		while (nPractica <0 || nPractica>10) {
			
			System.out.println("Error la nota no puede tener esos valores");
			
			System.out.println("Introduce la nota de la parte práctica");
			nPractica = Double.parseDouble(teclado.nextLine());
			
		}
		
		System.out.println("Introduce la nota de los problemas");
		nProblemas = Double.parseDouble(teclado.nextLine());
		
		while(nProblemas <0 || nProblemas>10) {
			
			System.out.println("Introduce la nota de los problemas");
			nProblemas = Double.parseDouble(teclado.nextLine());
		}
		
		System.out.println("Introduce la nota de la parte teórica");
		nTeorica = Double.parseDouble(teclado.nextLine());
		
		while(nTeorica <0 || nTeorica>10) {
			System.out.println("Introduce la nota de la parte teórica");
			nTeorica = Double.parseDouble(teclado.nextLine());
		}
		
		//Sacamos el valor de las notas según los criterios
		nPractica = nPractica*0.10;
		nProblemas = nProblemas*0.50;
		nTeorica= nTeorica*0.40;
		total = nPractica+ nProblemas+ nTeorica;
		System.out.println(Math.round(total*100.0)/100.0);
	}

}
