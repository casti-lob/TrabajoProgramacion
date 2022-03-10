import java.util.Scanner;

public class Menu {
	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Avion a1;
		menuPrincipal();
		int opc;
		opc = Integer.parseInt(teclado.nextLine());
		if(opc==1) {
			String idAvion;
			int capacidad;
			idAvion = teclado.nextLine();
			capacidad= Integer.parseInt(teclado.nextLine());
			a1 = new Avion(idAvion, capacidad);
		}else {
			String idAvion = null,compannia = null;
			int capacidad = 0;
			a1= new Avion(idAvion, compannia, capacidad);
		}
	}
	
	public static void menuPrincipal() {
		System.out.println("1. Crear avion con identificador y capacidad");
		System.out.println("1. Crear avion con identificador, compañia y capacidad");
	}
}
