package com.clases;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Ejemplo {
	public static <T> void volcarArray (T[] origen, T[] destino) {
		int tamano = Math.min(origen.length, destino.length);
		for(int i=0; i<tamano;i++) {
			destino[i]=origen[i];
		}
	}
	
	public static <P> toString (P[] array) {
		StringBuilder lista= new StringBuilder();
		for (int i=0; i<array.length; i++) {
			if(array[i]!=null) {
				lista.append(array[i]);
			}
		}
		System.out.println(lista.toString()+"\n");
	}
	
}
