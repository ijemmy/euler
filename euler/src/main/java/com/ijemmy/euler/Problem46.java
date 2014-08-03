/**
 * 
 */
package com.ijemmy.euler;

import com.ijemmy.euler.lib.Prime;

/**
 * We will iterate through all odd number until we find the number that break Goldbach's conjecture
 * For each number, we will
 * 1. Check that it is not a prime number (must be composite)
 * 2. Iterate through a list of prime numbers with smaller value than the current number
 * 2.1 Subtract the number with the prime number and divide by 2
 * 2.2 Determine if this number is a square root of another integer
 * If there is a number that do not pass the test in 2.2 for all prime. That number is the smallest one that break Goldbach's conjecture
 * 
 * Note: There is a faster way to determine if an integer is a square of another integer
 * The discussion can be found here
 * http://stackoverflow.com/questions/295579/fastest-way-to-determine-if-an-integers-square-root-is-an-integer
 * 
 * @author ijemmy
 *
 */
public class Problem46 {

	public static void main(String[] args) {
		int i = 3;
		boolean foundNonGoldBach = false;
		int smallestNonGoldBach = -1;
		while(!foundNonGoldBach){
			boolean foundGoldBach = false;
			
			if(Prime.isPrime(i)){
				i += 2;
				continue;
			}
			
			int[] primeList = Prime.getListUntil(i); ///Can implement caching to improve performance
			for(int prime : primeList){
				int testNumber = (i - prime) / 2;
				if(isSquare(testNumber)){
					foundGoldBach = true;
				}
			}
			
			if(!foundGoldBach){
				foundNonGoldBach = true;
				smallestNonGoldBach = i;
			}
			
			i += 2;
		}
		
		System.out.println("The smallest odd composite number that betrays Christian Goldbach is " + smallestNonGoldBach);
	}
	
	public static boolean isSquare(int n){
		if (n < 0){
		    return false;
		}
		long sqrt = (long)Math.sqrt(n);
		return sqrt*sqrt == n;
	}

}
