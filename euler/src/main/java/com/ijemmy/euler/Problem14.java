package com.ijemmy.euler;

import com.ijemmy.euler.lib.CollatzSequence;

public class Problem14 {

	public static void main(String[] args) {
		int maxLength = 1;
		int maxNo = 1;
		for(int i = 1; i < 1000000; i++){
			int length = CollatzSequence.getLength(i);
			if(length > maxLength){
				maxLength = length;
				maxNo = i;
			}
		}
		System.out.println("The starting number, under one million, that produce longest chain is " + maxNo);
	}

}
