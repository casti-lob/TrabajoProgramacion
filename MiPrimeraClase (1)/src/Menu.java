import java.util.Scanner;

public class Menu {
	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Avion a1;
		menuPrincipal();
		int opc;
		char letra;
		System.out.println("Introduce una opcion");
		opc = Integer.parseInt(teclado.nextLine());
		if(opc==1) {
			String idAvion;
			int capacidad;
			System.out.println("Introduce el id del avion");
			idAvion = teclado.nextLine();
			System.out.println("Introduce la capacidad del avion");
			capacidad= Integer.parseInt(teclado.nextLine());
			a1 = new Avion(idAvion, capacidad);
		}else {
			String idAvion = null,compannia = null;
			int capacidad = 0;
			System.out.println("Introduce el id del avion");
			idAvion = teclado.nextLine();
			System.out.println("Introduce la compañia del avion");
			compannia= teclado.nextLine();
			System.out.println("Introduce la capacidad del avion");
			capacidad= Integer.parseInt(teclado.nextLine());
			a1= new Avion(idAvion, compannia, capacidad);
		}
		
		do {
			subMenu();
			System.out.println("Selecciona la opcion");
			letra= teclado.nextLine().charAt(0);
			
			switch (letra) {
			case 'a':
			case 'A':{
				int asientoOcupados;
				double kmViaje;
				System.out.println("Numeros de asientos ocupados");
				asientoOcupados= Integer.parseInt(teclado.nextLine());
				System.out.println("Distancia del viaje");
				kmViaje= Double.parseDouble(teclado.nextLine());
				System.out.println(a1.asignarVuelo(asientoOcupados, kmViaje));
				break;
			}
			case'b':
			case'B':{
				System.out.println(a1.getNumVuelos());
				break;
			}
			case'c':
			case'C':{
				System.out.println(a1.getTotalKm());
				break;
			}
			case'd':
			case'D':{
				System.out.println(a1.getMediaKm());
			}
			case'e':
			case'E':{
				String compannia;
				System.out.println("Introduce la nueva compañia");
				compannia=teclado.nextLine();
				a1.setCompannia(compannia);
				break;
				
			}
			case'f':
			case'F':{
				System.out.println(a1.toString());
				break;
			}
			default:
				System.out.println("Parametro no contemplado");
			}
		} while (letra!='g' && letra!='G');
		System.out.println("Cerrando programa");
	}
	
	public static void menuPrincipal() {
		System.out.println("1. Crear avion con identificador y capacidad");
		System.out.println("2. Crear avion con identificador, compaÃ±ia y capacidad");
	}
	
	public static void subMenu() {
		System.out.println("a. Asignar vuelo");
		System.out.println("b. Obtener el numero de vuelos");
		System.out.println("c. Obtener el numero de kilometros");
		System.out.println("d. Obtener la media de kilómetros por vuelo");
		System.out.println("e. Cambio de compañía");
		System.out.println("f. Mostrar información del avión");
		System.out.println("g. Salir");
	}
}
