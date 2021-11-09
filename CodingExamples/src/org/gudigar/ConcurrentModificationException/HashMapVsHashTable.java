package org.gudigar.ConcurrentModificationException;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapVsHashTable {

	public static void main(String[] args) {
		//We have 4 classes which implements Map
		//HashMap, Hashtable, TreeHashmap, Linkedhashmap
		
		//HashMap
		//introduced in java 1.2
		//not threadsafe and unsynchronized
		//Faster
		//works with single thread
		//Allows one null key, and can have multiple null values
		//Insertion order is not fixed, it may change
		
		Map<String, String> phoneBook = new HashMap<>();
		phoneBook.put("ABC", "111111");
		phoneBook.put("DEF", "222222");
		phoneBook.put("GHI", "333333");
		phoneBook.put("JKL", "444444");
		phoneBook.put("MNO", "555555");
		
		//print only specific value
		System.out.println(phoneBook.get("ABC"));
		
		//print all the values - 1st approach
		//to get all the keys
		Set<String> keySet = phoneBook.keySet();
		//now to print key-values
		for(String i : keySet) {
			System.out.println(i + " : " + phoneBook.get(i));
		}
		
		//print all the values - 2nd approach
		//Entry is a interface in map (nested). Entry is a key value pair
		Set<Map.Entry<String, String>> values = phoneBook.entrySet();
		for(Map.Entry<String, String> e : values) {
			System.out.println(e.getKey() + " - " + e.getValue());
		}
		
		//Hashtable
		//was there since java was introduced
		//every method in hashtable is thread safe and is synchronized
		//Slow performance
		//Works with multiple threads
		//Does not allow null key and null values
		//Lock is applied on object level. 
		//If one thread is accessing the object, other thread cannot access until first thread releases the lock
		//Insertion order is not fixed, it may change
		
		//LinkedHashMap
		//Insertion order is fixed
		
		//Treehashmap
		//Hashmap in sorted order, where all elements are sorted 
		
		//synchronizedHashmap
		//Thread-safe
		//slow performance
		//null key and null values are allowed
		//Lock is applied on object level. 
		//If one thread is accessing the object, other thread cannot access until first thread releases the lock
		Map<String, String> map1 = new HashMap<>();
		map1.put("1", "AAA");
		map1.put("2", "BBB");
		map1.put("3", "CCC");
		map1.put("4", "DDD");
		//create synchronizedMap from the above map
		Map<String, String> synchronizedMap = Collections.synchronizedMap(map1);
		System.out.println(synchronizedMap);
		
		//ConcurrentHashMap
		//introduced after jdk1.5
		//Thread-safe
		//Faster performance. 
		//null key and values are not allowed.
		//Hashmap divided into 16 segments. 
		//Lock is applied on segment level only for write/update operation. No lock is applied for read operation
		//this map does not throw any ConcurrentModificationException
		ConcurrentHashMap<String, String> concurrentMap = new ConcurrentHashMap<>();
		concurrentMap.put("A", "Java");
		concurrentMap.put("B", "Python");
		concurrentMap.put("C", "Ruby");
		System.out.println(concurrentMap.get("A"));
	}

}
