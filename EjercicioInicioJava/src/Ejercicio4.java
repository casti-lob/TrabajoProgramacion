import java.util.Scanner;

public class Ejercicio4 {
	
	public static Scanner teclado=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Calcular las calificaciones de un alumno con un m�todo que reciba la nota de la parte pr�ctica, 
		la nota de los problemas y la parte te�rica. La nota final se calcula seg�n el siguiente criterio: 
		la parte pr�ctica vale el 10%; la parte de problemas vale el 50% y la parte te�rica el 40%. 
		Las notas deben estar entre 0 y 10, si no lo est�n, deber� devolver un mensaje de error. 
		Realiza el m�todo que calcule la media de tres notas y te devuelva la nota del bolet�n 
		(insuficiente, suficiente, bien, notable o sobresaliente).
		*/
		
		double nPractica, nProblemas, nTeorica, total;
		
		System.out.println("Introduce la nota de la parte pr�ctica");
		nPractica = Double.parseDouble(teclado.nextLine());
		
		while (nPractica <0 || nPractica>10) {
			
			System.out.println("Error la nota no puede tener esos valores");
			
			System.out.println("Introduce la nota de la parte pr�ctica");
			nPractica = Double.parseDouble(teclado.nextLine());
			
		}
		
		System.out.println("Introduce la nota de los problemas");
		nProblemas = Double.parseDouble(teclado.nextLine());
		
		while(nProblemas <0 || nProblemas>10) {
			
			System.out.println("Introduce la nota de los problemas");
			nProblemas = Double.parseDouble(teclado.nextLine());
		}
		
		System.out.println("Introduce la nota de la parte te�rica");
		nTeorica = Double.parseDouble(teclado.nextLine());
		
		while(nTeorica <0 || nTeorica>10) {
			System.out.println("Introduce la nota de la parte te�rica");
			nTeorica = Double.parseDouble(teclado.nextLine());
		}
		
		//Sacamos el valor de las notas seg�n los criterios
		nPractica = nPractica*0.10;
		nProblemas = nProblemas*0.50;
		nTeorica= nTeorica*0.40;
		total = nPractica+ nProblemas+ nTeorica;
		String resultado;
		if(total <5) {
			resultado ="Insuficiente";
		}else if (total <6) {
			resultado ="Suficiente";
			
		}else if(total <7) {
			resultado ="Bien";
		}else if(total <9) {
			resultado="Notable";
		}else {
			resultado="Sobre saliente";
		}
		System.out.println(Math.round(total*100.0)/100.0+" el resultado es "+resultado);
	}

}
