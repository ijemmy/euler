package com.ijemmy.euler;

public class LCM {
	public static int calculate(int a, int b) {
		//LCM, by definition, should be a positive number. If one argument is 0, any positive integer (1, 2, ...)  can be LCM
		if(a == 0 || b == 0){
			throw new IllegalArgumentException("Cannot find LCM of 0");
		}
		
		int absA, absB, more, less, lcm;
		absA = Math.abs(a);
		absB = Math.abs(b);
			
		if (absA >= absB) {
			more = absA;
			less = absB;
		} else {
			more = absB;
			less = absA;
		}

		lcm = more;
		
		while (lcm % less != 0) {
			lcm += more;
		}
		
		return lcm;

	}

	// TODO: overload with BigInt version?
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
		for (int i = to - 1; i >= from; i--) {
			totalLCM = LCM.calculate(totalLCM, i);
		}

		return totalLCM;

	}
}
