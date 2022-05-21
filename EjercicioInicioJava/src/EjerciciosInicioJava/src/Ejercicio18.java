package EjerciciosInicioJava.src;


public class Ejercicio18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Escribe los n�meros del 320 al 160, contando de 20 en 20 utilizando un bucle do-while.
		 */
		System.out.println(del_320_160());

	}
	public static String del_320_160() {
		int contador=320;
		String resul="";
		do {
			resul +=Integer.toString(contador)+"\n";
			contador-=20;
		} while (contador>=160);
		return resul;
	}
}
