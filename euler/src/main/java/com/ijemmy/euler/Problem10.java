package com.ijemmy.euler;

import com.ijemmy.euler.lib.Prime;

/**
 * Algorithm
 * 1. Iterate through all numbers below the threshold(2,000,000)
 * 1.1 If the number is prime, add it to the sum
 * 2. After iterate through all numbers, we get the sum
 * 
 * 
 * @author ijemmy
 *
 */
public class Problem10 {

	public static void main(String[] args) {
		System.out.println("PrimeSum below 2,000,000 = " + Prime.sumBelow(2000000));
	}

}
