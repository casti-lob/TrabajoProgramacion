package EjerciciosInicioJava.src;


public class Ejercicio10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Escribe los n�meros del 100 al 1 utilizando la instrucci�n for
		 */
		
		System.out.println(numerosInversos());

	}
	
	public static String numerosInversos() {
		String resul="";
		for (int i=100; i!=0; i-=1) {
			resul += i +"\n";
		}
		return resul;
	}

}
