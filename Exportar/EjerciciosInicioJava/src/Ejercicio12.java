
public class Ejercicio12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * M�todo que muestre los n�meros del 100 al 1 utilizando la instrucci�n do..while
		 */
		
		numerosInversos();

	}
	
	public static void numerosInversos() {
		int contador =100;
		do {
			System.out.println(contador);
			contador-=1;
		} while (contador !=0);
	}

}
