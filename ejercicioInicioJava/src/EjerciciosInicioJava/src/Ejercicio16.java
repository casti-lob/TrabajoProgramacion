package EjerciciosInicioJava.src;


public class Ejercicio16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Escribe los n�meros del 320 al 160, contando de 20 en 20 hacia atr�s utilizando un bucle for.
		 */
		System.out.println(del_320_160());

	}
	public static String del_320_160() {
		String resul="";
		for(int i =320;i>=160;i-=20) {
			resul+=Integer.toString(i)+"\n";
		}
		return resul;
	}
}
