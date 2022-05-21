package EjerciciosInicioJava.src;


public class Ejercicio14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Muestra los n�meros m�ltiplos de 5 de 0 a 100 utilizando un bucle while.
		 */
		
		System.out.println(multiplo5());
		int num = 0;
		String resultado;
		//condicion ? valor si es cierto:valor si es falso
		resultado =(num%2==0? "par":"impar");
	}
	
	public static String multiplo5() {
		int contador = 0;
		String resul="";
		while(contador !=101) {
			
			if (contador%5==0) {
				resul+= Integer.toString(contador)+"\n";
			}
			
			contador+=1;
		}
		return resul;
	}

}
