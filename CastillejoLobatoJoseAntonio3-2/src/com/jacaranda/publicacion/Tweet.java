package com.jacaranda.publicacion;

import com.jacaranda.usuario.Usuario;

public class Tweet extends Publicacion {
	
	public Tweet(String texto, Usuario user) throws PublicacionException {
		super(texto, user);
		
	}

	@Override
	protected void setTexto(String texto) throws PublicacionException {
		if(texto.length()>50) {
			throw new PublicacionException("Extension  maxima 50");
		}else {
			this.texto =texto;
		}

	}
	
	private void setValoracion(String valoracion) {
		valoracion= valoracion.toUpperCase();
		
		this.valoracion= Valoraciones.valueOf(valoracion).getValor()*2;
	}

	@Override
	public String toString() {
		return "Tweet \n"+"Publicacion: "+this.texto+"\n Realizada por: "+this.getLoginUsuario()+"\n Valoracion: "+this.valoracion+"\n Fecha publicacion: "+getFechaCreacion();
	}
	
	
}
