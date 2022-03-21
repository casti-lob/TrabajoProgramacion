package com.clases;

import java.util.Arrays;

public class main {
	public static void main(String[] args) {
		String[] origen= {"Luis","Pepe","Lola"};
		String[] destino= new String[7];
		Integer[] array1Int= {10,20,30};
		Integer[] array2Int= new Integer[7];
		
		Ejemplo.volcarArray(origen, destino);
		Ejemplo.volcarArray(array1Int, array2Int);
		
		System.out.println("Array string origen " +Arrays.toString(origen));
		System.out.println("Array string origen " +Arrays.toString(destino));
		System.out.println("Array string origen " +Arrays.toString(array1Int));
		System.out.println("Array string origen "+Arrays.toString(array2Int));
		System.out.println("Array string origen "+Arrays.toString());
	}

}
