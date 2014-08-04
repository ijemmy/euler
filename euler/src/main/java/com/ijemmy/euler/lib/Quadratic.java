package com.ijemmy.euler.lib;


/**
 * This class represents a quadratic equation. It provides related calculation
 * The object in this class is immutable.
 * 
 * @author ijemmy
 *
 */
public class Quadratic {
	private long a, b;
	
	/**
	 * Construct an quadratic in term of n^2 + a*n + b
	 * @param a The coefficient for the first degree
	 * @param b The coefficient for the second degree
	 */
	public Quadratic(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	/**
	 * Compute the value of quadratic equation for the given n
	 * @param n
	 * @return Value of the equation for given n
	 */
	public long compute(int n){
		long result = (long) Math.pow(n, 2);
		result += a*n + b;
		return result;
	}
	
	/**
	 * Get the maximum n that still provides prime value with this quadratic equation from 0 to n
	 * @return
	 */
	public int getMaxPrime(){
		int i = -1;
		boolean isCurrentIPrime = true;
		
		while(isCurrentIPrime){
			i++;
			isCurrentIPrime = Prime.isPrime(this.compute(i));
		}
		
		return i-1;
	}

}
