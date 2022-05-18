import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;



public class Menu {
	public static Set<Cita> agenda = new HashSet<>();
	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		leerAgenda("Fichero//Agenda.txt");
		System.out.println(agenda);
		anadirCita();
		anadirCita();
		escribirAgenda("Fichero//Agenda.txt");
		
		
	}
	
	public static void leerAgenda(String nombreFichero)  {
		String linea;
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			linea = filtroLectura.readLine();
			while (linea != null) {
				// System.out.println(linea);
				// proceso la linea que acabo de leer
				String[] campos = linea.split(",");
				
				Cita c = new Cita(campos[0],campos[1]);
				if(agenda.add(c)) {
					
				}
				

				// Leo otra linea
				linea = filtroLectura.readLine();
			}
			filtroLectura.close();
			flujoLectura.close();
		} catch (FileNotFoundException e) {
			System.out.println("No existe el fichero " + nombreFichero);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void anadirCita() {
		String nombre, lugar;
		System.out.println("Nombre de la cita");
		nombre= teclado.nextLine();
		System.out.println("Lugar de la cita");
		lugar=teclado.nextLine();
		
		Cita c = new Cita(nombre, lugar);
		agenda.add(c);
	}

	private static void escribirAgenda(String nombre) {
		String cadena;
		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);
			// proceso el fichero
				
			for(Cita i: agenda){
				filtroEscritura.println(i.escrituraCita());
			}

			// fin del proceso
			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
