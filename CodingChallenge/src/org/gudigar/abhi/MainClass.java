package org.gudigar.abhi;

public class MainClass {

	public static void main(String[] args) {
		
		MyLinkedList myLinkedList = new MyLinkedList(2);
		myLinkedList.insert(4);
		myLinkedList.insert(8);
		myLinkedList.insert(6);
		myLinkedList.insert(10);
		
		myLinkedList.print();
		
		System.out.println("Size of the Linked list is : " + myLinkedList.getSize());
		
		//Sorting the above list before proceeding to insert the data in the sorted list
		myLinkedList.sortList();
		
		myLinkedList.sortedInsert(3);
		myLinkedList.sortedInsert(9);
		myLinkedList.sortedInsert(1);
		myLinkedList.sortedInsert(5);	
		myLinkedList.sortedInsert(7);	
		
		myLinkedList.print();
		
		System.out.println("Size of the Linked list is : " + myLinkedList.getSize());
	}

}
