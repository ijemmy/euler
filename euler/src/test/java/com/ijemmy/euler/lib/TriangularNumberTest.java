/**
 * 
 */
package com.ijemmy.euler.lib;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ijemmy.euler.lib.TriangularNumber;

/**
 * @author ijemmy
 *
 */
public class TriangularNumberTest {

	@Test(expected=IllegalArgumentException.class)
	public void TriangularStartsFrom1() {
		new TriangularNumber(0);
	}
	
	@Test
	public void getValueOfNumber() {
		TriangularNumber tn = new TriangularNumber(3);
		assertEquals(6, tn.getValue());
		
		TriangularNumber tn2 = new TriangularNumber(40);
		assertEquals(40*41/2, tn2.getValue());
	}
	
	@Test
	public void getNumberOfDivisorsWithSmallNumbers() {
		TriangularNumber tn = new TriangularNumber(1);
		assertEquals(1, tn.getNumberOfDivisors());
		
		tn = new TriangularNumber(2);
		assertEquals(2, tn.getNumberOfDivisors());
		
		tn = new TriangularNumber(3);
		assertEquals(4, tn.getNumberOfDivisors());
		
		tn = new TriangularNumber(4);
		assertEquals(4, tn.getNumberOfDivisors());
		
		tn = new TriangularNumber(5);
		assertEquals(4, tn.getNumberOfDivisors());
		
		tn = new TriangularNumber(6);
		assertEquals(4, tn.getNumberOfDivisors());
		
		tn = new TriangularNumber(7);
		assertEquals(6, tn.getNumberOfDivisors());
	}
	
	@Test
	public void getNumberOfDivisorsWithLargeNumbers() {
		TriangularNumber tn = new TriangularNumber(27); //378
		assertEquals(16, tn.getNumberOfDivisors()); //1, 2, 3, 6, 7, 9, 14, 18, 21, 27, 42, 54, 63, 126, 189, 378
		
		
		tn = new TriangularNumber(35); //630
		assertEquals(24, tn.getNumberOfDivisors()); //1, 2, 3, 5, 6, 7, 9, 10, 14, 15, 18, 21, 30, 35, 42, 45, 63, 70, 90, 105, 126, 210, 315, 630
	}

}
