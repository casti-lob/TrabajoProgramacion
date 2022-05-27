package com.country;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Country {
	private int country_id;
	private String country;
	private int numero;
	private static int incremento=1;
	private List<City> cities;
	
	public Country(int country_id, String country) {
		super();
		this.country_id = country_id;
		this.country = country;
		cities= new ArrayList<>();	
		this.numero=incremento++;
	}

	public int getCountry_id() {
		return country_id;
	}

	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}

	public String getCountry() {
		return country;
	}
	
	public int getNumero() {
		return numero;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<City> getCities() {
		return cities;
	}

	public boolean setCities(City c) throws CityException {
		boolean existe=false;
		if (cities.contains(c)) {
			cities.add(c);
			existe= true;
		}

		return existe;
		
	}
	public String formatoCountry() {
		return this.country_id+","+this.country;
	}
	
	@Override
	public String toString() {
		return "Country [country_id=" + country_id + ", country=" + country + ", numero=" + numero + ", cities="
				+ cities + "]";
	}
	
	
	
}
