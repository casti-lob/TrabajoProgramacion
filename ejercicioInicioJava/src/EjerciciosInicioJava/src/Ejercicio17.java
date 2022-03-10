package EjerciciosInicioJava.src;


public class Ejercicio17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Muestra los n�meros del 320 al 160, contando de 20 en 20 hacia atr�s utilizando un bucle while.
		 */
		System.out.println(del_320_160());
	}
	public static String del_320_160() {
		int contador=320;
		String  resul="";
		while(contador>=160) {
			resul += Integer.toString(contador)+"\n";
			contador-=20;
		}
		return resul;
	}

}
