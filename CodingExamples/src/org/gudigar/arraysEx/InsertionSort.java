package org.gudigar.arraysEx;

public class InsertionSort {

	/*
	 * How insertion sort works
	 * 
	 * Unsorted array {5, 4, 2, 9, 1}
	 * 
	 * How can we sort unsorted array using insertion sort
	 * 1. Traverse an array from left to right
	 * 2. Take each items of an array and compare it to items on its left
	 * 3. insert it to its correct position
	 */
	public static void main(String[] args) {

		int[] arr = {5, 4, 2, 9, 1};
		int temp;
		int j = 0;
		//{2, 4, 5, 9, 1};
		for (int i = 1; i < arr.length; i++) {
			//i=4
			temp = arr[i]; // temp = arr[4] = 1
			j = i-1; // j = 3
			
			//9 > 1
			while(j >= 0 && arr[j] > temp) {
				arr[j+1] = arr[j]; //arr[4] = 9
				j = j - 1; //j = -1
			}
			
			arr[j+1] = temp; //arr[1] = 2
		}

	}

}
