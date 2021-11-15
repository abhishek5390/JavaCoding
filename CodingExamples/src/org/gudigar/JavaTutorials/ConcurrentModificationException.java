package org.gudigar.JavaTutorials;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModificationException {

	//How to fix concurrentModificationException while iterating elements from arraylist in java??
	//We cannot iterate arraylist through some for loop and remove an element based on some condition. Because it will throw CME
	//right way to remove elements from arraylist is to use iterator.remove() method. Hence CME is not thrown. 
	//because it will update the counters and variables used by iterators like modCount, which means modification is done by iterator itself
	
	public static void main(String[] args) {
		List<String> mobiles = new ArrayList<>();
		mobiles.add("Redmi");
		mobiles.add("Samsung");
		mobiles.add("Apple");
		mobiles.add("Realme");
		
		//printing arraylist before removing any element
		System.out.println(mobiles);
		
		//removing element using ArrayList's remove method during iteration
		//This will throw CME
		
		for(String mobile : mobiles) {
			if(mobile.equals("Redmi")) {
				mobiles.remove(mobile);
			}
		}
		
		
		//to fix this issue, we need to use Iterator remove method
		Iterator<String> itr = mobiles.iterator();
		while(itr.hasNext()) {
			String mobile = itr.next();
			if(mobile.equals("Redmi")) {
				itr.remove();
			}
		}
		//printing arraylist after removing any element
		System.out.println(mobiles);
	}

}
