package tree;

import java.util.Scanner;

public class BinaryTree
{
	private TreeNode root;

	public BinaryTree()
	{
		super();
	}
	
	public void populate(Scanner sc)
	{
		System.out.println("Enter the root Node value :");
		int rootNodeValue = sc.nextInt();
		root = new TreeNode(rootNodeValue);
		populate(sc,root);
		System.out.println("Binary Tree is as follows");
		display(root,"");
		System.out.println("Binary Tree pretty display is as follows");
		prettyDisplay(root,"");
	}

	private void populate(Scanner sc, TreeNode node)
	{
		System.out.println("Do you want to enter the left node value of "+ node.value);
		boolean left = sc.nextBoolean();
		if(left)
		{
			System.out.println("Enter the left value of "+node.value);
			int leftValue = sc.nextInt();
			node.left = new TreeNode(leftValue);
			populate(sc,node.left);
		}
		System.out.println("Do you want to enter the right node value of "+ node.value);
		boolean right = sc.nextBoolean();
		if(right)
		{
			System.out.println("Enter the right value of "+node.value);
			int rightValue = sc.nextInt();
			node.right = new TreeNode(rightValue);
			populate(sc,node.right);
		}
	}
	
	private void display(TreeNode node, String indent)
	{
		if(node==null)
		{
			return;
		}
		System.out.println(indent+node.value);
		display(node.left, indent +"\t");
		display(node.right,indent +"\t");
	}
	private void prettyDisplay(TreeNode node, String indent)
	{
		if(node==null)
		{
			return;
		}
		prettyDisplay(node.right, indent+"\t");
		if(indent.length()==0)
		{
			System.out.println(node.value);
		}
		else
		{
			System.out.println(indent+"->>>>>"+node.value);
		}
		prettyDisplay(node.left, indent+"\t");
	}
	public void preOrder()
	{
		preOrder(this.root);
	}

	private void preOrder(TreeNode node)
	{
		if(node==null)return;
		
		System.out.println(node.value);
		preOrder(node.left);
		preOrder(node.right);
	}
	public void postOrder()
	{
		postOrder(this.root);
	}

	private void postOrder(TreeNode node)
	{
		if(node==null)return;
		
		preOrder(node.left);
		preOrder(node.right);
		System.out.println(node.value);
	}
	public void inOrder()
	{
		inOrder(this.root);
	}

	private void inOrder(TreeNode node)
	{
		if(node==null)return;
		
		preOrder(node.left);
		System.out.println(node.value);
		preOrder(node.right);
	}
}
