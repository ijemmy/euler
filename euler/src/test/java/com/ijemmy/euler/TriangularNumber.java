package com.ijemmy.euler;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class TriangularNumber {
	private int n;
	private int firstNumber;
	private int secondNumber;
	
	public TriangularNumber(int n) {
		if(n < 1){
			throw new IllegalArgumentException("Triangular number starts from 1");
		}
		
		this.n = n;
		
		
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
	
	public int getValue(){
		return firstNumber * secondNumber;
	}
	
	public int getNumberOfDivisors(){
		HashMap<Integer, Integer> primeFactors = this.getPrimeFactors();
		Iterator<Integer> it = getPrimeFactors().values().iterator(); 
		int numberOfDivisor = 1;
		while(it.hasNext()){
			numberOfDivisor *= (it.next() + 1);
		}
		return numberOfDivisor;
	}
	
	
	/**
	 * Keep all dependencies in on class Factor in private here
	 * @return
	 */
	private HashMap<Integer, Integer> getPrimeFactors(){
		HashMap<Integer, Integer> firstPrimeFactors = Factor.primeFactorize(this.firstNumber);
		HashMap<Integer, Integer> secondPrimeFactors = Factor.primeFactorize(this.secondNumber);
		return Factor.mergePrimeFactorMap(firstPrimeFactors, secondPrimeFactors);
	}
	

}
