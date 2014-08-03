package com.ijemmy.euler.lib;

import java.util.HashMap;
import java.util.Set;

public class Factor {
	public static HashMap<Integer, Integer> primeFactorize(int number){
		HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();
		int[] primeList = Prime.getListUntil(number);
		int currentVal = number;
		
		//Greedy algorithm to get all prime divisors their multipliers
		for(int i = primeList.length-1; i >= 0; i--){
			int multiplier = 0;
			int currentPrime = primeList[i];
			while(currentVal % currentPrime == 0){
				currentVal = currentVal/currentPrime;
				multiplier++;
			}
			
			if(multiplier > 0){
				result.put(currentPrime, multiplier);
			}
		}
		
		return result;
	}
	
	public static HashMap<Integer, Integer> mergePrimeFactorMap(HashMap<Integer, Integer> first, HashMap<Integer, Integer> second){ 
		HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();
		result.putAll(first);
		Set<Integer> secondKS = second.keySet();
		for(Integer key : secondKS){
			//If there is the same prime, the multiplier should add up
			if(result.containsKey(key)){
				Integer mult1 = result.get(key);
				Integer mult2 = second.get(key);
				result.put(key, mult1 + mult2);
			}else{
				result.put(key, second.get(key));
			}
		}
		return result;
	}
}
