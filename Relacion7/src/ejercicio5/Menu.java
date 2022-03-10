package ejercicio5;

import java.util.Scanner;

public class Menu {
	
	public static Scanner teclado = new Scanner(System.in);
	public static final int PARTIDOSMAX=100;
	public static final int EQUIPOSMAX=20;
	static Equipo[] listaEquipos = new Equipo[EQUIPOSMAX];
	static Partido[]listaPartidos = new Partido[PARTIDOSMAX];
	static int numeroEquipos=0;
	static int numeroPartidos=0;
	
	public static void main(String[] args) throws PartidoException {
		// TODO Auto-generated method stub
		int opc;
		
		do {
			menu();
			System.out.println("Introduce una opcion");
			opc = Integer.parseInt(teclado.nextLine());
			
			switch (opc) {
			case 1: {
				System.out.println( introducirEquipo()); 
				
				break;
			}case 2: {
				System.out.println(cambiarCiudad()); 
				
				break;
			}case 3: {
				System.out.println(cambiarEstadio());
				
				break;
			}case 4:{
				String nombre="";
				System.out.println("Introduce el nombre del equipo");
				nombre= teclado.nextLine();
				if(mostrarEquipo(nombre)==-1) {
					System.out.println("Equipo no encontrado");
				}else {
					
					System.out.println(listaEquipos[mostrarEquipo(nombre)]);
				}
				break;
			}
			case 5:{
					if(darAltaPartido()==true) {
						System.out.println("Equpo introducido");
					}
					break;
			
			}case 6:{
					ponerResultadoEquipo();
					break;
			}case 7:{
					String nombreLocal,nombreVisitante;
					System.out.println("Introduce el nombre del equipo local");
					nombreLocal=teclado.nextLine();
					System.out.println("Introduce el nombre del equipo visitante");
					nombreVisitante=teclado.nextLine();
					System.out.println(listaPartidos[mostrarPartido(nombreLocal, nombreVisitante)]);
					break;
			}case 8:{
					mostrarTodosPartidos();
					break;
			}case 9: {
				mostrarTodosEquipos();
				
				break;
			}
			default:
				System.out.println("Valor no aceptado");
			}
			
		} while (opc!=10);
		
	}
	
	public static void menu() {
		System.out.println("1.- Dar de alta un equipo.\n"+

							"2.- Modificar la ciudad del equipo.\n"+

							"3.- Modificar el estado de un equipo (Al igual que el anterior.\n"+

							"4.- Imprimir el equipo \n"+

							"5.- Dar de alta un partido.\n"+

							"6.- Poner el resultado de un partido.\n"+

							"7.- Mostrar un partido. \n"+

							"8.- Mostrar todos los partidos.\n"+

							"9.- Mostrar todos los equipos.\n"+
							"10.- Salir\n"
							);
	}
	
	
	
	
	public static boolean comprobacionEquipo(String nombre) {
		boolean encontrado=false;
		for(int i =0; i<numeroEquipos && encontrado==false ;i++) {
			if(nombre.toUpperCase().equals(listaEquipos[i].getNombre())) {
				encontrado = true;
			}
		}
		return encontrado;
	}
	public static String introducirEquipo () {
		String respuesta, ciudad = "", nombre = "", estadio = "";
		System.out.println("Introduce el nombre del equipo");
		nombre= teclado.nextLine();
		System.out.println("Introduce el nombre de la ciudad");
		ciudad= teclado.nextLine();
		System.out.println("Introduce el nombre del estadio");
		estadio= teclado.nextLine();
		
		if(comprobacionEquipo(nombre)==false&& numeroEquipos<EQUIPOSMAX) {
			listaEquipos[numeroEquipos]= new Equipo(nombre, estadio, ciudad);
			respuesta="Equipo introducido";
			numeroEquipos+=1;
		}else {
			respuesta ="Equipo repetido o no se puede introducir mas equpos";
		}
		return respuesta;
		
	}
	
	public static String cambiarCiudad(){
		String nombre="",ciudad="",respuesta="";
		boolean encontrado=false;
		
		System.out.println("Introduce el nombre del equipo");
		nombre= teclado.nextLine();
		for (int i =0; i<numeroEquipos && encontrado==false;i++) {
			if(nombre.toUpperCase().equals(listaEquipos[i].getNombre())) {
				encontrado = true;
				System.out.println("Introduce la nueva ciudad");
				ciudad = teclado.nextLine();
				listaEquipos[i].setCiudad(ciudad);
				respuesta = "Equipo encontrado y actualizado";
			}else {
				respuesta="Equipo no encontrado";
			}
		}
		return respuesta;
	}
	
	public static String cambiarEstadio() {
		String nombre="",estadio="",respuesta="";
		boolean encontrado=false;
		
		System.out.println("Introduce el nombre del equipo");
		nombre= teclado.nextLine();
		for (int i =0; i<numeroEquipos && encontrado==false;i++) {
			if(nombre.toUpperCase().equals(listaEquipos[i].getNombre())) {
				encontrado = true;
				System.out.println("Introduce la nueva ciudad");
				estadio = teclado.nextLine();
				listaEquipos[i].setCiudad(estadio);
				respuesta = "Equipo encontrado y actualizado";
			}else {
				respuesta="Equipo no encontrado";
			}
		}
		return respuesta;
	}
	public static int mostrarEquipo(String nombre) {
		boolean encontrado =false;
		
		int posicionEquipo = 0;
		
		
		for(int i =0;i<numeroEquipos&& encontrado==false;i++) {
			if(nombre.toUpperCase().equals(listaEquipos[i].getNombre())) {
				encontrado=true;
				posicionEquipo=i;
			}else {
				posicionEquipo=-1;
			}
		}
		return posicionEquipo;
	}
	public static void mostrarTodosEquipos() {
		for(int i=0; i<numeroEquipos;i++) {
			System.out.println(listaEquipos[i]);
		}
	}
	
	public static boolean darAltaPartido() throws PartidoException {
		boolean alta= false;
		String nombreLocal="", nombreVisitante="";
		System.out.println("Introduce el nombre del equipo local");
		nombreLocal=teclado.nextLine();
		System.out.println("Introduce el nombre del equipo visitante");
		nombreVisitante=teclado.nextLine();
		if(numeroPartidos== PARTIDOSMAX) {
			throw new PartidoException("No se puede incluir mas partidos");
			
		}else if(nombreLocal.equals(nombreVisitante)) {
			throw new PartidoException("No se pueden enfrentar el mismo equipo");
		}else if(comprobacionEquipo(nombreVisitante)==false || comprobacionEquipo(nombreLocal)==false) {
			throw new PartidoException("El equipo no esta dentro de la lista equipos");
		}else {
			listaPartidos[numeroPartidos] = new Partido(listaEquipos[mostrarEquipo(nombreLocal)], listaEquipos[mostrarEquipo(nombreVisitante)], 1);
			numeroPartidos+=1;
			alta= true;
		}
		return alta;
	}
	public static void mostrarTodosPartidos() {
		for(int i=0; i<numeroPartidos;i++) {
			System.out.println(listaPartidos[i]);
		}
	}
	
	public static void ponerResultadoEquipo() throws PartidoException {
		String nombreLocal="", nombreVisitante="", resultado="";
		
		System.out.println("Introduce el nombre del equipo local");
		nombreLocal=teclado.nextLine();
		System.out.println("Introduce el nombre del equipo visitante");
		nombreVisitante=teclado.nextLine();
		
		if(mostrarPartido(nombreLocal, nombreVisitante)==-1) {
			throw new PartidoException("Partido no encontrado");
		}else if(listaPartidos[mostrarPartido(nombreLocal, nombreVisitante)].getResultadoQuiniela()!=' '){
			throw new PartidoException("Partido ya resuleto");
	}else {
			System.out.println("Pon el resultado (0-0)");
			resultado= teclado.nextLine();
			listaPartidos[mostrarPartido(nombreLocal, nombreVisitante)].ponerResultado(resultado);
		}
	}
	
	public static int mostrarPartido(String nombreLocal, String nombreVisitante) {
		boolean encontrado =false;
		int posicionPartidos = 0;
		
		for(int i =0;i<numeroPartidos&& encontrado==false;i++) {
			if(nombreLocal.toUpperCase().equals(listaPartidos[i].getEquipoLocal().getNombre()) && nombreVisitante.toUpperCase().equals(listaPartidos[i].getEquipoVisitante().getNombre())) {
				encontrado=true;
				posicionPartidos=i;
			}else {
				posicionPartidos=-1;
			}
		}
		return posicionPartidos;
	}
}