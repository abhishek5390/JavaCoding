package org.gudigar.arraysEx;

public class Segregate0And1sInArray {

	/*
	 * Segregate 0s and 1s in an array
	 * 
	 * Given an array of 0's and 1's in random order. Write a code to segregate 0's on left side and
	 * 1's on right side of array
	 * 
	 * input arr: [0,1,0,1,0,0,1]
	 * output arr: [0,0,0,0,1,1,1]
	 * 
	 * 	How to solve this problem
	 * 
	 * Traverse an array, we first move 0's on left side then move 1st on right side in single traversal
	 * 
	 * time complexity is O(n)
	 * */
	public static void main(String[] args) {
		int arr[] = {0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0};
		
		int j = 0;
		
		//[0,1,0,1,0,0,1]. length = 7
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == 0) {
				arr[j++] = arr[i]; //[0,0,0,0] j=4
			}
		}
		
		while(j<arr.length) {
			arr[j++] = 1;
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
