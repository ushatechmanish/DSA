package dsa;

import java.util.Scanner;

import tree.BST;
import tree.BinaryTree;

public class DSA
{

	public static void main(String[] args)
	{
//		BinaryTree tree = new BinaryTree();
//		tree.populate(new Scanner(System.in));
		
		BST bst = new BST();
//		bst.populate(new int[]{1,4,-4,47,31});
//		bst.display();
//		System.out.println("isBalanced"+bst.isBalanced());
		bst.populateSortedArray(new int[]{1,2,3,4,5});
		bst.display();
		bst.prettyDisplay();
		System.out.println("isBalanced"+bst.isBalanced());
	}	
}
