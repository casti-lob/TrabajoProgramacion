package com.country;

import java.util.HashMap;
import java.util.HashSet;

public class Country {
	private int country_id;
	private String country;
	private HashMap<Integer, HashSet<City>> cities;
	
	public Country(int country_id, String country) {
		super();
		this.country_id = country_id;
		this.country = country;
		cities= new HashMap<>();	
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

	public void setCountry(String country) {
		this.country = country;
	}

	public HashMap<Integer, HashSet<City>> getCities() {
		return cities;
	}

	public void setCities(Integer id_city, String city) {
		City c = new City(country_id, city);
		HashSet<City>contentMap = new HashSet<>();
		contentMap.add(c);
	}
	
	
}
