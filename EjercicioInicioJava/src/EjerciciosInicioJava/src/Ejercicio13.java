package EjerciciosInicioJava.src;


public class Ejercicio13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Calcula y escribe los n�meros m�ltiplos de 5 de 0 a 100 utilizando un bucle for.
		 */
		
		System.out.println(multiplos5());
	}
	
	public static String multiplos5 () {
		String resul ="";
		for (int i =0; i!=101; i+=1) {
			
			if(i % 5==0)
			resul += Integer.toString(i)+"\n";
		}
		return resul;
	}

}
