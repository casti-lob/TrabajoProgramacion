package ejercicio1;

import java.util.Scanner;

public class Prueba {
	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		double coordenadaX,coordenadaY, distancia;
		int opcion = 0;
		char movimiento;
		
		System.out.println("Primer Punto");
		System.out.println("Coordenada x");
		coordenadaX= Double.parseDouble(teclado.nextLine());
		System.out.println("Coordenada Y");
		coordenadaY= Double.parseDouble(teclado.nextLine());
		Punto p1 = new Punto(coordenadaX, coordenadaY);
		
		System.out.println("Segundo Punto");
		System.out.println("Coordenada x");
		coordenadaX= Double.parseDouble(teclado.nextLine());
		System.out.println("Coordenada Y");
		coordenadaY= Double.parseDouble(teclado.nextLine());
		Punto p2 = new Punto(coordenadaX, coordenadaY);
		
		Linea linea = new Linea(p1, p2);
		if (linea.equals(linea)) {
			System.out.println("No es una linea ya que sus dos puntos son los mismos");
		}else {
		
		
			do {
				menu();
				
				try {
					System.out.println("Introduce la opcion");
					opcion= Integer.parseInt(teclado.nextLine());
					if(opcion ==1) {
						System.out.println("Movimiento que desea realizar A-arriba, B-ABajo, I-Izquierda, D-Derecha");
						movimiento= teclado.nextLine().charAt(0);
						switch (movimiento) {
						case 'A': {
							System.out.println("Introduce la distancia");
							distancia= Double.parseDouble(teclado.nextLine());
							linea.moverArriba(distancia);
							break;
							
						}case 'B': {
							System.out.println("Introduce la distancia");
							distancia= Double.parseDouble(teclado.nextLine());
							linea.moverAbajo(movimiento);
							break;
							
						}case 'I': {
							System.out.println("Introduce la distancia");
							distancia= Double.parseDouble(teclado.nextLine());
							linea.moverIzquierda(movimiento);
							break;
							
						}case 'D': {
							System.out.println("Introduce la distancia");
							distancia= Double.parseDouble(teclado.nextLine());
							linea.moverDerecha(movimiento);
							break;
							
						}
						default:
							System.out.println("Opcion no contemplada");
						}
					}else if(opcion==2){
						System.out.println(linea.mostrarLinea());
					}
					
				} catch (LineaException e) {
					// TODO: handle exception
					int codigo = Integer.parseInt(e.getMessage().substring(0,4));
					if(codigo==1) {
						System.out.println("No se aceptan valores menores de 1");
					}
				}
			} while (opcion!=3);
		}
	}
	
	public static void menu() {
		System.out.println("1. Mover línea");
		System.out.println("2. Mostrar línea");
		System.out.println("3. Salir");
		
	}


}

