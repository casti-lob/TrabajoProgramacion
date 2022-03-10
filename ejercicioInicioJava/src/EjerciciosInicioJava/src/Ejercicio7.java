package EjerciciosInicioJava.src;


public class Ejercicio7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//M�todo que muestre los n�meros del 1 al 100 utilizando la instrucci�n for  (para)
		
		System.out.println(numeros());
		
	}
	public static String numeros() {
		String resultado="";
		for (int i = 0; i<=100; i+=1) {
			resultado += Integer.toString(i)+"\n";
		}
		return resultado;
		
		}
		
}
