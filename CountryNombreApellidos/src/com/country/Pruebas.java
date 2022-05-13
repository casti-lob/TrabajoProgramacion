package com.country;

import java.util.HashMap;
import java.util.HashSet;

public class Pruebas {

	public static void main(String[] args) throws CityException {
		Address a = new Address(0, null);
		Address a1 = new Address(0, null);
		System.out.println(a.getNumero());
		System.out.println(a1.getNumero());
		Country c = new Country(0, null);
		System.out.println(c.getCities());
		
		HashMap<Integer, HashSet<City>> ciudades;
		ciudades= c.getCities();
		HashSet<City> cc= ciudades.get(0);
		
		City aa = new City(0, null);
		cc.getClass(aa);
		

	}

}
