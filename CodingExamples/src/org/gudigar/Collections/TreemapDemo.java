package org.gudigar.Collections;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;

public class TreemapDemo {

	/*
	 * Tree map is the implementation of Sorted map
	 * It is not a hashmap
	 * It does not follow hashing concept. 
	 * It maintains the sorting order on the keys
	 * It stored in <Key-value> pair format
	 * 
	 *                   Map(I)
	 *      SortedMap(I)          HashMap(C)
	 *      TreeMap(C)           LinkedHashMap(C)       
	 */
	public static void main(String[] args) {
		TreeMap<Integer, String> map = new TreeMap<>();
		map.put(1000, "Tom");
		map.put(2000, "Peter");
		map.put(3000, "Steve");
		map.put(11000, "Naveem");
		map.put(1400, "Robby");
		
		System.out.println(map);
		//Output - {1000=Tom, 1400=Robby, 2000=Peter, 3000=Steve, 11000=Naveem}
		
		map.forEach((k,v) -> System.out.println("Key : " + k + ", value : " + v));
		//Output
//		Key : 1000, value : Tom
//		Key : 1400, value : Robby
//		Key : 2000, value : Peter
//		Key : 3000, value : Steve
//		Key : 11000, value : Naveem
		
		//Practical implementation of Treemap
		//Find the highest salary
		System.out.println(map.lastKey());
		//Output: 11000
		
		//Find the lowest salary
		System.out.println(map.firstKey());
		//output: 1000
		
		//Give me all the keys, where emp's salary is less than 3000
		Set<Integer> keysLessThan3k = map.headMap(3000).keySet();
		System.out.println(keysLessThan3k);
		//output: [1000, 1400, 2000]
		
		//Give me all the keys, where emp's salary is greater than 3000
		Set<Integer> keysGreaterThan3k = map.tailMap(3000).keySet();
		System.out.println(keysGreaterThan3k);
		//output: [3000, 11000]
		
		
		/*
		 * Treemap maintains one red-black tree
		 * RedBlack tree is a balanced binary tree which has following rules
		 * 1. Each node has to be either red or black
		 * 2. Root should be black. this rule is omitted sometimes. Since the root can always be changed from red to black, 
		 * but not necessarily vice versa, this rule has little effect of analysis.
		 * 3. All leaves(NIL) are black
		 * 4. If the node is red, both its children has be black.
		 * 5. Every path from given node to any of its descendant NIL nodes contains same number of black nodes
		 */ 
		 
		TreeMap<Integer, String> map1 = new TreeMap<>(Comparator.reverseOrder());
		map1.put(1000, "Tom");
		map1.put(2000, "Peter");
		map1.put(3000, "Steve");
		map1.put(11000, "Naveem");
		map1.put(1400, "Robby");
		
		System.out.println(map1);
		//Output - {11000=Naveem, 3000=Steve, 2000=Peter, 1400=Robby, 1000=Tom}
	}

}
