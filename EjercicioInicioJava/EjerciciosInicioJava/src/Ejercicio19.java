import java.util.Scanner;

public class Ejercicio19 {
	
	public static Scanner teclado= new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Método que pida 15 números y escribir la suma total.
		 */
		totalNumeros();

	}
	public static void totalNumeros() {
		int  total=0,numero;
		for (int i = 0;i!=15;i+=1) {
			System.out.println("Escribe un numero");
			numero= Integer.parseInt(teclado.nextLine());
			total += numero;
		}
		System.out.println(total);
	}

}
