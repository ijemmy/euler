/**
 * 
 */
package com.ijemmy.euler;

import com.ijemmy.euler.lib.Quadratic;

/**
 * @author ijemmy
 *
 */
public class Problem27 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int bestA = -1001;
		int bestB = -1001;
		int maxNoOfPrime = -1;
		for(int a = -1000; a <= 1000; a++){
			for(int b = -1000; b <= 1000; b++){
				Quadratic q = new Quadratic(a, b);
				int noOfPrime = q.getMaxPrime();
				if(noOfPrime > maxNoOfPrime){
					bestA = a;
					bestB = b;
					maxNoOfPrime = noOfPrime;
				}
			}
		}
		
		System.out.println("The coefficients, a and b, for the quadratic expression that produces the maximum number of primes for consecutive values of n, starting with n = 0 is " + bestA + ", " + bestB);
		System.out.println("The maximum n that is still prime is " + maxNoOfPrime);
		System.out.println("The product of them is " + (bestA*bestB));
	}

}
