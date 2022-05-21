package ejercicio2;

import java.util.Scanner;

public class Menu {
	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) throws ProductoException {
		// TODO Auto-generated method stub
		Producto[]arrayProducto=new Producto[1000];
		int numeroProductoscreados=0;
		for(int i =0;i<5;i++) {
			String descripcion;
			double precio;
			System.out.println("Introduce la descripcion del producto");
			descripcion= teclado.nextLine();
			System.out.println("Introduce el precio");
			precio = Integer.parseInt(teclado.nextLine());
			arrayProducto[i]= new Producto(descripcion, precio);
			numeroProductoscreados+=1;
		}
		System.out.println(arrayProducto[4]);
	}

}
