package com.ijemmy.euler;

import com.ijemmy.euler.lib.CollatzSequence;

/**
 * Algorithm:
 * 1. Repeat the number from 1 to 1000000
 * 2. For each number, calculate the length with CollatzSequence
 * 3. If the length is more than max length, remember the number and the length
 * 
 * To improve the performance, CollatzSequence.getLength() implements the cahcing with HashMap
 * If we calculate -> 16 => 8 => 4 => 2 => 1
 * The length of 16(5), 8(4), 4(3), 2(2), and 1(1) are all kept in the map which can be access with O(1)
 * This greatly reduce the number of computation because we repeatedly calculate the length of every starting number
 * 
 * @author ijemmy
 *
 */
public class Problem14 {

	public static void main(String[] args) {
		int maxLength = 1;
		int maxNo = 1;
		for(int i = 1; i < 1000000; i++){
			int length = CollatzSequence.getLength(i); //This method uses caching to improve performance
			
			//Keep the number with longest sequence
			if(length > maxLength){
				maxLength = length;
				maxNo = i;
			}
		}
		System.out.println("The starting number, under one million, that produce longest chain is " + maxNo);
	}

}
