package com.ijemmy.euler.lib;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuadraticTest {
	@Test
	public void computeSimpleAandB() {
		Quadratic q = new Quadratic(1, 2);
		assertEquals(2*2+2*1+2, q.compute(2));
	}
	
	@Test
	public void computeZeroAorB() {
		Quadratic q = new Quadratic(0, 2);
		assertEquals(2*2+2*0+2, q.compute(2));
		
		q = new Quadratic(2, 0);
		assertEquals(2*2+2*2+0, q.compute(2));
	}
	
	@Test
	public void computeNegativeAorB() {
		Quadratic q = new Quadratic(-1, 2);
		assertEquals(2*2+2*-1+2, q.compute(2));
		
		q = new Quadratic(2, -2);
		assertEquals(2*2+2*2-2, q.compute(2));
	}

	@Test
	public void computeNisZero() {
		Quadratic q = new Quadratic(-1, 2);
		assertEquals(2, q.compute(0));
	}
	
	@Test
	public void computeLargeNumber() {
		Quadratic q = new Quadratic(-1000, 700);
		long expectedRes = 5000*5000 - 1000*5000 + 700;
		assertEquals(expectedRes, q.compute(5000));
		
		q = new Quadratic(1000, 700);
		expectedRes = 5000*5000 + 1000*5000 + 700;
		assertEquals(expectedRes, q.compute(5000));
	}
	
	@Test
	public void getMaxPrimeWithPrimeQuad() {
		Quadratic q = new Quadratic(1, 41);
		assertEquals(39, q.getMaxPrime());
		
		q = new Quadratic(-79, 1601);
		assertEquals(79, q.getMaxPrime());
	}
	
	@Test
	public void getMaxPrimeWithNonPrimeQuad() {
		Quadratic q = new Quadratic(0, 4);
		assertEquals(-1, q.getMaxPrime());
		
		q = new Quadratic(0, 1);
		assertEquals(-1, q.getMaxPrime());
	}
	
}
