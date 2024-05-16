package atividade01;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class CalculadoraTest {

	@Test
	void testDeveSomarNumerosInteiros() {
		Calculadora calc = new Calculadora();
		double expected = 5;
		double result = calc.soma(2, 3);
		assertTrue(result == expected);
		assertEquals(expected, result);
	}
	
	@Test
	void testDeveSomarNumerosDecimais() {
		Calculadora calc = new Calculadora();
		double expected = 0.3;
		double result = calc.soma(0.1, 0.2);
//		System.out.println(result);
//		assertEquals(expected, result, 0.0001);
	}

	@Test
	void testDeveSomarNumerosDecimaisComTruncamento() {
		Calculadora calc = new Calculadora();
		double expected = 0.3;
		double result = calc.soma(0.1, 0.2);
		assertEquals(expected, result, 0.0001);
	}
	
	@Test
	void testDeveDividirNumerosInteiros() {
		Calculadora calc = new Calculadora();
		int expected = 3;
		double result = calc.dividir(6, 2);
		assertEquals(expected, result);
	}
	
	@Test
	void testDeveDividirNumerosDecimais() {
		Calculadora calc = new Calculadora();
		double expected = 3.33;
		double result = calc.dividir(10, 3);
		assertEquals(expected, result, 0.01);
	}
	
	@Test
	public void testDeveRetornarFalhaAoDividirPorZero() {
		try {
			Calculadora calc = new Calculadora();
			double result = calc.dividir(10, 0);
		} catch (IllegalArgumentException e) {
			assertEquals("O divisor não pode ser zero", e.getMessage());
		}
	}
	
	
//	@Test
//	public void testDeveRetornarFalhaAoDividirPorZero() {
//		try {
//		Calculadora calc = new Calculadora();
//		calc.dividir(10, 0);
//		fail("Não deveria chegar aqui, algo não mapeado ocorreu.");
//		} catch (IllegalArgumentException e) {
//			assertEquals(
//					"Não é possível divdir por zero", 
//					e.getMessage()
//			);
//		}
//	}

	@Test
	public void assertivas() {
		assertEquals("Comida", "Comida");
		assertNotEquals("Comida", "comida");
		assertTrue("comida".equalsIgnoreCase("COMIDA"));
		assertTrue("comida".equalsIgnoreCase("COMIDA"));
		assertTrue("comida".equalsIgnoreCase("COMIDA"));
		assertFalse("Comida" == "comida");
		
		List<String> s1 = new ArrayList<>();
		List<String> s2 = new ArrayList<>();
		List<String> s3 = null;
		
		assertEquals(s1, s2);
		assertNotSame(s1, s2);
		
		assertNull(s3);
		assertNotNull(s1);
		
//		asser
		
//		fail("Falhou por motivo de ValidationException");
		
	}
}
