package com.jacaranda.histrorial;

import java.time.LocalDateTime;
import java.util.Objects;

public class PaginaWeb {
	
	private String url;
	private LocalDateTime fechaYhora;
	
	public PaginaWeb(String url, LocalDateTime fechaYhora) throws PaginaWebException {
		super();
		this.setUrl(url);
		this.setFechaYhora(fechaYhora);
	}
	

	public PaginaWeb(String url) throws PaginaWebException {
		super();
		this.setUrl(url);
		this.fechaYhora= LocalDateTime.now();
	}


	public String getUrl() {
		return url;
	}

	public void setUrl(String url) throws PaginaWebException {
		
		if(url==null||url.isEmpty()) {
			throw new PaginaWebException("La url no puede ser nulo o estar en blanco");
		}
		this.url = url;
	}

	public LocalDateTime getFechaYhora() {
		return fechaYhora;
	}

	private void setFechaYhora(LocalDateTime fechaYhora) throws PaginaWebException {
		if(fechaYhora==null) {
			throw new PaginaWebException("La fecha y hora no puede ser nulo");
		}
		this.fechaYhora = fechaYhora;
	}


	


	@Override
	public int hashCode() {
		return Objects.hash(fechaYhora);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaginaWeb other = (PaginaWeb) obj;
		return Objects.equals(fechaYhora, other.fechaYhora);
	}


	@Override
	public String toString() {
		return "PaginaWeb [url=" + url + ", fechaYhora=" + fechaYhora + "]";
	}
	
	
	
	
	
	
}
