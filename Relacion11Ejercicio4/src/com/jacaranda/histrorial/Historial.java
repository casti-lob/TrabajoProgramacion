package com.jacaranda.histrorial;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class Historial {
	private List<PaginaWeb> paginas;

	public Historial(List<PaginaWeb> paginas) {
		super();
		this.paginas = new LinkedList<PaginaWeb>();
	}
	
	public boolean addPaginaWeb(String url, LocalDateTime fechaYhora) {
		boolean introducido = false;
		
		return introducido;
	}
	

}
