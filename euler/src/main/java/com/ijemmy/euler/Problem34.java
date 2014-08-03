package com.ijemmy.euler;

import com.ijemmy.euler.lib.CachedFactorial;

/**
 * ========================
 * Calculate the upper limit of calculation
 * ========================
 * The maximum value of factorial sum of all digit for number n is (number of digit * 9!)
 * For number with 
 * 1 digit 		-> max = 362,880
 * 2 digits 	-> max = 725,760
 * .....................
 * 7 digits 	-> max = 2,540,160
 * 
 * It is impossible that the number more than 2,540,160 is equal to the factorial sum of all digits. Becaus the factorial sum cannot be more than 2,540,160 for certain. 
 * Thus, we could use this number as the upperbound limit
 * ========================
 * @author ijemmy
 *
 */
public class Problem34 {

	public static void main(String[] args) {
		long answer = 0;
		for(int i = 3; i <= 2903040; i++){
			if(i == digitFactorialSum(i)){
				answer += i;
			}
		}
		System.out.println("Sum of all numbers which are equal to the sum of the factorial of their digits (exclude 0!, 1! and 2!) is " + answer);
	}
	
	public static int digitFactorialSum(int n){
		int currentN = n;
		int digitSum = 0;
		while(currentN > 0){
			int currentDigit = currentN % 10;
			digitSum += CachedFactorial.get(currentDigit);
			currentN /= 10;
		}
		return digitSum;
	}
	

}
