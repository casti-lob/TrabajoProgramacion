package com.jacaranda.publicacion;

import com.jacaranda.usuario.Usuario;

public class Prueba {

	public static void main(String[] args) throws PublicacionException {
		// TODO Auto-generated method stub
		
		try {
			
		
			Usuario u=new Usuario("jose", "jjj");
			System.out.println(u.setPass("jjj", null));
			Publicacion p = new Recomendacion("dddd", u,3);
			System.out.println(p);
			p.valorar("MUYBUENA");
			System.out.println(p);
			p.valorar("MUBUENA");
			System.out.println(p);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
	}
}
