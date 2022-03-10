package SaldosCuenta;

import java.util.Scanner;

public class Principal {
	public static Scanner teclado= new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CuentaCorriente  miCuenta = new CuentaCorriente(500);
		int opc;
		do {
			menu();
			System.out.println("Introduce una opcion");
			opc= Integer.parseInt(teclado.nextLine());
			
			while(opc<1 || opc>4) {
				System.out.println("error");
				menu();
				System.out.println("Introduce una opcion");
				opc= Integer.parseInt(teclado.nextLine());
			}
			switch (opc) {
			case 1: {
				double cantidad;
				System.out.println("Introduce la cantidad a reintegrar");
				cantidad = Double.parseDouble(teclado.nextLine());
				if (cantidad > miCuenta.getSaldo()) {
					System.out.println("No puedes sacar mas de lo que tienes");
				}else {
					miCuenta.reintegro(cantidad);
				}
				break;
			}
			case 2:{
				double cantidad;
				System.out.println("Introduce la cantidad a ingresar");
				cantidad = Double.parseDouble(teclado.nextLine());
				miCuenta.ingresar(cantidad);
				break;
			}
			case 3:{
				System.out.println(miCuenta.toString());
				break;
			}
			default:
				System.out.println("Error inesperado");
			}
			
		} while (opc !=4);
		System.out.println(miCuenta.toString());
	}
	
	public static void menu() {
		System.out.println("1. Reintegro");
		System.out.println("2. Ingreso");
		System.out.println("3. Consulta saldo");
		System.out.println("4. Salir");
	}
}
