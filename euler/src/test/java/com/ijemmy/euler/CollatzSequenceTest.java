package com.ijemmy.euler;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

public class CollatzSequenceTest {

	@Test
	public void getNextNumberWithEven() {
		assertEquals(1 , CollatzSequence.getNextNumber(2));
		assertEquals(2 , CollatzSequence.getNextNumber(4));
		assertEquals(51, CollatzSequence.getNextNumber(102));
	}
	
	@Test
	public void getNextNumberWithOdd() {
		assertEquals(3*3+1 , CollatzSequence.getNextNumber(3));
		assertEquals(5*3+1 , CollatzSequence.getNextNumber(5));
		assertEquals(101*3 +1, CollatzSequence.getNextNumber(101));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void getNextNumberWithOne() {
		CollatzSequence.getNextNumber(1);
	}

	@Test
	public void getSeqLength() {
		assertEquals(10 , CollatzSequence.getLength(13));
		assertEquals(9 , CollatzSequence.getLength(40));
		assertEquals(1, CollatzSequence.getLength(1));
	}
	
	@Test
	public void getSeqLengthLong() {
		//50->25->76->38->19->58->29->88->44->22->11->34->17->52->26->13 
		assertEquals(25 , CollatzSequence.getLength(50));
	}
	
	@Test
	public void getSeqLengthUseCache() {
		CollatzSequence.seqLengthMap = new HashMap<Integer, Integer>();
		CollatzSequence.getLength(13);
		assertEquals(10 , CollatzSequence.seqLengthMap.size());
	}
}
