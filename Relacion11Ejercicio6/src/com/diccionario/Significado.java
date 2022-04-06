package com.diccionario;

import java.util.Objects;

public class Significado {
	private String texto;

	public Significado(String texto) throws SignificadoException {
		super();
		this.setTexto(texto);
	}

	public String getTexto() {
		return texto;
	}

	private void setTexto(String texto) throws SignificadoException {
		if(texto== null|| texto==""||texto==" ") {
			throw new SignificadoException("El significado no puede ser nulo");
		}
		this.texto = texto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(texto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Significado other = (Significado) obj;
		return Objects.equals(texto, other.texto);
	}

	@Override
	public String toString() {
		return "Significado [texto=" + texto + "]";
	}
	
}
