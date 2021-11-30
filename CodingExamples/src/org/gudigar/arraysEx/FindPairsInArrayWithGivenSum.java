package org.gudigar.arraysEx;

public class FindPairsInArrayWithGivenSum {

	public static void main(String[] args) {
		//Find pairs with given sum in sorted array
		
		//Given an array A of size N
		//We need to find all the pairs in the array the sum to a number equal to K
		//If no such pair exists, then output will be -1
		
		//Array elements are distinct and in sorted array
		
		//arr[] = {1,2,3,4,5,6,7};
		//Sum = 9
		
//		output:
//			Pair(2,7)
//			pair(3,6)
//			Pair(4,5)
		
		int arr[] = {1,3,5,7,9,11,13};
		int sum = 12;
		
		int low = 0;
		int high = arr.length - 1;
		while(low<high) {
			if(arr[low] + arr[high] > sum) {
				high--;
			}else if(arr[low] + arr[high] < sum){
				low++;
			}else if(arr[low] + arr[high] == sum){
				System.out.println("Pair(" + arr[low] + "," + arr[high] + ")");
				high--;
				low++;
			}
		}
	}

}
