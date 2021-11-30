package org.gudigar.abhi;

public class MyLinkedList {
	
	Node head;
	
	//This constructor is taking no arguments (i.e. an empty list)
	public MyLinkedList() {
	}
	
	//This constructor taking an integer argument (i.e. the first member of the list)
	public MyLinkedList(int val) {
		head = new Node(val);
	}
	
	public void insert(int val) {
		Node newNode = new Node(val);
		
		//If linked list is empty
		if(head == null) {
			head = newNode;
		}else {
			Node curr = head;
			//Loop goes on until next node reference of current node is not null
			while(curr.next != null) {
				curr = curr.next;
			}
			//Once the next node reference of current node is null, it will add newNode at the end of linked list. 
			curr.next = newNode;
		}
	}
	
	public void print() {
		Node temp = head;
		//If linked list is empty, then no need to print anything
		if(temp != null) {
			//Iteration goes on until the next reference of temp is null
			while(temp.next != null) {
				System.out.print(temp.data + " " );
				temp = temp.next;
			}
			//Since last node data is skipped in the above loop, because of null next reference, 
			//the data is printed here explicitly
			System.out.print(temp.data + " \n");
		}	
	}
	
	//A method ‘getSize’ returning the number of items in the list
	public int getSize() {
		Node temp = head;
		int count = 0;
		//Iteration continues until temp is null
		while(temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}
	
	//A method ‘insertSorted’ taking an integer argument that inserts this integer at a position in the 
	//LinkedList based on ascending numerical value, where the Head holds the smallest integer and 
	//Tail holds the greatest integer
	public void sortedInsert(int val) {
		
		Node newNode = new Node(val);
		
		//Condition1: If list is empty, head will be null
		//Condition2: When newNode becomes the head, which means the inserted value is less than data in head
		if(head == null || head.data > val ) {
			newNode.next = head;
			head = newNode;
			return;
		}
		
		//Temporarily assigning head reference to curr.
		Node curr = head;
		
		//We will keep moving the pointer to each node, until the data in next node is greater than val which is to be inserted.
		//Ex: head [5,->], curr[6,->], [8,->],[9,null]
		//newNode[7,null] is tried to inserted. 
		//curr.next will be [8,->] which is not null
		//curr.next.data < newNode.data will be 8 < 7, returns false. 
		
		while(curr.next != null && curr.next.data < newNode.data) {
			//If newNode [10,null] is tried to insert, iteration starts from [5,->] and loop goes until [9,null]
			//since curr.next.data < newNode.data satisfies till last node (9<10)
			curr = curr.next;
		}
		
		//newNode.next = curr.next; means newNode[7,null] will become newNode[7,->], [8,->]
		newNode.next = curr.next; 
		
		//curr.next = newNode; means curr[6,->], [8,->] will become curr[6,->], [7,->], [8,->]
		curr.next = newNode;
	}
	
	/*
	 * Function to sort the existing linked list, before calling sortedInsert method
	 */
	public void sortList(){
 
        // Node current will point to head
        Node current = head;
        Node index = null;
 
        int temp;
 
        if (head == null) {
            return;
        }
        else {
            while (current != null) {
                // Node index will point to node next to
                // current
                index = current.next;
 
                while (index != null) {
                    // If current node's data is greater
                    // than index's node data, swap the data
                    // between them
                    if (current.data > index.data) {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
 
                    index = index.next;
                }
                current = current.next;
            }
        }
    }
}
