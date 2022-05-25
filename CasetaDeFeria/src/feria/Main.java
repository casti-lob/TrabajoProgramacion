package feria;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		SubCasetas feria = new SubCasetas();
		int opc;

		do {
			menu();
			opc = Integer.parseInt(teclado.nextLine());

			switch (opc) {
			case 1:
				System.out.println("Introduce la calle: ");
				String calle = teclado.nextLine();

				System.out.println(feria.mostrarCasetasPorCalle(calle));

				break;
			case 2:
				Set<Caseta> familia = feria.mostrarCasetasFamiliar();
				System.out.println(mostrarLista(familia));
				break;
			case 3:
				Set<Caseta> distrito = feria.mostrarCasetasDistrito();
				System.out.println(mostrarLista(distrito));
				break;
			case 4:
				Set<Caseta> otrasCasetas = feria.mostrarCasetasOtras();
				System.out.println(mostrarLista(otrasCasetas));
				break;
			case 5:
				Map<String, Integer> callesFamilia = feria.mostrarCallesFamiliar();
				System.out.println(mostrarRecinto(callesFamilia));
				break;
			case 6:
				Map<String, Integer> callesDistrito = feria.mostrarCallesDistrito();
				System.out.println(mostrarRecinto(callesDistrito));
				break;
			case 7:
				System.out.println("Introduce el título de la caseta: ");
				String titulo = teclado.nextLine();
				boolean resultado = feria.eliminarCaseta(titulo);
				if (resultado) {
					System.out.println("Caseta eliminada.");
				} else {
					System.out.println("No se ha encontrado la caseta.");
				}
				break;
			case 8:
				System.out.println("Cerrando programa");
				break;
			default:
				System.out.println("Opcion no contemplada");
				
			}
		} while (opc != 8);

	}

	public static void menu() {
		System.out.println("1. Mostrar todas las casetas existentes en una calle\n2. Mostrar todas las casetas de tipo familiar\n" + "3. Mostrar todas las casetas de tipo Distrito\n4. Mostrar todas las casetas que no sean ni familiares ni distritos\n 5. Mostrar para cada una de las calles del recinto ferial el número de casetas de tipo familiar que existen\n 6. Mostrar para cada una de las calles del recinto ferial el número de casetas de tipo Distrito que existen\n 7. Eliminar una caseta\n8. Salir.");
	}

	public static String mostrarLista(Set<Caseta> caseta) {
		StringBuilder lista = new StringBuilder();

		Iterator<Caseta> siguiente = caseta.iterator();
		Caseta i;

		while (siguiente.hasNext()) {
			i = siguiente.next();
			lista.append(i + "\n");
		}
		return lista.toString();
	}

	public static String mostrarRecinto(Map<String, Integer> recinto) {
		StringBuilder result = new StringBuilder();
		for (String calle : recinto.keySet()) {
			int valor = recinto.get(calle);
			result.append("Calle: " + calle + ", número de casetas: " + valor + "\n");

		}
		return result.toString();
	}
}
