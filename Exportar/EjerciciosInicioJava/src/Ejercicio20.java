import java.util.Scanner;

public class Ejercicio20 {
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Método que pida 5 números e indica si alguno es múltiplo de 3.
		 */
		multiplo3();
		
	}
	public static void multiplo3() {
		int numero;
		String multiplos ="Numeros multiplos de 3: ";
		for(int i = 0; i<5;i+=1) {
			System.out.println("Introduce un numero para saber si es multiplo de 3");
			numero = Integer.parseInt(teclado.nextLine());
			if (numero%3==0) {
				multiplos+= Integer.toString(numero);
				multiplos+=", ";
				
			}
		System.out.println(multiplos);
		}
	}

}
