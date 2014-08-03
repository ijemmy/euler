package com.ijemmy.euler;

import com.ijemmy.euler.lib.LCM;

/**
 * This problem is basically calculating LCM of multiple numbers
 * Given that we can calculate LCM of two numbers LCM(a,b)
 * LCM(a,b,c) = LCM(a, LCM(b, c))
 * This way, we could calculate the LCM of multiple number.
 * 
 * LCM.calculateSeq iterates through the given range and calculate the LCM of all number in the range
 * The algorithm is as followed
 * 1. Start from the upper bound of the range (20)
 * 2. Find the LCM of 20 and the next number (19) -- (LCM algorithm can be found below)
 * 3. Keep the result (380), use it for calculating LCM with the next number (18)
 * 4. Repeat until reaching the lower bound of the range
 * 
 * LCM algorithm
 * 1. Let the larger number be the testing number 
 * 2. Check if the testing number can be divided by the smaller number (20 % 19) or not
 * 3. If not, add the larger number to the testing number (20 + 20 = 40)
 * 4. Repeat step 2-3 until the testing number can be divided by the smaller number. 
 * 5. The last testing number of LCM of two numbers
 * 
 * By starting from the upper bound, we can reduce the amount of computation than starting with the lower bound.
 * e.g. When we reach number 10, the current LCM of 11-20 should be the LCM automatically because it is divisible by 20 (10*2)
 * All the LCM calculation logics are encapsulated in LCM class.
 * 
 * Note: We can calculate LCM of two number from GCD with this equation
 * GCD(a, b) × LCM(a, b) = a × b. The GCD can be found with Euclid algorithm. This can be faster in some situations.
 * However, I decide to calculate LCM directly because we know the whole range of numbers to calculate. 
 * The amount of computation is less if we start from the upper bound of the range (20) downward with LCM algorithm I use. (can be found in LCM class)
 * @author ijemmy
 */
public class Problem5 {
	public static void main(String[] args) {
		System.out.println("result = "+ LCM.calculateSeq(1,20));
	}
}
