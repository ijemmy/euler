package com.ijemmy.euler.lib;

/**
 * This class encapsulates calculations of LCM (Least Common Multiple)
 * 
 * @author ijemmy
 *
 */
public class LCM {
	
	/**
	 * Finding an LCM of two given parameters
	 * Note: algorithm of this method is explained in Problem5's documentation
	 * @param a The first number for LCM calculation
	 * @param b The second number for LCM calculation
	 * @return LCM of both parameters
	 */
	public static int calculate(int a, int b) {
		//LCM, by definition, should be a positive number. If one argument is 0, any positive integer (1, 2, ...)  can be LCM
		if(a == 0 || b == 0){
			throw new IllegalArgumentException("Cannot find LCM of 0");
		}
		
		int absA, absB, greater, smaller, lcm;
		
		//By definition, LCM is positive and can be calculated from negative numbers (but the result will be positive)
		absA = Math.abs(a);
		absB = Math.abs(b);
		
		//Find out which number is greater
		if (absA >= absB) {
			greater = absA;
			smaller = absB;
		} else {
			greater = absB;
			smaller = absA;
		}
		
		//Keep adding the testing value with greater number (making the next multiple). Until it can be divided by the smaller number
		lcm = greater;
		while (lcm % smaller != 0) {
			lcm += greater;
		}
		
		return lcm;

	}

	/**
	 * Calculate LCM of all number of the given range
	 * @param from Starting of the range (inclusive)
	 * @param to End of the range (inclusive)
	 * @return LCM of all numbers in the range
	 */
	public static int calculateSeq(int from, int to) {
		if(from <= 0){
			throw new IllegalArgumentException("Only positive range is allowed");
		}
		if(from > to){ 
			throw new IllegalArgumentException("The provided range is invalid");
		}
		if(from == to){
			throw new IllegalArgumentException("The range must contain more than 1 number (inclusive)");
		}
		
		int totalLCM = to;
		//By starting from the largest number, it is calculated less than starting from the lower number
		for (int i = to - 1; i >= from; i--) {
			totalLCM = LCM.calculate(totalLCM, i);
		}

		return totalLCM;
	}
}
