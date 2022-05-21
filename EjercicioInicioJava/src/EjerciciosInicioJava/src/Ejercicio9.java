package EjerciciosInicioJava.src;


public class Ejercicio9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//M�todo que muestre los n�meros del 1 al 100 utilizando la instrucci�n do.while (repetir .. hasta)
		
		System.out.println(numeros());
	}
	
	public static String numeros() {
		int numero = 0;
		String resul="";
		do {
			numero +=1;
			resul+= Integer.toString(numero)+"\n";
		} while (numero!=100);
		return resul;
	}

}
