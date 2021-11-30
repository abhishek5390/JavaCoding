package org.gudigar.TrickyJavaCodeProblems;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FindWhoKilledWhom {

	public static void main(String[] args) {
		int noOfPeople = 6;
		List<Integer> listOfPeople = new ArrayList<>();
		for (int i = 0; i < noOfPeople; i++) {
			listOfPeople.add(i+1);
		}
		
		System.out.println(listOfPeople);
		
		boolean kill = false;
		
		while(listOfPeople.size() != 1) {
			Iterator<Integer> iterator = listOfPeople.iterator();
			while(iterator.hasNext()) {
				iterator.next();
				if(kill) {
					iterator.remove();
					kill = false;
				}else {
					kill = true;
				}
			}
		}
		
		
		System.out.println("Safe position is : " + listOfPeople.get(0));
	}
}
