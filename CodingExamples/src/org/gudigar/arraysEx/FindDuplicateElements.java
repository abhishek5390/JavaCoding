package org.gudigar.arraysEx;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicateElements {

	/*
	 * Java program to find duplicates in array
	 * 
	 * Input : {1,4,6,7,4,8,1};
	 * Output : {1,4}
	 * 
	 * We are going to use set data structures
	 * 
	 * set is an unordered collection of objects in which duplicate values cannot be added
	 * Set is an interface and is implemented by hashset, linkedhashset and treeset
	 */
	public static void main(String[] args) {
		int[] arr = {1,4,6,7,4,8,1};
		
		Set<Integer> set = new HashSet<>();
		
		boolean isDuplicateExists = false;
		
		for (int i = 0; i < arr.length; i++) {
			if(set.contains(arr[i])) {
				isDuplicateExists = true;
				System.out.println("Duplicate Element is : " + arr[i]);
			}else {
				set.add(arr[i]);
			}
		}
		
		if(!isDuplicateExists) {
			System.out.println(-1);
		}

	}

}
