
public class Ejercicio9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//M�todo que muestre los n�meros del 1 al 100 utilizando la instrucci�n do.while (repetir .. hasta)
		
		numeros();
	}
	
	public static void numeros() {
		int numero = 0;
		do {
			numero +=1;
			System.out.println(numero);
		} while (numero!=100);
	}

}
