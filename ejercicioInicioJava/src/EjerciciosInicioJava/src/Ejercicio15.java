package EjerciciosInicioJava.src;


public class Ejercicio15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Realiza un programa que muestre los n�meros m�ltiplos de 5 de 0 a 100 utilizando un bucle do-while.
		 */
		
		System.out.println(multiplos5());

	}
	
	public static String multiplos5() {
		int contador=0;
		String resul="";
		do {
			if (contador%5==0) {
				resul+= Integer.toString(contador)+"\n";
				
			}
			contador+=1;
		} while (contador !=101);
		return resul;
	}
}
