package com.ijemmy.euler;

public class Prime {
	//TODO: Implement caching if required
	
	public static boolean isPrime(int candidate){
		if(candidate < 2){
			return false;
		}
		
		if(candidate == 2){
			return true;
		}
		
		if(candidate % 2 == 0){
			return false;
		}
		
		//Sieve of Eratosthenes
		int limit = (int) Math.round(Math.sqrt(candidate));
		for(int i = 3; i <= limit ; i+=2){
			if(candidate % i == 0){
				return false;
			}
		}
		return true;
	}
	
	public static int[] getList(int size){
		if(size <= 0){
			throw new IllegalArgumentException("The size parameter must be positive");
		}
		
		int[] result = new int[size];
		int candidate = 2;
		int currPos = 0;
		while(currPos < result.length){
			if(isPrime(candidate)){
				result[currPos++] = candidate;
			}
			candidate = (candidate == 2)? 3 : candidate + 2;
		}
		
		return result;		
	}
	
	public static int getPrimeAt(int primeAt){
		if(primeAt <= 0){
			throw new IllegalArgumentException("The position of prime must be positive");
		}
		return Prime.getList(primeAt)[primeAt-1];
	}
}