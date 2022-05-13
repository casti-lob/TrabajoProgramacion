package com.country;

import java.util.Objects;

public class Address {
	
	private int address_id;
	private String address;
	private int numero;
	private static int incremento=1;
	
	
	public Address(int address_id, String address) {
		super();
		this.address_id = address_id;
		this.address = address;
		this.numero=incremento++;
	}


	public int getAddress_id() {
		return address_id;
	}

	public int getNumero() {
		return numero;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(address_id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return address_id == other.address_id;
	}

	

	@Override
	public String toString() {
		return "Address [address_id=" + address_id + ", address=" + address + "]";
	}
	
}
