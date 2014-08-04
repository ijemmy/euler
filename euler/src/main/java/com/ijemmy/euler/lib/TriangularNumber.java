package com.ijemmy.euler.lib;

import java.util.HashMap;
import java.util.Iterator;

/**
 * This class represents a triangular number. It provides related calculation
 * The object in this class is immutable.
 * 
 * @author ijemmy
 *
 */
public class TriangularNumber {
	private int firstNumber;
	private int secondNumber;
	
	/**
	 * Constructor for nth triangular number
	 * @param n
	 */
	public TriangularNumber(int n) {
		if(n < 1){
			throw new IllegalArgumentException("Triangular number starts from 1");
		}
		
		/**
		 * Value of triangular number is (n)(n+1)/2
		 * Either n or n+1 must be even. The even number will be divided by 2
		 * We will store both number separately because it is faster to perform prime factorization
		 */
		if(n % 2 == 0){
			this.firstNumber = n/2;
			this.secondNumber = n + 1;
		}else{
			this.firstNumber = n;
			this.secondNumber = (n + 1)/2;
		}
	}
	
	/**
	 * Get the value of this triangular number
	 * @return the number's value
	 */
	public int getValue(){
		return firstNumber * secondNumber;
	}
	
	/**
	 * Get the number of divisors for this triangular number
	 * @return Number of divisors
	 */
	public int getNumberOfDivisors(){
		//Let's say the prime factor is 2(2) * 3(4) * 11(1)
		//The number of divisor is the product of all multiplier , which is (2+1) * (4+1) * (1+1)
		Iterator<Integer> it = this.getPrimeFactors().values().iterator(); 
		int numberOfDivisor = 1;
		while(it.hasNext()){
			numberOfDivisor *= (it.next() + 1);
		}
		return numberOfDivisor;
	}
	
	
	/**
	 * Keep all dependencies in on class Factor in private method
	 * @return
	 */
	private HashMap<Integer, Integer> getPrimeFactors(){
		HashMap<Integer, Integer> firstPrimeFactors = Factor.primeFactorize(this.firstNumber);
		HashMap<Integer, Integer> secondPrimeFactors = Factor.primeFactorize(this.secondNumber);
		return Factor.mergePrimeFactorMap(firstPrimeFactors, secondPrimeFactors);
	}
	

}
