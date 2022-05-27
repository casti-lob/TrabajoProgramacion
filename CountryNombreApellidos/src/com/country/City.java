package com.country;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class City {
	private int city_id;
	private String city;
	private int numero;
	private static int incremento=1;
	private List<Address> address;
	
	public City(int city_id, String city) {
		super();
		this.city_id = city_id;
		this.city = city;
		this.numero=incremento++;
		address = new ArrayList<Address>();
		
	}
	
	public int getCity_id() {
		return city_id;
	}
	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}
	public String getCity() {
		return city;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setCity(String city) {
		this.city = city;
	}

	public List<Address> getAddress() {
		return address;
	}

	public boolean setAddress(Address a) throws CityException {
			boolean existe=false;
			if(address.contains(a)) {
				existe=true;
			}else {
				address.add(a);
				
			}
			return existe;
	}

	@Override
	public int hashCode() {
		return Objects.hash(city_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		return city_id == other.city_id;
	}

	@Override
	public String toString() {
		return "City [city_id=" + city_id + ", city=" + city + "]";
	}
	
	
	
	
}
