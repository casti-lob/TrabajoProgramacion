
public class Ejercicio11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Muestra los n�meros del 100 al 1 utilizando la instrucci�n while
		 */
		
		numerosInvertidos();

	}
	
	public static void numerosInvertidos() {
		int contador=100;
		while(contador >0) {
			System.out.println(contador);
			contador-=1;
		}
	}

}
