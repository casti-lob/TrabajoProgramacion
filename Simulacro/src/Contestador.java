import java.util.Scanner;

public class Contestador {
	public static Scanner teclado =new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opc, numeroMensajes=0;
		String mensaje1 = "null", mensaje2="null";
		
		do {
			
			
			menu();
			System.out.println("Escribe una opcion");
			opc = Integer.parseInt(teclado.nextLine());
			while(opc<1 ||opc>5) {
				System.out.println("Opcion no contemplada");
				System.out.println("Escribe una opcion");
				menu();
				opc = Integer.parseInt(teclado.nextLine());
			}
			
			if (opc==1) {
				System.out.println("El numero actual de mensajes es "+numeroMensajes);
				
			}else if(opc==2) {
				System.out.println("	1. Mensaje n�mero 1");
				System.out.println("	2. Mensaje n�mero 2");
				System.out.println("Escribe la opcion");
				opc = Integer.parseInt(teclado.nextLine());
				if(opc==1) {
					System.out.println("		1. O�r");
					System.out.println("		2. Borrar");
					System.out.println("Escribe la opcion");
					opc = Integer.parseInt(teclado.nextLine());
					if(opc==1) {
						if (mensaje1.equals("null")==false) {
							System.out.println("Mensaje:"+ mensaje1);
						}else {
							System.out.println("Error");
						}
						
					}else {
						mensaje1= "null";
						numeroMensajes-=1;
					}
				}else {
					System.out.println("		1. O�r");
					System.out.println("		2. Borrar");
					System.out.println("Escribe la opcion");
					opc = Integer.parseInt(teclado.nextLine());
					if(opc==1) {
						if (mensaje1.equals("null")==false) {
							System.out.println("Mensaje:"+ mensaje2);
						}else {
							System.out.println("Error");
						}
					}else {
						mensaje2= "null";
						numeroMensajes-=1;
					}
				}
				
				
			}else if(opc==3) {
				if (numeroMensajes<2) {
					if(numeroMensajes==0) {
						mensaje1=annadirMensaje();
						
					}else {
						mensaje2=annadirMensaje();
					}
					numeroMensajes+=1;
			
				}else {
					System.out.println("Buzon completo");
				}
			}else {
				mensaje1="null";
				mensaje2="null";
				numeroMensajes =0;
			}
			
			
		} while (opc !=5);
	
		
	}
	
	public static void menu() {
		System.out.println("1. Consultar n�mero de mensajes");
		System.out.println("2. Consultar mensaje");
		System.out.println("3.- A�adir mensaje");
		System.out.println("4. Borrar todos los mensajes");
		System.out.println("5. Salir");
	}
	
	public static String annadirMensaje() {
		String mensaje;
		System.out.println("Introduce un mensaje");
		mensaje = teclado.nextLine();
		return mensaje;
	}
}
