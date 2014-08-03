package com.ijemmy.euler.lib;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

public class CachedFactorialTest {

	@Test
	public void factorialOf0() {
		assertEquals(1, CachedFactorial.get(0));
	}
	
	@Test
	public void factorialOf1() {
		assertEquals(1, CachedFactorial.get(1));
	}
	
	@Test
	public void factorialOfSmallNumbers() {
		assertEquals(2, CachedFactorial.get(2));
		assertEquals(6, CachedFactorial.get(3));
		assertEquals(9*8*7*6*5*4*3*2*1, CachedFactorial.get(9));
	}
	
	@Test
	public void factorialOfLargeNumbers() {
		assertEquals(479001600, CachedFactorial.get(12));
		assertEquals(6402373705728000l, CachedFactorial.get(18));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void factorialOfNegativeNumber() {
		CachedFactorial.get(-1);
	}
	
	@Test
	public void factorialShouldUseCache(){
		CachedFactorial.setCache(new HashMap<Integer, Long>());
		assertEquals(0, CachedFactorial.cacheMap.size());
		
		assertEquals(6, CachedFactorial.get(3));
		assertEquals(1, CachedFactorial.cacheMap.size());
		
		assertEquals(24, CachedFactorial.get(4));
		assertEquals(2, CachedFactorial.cacheMap.size());
		
		assertEquals(6, CachedFactorial.get(3));
		assertEquals(2, CachedFactorial.cacheMap.size());
	}
}
