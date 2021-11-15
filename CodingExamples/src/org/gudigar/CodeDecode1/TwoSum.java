package org.gudigar.CodeDecode1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author abhishek.gudigar
 * Given an array of integers nums and an integer target, return indices of the two numbers 
 * such that they add up to  the given required target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice at all.
	
	You can return the answer in any order is the flexibility given in two sum leetcode problem.
	
	Example 1 as per two sum leetcode :
	
	Input: nums = [2,7,11,15], target = 9
	Output: [0,1]
	Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 */
public class TwoSum {

	public static void main(String[] args) {
		int[] intArray = {2,7,11,15};
		int target = 9;
		
		int[] output;
		//output = getIndexes(intArray, target);
		//output = getIndexesUsingHashMap(intArray, target);
		output = getIndexesUsingHashMap1(intArray, target);
		System.out.println(Arrays.toString(output));
	}

	private static int[] getIndexes(int[] intArray, int target) {
		for (int i = 0; i < intArray.length; i++) { 
			for (int j = i+1; j < intArray.length; j++) {
				if(intArray[i] + intArray[j] == target) {
					return new int[] {i,j};
				}
			}
			
		}
		throw new IllegalArgumentException("No Such numbers found");	
	}
	
	private static int[] getIndexesUsingHashMap(int[] intArray, int target) {
		Map<Integer, Integer> input = new HashMap<Integer, Integer>();
		for (int i = 0; i < intArray.length; i++) {
			input.put(intArray[i], i);
			// {2,0} {7,1} {11,2} {15,3}
		}
		
		for (int i = 0; i < intArray.length; i++) {
			int secondNumber = target - intArray[i]; //17-2 = 15
			
			if(input.containsKey(secondNumber) && input.get(secondNumber) != i) {
				return new int[] {i, input.get(secondNumber)};
				//{0,3}
			}
		}
		throw new IllegalArgumentException("No Such numbers found");
	}
	
	private static int[] getIndexesUsingHashMap1(int[] intArray, int target) {
		Map<Integer, Integer> input = new HashMap<Integer, Integer>();
		//intArray = {2,7,11,15};
		//target = 17
		for (int i = 0; i < intArray.length; i++) {
			int secondNumber = target - intArray[i]; //17-2=15, 17-7=10, 17-11=6, 17-15=2
			
			if(input.containsKey(secondNumber)) {
				return new int[] {input.get(secondNumber), i};
				//{0,3}
			}
			
			input.put(intArray[i], i);
		}
		throw new IllegalArgumentException("No Such numbers found");
	}

}
