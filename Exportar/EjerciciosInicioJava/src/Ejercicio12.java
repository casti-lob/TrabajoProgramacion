
public class Ejercicio12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Método que muestre los números del 100 al 1 utilizando la instrucción do..while
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
