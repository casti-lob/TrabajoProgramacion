package com.jacaranda.publicacion;

import com.jacaranda.usuario.Usuario;

public class Recomendacion extends Publicacion {
	private int numeroEstrellas;
	
	public Recomendacion(String texto, Usuario user, int numeroEstrellas) throws PublicacionException {
		super(texto, user);
		if(numeroEstrellas>5&&numeroEstrellas<1) {
			throw new PublicacionException("No pueden tener ese valor las estrellas");
		}
		this.numeroEstrellas = numeroEstrellas;
	}
	

	@Override
	protected void setTexto(String texto) throws PublicacionException {
		if(texto.length()>200&& texto.length()<100) {
			throw new PublicacionException("Extension minima 100 y maxima 200");
		}else {
			this.texto =texto;
		}
	}

	@Override
	public String toString() {
		return "Recomendacion\n"+ "Publicacion"+this.texto+"\n Realizada por:"+this.getLoginUsuario()+"\n Valoracion: "+this.valoracion+"\n Fecha de publicacion"+this.getFechaCreacion()+"\n Numero de estrellas: "+this.numeroEstrellas; 
	}
	
	

}
