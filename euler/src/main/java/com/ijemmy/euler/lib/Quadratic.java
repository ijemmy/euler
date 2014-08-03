package com.ijemmy.euler.lib;

public class Quadratic {
	private long a, b;
	
	public Quadratic(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public long compute(int n){
		long result = (long) Math.pow(n, 2);
		result += a*n + b;
		return result;
	}
	
	public int getMaxPrime(){
		int i = -1;
		boolean isCurrentIPrime = true;
		
		while(isCurrentIPrime){
			i++;
			isCurrentIPrime = Prime.isPrime(this.compute(i));
		}
		
		return i-1;
	}

}
