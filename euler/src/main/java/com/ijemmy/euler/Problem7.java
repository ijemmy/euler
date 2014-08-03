package com.ijemmy.euler;

import com.ijemmy.euler.lib.Prime;

/**
 * Algorithm
 * 0. 2 is the first prime number 
 * 1. Starting from 3, test if the number is prime or not 
 * 2  If it is, put it in the prime list
 * 3. Check the next odd number, Repeat until we find prime at 10001th position
 * 4. Return the prime number at 10001
 * 
 * 
 * The actual implementation is put in Prime class
 * because the prime calculation is reused in multiple problems.
 * 
 * Note: It is possible to use Sieve of Atkins instead for better performance. 
 * However, we need the upper bound to get all number for using the sieve so it is not applicable to this problem. 
 * 
 * @author ijemmy
 */
public class Problem7 {

	public static void main(String[] args) {
		System.out.println("result = " + Prime.getPrimeAt(10001) );
	}

}
