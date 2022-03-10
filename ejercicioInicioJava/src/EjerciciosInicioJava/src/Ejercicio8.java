package EjerciciosInicioJava.src;


public class Ejercicio8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Muestra los n�meros del 1 al 100 utilizando la instrucci�n while (mientras)
		
		System.out.println(numeros());

	}
	
	public static String numeros() {
		int numero= 0;
		String resul="";
		while(numero != 100){
			numero +=1;
			resul += Integer.toString(numero)+"\n";
		}
		return resul;
	}

}
