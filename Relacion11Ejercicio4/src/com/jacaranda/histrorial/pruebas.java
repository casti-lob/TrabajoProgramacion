package com.jacaranda.histrorial;

import java.time.LocalDateTime;

public class pruebas {

	public static void main(String[] args) {
		try {
			PaginaWeb a= new PaginaWeb("sdd",null);
			System.out.println(a);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
