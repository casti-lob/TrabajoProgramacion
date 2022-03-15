package com.libreria;

public class Puebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Libro l1=new Libro(" s s sss ", "joselillo");
		Libro l2=new Libro("s s", "yo");
		Libro l3=new Libro("ss", "yo");
		
		System.out.println(l3.getCodigoLibro());
		System.out.println(l1.getCodigoLibro());
		System.out.println(l2.getCodigoLibro());
		
		System.out.println(l1.getIsbn());
		System.out.println(l2.getIsbn());

	}

}
