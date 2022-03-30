package com.jacaranda.histrorial;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class Historial {
	private String usuario;
	private List<PaginaWeb> paginas;

	public Historial(String usuario) {
		super();
		this.usuario= usuario;
		this.paginas = new LinkedList<PaginaWeb>();
	}
	
	public boolean addPaginaWeb(String url, LocalDateTime fechaYhora) throws PaginaWebException, HistorialException {
		boolean introducido = false;
		PaginaWeb p= new PaginaWeb(url, fechaYhora);
		if(paginas.size()==0) {
			paginas.add(p);
			introducido= true;
		}else {
			if(paginas.contains(p)) {
				throw new HistorialException("Pagina repetida");
			}else if(paginas.get(paginas.size()).getFechaYhora().isAfter(fechaYhora)) {
				throw new HistorialException("La fecha no puede ser anterior al ultimo registro del historial");
			}else {
				paginas.add(p);
				introducido= true;
			}
			
		}
		return introducido;
	}
	
	public String consultarHistorial() {
		StringBuilder lista = new StringBuilder();
		if(paginas.size()==0) {
			lista.append("No hay historial");
		}else {
			for(PaginaWeb i:paginas) {
				lista.append(i+"\n");
			}
		}
		return lista.toString();
	}
	

}
