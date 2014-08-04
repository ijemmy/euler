package com.ijemmy.euler.lib;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * This class encapsulates calculations of prime numbers
 * 
 * @author ijemmy
 *
 */
public class Prime {
	
	/**
	 * Find out if the given number is prime or not
	 * @param n The number to be tested
	 * @return A boolean indicate whether the parameter is prime or not
	 */
	public static boolean isPrime(long n){
		if(n < 2){
			return false;
		}
		
		//2 is the only even prime
		if(n == 2){
			return true;
		}
		
		//All even numbers are not prime
		if(n % 2 == 0 ){
			return false;
		}
		
		//Adapted from sieve of Eratosthenes
		int limit = (int) Math.round(Math.sqrt(n));
		//Only odd number is used to check
		for(int i = 3; i <= limit ; i+=2){ 
			if(n % i == 0){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Get a list of prime number until the given size
	 * @param size The limit size of the prime list
	 * @return Array of prime number until the given size
	 */
	public static int[] getList(int size){
		if(size <= 0){
			throw new IllegalArgumentException("The size parameter must be positive");
		}
		
		int[] result = new int[size];
		int candidate = 2;
		int currPos = 0;
		
		//Fill the array with prime number until it is full
		while(currPos < result.length){
			if(isPrime(candidate)){
				result[currPos++] = candidate;
			}
			candidate = (candidate == 2)? 3 : candidate + 2;
		}
		
		return result;		
	}
	
	/**
	 * Get a list of prime number until the given limit number 
	 * @param limit Upper limit of the prime number in the returned list
	 * @return List of prime numbers until the given limit
	 */
	public static int[] getListUntil(int limit){
		//Since we do not know the size, we use List instead of an array
		//LinekdList is used be cause we only append and iterate sequentially, no index access
		List<Integer> result = new LinkedList<Integer>();
		int candidate = 2;
		while(candidate <= limit){
			if(isPrime(candidate)){
				result.add(candidate);
			}
			candidate = (candidate == 2)? 3 : candidate + 2;
		}
		
		//Convert List<Integer> to int[]
		int[] intResult = new int[result.size()];
		Iterator<Integer> resultIt = result.iterator();
		for(int i = 0; i < intResult.length; i++){
			intResult[i] = resultIt.next();
		}
		
		return intResult;		
	}
	
	/**
	 * Get the n th prime number
	 * @param n 
	 * @return n th prime number
	 */
	public static int getPrimeAt(int n){
		if(n <= 0){
			throw new IllegalArgumentException("The position of prime must be positive");
		}
		return Prime.getList(n)[n-1];
	}
	
	/**
	 * Calculate the summation of all prime numbers below the given upper bound
	 * @param upperBound The upper limit of the prime number to be summed(exclusive)
	 * @return The sum of all prime numbers which are less than upper bound
	 */
	public static BigInteger sumBelow(int upperBound){
		BigInteger sum = BigInteger.valueOf(0);
		int candidate = 2;
		while(candidate < upperBound){
			if(isPrime(candidate)){		
				sum = sum.add(BigInteger.valueOf(candidate));
			}
			candidate = (candidate == 2)? 3 : candidate + 2;
		}
		return sum;
	}
}
