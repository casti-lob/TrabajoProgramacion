package com.jacaranda.histrorial;

import java.time.LocalDateTime;

public class pruebas {

	public static void main(String[] args) {
		try {
			Historial h = new Historial();
			System.out.println(h.addPaginaWeb("ll", LocalDateTime.of(2018, 10, 10, 3, 6)));
			System.out.println(h.addPaginaWeb("ll", LocalDateTime.of(2018, 9, 10, 3, 8)));
			System.out.println(h.consultarHistorial());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
