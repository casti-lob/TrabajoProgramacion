package com.country;

import java.util.HashMap;
import java.util.HashSet;

public class Country {
	private int country_id;
	private String country;
	private int numero;
	private static int incremento=1;
	private HashMap<Integer, HashSet<City>> cities;
	
	public Country(int country_id, String country) {
		super();
		this.country_id = country_id;
		this.country = country;
		cities= new HashMap<>();	
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

	public HashMap<Integer, HashSet<City>> getCities() {
		return cities;
	}

	public void setCities(Integer idCity, String city) {
		City c = new City(idCity, city);
		if (cities.isEmpty()) {
			HashSet<City>contentMap = new HashSet<>();
			
			contentMap.add(c);
			cities.put(idCity, contentMap);
		
			contentMap.add(c);
		}
		
		
	}

	@Override
	public String toString() {
		return "Country [country_id=" + country_id + ", country=" + country + ", numero=" + numero + ", cities="
				+ cities + "]";
	}
	
	
	
}
