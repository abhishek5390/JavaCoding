package org.gudigar.Collections;

import java.util.Scanner;

public class CreateBinaryTree {

	static Scanner sc = null;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		Node root = createTree();
		
		inOrder(root);
		System.out.println();
		preOrder(root);
		System.out.println();
		postOrder(root);
		System.out.println();


	}

	private static Node createTree() {
		Node root = null;
		System.out.println("Enter data : ");
		int data = sc.nextInt();

		if(data == -1) return null;

		root = new Node(data);

		System.out.println("Enter left for " + data);
		root.left = createTree();

		System.out.println("Enter right for " + data);
		root.right = createTree();

		return root;
	}

	//LNR approach
	private static void inOrder(Node root) {
		if(root == null) return;

		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}

	//NLR approach
	private static void preOrder(Node root) {
		if(root == null) return;

		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	//LRN approach
	private static void postOrder(Node root) {
		if(root == null) return;

		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}
}


