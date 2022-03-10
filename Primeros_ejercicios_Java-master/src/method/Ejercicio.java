package method;


public class Ejercicio {
	
	public static final Double PI = 3.14;
	

	public static void main(String[] args) {
				
		// Variables
		
		// Inicio
		
		System.out.println(solucionSumaEcuacionSegundoGrado(2, -7, 3));
				
	}
	
	public static int numeroSolucionesEcuacionSegundoGrado(int a, int b, int c) {
		int resultado =0,f= b*b-4*a*c;
		if (a==0) {
			resultado=-1;
		}else if(f == 0) {
			resultado =1;
		}else if(f>0) {
			resultado=2;
		}
		return resultado;
	}
	
	public static double solucionSumaEcuacionSegundoGrado(int a, int b, int c) {
		double solucion;
		if(numeroSolucionesEcuacionSegundoGrado(a, b, c)==2){
			solucion= (-b+(Math.pow(b,2)+(-4*a*c))/(2*a));
		}else{
			solucion =-1000;
		}
		return solucion;
	}
	
	/*
	
	public static Double solucionRestaEcuacionSegundoGrado(int a, int b, int c) {
		
	}	
	
	public static Double areaCirculo(Double r) {
		
	}
	
	public static Double longitudCirculo(Double r) {
		
	}
	
	public static boolean esMultiplo(int a, int b) {
		
	}
	
	public static int horaMayor(int hora1, int min1, int seg1, int hora2, int min2, int seg2) {
		
		
	}
	
	public static int segundosEntre(int hora1, int min1, int seg1, int hora2, int min2, int seg2) {
				
		
	}
	
	public static int maximoComunDivisor(int a, int b) {
		
	}
	
	public static int minimoComunMultiplo(int a, int b) {
		
	}
	
	public static String binario(int num) {
		
	}
	
	public static int decimal(String num) {
		
	}
	*/
}

