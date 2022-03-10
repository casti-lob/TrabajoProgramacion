import java.util.Scanner;

public class HolaMundo {
	
	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hola Mundo");
		
		//Declaracion de variables
		int a,b,resultado;
		a=3;
		b=4;
		resultado = a+b;
		System.out.println(resultado);
		
		//ejemplo uso ++
		int r,resul;
		r=3;
		
		resul = r ++;
		System.out.println(resul+" El valor de a "+r);
		
		// leer forma no recomendado
		/*int p,t, respuesto;
		char opc;
		System.out.println("Quieres sumar(S/N)");
		opc=teclado.nextLine().charAt(0);//el 0 es la posicion del caracter
		System.out.println("Introduce un numero");
		p = teclado.nextInt();
		System.out.println("Introduce un numero");
		t= teclado.nextInt();
		respuesto = p+t;
		System.out.println(respuesto);
		System.out.println("LA OPCION HA SIDO "+opc);
		*/
		//leer forma recomendado
		int p,t;
		char opc;
		double respuesto, real;
		
		System.out.println("Quieres sumar(S/N)");
		opc=teclado.nextLine().charAt(0);//el 0 es la posicion del caracter
		System.out.println("Introduce un numero");
		p = Integer.parseInt(teclado.nextLine());
		System.out.println("Introduce un numero");
		t= Integer.parseInt(teclado.nextLine());
		System.out.println("Introduce un real");
		real = Double.parseDouble(teclado.nextLine());
		respuesto = real+p+t;
		
		System.out.println(respuesto);
		System.out.println("LA OPCION HA SIDO "+opc);
		
		//Hacer un casting
		int num1,num2;
		double j;
		
		System.out.println("INTRODUCE");
		num1= Integer.parseInt(teclado.nextLine());
		System.out.println("Introduce");
		num2 = Integer.parseInt(teclado.nextLine());
		j =(double)num1/num2;
		System.out.println(j);
		
	}

}
