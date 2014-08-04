package com.ijemmy.euler.lib;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * This class encapsulates calculations related Collatz Sequence
 * It implements caching feature for calculating the sequence's length
 * 
 * @author ijemmy
 *
 */
public class CollatzSequence {
	
	private static HashMap<Long, Integer> seqLengthMap = new HashMap<Long, Integer>();
	
	public static int getLength(long n){
		//Retrieve from cache
		if(seqLengthMap.containsKey(n)){
			return seqLengthMap.get(n);
		}
		
		List<Long> seq = new LinkedList<Long>(); //For caching
		seq.add(n);
		
		long currentNo = n;
		int length = 1;
		//Though it has not been proved, I will assume that ColltazSequence always ends with 1
		while(currentNo != 1){
			currentNo = CollatzSequence.getNextNumber(currentNo);
			seq.add(currentNo);//Prepend number caching
			length++;
		}
		int result = length;
		
		//Iterate the sequence backward to store lengths in cache before returning result
		ListIterator<Long> it = seq.listIterator();
		while(it.hasNext()){
			seqLengthMap.put(it.next(), length--);
		}
		return result;
	}
	
	/**
	 * Get the next number in the Collatz Sequence
	 * @param n Current number
	 * @return The next number in Collatz sequence
	 */
	public static long getNextNumber(long n){
		if(n <= 1){
			throw new IllegalArgumentException("Collatz sequence does not have the next number for 1 and below ");
		}
		
		if(n % 2 == 0){
			return n / 2;
		}else{
			return n * 3 + 1;
		}
	}
	
	/**
	 * User can specify the map to be used for caching with this method. The cache is used for sequence length calculation
	 * @param map A map to be used for caching
	 */
	static void setCache(HashMap<Long, Integer> map){
		seqLengthMap = map;
	}
	
	/**
	 * Clear the cached values
	 */
	static void clearCache(){
		seqLengthMap.clear();
	}
}
