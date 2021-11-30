package org.gudigar.arraysEx;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RemoveDuplicateElementsFromUnsortedArray {

	/*
	 * Remove duplicate elements from unsorted array
	 * Input : {5, 1, 2, 6, 4, 4, 5}
	 * Output : {5, 1, 2, 6, 4}
	 * 
	 * 
	 */
	public static void main(String[] args) {
		
		int[] arr = {5, 1, 2, 6, 4, 4, 5};
		
		//removeDuplicatesUsingSorting(arr);
		
		//removeDuplicatesUsingHashing(arr);
		
		removeDuplicatesUsingSet(arr);
	}

	/*
	 * Using set data structure
	 * time complexity O(n)
	 */
	private static void removeDuplicatesUsingSet(int[] arr) {
		Set<Integer> numSet = new HashSet<Integer>();
		
		for (int i = 0; i < arr.length; i++) {
				numSet.add(arr[i]);
			
		}
		
		numSet.forEach(s -> System.out.print(s + " "));
	}

	/*
	 * using hashmap
	 * Create a hashmap of array elements and its count. then traverse a map and prints its key
	 * time complexity O(n)
	 */
	private static void removeDuplicatesUsingHashing(int[] arr) {
		Map<Integer, Integer> nummap = new HashMap<>();
		
		for (int i = 0; i < arr.length; i++) {
			if(nummap.containsKey(arr[i])) {
				nummap.put(arr[i], nummap.get(arr[i]) + 1);
			}else {
				nummap.put(arr[i], 1); //5-1 1-1, 2-1, 6-1, 4-1
			}
		}
		
		nummap.forEach((k,v) -> System.out.print(k + " "));
		
	}

	/*
	 * First sort the array and then remove duplicate elements from array
	 * Time complexity is O(nlogn)
	 */
	private static void removeDuplicatesUsingSorting(int[] arr) {
		Arrays.sort(arr);
		
		int j = 0;
		//Traverse through the array
		//{5, 1, 2, 6, 4, 4, 5}
		//{1, 2, 4, 4, 5, 5, 6} // sorted array
		for (int i = 0; i < arr.length-1; i++) {
			if(arr[i] != arr[i+1]) {
				arr[j++] = arr[i]; //1, 2, 4, 5. j=4
			}
		}
		
		//print last element
		arr[j++] = arr[arr.length-1];//1, 2, 4, 5, 6. j=5
		
		for (int i = 0; i < j; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
