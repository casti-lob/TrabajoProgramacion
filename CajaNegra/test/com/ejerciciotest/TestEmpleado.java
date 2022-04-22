package com.ejerciciotest;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.ejercicio.Empleado;
import com.ejercicio.empleadoException;

class TestEmpleado {

	@Test
	void testNEmpleadoNegativo() {
		try {
			Empleado emp=new Empleado(0,"JUAN",1,'-');
			fail("ERROR, debía haber lanzado excepción por número negativo");
		}catch(Exception e) {
			System.out.println("Numero empleado inferior a lo permitido"+e.getMessage());
		}
		
	}
	
	@Test
	void testNEmpleadoSuperior() {
		try {
			Empleado emp=new Empleado(1000,"JUAN",1,'-');
			fail("ERROR, debía haber lanzado excepción por número superior a lo permitido");
		}catch(Exception e) {
			System.out.println("Numero empleado superior a lo permitido"+e.getMessage());
		}
		
	}
	
	@Test
	void testNombreCaracteresInfeiror() {
		try {
			Empleado emp=new Empleado(1,"",1,'-');
			fail("ERROR, debía haber lanzado excepción caracteres del nombre inferior a lo permitido");
		}catch(Exception e) {
			System.out.println("Nombre con caracteres inferior a lo permitido"+e.getMessage());
		}
		
	}
	
	@Test
	void testNombreCaracteresSuperior() {
		try {
			Empleado emp=new Empleado(1,"JUANANANANA",1,'-');
			fail("ERROR, debía haber lanzado excepción caracteres del nombre superior a lo permitido");
		}catch(Exception e) {
			System.out.println("Nombre con caracteres superior a lo permitido"+e.getMessage());
		}
		
	}
	
	@Test
	void testMesesSuperior() {
		try {
			Empleado emp=new Empleado(1,"JUAN",1000,'-');
			fail("ERROR, debía haber lanzado excepción meses superior a lo permitido");
		}catch(Exception e) {
			System.out.println("Meses superior a lo permitido"+e.getMessage());
		}
		
	}
	
	@Test
	void testMesesInferior() {
		try {
			Empleado emp=new Empleado(1,"JUAN",-1,'-');
			fail("ERROR, debía haber lanzado excepción meses inferior a lo permitido");
		}catch(Exception e) {
			System.out.println("Meses inferior a lo permitido"+e.getMessage());
		}
		
	}
	
	@Test
	void testDirectivoNoValido() {
		try {
			Empleado emp=new Empleado(1,"JUAN",1,'*');
			fail("ERROR, debía haber lanzado excepción valor directivo no aceptado");
		}catch(Exception e) {
			System.out.println("Valor directivo no aceptado"+e.getMessage());
		}
		
	}
	
	@Test
	void testEmpleadoCorrectoValoresInferiores() {
		try {
			Empleado emp=new Empleado(1,"J",1,'+');
			
		}catch(Exception e) {
			
		}
	}
	
	@Test
	void testEmpleadoCorrectoValoresSuperiores() {
		try {
			Empleado emp=new Empleado(999,"Junjunjunj",999,'-');
			
		}catch(Exception e) {
			
		}
	}
	
	@Test
	void p1() {
		
		try {
			Empleado emp=new Empleado(1,"JUAN",12,'+');
			assertEquals("Asignacion prima p1","P1", emp.crearPrima());
		} catch (empleadoException e) {
			
		}
	}
	
	@Test
	void p2() {
		
		try {
			Empleado emp=new Empleado(1,"JUAN",12,'-');
			assertEquals("Asignacion prima p1","P2", emp.crearPrima());
		} catch (empleadoException e) {
			
		}
	}
	
	@Test
	void p3() {
		
		try {
			Empleado emp=new Empleado(1,"JUAN",0,'+');
			assertEquals("Asignacion prima p1","P1", emp.crearPrima());
		} catch (empleadoException e) {
			
		}
	}
	
	@Test
	void p4() {
		
		try {
			Empleado emp=new Empleado(1,"JUAN",0,'-');
			assertEquals("Asignacion prima p1","P1", emp.crearPrima());
		} catch (empleadoException e) {
			
		}
	}
}
