package com.jacaranda.notas;

import com.jacaranda.bloc.Bloc;
import com.jacaranda.bloc.BlocException;

public class Pruebas {

	public static void main(String[] args) throws NotaAlarmaException, BlocException {
		// TODO Auto-generated method stub
		Bloc n = new Bloc("ddd!");
		System.out.println(n);
		n.addNota("uno");
		n.addNota("dos");
		n.addNota("tres");
		System.out.println(n.ordenaBloc());
		
	}

}
