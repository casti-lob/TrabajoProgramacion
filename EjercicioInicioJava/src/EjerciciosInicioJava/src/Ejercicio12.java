package EjerciciosInicioJava.src;


public class Ejercicio12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * M�todo que muestre los n�meros del 100 al 1 utilizando la instrucci�n do..while
		 */
		
		System.out.println(numerosInversos());

	}
	
	public static String numerosInversos() {
		int contador =100;
		String resul="";
		do {
			resul+=Integer.toString(contador)+"\n";
			contador-=1;
		} while (contador !=0);
		return resul;
	}

}
