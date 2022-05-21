
public class Ejercicio15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Realiza un programa que muestre los números múltiplos de 5 de 0 a 100 utilizando un bucle do-while.
		 */
		
		multiplos5();

	}
	
	public static void multiplos5() {
		int contador=0;
		do {
			if (contador%5==0) {
				System.out.println(contador);
				
			}
			contador+=1;
		} while (contador !=101);
	}
}
