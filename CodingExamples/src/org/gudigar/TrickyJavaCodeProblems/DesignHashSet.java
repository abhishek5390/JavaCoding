package org.gudigar.TrickyJavaCodeProblems;

/*
 * Design HashSet
	Design hashset without using any built in hash table libraries
	to be specific, your design should include these functions.
	
	add(value): insert a value into HashSet
	contains(value) : Return whether value exists in Hashset or not
	remove(value): remove a value in the hashset. If the value does not exist in the Hashset, do nothing
	
	Assumptions:
	All values will be in the range of 0-1000000
	No of operations will be in range of 1-100000
	Please dont use built in set implementations.
 */
public class DesignHashSet {
	
	/*
	 * Simple Implementation
		Create a boolean array of size 1000001
		If someone adds at index 5, set true at index 5 in boolean array. 
		Adding number n is setting arr[n] = true
		Removing number n is setting arr[n] = false
		Contains a number n is returning arr[n]
		
		Time Complexity 
		O(1)
		Space Complexity
		O(N)

	 */
	boolean[] arr;
	public DesignHashSet() {
		arr = new boolean[1000001];
	}

	public void add(int key) {
		arr[key] = true;
	}
	
	public void remove(int key) {
		arr[key] = false;
	}

	public boolean contains(int key) {
	    return arr[key];
	}
}
