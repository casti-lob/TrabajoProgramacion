
public class Ejercicio14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Muestra los números múltiplos de 5 de 0 a 100 utilizando un bucle while.
		 */
		
		multiplo5();

	}
	
	public static void multiplo5() {
		int contador = 0;
		while(contador !=101) {
			
			if (contador%5==0) {
				System.out.println(contador);
			}
			
			contador+=1;
		}
	}

}
