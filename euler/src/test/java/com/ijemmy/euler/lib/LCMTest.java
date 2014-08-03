package com.ijemmy.euler.lib;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ijemmy.euler.lib.LCM;

public class LCMTest {

	@Test
	public void calculateLCMSimpleCases(){
		assertEquals(6, LCM.calculate(2,3));
		assertEquals(24, LCM.calculate(6,8));
		assertEquals(297, LCM.calculate(27,33));
	}
	
	@Test
	public void calculateLCMWithHigherValueFirst(){
		assertEquals(6, LCM.calculate(3,2));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void calculateLCMWithZeroValue(){
		LCM.calculate(0,2);
	}
	
	@Test
	public void calculateLCMWithNegativeValues(){
		assertEquals(6, LCM.calculate(-2,3));
		assertEquals(24, LCM.calculate(6,-8));
		assertEquals(297, LCM.calculate(-27,-33));
	}
	
	@Test
	public void calculateLCMWithOne(){
		assertEquals(1, LCM.calculate(1,1));
		assertEquals(3, LCM.calculate(1,3));
		assertEquals(Integer.MAX_VALUE, LCM.calculate(1,Integer.MAX_VALUE));	
	}
	
	@Test
	public void calculateSequenceFrom1to10() {
		assertEquals(2520, LCM.calculateSeq(1,10));
	}
	
	@Test
	public void calculateSequenceFrom1to11() {
		assertEquals(2520 * 11, LCM.calculateSeq(1,11));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void calculateSequenceWithIllegalInputs() {
		LCM.calculateSeq(0,10);
		LCM.calculateSeq(-1,10);
		LCM.calculateSeq(10,10);
		LCM.calculateSeq(8,10);
	}

}
