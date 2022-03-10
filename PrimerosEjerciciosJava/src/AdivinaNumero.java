import java.util.Scanner;

public class AdivinaNumero {
	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numeroAleatorio=0,numeroUsuario;
		
		numeroAleatorio= (int) (Math.random()*100);
		
		System.out.println(numeroAleatorio);
		System.out.println("Adivina el número aleatorio");
		System.out.println("Introduce el número");
		numeroUsuario= Integer.parseInt(teclado.nextLine());
		while(numeroUsuario != numeroAleatorio) {
			System.out.println("Introduce el número");
			numeroUsuario= Integer.parseInt(teclado.nextLine());
		}
		System.out.println("Enorabuena lo has adivinado");
		

	}

}
