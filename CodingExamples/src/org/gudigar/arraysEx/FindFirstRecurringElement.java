package org.gudigar.arraysEx;

public class FindFirstRecurringElement {

	public static void main(String[] args) {
//		int[] arr = {10,5,3,4,3,5,6}
//		output - 5
//
//		{6,10,5,4,9,12,4,6,10}
//		output - 6
		
		int[] arr = {6,10,5,4,9,12,4,6,10};
		
		outer: for (int i = 0; i < arr.length; i++) {
			inner: for (int j = i+1; j < arr.length; j++) {
				if(arr[i] == arr[j] ) {
					System.out.println(arr[i]);
					break outer;
				}
			}
		}

	}

}
