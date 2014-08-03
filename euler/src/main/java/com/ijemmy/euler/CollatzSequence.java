package com.ijemmy.euler;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class CollatzSequence {
	
	static HashMap<Integer, Integer> seqLengthMap = new HashMap<Integer, Integer>();
	
	public static int getLength(int n){
		//Retrieve from cache
		if(seqLengthMap.containsKey(n)){
			return seqLengthMap.get(n);
		}
		
		List<Integer> seq = new LinkedList<Integer>(); //For caching
		seq.add(n);
		
		int currentNo = n;
		int length = 1;
		//Though it has not been proved, I will assume that ColltazSequence always ends with 1
		while(currentNo != 1){
			currentNo = CollatzSequence.getNextNumber(currentNo);
			seq.add(currentNo);//Prepend number caching
			length++;
		}
		int result = length;
		
		//Iterate the sequence backward to store lengths in cache before returning result
		ListIterator<Integer> it = seq.listIterator();
		while(it.hasNext()){
			seqLengthMap.put(it.next(), length--);
		}
		System.out.println(seqLengthMap);
		return result;
	}
	
	public static int getNextNumber(int n){
		if(n <= 1){
			throw new IllegalArgumentException("Collatz sequence does not have the next number for 1 and below ");
		}
		
		if(n % 2 == 0){
			return n / 2;
		}else{
			return n * 3 + 1;
		}
	}
}
