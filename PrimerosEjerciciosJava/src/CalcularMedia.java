import java.util.Scanner;

public class CalcularMedia {
	public static Scanner teclado= new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double resultado=0,numero;
		int i;
		for( i=0;i<=9;i=i+1) {
			System.out.println("Introduce un número");
			numero = Integer.parseInt(teclado.nextLine());
			resultado+=numero;
			
			
		}
		resultado = resultado/i;
		System.out.println("El total de números introducido es "+resultado);
		

	}

}
