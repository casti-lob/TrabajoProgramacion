package com.ejercicio;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static List<Empleado> empleados =new ArrayList<Empleado>();
	public static Array [] registros =new arra
	public static void main(String[] args) {
		try {
			Empleado e = new Empleado(001, "1234567891",12, '-');
			System.out.println(e);
		} catch (empleadoException e) {
			System.out.println(e.getMessage());		}
	}

}
