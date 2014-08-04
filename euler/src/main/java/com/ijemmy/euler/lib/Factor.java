package com.ijemmy.euler.lib;

import java.util.HashMap;
import java.util.Set;

/**
 * This class encapsulates calculations related to factorization
 * 
 * @author ijemmy
 *
 */
public class Factor {
	
	/**
	 * Find the prime factors and their multiplier and return back in the HashNap format
	 * For example, number 42 = 7(1) + 3(1) + 2(1)
	 * The returned HashMap will contains { 7=>1, 3=>1, 2=>1} (unsorted)
	 * @param number The number to be prime factorized
	 * @return HashMap that contains prime factors as keys and their multipliers as values
	 */
	public static HashMap<Integer, Integer> primeFactorize(int number){
		HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();
		int[] primeList = Prime.getListUntil(number);
		int currentVal = number;
		
		//Greedy algorithm to get all prime divisors their multipliers
		//It find the multipliers of greatest prime first and continue with the smaller prime number
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
	
	/**
	 * Generate a new HashMap which has merged prime factors from both parameters
	 * If the maps contain the same key, the value(multiplier) will be the sum of multiplier from both maps
	 * For example, first map is { 2=>2, 3=>1 }, the second map is {2=>1, 5=>1}
	 * The result will be { 2=>3, 3=>1, 5=>1}
	 * This method does not modify the parameter HashMaps.
	 * 
	 * @param first The first HashMap to be merged
	 * @param second The second HashMap to be merged
	 * @return A new merged HashMap
	 */
	static HashMap<Integer, Integer> mergePrimeFactorMap(HashMap<Integer, Integer> first, HashMap<Integer, Integer> second){ 
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
