package com.mensajes;

import java.time.LocalDateTime;
import java.util.Objects;

public class Mensaje implements Comparable<Mensaje> {
	private String remitente;
	private String texto;
	private LocalDateTime fechaYhora;
	private int codigo;
	private static int codigoSiguiente=1;
	
	public Mensaje(String remitente, String texto) throws MensajeException {
		super();
		this.setRemitente(remitente);
		this.setTexto(texto);
		this.codigo= codigoSiguiente++;
		this.setFechaYhora();
	}

	public String getRemitente() {
		return remitente;
	}

	public String getTexto() {
		return texto;
	}
	

	private void setRemitente(String remitente) throws MensajeException {
		if(remitente==null) {
			throw new MensajeException("El remitente no pouede ser nulo");
		}
		this.remitente = remitente;
	}

	private void setTexto(String texto) throws MensajeException {
		if(texto==null) {
			throw new MensajeException("El texto no puede ser nulo");
		}
		this.texto = texto;
	}

	private void setFechaYhora() throws MensajeException {
		
		this.fechaYhora = LocalDateTime.now();
	}

	public LocalDateTime getFechaYhora() {
		return fechaYhora;
	}

	public int getCodigo() {
		return codigo;
	}

	public static int getCodigoSiguiente() {
		return codigoSiguiente;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(fechaYhora, remitente, texto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mensaje other = (Mensaje) obj;
		return Objects.equals(fechaYhora, other.fechaYhora) && Objects.equals(remitente, other.remitente)
				&& Objects.equals(texto, other.texto);
	}

	@Override
	public String toString() {
		return "Mensaje "+this.codigo+" De: "+this.remitente+" Texto: "+this.texto+" Fecha y hora "+this.fechaYhora;
	}

	@Override
	public int compareTo(Mensaje o) {
		
		return this.remitente.compareTo(o.remitente);
	} 
	
	
	
	
}
