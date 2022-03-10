package EjerciciosInicioJava.src;


public class Ejercicio11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Muestra los n�meros del 100 al 1 utilizando la instrucci�n while
		 */
		
		System.out.println(numerosInvertidos());

	}
	
	public static String numerosInvertidos() {
		int contador=100;
		String resul="";
		while(contador >0) {
			
			resul += Integer.toString(contador)+"\n";
			contador-=1;
			
		}
		return resul;
	}

}
