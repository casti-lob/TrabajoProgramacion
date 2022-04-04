package com.ejercicio2;

import java.lang.reflect.Array;

public class Ejercicio2 {
	
	public static void main(String[] args) {
		
		int[] vacio= new int[]{};// El flujo del programa no entra ninguna vez
		int[] unaVez= new int[]{1}; //Pasa una �nica vez por el bucle
		int[] dosVeces= new int[]{2,1};// Pasa dos veces por el bucle Tiene que estar ordenado
		int[] normal= new int[]{2,1,8,7,3,11,5,9,4,80 ,-8,-1};//Pasa m veces por el bucle donde m <n tiene que estar ordenado y desordenado elementos
		
		System.out.println(ordenar(unaVez));
	}
	
	public static String ordenar (int[] numeros) {
		String lista="";
		int menor ,pos, tmp;
		for(int i=0;i<numeros.length-1;i++) { //aplicamos un hit count superior al tama�o del array Tiene que estar todo desordenado
			menor=numeros[i];
			pos=i;
			for(int j=i+1;j<numeros.length;j++) {
				if(numeros[j]<menor) {
					menor=numeros[j];
					pos=j;
				}
			}
			if(pos!=i) {
				tmp=numeros[i];
				numeros[i]=numeros[pos];
				numeros[pos]= tmp;
			}
		}
		
		for(int l=0;l<numeros.length;l++) {
			lista+=numeros[l]+" ";
		}
		return lista;
	}

}
