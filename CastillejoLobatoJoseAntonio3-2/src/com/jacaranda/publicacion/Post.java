package com.jacaranda.publicacion;

import com.jacaranda.usuario.Usuario;

public class Post extends Publicacion {
	private int numeroLecturas;
	private String tema;
	
	public Post(String texto, Usuario user, String tema) throws PublicacionException {
		super(texto, user);
		this.numeroLecturas = 0;
		this.tema = tema;
	}
	
	@Override
	protected void setTexto(String texto) throws PublicacionException {
		if(texto==null) {
			
		}
		else if(texto.equals("")) {
			throw new PublicacionException("No puede estar en blanco");
		}else {
			this.texto =texto;
		}


	}
	private void setValoracion(String valoracion) {
		setValoracion(valoracion);
		setValoracion(valoracion);
	}
	
	@Override
	public String toString() {
		return "Post \n"+"Publicacion: "+this.texto+"\n Realizada por: "+this.getLoginUsuario()+"\n Valoracion: "+this.valoracion+"\n Fecha publicacion: "+getFechaCreacion();
	}

}
