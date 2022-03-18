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
	private Usuario listaUsuarios[];
	private Publicacion listaPublicaciones[];
	
	public MemoryStorage() {
		super();
		this.numUsuariosActuales=0;
		this.numPublicacionesActuales=0;
		this.listaUsuarios = new Usuario[NUM_MAXIMO_USUARIOS];
		this.listaPublicaciones=new Publicacion[NUM_MAXIMO_PUBLICACIONES];
		
	}
	
	public int posicionUsuario(String usu) {
		int posicion=-1;//si es -1 el usuario no esa en la lista
		for(int i=0;i<this.numUsuariosActuales||i!=-1;i++) {
			if(listaUsuarios[i].getLogin().equals(usu)) {
				posicion=i;
			}
		}
		return posicion;
	}
	
	public void addUsuario(String usu,String pass) throws MemoryStorageException {
		if(posicionUsuario(usu)==-1) {
			throw new MemoryStorageException("Usuario repetido");
		}else {
			listaUsuarios[numUsuariosActuales]=new Usuario(usu, pass);
			this.numUsuariosActuales+=1;
		}
	}
	
	public void addPublicacion(String texto, String usu) throws MemoryStorageException, PublicacionException {
		if(posicionUsuario(usu)==-1) {
			throw new MemoryStorageException("Usuario repetido");
		}else {
			listaPublicaciones[numPublicacionesActuales]= new Tweet(texto,listaUsuarios[posicionUsuario(usu)]);
			this.numPublicacionesActuales+=1;
		}
	}
	
	public void addPublicacion(String texto, String usu,String t) throws MemoryStorageException, PublicacionException {
		if(posicionUsuario(usu)==-1) {
			throw new MemoryStorageException("Usuario repetido");
		}else {
			listaPublicaciones[numPublicacionesActuales]= new Post(texto,listaUsuarios[posicionUsuario(usu)],t);
			this.numPublicacionesActuales+=1;
		}
	}
	
	public void addPublicacion(String texto, String usu,int t) throws MemoryStorageException, PublicacionException {
		if(posicionUsuario(usu)==-1) {
			throw new MemoryStorageException("Usuario repetido");
		}else {
			listaPublicaciones[numPublicacionesActuales]= new Recomendacion(texto,listaUsuarios[posicionUsuario(usu)],t);
			this.numPublicacionesActuales+=1;
		}
	}
	
	
}
