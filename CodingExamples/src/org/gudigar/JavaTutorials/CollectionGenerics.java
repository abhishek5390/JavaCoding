package org.gudigar.JavaTutorials;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class CollectionGenerics {
	
	//collection - concept
	//Collection - Interface
	//Collections - class
	public static void main(String[] args) {
		
		//Array of 4 elements. Size of array is fixed. Here type is int as it is defined
		int a[] = new int[4];
		
		//For having array of dynamic size, we go with Collection interface and use arrayList as the implementation of Collection
		//Here type is not defined. hence is is object type, which means we can add any types of objects
		//In java 1.2 we got Collection api
		Collection values = new ArrayList();
		values.add(5);
		values.add("Six");
		values.add(7);
		
		//If we want to have Collection values of specific type, then we have to use Generics
		//in java 1.5, we got generics
		Collection<Integer> values1 = new ArrayList<Integer>();
		
		//in java 1.7, 
		Collection<Integer> values2 = new ArrayList<>();
		
		//Collection doesnt work with index number. hence we cannot add elements on a particular index.
		//Hence we can use List/Set/Map instead of Collection
		//List can have duplicate values. Order in which elements are retrieved is in Sequence
		List<Integer> values3 = new ArrayList<>();
		
		//Set cannot have duplicate values. Order in which elements are retrieved is in random
		Set<Integer> values4 = new HashSet<>();
		//In treeset order in which elements are retrieved will be in sorted (ascending)
		Set<Integer> values5 = new TreeSet<>();
		
		Map<Integer, String> m = new HashMap<>(); //Non synchorized, not thread safe
		Map<Integer, String> m1 = new Hashtable<>(); //Synchronized, Thread safe
	}

}
