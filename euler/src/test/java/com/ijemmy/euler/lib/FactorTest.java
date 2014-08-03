package com.ijemmy.euler.lib;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import com.ijemmy.euler.lib.Factor;

public class FactorTest {
	private HashMap<Integer, Integer> expectedMap;
	
	@Before
	public void setUp(){
		expectedMap = new HashMap<Integer, Integer>();
	}
	
	@Test
	public void getPrimeDivisorOf1() {
		//Should return empty map
		assertEquals(new HashMap<Integer, Integer>(), Factor.primeFactorize(1));
	}
	
	@Test
	public void getPrimeDivisorOf2() {
		expectedMap.put(2, 1);
		assertEquals(expectedMap, Factor.primeFactorize(2));
	}
	
	@Test
	public void getPrimeDivisorOf3() {
		expectedMap.put(3, 1);
		assertEquals(expectedMap, Factor.primeFactorize(3));
	}
	
	@Test
	public void getPrimeDivisorOf4() {
		expectedMap.put(2, 2);
		assertEquals(expectedMap, Factor.primeFactorize(4));
	}

	@Test
	public void getPrimeDivisorOf5() {
		expectedMap.put(5, 1);
		assertEquals(expectedMap, Factor.primeFactorize(5));
	}
	
	@Test
	public void getPrimeDivisorOf8() {
		expectedMap.put(2, 3);
		assertEquals(expectedMap, Factor.primeFactorize(8));
	}
	
	@Test
	public void getPrimeDivisorOf20() {
		expectedMap.put(2, 2);
		expectedMap.put(5, 1);
		assertEquals(expectedMap, Factor.primeFactorize(20));
	}
	
	@Test
	public void getPrimeDivisorOf3PrimeFactor() {
		expectedMap.put(3, 1);
		expectedMap.put(5, 1);
		expectedMap.put(11, 1);
		assertEquals(expectedMap, Factor.primeFactorize(3*5*11));
	}
	
	@Test
	public void getPrimeDivisorOfMoreThan4Multiplier() {
		expectedMap.put(2, 5);
		expectedMap.put(3, 2);
		assertEquals(expectedMap, Factor.primeFactorize(2*2*2*2*2*3*3));
	}
	
	@Test
	public void getPrimeDivisorOfLargeInteger() {
		expectedMap.put(4139, 1);
		expectedMap.put(3, 2);
		expectedMap.put(11, 1);
		assertEquals(expectedMap, Factor.primeFactorize(4139*3*3*11));
	}
	
	@Test
	public void mergePrimeFactorsMapWithNoDupplicatePrime() {
		HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		map1.put(3, 2);
		
		HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
		map2.put(11, 1);
		map2.put(5, 1);
		
		HashMap<Integer, Integer> expectedMap = new HashMap<Integer, Integer>();
		expectedMap.put(3, 2);
		expectedMap.put(5, 1);
		expectedMap.put(11, 1);
		
		assertEquals(expectedMap, Factor.mergePrimeFactorMap(map1, map2));
	}
	
	@Test
	public void mergePrimeFactorsMapWithWithDupplicatePrime() {
		HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		map1.put(3, 2);
		
		HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
		map2.put(3, 1);
		map2.put(5, 1);
		
		HashMap<Integer, Integer> expectedMap = new HashMap<Integer, Integer>();
		expectedMap.put(3, 3);
		expectedMap.put(5, 1);
		
		assertEquals(expectedMap, Factor.mergePrimeFactorMap(map1, map2));
	}
	
	@Test
	public void mergePrimeFactorsMapWithEmptyMap() {
		HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		
		HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
		map2.put(3, 1);
		map2.put(5, 1);
		
		HashMap<Integer, Integer> expectedMap = new HashMap<Integer, Integer>();
		expectedMap.put(3, 1);
		expectedMap.put(5, 1);
		
		assertEquals(expectedMap, Factor.mergePrimeFactorMap(map1, map2));
	}
	
}
