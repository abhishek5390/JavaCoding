package org.gudigar.Collections;

public class PrintLeftViewOfBinaryTree {
	static int maxLevel = 0;
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(5);
		root.left.right = new Node(8);
		root.right.left = new Node(4);
		root.right.right = new Node(6);
		root.right.right.left = new Node(9);
		
		printLeftView(root, 1);
	}

	/*
	 *          1        --> 1
	 *      2       3    --> 2
	 *   5    8   4    6 --> 3
	 *               9   --> 4   
	 *                
	 *   Output : 1 2 5 9 
	 */
	private static void printLeftView(Node root, int level) {
		
		
		if(root == null) return;
		
		//This is a NLR approach
		//0<1
		/*
		if(maxLevel < level) {
			System.out.print(root.data + " ");
			maxLevel = level; //maxLevel = 2
		}
		
		printLeftView(root.left, level+1);
		printLeftView(root.right, level+1);	
		*/
		
		//This is a LNR approach
		printLeftView(root.left, level+1);
		if(maxLevel < level) {
			System.out.print(root.data + " ");
			maxLevel = level; //maxLevel = 2
		}
		
		printLeftView(root.right, level+1);	
	}
	
	

}
