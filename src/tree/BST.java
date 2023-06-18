package tree;

import java.util.Arrays;

public class BST
{
	private TreeNode root;
	
	public BST()
	{
		super();
	}
	public int height(TreeNode node)
	{
		if(node==null)
		{
			return -1;
		} 
		return node.height;
	}
	public boolean isEmpty()
	{
		return root==null;
	}
	
	public void insert(int value)
	{
		root = insert(root,value);
	}
	private TreeNode insert(TreeNode node, int value)
	{
		if(node==null)
		{
			node= new TreeNode(value);
			return node;
		}
		if(value<node.value)
		{
			node.left=insert(node.left, value);
		}
		if(value>node.value)
		{
			node.right=insert(node.right, value);
		}
		node.height=Math.max(height(node.left), height(node.right))+1;
		return node;
	}
	public boolean isBalanced(TreeNode node)
	{
		if(node==null) return true;
		
		return Math.abs(height(root.left)-height(root.right))<=1 
				&& isBalanced(node.left)
				&& isBalanced(node.right);
	}
	
	public void display()
	{
		display(this.root, "Root Node");
	}
	private void display(TreeNode node , String details)
	{
		if(node==null)
		{
			return;
		}
		System.out.println(details+ node.value);
		display(node.left,"Left node of "+node.value +":");
		display(node.right,"Right node of "+node.value+":");
	}
	
	public void populate(int[] arr)
	{
		Arrays.stream(arr).forEach(num->  insert(num));
	}
}
