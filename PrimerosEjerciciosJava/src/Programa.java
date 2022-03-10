

import java.util.Scanner;

public class Programa {
	private static Scanner teclado=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char operador,seguir;
		int num1,num2,resultado = 0;
		boolean error =false;
		
		
		do {
			System.out.println("Elija la operaci�n que desee (+,-,*,/)");
			operador = teclado.nextLine().charAt(0);
			
			System.out.println("Introduce el primer número");
			num1= Integer.parseInt(teclado.nextLine());
			System.out.println("Introduce el segundo número");
			num2= Integer.parseInt(teclado.nextLine());
			
			switch (operador) {
			case '+': {
				resultado = num1 + num2;
				break;
				
			}case '-':{
				resultado = num1-num2;
				break;
			}case'*':{
				resultado = num1*num2;
				break;
			}case'/':{
				resultado= num1/num2;
				break;
			}
			default:
				System.out.println("Operador no contemplado");
				error = true;
			}
			if(error!= true) {
				System.out.println(resultado);
			}else {
				System.out.println("Ups hay un error");
			}
			error = false;
			System.out.println("Quieres seguir calculando?(s/n)");
			seguir = teclado.nextLine().charAt(0);
			while(seguir != 's'&& seguir !='n') {
				System.out.println("Opcion no contemplada");
				System.out.println("Quieres seguir calculando?(s/n)");
				seguir = teclado.nextLine().charAt(0);
			}
		}while(seguir =='s');
		
		
	}
}
