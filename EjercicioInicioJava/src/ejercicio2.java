import java.util.Scanner;

public class ejercicio2 {

	public static Scanner teclado=new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 
		 Escribe un m�todo que reciba por par�metro el d�a de la semana (Lunes, Martes, Mi�rcoles, etc) 
		 y devuelva qu� asignatura toca a primera hora ese d�a.
		 */
		
		char dia,opcion='N';
		String asignatura;
		
		do {
			
			System.out.println("Introduce el dia(L/M/X/J/V/S/D)");
			dia = teclado.nextLine().charAt(0);
			
			switch (dia) { 
				case 'L':
				case 'l':{
					
					asignatura = "BBDD";
					break;
				}case 'M': {
					
					asignatura = "Programacion";
					break;
				}case 'X': {
					
					asignatura = "Entorno";
					break;
				}case 'J': {
					
					asignatura = "Sistema";
					break;
				}case 'V': {
					
					asignatura = "FOL";
					break;
				}case 'S': {
					
					asignatura = "Tienes el dia libre";
					break;
				}case 'D': {
					
					asignatura = "Tienes el dia libre";
					break;
				}
				default:
					asignatura="Opcion no contemplada";
			}
			System.out.println(asignatura);
			
			System.out.println("Quieres consultam mas dias?");
			opcion = teclado.nextLine().charAt(0);
		} while (opcion == 'S');
		System.out.println("Programa finalizado");
		
	}

}
