import java.util.Scanner;

public class ComprimirDescomprimirClave {
	public static Scanner teclado=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String clave;
		System.out.println("Introduzca la clave");
		clave= teclado.nextLine();
		while(validezClave(clave)==false) {
			System.out.println("Clave no permitida, solo se aceptan letras");
			System.out.println("Introduzca la clave");
			clave= teclado.nextLine();
		}
		while(validezRepeticion(clave)==false) {
			System.out.println("No se admiten claves con repeticiones de letras superiores a 9");
			System.out.println("Introduzca la clave");
			clave= teclado.nextLine();
		}
		System.out.println(codificacion(clave));
		
		
	}
	
	public static boolean validezClave(String clave) {
		boolean valido =true;
		clave = clave.toUpperCase();
		for(int i=0;i<=clave.length()-1;i+=1) {
			if (clave.charAt(i)<65||clave.charAt(i)>90) {
				valido = false;
				
			}
		}
		return valido;
	}
	
	public static boolean validezRepeticion(String clave) {
		boolean valido =true;
		clave=clave.toUpperCase();
		int contador=0;
		char letraRepetida= clave.charAt(0);
		for(int i =0; i<=clave.length()-1;i+=1) {
			if(clave.charAt(i)== letraRepetida) {
				contador+=1;
				
			}else {
				letraRepetida=clave.charAt(i);
				i -=1;
				contador=0;
			}
			if(contador >9) {
				valido= false;
			}
		}
		return valido;
	}
	public static String codificacion(String clave) {
		String codificacion="";
		clave=clave.toUpperCase();
		int contador=-1;
		char letraRepetida= clave.charAt(0);
		for(int i = 0; i <= clave.length()-1;i+=1) {
			contador+=1;
			if(clave.charAt(i)!=letraRepetida) {
				codificacion+=letraRepetida;
				codificacion+=contador;
				letraRepetida = clave.charAt(i);
				contador=0;
			}
		
		
		}
		if(letraRepetida == clave.charAt(clave.length()-1)) {
			codificacion+=letraRepetida;
			codificacion+=contador;
		}
		return codificacion;
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

