package com.ijemmy.euler;

import com.ijemmy.euler.lib.TriangularNumber;

public class Problem12 {

	/**
	 * Adapt the idea from the answers in http://stackoverflow.com/questions/110344/algorithm-to-calculate-the-number-of-divisors-of-a-given-number
	 * 1. Reduce problem to (n)*(n+1)/2
	 * 2. To find number of divisors, we can calculate the multiplier of each prime factors
	 * ex(1).   	Triangular Number 7th = (7)*(8)/2 = 7*4 = 2(2) * 7(1)
	 * 				Total divisor = (2+1) * (1+1) = 6
	 * ex(2).		Triangular Number 20th = (20)*(21)/2 = (10) * (21) = 2 * 3 * 5 * 7
	 * 				Total divisor = (1+1)^4 = 16
	 * 				(Can double check at http://en.wikipedia.org/wiki/Table_of_divisors)
	 * ex(3).		Triangular Number 42th = (42)*(43)/2 = (21) * (43) = 3(1) * 7(1) * 43(1)
	 * 				Total divisor = (1+1)^3 = 8
	 * 	   We'll keep the prime factor in term of HashMap. 
	 * 	   For ex(1), we'll have
	 * 			HashMap#1 = {7->1}
	 * 			HashMap#2 = {2->1}
	 * 			MergedHashMap = {2->1, 7->1}
	 *	   For ex(2), we'll have
	 * 			HashMap#1 = {2->1, 5->1}
	 * 			HashMap#2 = {7->1, 3->1}
	 * 			MergedHashMap = {2->1, 3->1, 5->1, 7->1}
	 * 
	 * Performance note: Notice that it is faster to find prime factorization of two numbers (7 and 4) instead of the whole number (28)
	 * To do prime factorization, we must find the list of all prime number until that number. This take O(sqr(N))
	 * If we calculate prime factorization of two numbers (a and b), it is O(sqr(a)) + O(sqr(b))
	 * If we calculate prime factorization of the sum, it is (O(sqr(a*b)))
	 * Performance note(2): For this problem, Caching can be used in Factor class to improve speed because we repeatedly compute the number until
	 * we find the number that 500 divisor. I do not implement cache because I want to keep the library generic and avoid adding static mutable object (HashMap) into the Factor class
	 */
	public static void main(String[] args) {
		int currentN = 1;
		TriangularNumber currentTN = new TriangularNumber(currentN) ;
		int currentNoOfDivisor = currentTN.getNumberOfDivisors();
		while(currentNoOfDivisor <= 500){
			currentN++;
			currentTN = new TriangularNumber(currentN);
			currentNoOfDivisor = currentTN.getNumberOfDivisors();
		}
		System.out.println("Value of the first triangle number to have over five hundred divisors = " + currentTN.getValue());
	}

}
