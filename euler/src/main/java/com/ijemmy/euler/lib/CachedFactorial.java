package com.ijemmy.euler.lib;

import java.util.HashMap;
import java.util.Map;

public class CachedFactorial {
	static Map<Integer, Long> cacheMap = new HashMap<Integer, Long>(); 
	
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
	
	public static void setCache(Map<Integer, Long> map){
		cacheMap = map;
	}
	
	public static void clearCache(){
		cacheMap.clear();
	}
}
