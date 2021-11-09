package org.gudigar.ConcurrentModificationException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ComparableVsComparator {
	
	
	public static void main(String[] args) {
		List<Laptop> laps = new ArrayList<Laptop>();
		
		laps.add(new Laptop("Dell", 16, 800));
		laps.add(new Laptop("Apple", 8, 1200));
		laps.add(new Laptop("Samsung", 20, 1800));
		laps.add(new Laptop("Acer", 12, 700));
		
		//when we have list of integers or strings, we can easily sort the list just by calling
		//Integer, String class implements comparable. hence sorting list of integer or strings doesnt need to separate comparator to define sorting logic
		//Collections.sort(list)
		
		
		//What is comparable?
		
		//sort method will accept those things which are comparable
		//In order to sort the laps like Collections.sort(laps), we need to make Laptop implement Comparable<Laptop>
		//this will make sure all the values in that list (laps) are comparable. And then we can have own logic in Laptop class 
		//in the unimplemented method called compareTo(). U define logic in compareTo() where you specify, when to swap and when not to
		/*
		Collections.sort(laps);
		*/
		
		//What is comparator?
		
		//We use comparator is 2 situations
		//Situation 1 : What if Laptop is not implementing any comparable interface. 
		//Then Sort will take 2 parameters - List and comparator. 
		//then we can specify the comparing logic using comparator
		
		//Situation 2: Even though Laptop is implementing comparable interface and if we want to want sort the list based on some other parameters
		
		//since we cannot get object of comparator interface directly, we have to define class inside (anonymous class). 
		//Comparator will have method called compare(T o1, T o2)
		Comparator<Laptop> com = new Comparator<Laptop>() {

			@Override
			public int compare(Laptop l1, Laptop l2) {
				if(l1.getPrice() > l2.getPrice()) {
					return 1;
				}else {
					return -1;
				}
					
			}
			
		};
		Collections.sort(laps, com);
		
		//printing sorted laptop values from the list
		for (Laptop l : laps) {
			System.out.println(l);
		}
		
		
		
	}

}
