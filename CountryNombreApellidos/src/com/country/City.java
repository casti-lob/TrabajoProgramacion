package com.country;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class City {
	private int city_id;
	private String city;
	private HashMap<Integer, HashSet<Address>> address;
	public City(int city_id, String city) {
		super();
		this.city_id = city_id;
		this.city = city;
		address = new HashMap<>();
		
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
	public void setCity(String city) {
		this.city = city;
	}

	public HashMap<Integer, HashSet<Address>> getAddress() {
		return address;
	}

	public void setAddress(Integer address_id, String addres) {

			Address a = new Address(address_id, addres);
			HashSet<Address> contentMap =new HashSet<>();
			
			contentMap.add(a);
			address.put(address_id, contentMap);
		
		
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
