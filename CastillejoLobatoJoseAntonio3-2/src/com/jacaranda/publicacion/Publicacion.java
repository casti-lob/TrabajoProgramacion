package com.jacaranda.publicacion;

import java.time.LocalDateTime;
import java.util.Objects;
import com.jacaranda.usuario.Usuario;

public abstract class Publicacion implements Valorable ,Comparable<Publicacion> {
	protected String texto;
	private LocalDateTime fechaCreacion;
	protected int valoracion;
	private int codigo;
	private static int codigoSiguiente;
	private Usuario user;
	
	public Publicacion(String texto, Usuario user) throws PublicacionException {
		super();
		setTexto(texto);;
		this.user =user;
		this.fechaCreacion= LocalDateTime.now();
		setValoracion(texto);
		this.codigo= codigoSiguiente++;
	}

	protected String getTexto() throws PublicacionException {
		if(this.texto==null) {
			throw new PublicacionException("El texto no puede ser nulo o en blanco");
		}
		return texto;
	}

	protected abstract void setTexto(String texto) throws PublicacionException;

	@Override
	public int hashCode() {
		return Objects.hash(texto, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publicacion other = (Publicacion) obj;
		return Objects.equals(texto, other.texto) && Objects.equals(user, other.user);
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public int getValoracion() {
		return valoracion;
	}

	public int getCodigo() {
		return codigo;
	}
	
	private void setValoracion(String valoracion) {
		valoracion= valoracion.toUpperCase();
		
		this.valoracion= Valoraciones.valueOf(valoracion).getValor();
	}
	
	public boolean Valorar(String texto) {
		boolean valorado=false; //Por defecto no esta valorado
		if(texto.equals(Valoraciones.SUPERBUENA)||texto.equals(Valoraciones.MUYBUENA)||texto.equals(Valoraciones.BUENA)||texto.equals(Valoraciones.NORMAL)||texto.equals(Valoraciones.REGULAR)||texto.equals(Valoraciones.MUYMALA)) {
			valorado=true;
		}
		return valorado;
	}
	
	public String getLoginUsuario() {
		return this.user.getLogin();
	}

	@Override
	public String toString() {
		return "Publicación:"+this.texto+"\n"+"Realizado por:"+this.getLoginUsuario()+"\n"+"Valoración:"+this.valoracion+"\n"+"Fecha de publicación"+this.fechaCreacion;
	}
	
	@Override
	public int compareTo(Publicacion o) {
		int resultado = this.valoracion-o.valoracion;
		if (resultado==0) {
			resultado =this.fechaCreacion.compareTo(o.fechaCreacion);
		}
			
		return resultado;
	}
	
	public boolean isAnterior(Publicacion o) {
		boolean resultado=false;
		if(this.fechaCreacion.isBefore(o.fechaCreacion)) {
			resultado=true;
		}
		return resultado;
	}
	
	
	
	
	
	
	
	
	
	
	
}

