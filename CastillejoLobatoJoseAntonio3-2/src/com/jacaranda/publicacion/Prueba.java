package com.jacaranda.publicacion;

import com.jacaranda.usuario.Usuario;
import com.jacaranda.memoryStorage.*;

public class Prueba {

	public static void main(String[] args) throws PublicacionException {
		// TODO Auto-generated method stub
		
		try {
			
		
			Usuario u=new Usuario("jose", "jjj");
			Usuario r=new Usuario("luis", "jjj");
			Usuario c=new Usuario("jose", "jjj");
			Usuario d=new Usuario("jose", "jjj");
			System.out.println(u.setPass("jjj", null));
			Publicacion p = new Recomendacion("dddd", u,3);
			System.out.println(p);
			p.valorar("MUYBUENA");
			System.out.println(p);
			
			MemoryStorage me = new MemoryStorage();
			me.addUsuario("jose", "j");
			me.addUsuario("pepe", "l");
			me.addUsuario("lope", "i");
			System.out.println(me.posicionUsuario("pepe"));
			me.addUsuario("jose", "j");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
	}
}
