package com.jacaranda.histrorial;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Historial {
	
	private List<PaginaWeb> paginas;

	public Historial() {
		super();
		
		this.paginas = new ArrayList<PaginaWeb>();
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
			}else if(paginas.get(paginas.size()-1).getFechaYhora().isAfter(fechaYhora)) {
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
	public String consultarHistorialUnDia(LocalDateTime dia) {
		boolean resultado=false;
		StringBuilder lista = new StringBuilder();
		if(paginas.size()==0) {
			lista.append("No hay historial");
		}else {
	
			Iterator<PaginaWeb> siguiente = paginas.iterator();
			while(siguiente.hasNext()&&!resultado) {
				PaginaWeb p1= siguiente.next();
				if(p1.getFechaYhora().equals(dia)) {
					resultado= true;
					lista.append(p1);
				}
			}
		}
		return lista.toString();
	}
	
	public void borrarHistorial() {
		
		paginas.clear();
		
	}
	
	

}
