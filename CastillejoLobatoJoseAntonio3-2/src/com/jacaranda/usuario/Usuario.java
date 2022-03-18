package com.jacaranda.usuario;

import java.util.Objects;

public class Usuario {
	private String login;
	private String pass;
	
	//Constructor
	public Usuario(String login, String pass) {
		super();
		this.login = login;
		this.pass = pass;
	}

	public String getLogin() {
		return login;
	}
	//Para cambiar la contraseña tiene que comprobar el usuario y el pass
	public boolean setPass(String login,String pass)  {
		boolean fechaModificada=false;
		if(this.login.equals(login)&& this.pass.equals(pass)) {
			this.pass = pass;
			fechaModificada=true;
		}
		return fechaModificada;
		
	}
	//comprueba si la contraseña es correcta
	public boolean checkPass(String pass) {
		boolean contrasennaCorrecta=false;
		if(pass.equals(this.pass)) {
			contrasennaCorrecta=true;
		}
		return contrasennaCorrecta;
	}
	//dos usuarios son iguales cuando tienen el mismo login
	@Override
	public int hashCode() {
		return Objects.hash(login);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(login, other.login);
	}
	
	
	
	
	
	
	
	
	
}
