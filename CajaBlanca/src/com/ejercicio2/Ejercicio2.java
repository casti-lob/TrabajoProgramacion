package com.ejercicio2;

import java.lang.reflect.Array;

public class Ejercicio2 {
	
	public static void main(String[] args) {
		
		int[] numeros= new int[]{0,5,7,8,1,4};
	}
	
	public static String ordenar (int[] numeros) {
		StringBuilder lista= new StringBuilder();
		for(int i=0;i<numeros.length;i++) {
			int minimo=i;
			for(int j= i+1;j<numeros.length;j++) {
				if(numeros[j]<numeros[minimo]) {
					minimo=j;
				}
			}
			lista.append(numeros);
			intercambiar(numeros,i,minimo);
		}
		
	}

}
