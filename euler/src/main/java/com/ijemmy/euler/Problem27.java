/**
 * 
 */
package com.ijemmy.euler;

import com.ijemmy.euler.lib.Quadratic;

/**
 * Algorithm (Brute force):
 * 1. Iterate all combination of a and b between -1000 and 1000
 * 2. For each combination, calculate the highest possible N that can give prime values
 * 2.1 Starting testing from 0 
 * 2.2 Check if the testing number is prime. If it is, continue with the next number
 * 2.3 When the testing number is not prime, we can return testing number -1 as N 
 * 3. If N is more the maximum number, remember the combination of a, b
 * 4. After iterate through all combination of a and b, calculate the product of a and b with maximum number
 * 
 * @author ijemmy
 *
 */
public class Problem27 {

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
