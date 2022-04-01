package com.ejercicio1;

public class Ejercicio1 {
	
	public static void main(String[] args) {
		System.out.println(numeroMaximo(1,3, 2));

	}
	public static int numeroMaximo(int a, int b, int c) {
		int numero;
		if(a>b) {
			if(a>c) {
				numero=a;
			}else {
				numero=c;
			}
		}else {
			if(b>c) {
				numero=b;
			}else {
				numero=c;
			}
		}
			
		return numero;
	}
	

}
