package com.mensajes;

import java.time.LocalDateTime;
import java.util.Objects;

public class Mensaje {
	private String remitente;
	private String texto;
	private LocalDateTime fechaYhora;
	private int codigo;
	private static int codigoSiguiente=1;
	
	public Mensaje(String remitente, String texto) {
		super();
		this.remitente = remitente;
		this.texto = texto;
		this.codigo= codigoSiguiente++;
		this.fechaYhora= LocalDateTime.now();
	}

	public String getRemitente() {
		return remitente;
	}

	public String getTexto() {
		return texto;
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
		return "Mensaje [remitente=" + remitente + ", texto=" + texto + ", fechaYhora=" + fechaYhora + ", codigo="
				+ codigo + "]";
	} 
	
	
	
	
}
