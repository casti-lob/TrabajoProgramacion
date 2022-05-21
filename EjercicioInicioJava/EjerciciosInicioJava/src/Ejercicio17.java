
public class Ejercicio17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Muestra los números del 320 al 160, contando de 20 en 20 hacia atrás utilizando un bucle while.
		 */
		del_320_160();
	}
	public static void del_320_160() {
		int contador=320;
		while(contador>=160) {
			System.out.println(contador);
			contador-=20;
		}
	}

}
