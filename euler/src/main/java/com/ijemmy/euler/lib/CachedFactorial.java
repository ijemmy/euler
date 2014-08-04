package com.ijemmy.euler.lib;

import java.util.HashMap;
import java.util.Map;

/**
 * This class encapsulates calculations of factorial numbers.
 * Caching is used to speed up the calculation of the previously calculated number.
 * @author ijemmy
 *
 */
public class CachedFactorial {
	/**
	 * A map used for caching the previously calculated factorial
	 */
	private static Map<Integer, Long> cacheMap = new HashMap<Integer, Long>(); 
	
	/**
	 * Calculate the n th facatorial number.
	 * If the factorial number has been calculated before, a cached value will be used 
	 * @param n Number for calculating factorial
	 * @return A factorial value of given parameter
	 */
	public static long get(int n){
		if(n < 0){
			throw new IllegalArgumentException("Only 0 or positive numbers are allowed for factorial");
		}
		
		if(cacheMap.containsKey(n)){
			return cacheMap.get(n);
		}else{
		
			long result = 1;
			for(int i = 1; i <= n; i++){
				result *= i;
			}
			
			cacheMap.put(n, result);
			return result;
		}
	}
	
	/**
	 * User can specify the map to be used for caching with this method.
	 * @param map A map to be used for caching
	 */
	static void setCache(Map<Integer, Long> map){
		cacheMap = map;
	}
	
	/**
	 * Clear the cached values
	 */
	static void clearCache(){
		cacheMap.clear();
	}
}
