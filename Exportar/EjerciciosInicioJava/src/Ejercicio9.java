
public class Ejercicio9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Método que muestre los números del 1 al 100 utilizando la instrucción do.while (repetir .. hasta)
		
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
