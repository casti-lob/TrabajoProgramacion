
public class Ejercicio18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Escribe los números del 320 al 160, contando de 20 en 20 utilizando un bucle do-while.
		 */
		del_320_160();

	}
	public static void del_320_160() {
		int contador=320;
		do {
			System.out.println(contador);
			contador-=20;
		} while (contador>=160);
	}
}
