package com.country;

public class Pruebas {

	public static void main(String[] args) throws CityException {
		City c = new City(1, "Sevilla");
		c.setAddress(12, "Macarena");
		System.out.println(c.getAddress());
		System.out.println(c);

	}

}
