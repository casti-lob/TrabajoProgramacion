package com.jacaranda.memoryStorage;

import com.jacaranda.publicacion.Post;
import com.jacaranda.publicacion.Publicacion;
import com.jacaranda.publicacion.PublicacionException;
import com.jacaranda.publicacion.Recomendacion;
import com.jacaranda.publicacion.Tweet;
import com.jacaranda.usuario.Usuario;

public class MemoryStorage {
	private static final int NUM_MAXIMO_USUARIOS=15;
	private static final int NUM_MAXIMO_PUBLICACIONES=50;
	private int numUsuariosActuales;
	private int numPublicacionesActuales;
	private Usuario[] listaUsuarios;
	private Publicacion[] listaPublicaciones;
	
	public MemoryStorage() {
		super();
		this.numUsuariosActuales=0;
		this.numPublicacionesActuales=0;
		this.listaUsuarios = new Usuario[NUM_MAXIMO_USUARIOS];
		this.listaPublicaciones=new Publicacion[NUM_MAXIMO_PUBLICACIONES];
		
	}
	
	public int posicionUsuario(String usu) {
		int posicion=-1;//si es -1 el usuario no esta en la lista
		for(int i=0;i<this.numUsuariosActuales && posicion==-1;i++) {
			if(listaUsuarios[i].getLogin().equals(usu)) {
				posicion=i;
			}
		}
		return posicion;
	}
	/*
	 * Metodo generico
	 * 
	private<I> int posicionELemento(I[] array,I elemento, int longitud) {
		int posicion=-1;//si es -1 el usuario no esa en la lista
		for(int i=0;i<longitud||i!=-1;i++) {
			if(array[i].equals(elemento)) {
				posicion=i;
			}
		}
		return posicion;
		
	}
	public void addUsuario(String texto,String login) throws MemoryStorageException, PublicacionException {
		Usuario aux= new Usuario(texto, null);
		int posicion= posicionELemento(this.listaUsuarios, aux, this.numUsuariosActuales);
		Publicacion paux = new Tweet(texto, this.listaUsuarios[posicion]);
		int posicionPubicacion = posicionElemento(this.publicaciones, paux,this.numPublicacionesActuales;
	}
	*/
	
	public void addUsuario(String usu,String pass) throws MemoryStorageException {
			if(this.numUsuariosActuales>=NUM_MAXIMO_USUARIOS) {
				throw new MemoryStorageException("Numero de usuarios completos");
			}
			else if(this.numUsuariosActuales >0) {
				if(posicionUsuario(usu)!=-1) {
					throw new MemoryStorageException("Usuario repetido");
				}
			}
			listaUsuarios[numUsuariosActuales]=new Usuario(usu, pass);
			this.numUsuariosActuales+=1;
		
	}
	
	public void addPublicacion(String texto, String usu) throws MemoryStorageException, PublicacionException {
		if(this.numPublicacionesActuales>=NUM_MAXIMO_PUBLICACIONES) {
			throw new MemoryStorageException("Numero de publicaciones completos");
		}
		else if(this.numUsuariosActuales==0) {
			throw new MemoryStorageException("No existe usuarios");
		}
		else if(this.numUsuariosActuales >0) {
			if(posicionUsuario(usu)==-1) {
			throw new MemoryStorageException("Usuario no existente");
			}
		}else {
			listaPublicaciones[numPublicacionesActuales]= new Tweet(texto,listaUsuarios[posicionUsuario(usu)]);
			this.numPublicacionesActuales+=1;
		}
	}
	
	public void addPublicacion(String texto, String usu,String t) throws MemoryStorageException, PublicacionException {
		if(this.numPublicacionesActuales>=NUM_MAXIMO_PUBLICACIONES) {
			throw new MemoryStorageException("Numero de publicaciones completos");
		}
		else if(this.numUsuariosActuales==0) {
			throw new MemoryStorageException("No existe usuarios");
		}
		else if(this.numUsuariosActuales >0) {
			if(posicionUsuario(usu)==-1) {
			throw new MemoryStorageException("Usuario no existente");
			}
		}else {
			listaPublicaciones[numPublicacionesActuales]= new Post(texto,listaUsuarios[posicionUsuario(usu)],t);
			this.numPublicacionesActuales+=1;
		}
	}
	
	public void addPublicacion(String texto, String usu,int t) throws MemoryStorageException, PublicacionException {
		if(this.numPublicacionesActuales>=NUM_MAXIMO_PUBLICACIONES) {
			throw new MemoryStorageException("Numero de publicaciones completos");
		}
		else if(this.numUsuariosActuales==0) {
			throw new MemoryStorageException("No existe usuarios");
		}
		else if(this.numUsuariosActuales >0) {
			if(posicionUsuario(usu)==-1) {
			throw new MemoryStorageException("Usuario no existente");
			}
		}else {
			listaPublicaciones[numPublicacionesActuales]= new Recomendacion(texto,listaUsuarios[posicionUsuario(usu)],t);
			this.numPublicacionesActuales+=1;
		}
	}
	
	public String mostrarListaPublicaciones() {
		StringBuilder lista= new StringBuilder();
		for(int i=0;i<numPublicacionesActuales;i++) {
			lista.append(listaPublicaciones[i]+"\n");
		}
		return lista.toString();
	}
	
	public String mostrarTweets() {
		StringBuilder lista = new StringBuilder();
		for(int i= 0;i<numPublicacionesActuales;i++) {
			if(listaPublicaciones[i]instanceof Tweet) {
				lista.append(listaPublicaciones[i]+"\n");
			}
			
		}
		return lista.toString();
	}
	
	public String mostrarPosts() {
		StringBuilder lista = new StringBuilder();
		for(int i= 0;i<numPublicacionesActuales;i++) {
			if(listaPublicaciones[i]instanceof Post) {
				lista.append(listaPublicaciones[i]+"\n");
			}
			
		}
		return lista.toString();
	}
	
	public String mostrarRecomendacion() {
		StringBuilder lista = new StringBuilder();
		for(int i= 0;i<numPublicacionesActuales;i++) {
			if(listaPublicaciones[i]instanceof Recomendacion) {
				lista.append(listaPublicaciones[i]+"\n");
			}
			
		}
		return lista.toString();
	}
	
}
