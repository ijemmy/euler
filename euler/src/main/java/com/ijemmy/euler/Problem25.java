package com.ijemmy.euler;

import java.math.BigInteger;

/**
 * Algorithm: Bruteforce
 * With formula,  F(n) = F(n-1) + F(n-2), we can keep calculating the fibonacci number with BigInteger 
 * until we find the number that has 1,000 digits (over 10^999)
 * 
 * Note: Actually, the question can be solved with pen and paper using logarithm
 * http://www.mathblog.dk/project-euler-25-fibonacci-sequence-1000-digits/ 
 * 
 * @author ijemmy
 *
 */
public class Problem25 {
	public static void main(String[] args) {
		//BigInteger must be used for this problem
		BigInteger target = BigInteger.valueOf(10).pow(999);
		BigInteger fibN2 = BigInteger.valueOf(1);  //F(n-2)
		BigInteger fibN1 = BigInteger.valueOf(1);  //F(n-1)
		int term = 2;
		
		//Repeat until we find the fibonacci number that exceed target
		while(fibN1.compareTo(target) < 0){
			BigInteger fibN = fibN2.add(fibN1);
			fibN2 = fibN1;
			fibN1 = fibN;
			term++;
		}
		
		System.out.println("The first 1000-digit Fibonacci number is " + term);

	}

}
