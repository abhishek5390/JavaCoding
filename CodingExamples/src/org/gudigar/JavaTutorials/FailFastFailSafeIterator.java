package org.gudigar.JavaTutorials;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class FailFastFailSafeIterator {

	/*
	 * Fail fast iterators & Fail Safe iterators
	 *
	 * these iterators in java help us determine whether out collection or class is applicable for concurrent modification or not
	 * While iterating the collection object using Iterator interface, when we modify the collection object, it will throw
	 * ConcurrentModificationException. This is the example of FailFast iterator
	 * While using Fail safe Iterator, it will not throw CME
	 * 
	 *      Fail Fast Iterator										Fail Safe Iterator
	 * 1. Directly work on collection object				Work on the clone or copy of collection object
	 * 2. if we modify collection object during				It does not throw CME
	 * iteration, it will throw CME
	 * 3. Doesn't require extra memory						Need extra memory. Consume heap
	 * 4. Iterator used in map, arraylist, hashmap			Iterator used in ConcurrentMap, ConcurrentHashMap
	 *                                                      ConcurrentLinkedQueue, CopyonWriteArrayList etc
	 */
	public static void main(String[] args) {
		
		//Fail-fast iterator
		Map<String, Integer> map = new HashMap<>();
		map.put("AAA", 1);
		map.put("BBB", 2);
		map.put("CCC", 3);
		
		Iterator<Entry<String, Integer>> itr = map.entrySet().iterator();
		while (itr.hasNext()) {
			Entry<String, Integer> pair = itr.next();
			System.out.println("Key : " + pair.getKey() + ", value : " + pair.getValue());
			
			//map.put("DDD", 4);
			//Output
//			Key : AAA, value : 1
//			Exception in thread "main" java.util.ConcurrentModificationException
		}
		
		List<String> cities = new ArrayList<>();
		cities.add("Kolkotta");
		cities.add("Bangalore");
		cities.add("Delhi");
		cities.add("Hyderbad");
		
		//removing element using ArrayList's remove method during iteration
		//This will throw CME
		Iterator<String> iterator = cities.iterator();
		while(iterator.hasNext()) {
			if(iterator.next() == "Bangalore") {
				cities.remove(1);
			}
			System.out.println(cities);
		}
		//Output
//		[Kolkotta, Bangalore, Delhi, Hyderbad]
//		[Kolkotta, Delhi, Hyderbad]
//		Exception in thread "main" java.util.ConcurrentModificationException
		
		//Fail-safe iterator
		ConcurrentHashMap<String, Integer> map1 = new ConcurrentHashMap<>();
		map1.put("AAA", 1);
		map1.put("BBB", 2);
		map1.put("CCC", 3);
		
		Iterator<Entry<String, Integer>> itr1 = map1.entrySet().iterator();
		while (itr1.hasNext()) {
			Entry<String, Integer> pair = itr1.next();
			System.out.println("Key : " + pair.getKey() + ", value : " + pair.getValue());
			
			map1.put("DDD", 4);
			//Output
//			Key : AAA, value : 1
//			Key : CCC, value : 3
//			Key : BBB, value : 2
//			Key : DDD, value : 4

		}
	}
}
