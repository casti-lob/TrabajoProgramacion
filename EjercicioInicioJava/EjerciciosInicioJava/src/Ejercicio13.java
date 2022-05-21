
public class Ejercicio13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Calcula y escribe los números múltiplos de 5 de 0 a 100 utilizando un bucle for.
		 */
		
		multiplos5();
	}
	
	public static void multiplos5 () {
	
		for (int i =0; i!=101; i+=1) {
			
			if(i % 5==0)
			System.out.println(i);
		}
	}

}
