package com.academialetras;

import java.util.HashMap;

public class ejemplo {

	public static void main(String[] args) {
		HashMap<Character, Academico> lista = new HashMap<>();
		lista.put('A', new Academico("yo", 2013, "el amo"));
		lista.put('L', new Academico("ee", 2013, "el amo"));
		lista.put('Z', new Academico("jj", 2013, "el amo"));
		System.out.println(lista);
	}

}
