package com.ijemmy.euler;

/**
 * There is a pattern of the numbers in the corner of spiral
 * 1x1 		=> 1
 * 3x3 		=> 3, 5, 7, 9 (each of them differs by 2, starting from 3)
 * 5x5 		=> 13, 17, 21, 25 (each differs by 4, starting from 13)
 * 7x7		=> 31, 37, 43, 49 (each differs by 6, starting from 31)
 * 9x9 		=> 57, 65, 73, 81
 * 
 * Let's say we have spiral n x n
 * The top right corner of each spiral is n^2 (1, 9, 25, 49, 81, ...)
 * Diff for each corner = (n - 1)
 * Therefore, the other three corners are  n^2 -(n-1), n^2 - 2(n-1), + n^2 - 3(n-1)
 * The sum of all corners for in n x n spiral = 4n^2 - 6(n-1) 
 * 
 * Let F(n) = sum of diagonals for spiral n x n
 * We get that F(n) = 4n^2 - 6(n-1) + F(n-2) 
 * With base case F(1) = 1
 * e.g. F(9) = 4(9^2) - 6(8) + F(7)
 * With this formula, we can recursively/iteratively calculate the the sum for given spiral n x n
 * @author ijemmy
 *
 */
public class Problem28 {

	public static void main(String[] args) {
		System.out.println("sum of the numbers on the diagonals in a 1001 by 1001 spiral is " + diagonalSumOfSpiral(1001));
	}
	
	public static long diagonalSumOfSpiral(int n){
		if(n < 1 || n % 2 == 0){
			throw new IllegalArgumentException("Spiral size must be an odd positive number");
		}
		
		//Use iterative for better performance. Recursive is simpler but create a lot of call stack
		long sum = 0;
		for(int currentN = 1; currentN <= n; currentN +=2){
			sum += cornerSumOfSpiral(currentN);
		}
		
		return sum;
	}
	public static long cornerSumOfSpiral(int n){
		if(n == 1){
			return 1;
		}else{
			return 4*n*n - 6 * (n-1);
		}
		
	}

}
