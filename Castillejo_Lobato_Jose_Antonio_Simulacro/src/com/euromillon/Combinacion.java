package com.euromillon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Combinacion {
	private List<Integer> numeros;
	private List<Integer> estrellas;
	// He utilizado ArrayList para que me aparezcan los numeros ordenados
	private int n1;
	private int n2;
	private int n3;
	private int n4;
	private int n5;
	private int est1;
	private int est2;

	public Combinacion(int n1, int n2, int n3, int n4, int n5, int est1, int est2) throws CombinacionException {
		super();
		numeros = new ArrayList<>();
		estrellas = new ArrayList<>();
		this.setEst1(est1);
		this.setEst2(est2);
		this.setN1(n1);
		this.setN2(n2);
		this.setN3(n3);
		this.setN4(n4);
		this.setN5(n5);

	}

	public int getN1() {
		return n1;
	}

	private void setN1(int n1) throws CombinacionException {
		if (n1 < 1 || n1 > 50) {
			throw new CombinacionException("Rango de numero no aceptado");
		}
		this.n1 = n1;
		numeros.add(n1);
	}

	public int getN2() {
		return n2;
	}

	private void setN2(int n2) throws CombinacionException {
		if (n2 < 1 || n2 > 50) {
			throw new CombinacionException("Rango de numero no aceptado");
		}
		this.n2 = n2;
		numeros.add(n2);
	}

	public int getN3() {
		return n3;
	}

	private void setN3(int n3) throws CombinacionException {
		if (n3 < 1 || n3 > 50) {
			throw new CombinacionException("Rango de numero no aceptado");
		}
		this.n3 = n3;
		numeros.add(n3);
	}

	public int getN4() {
		return n4;
	}

	private void setN4(int n4) throws CombinacionException {
		if (n4 < 1 || n4 > 50) {
			throw new CombinacionException("Rango de numero no aceptado");
		}
		this.n4 = n4;
		numeros.add(n4);
	}

	public int getN5() {
		return n5;
	}

	private void setN5(int n5) throws CombinacionException {
		if (n1 < 1 || n1 > 50) {
			throw new CombinacionException("Rango de numero no aceptado");
		}
		numeros.add(n5);
		this.n5 = n5;
	}

	public int getEst1() {
		return est1;
	}

	private void setEst1(int est1) throws CombinacionException {
		if (est1 < 1 || est1 > 12) {
			throw new CombinacionException("Rango de estrella no aceptado");
		}
		estrellas.add(est1);
		this.est1 = est1;
	}

	public int getEst2() {
		return est2;
	}

	private void setEst2(int est2) throws CombinacionException {
		if (est2 < 1 || est2 > 12) {
			throw new CombinacionException("Rango de estrella no aceptado");
		}
		this.est2 = est2;
	}

	public String cadenaNumeros() {
		return this.n1 + "-" + this.n2 + "-" + this.n3 + "-" + "-" + this.n4 + "-" + this.n5;
	}

	public String cadenaEstrellas() {
		return this.est1 + "-" + this.est2;
	}

	public String cadenaCombinacion() {
		return this.n1 + "-" + this.n2 + "-" + this.n3 + "-" + this.n4 + "-" + this.n5 + " Estrellas: " + this.est1
				+ "-" + this.est2;
	}

	@Override
	public int hashCode() {
		return Objects.hash(estrellas, numeros);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Combinacion other = (Combinacion) obj;
		return Objects.equals(estrellas, other.estrellas) && Objects.equals(numeros, other.numeros);
	}

	public int comprobarAciertos(Combinacion other) {
		int aciertos = 0;
		boolean encontrado = false;
		Iterator<Integer> siguiente = this.numeros.iterator();
		Iterator<Integer> otherSiguiente = other.numeros.iterator();

		while (siguiente.hasNext() && !encontrado) {
			Integer n = siguiente.next();

			Integer otherN = otherSiguiente.next();

			if (otherN.equals(n)) {
				aciertos += 1;
				encontrado = true;

			}

		}
		encontrado = false;
		Iterator<Integer> est = this.estrellas.iterator();
		Iterator<Integer> otherEst = other.estrellas.iterator();
		while (est.hasNext() && !encontrado) {
			Integer est1 = est.next();
			Integer est2 = otherEst.next();
			if (est2.equals(est1)) {
				aciertos += 1;
				encontrado = true;
			}
		}

		return aciertos;

	}

}
