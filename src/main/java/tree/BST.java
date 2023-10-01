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
		if (node == null)
		{
			return -1;
		}
		return node.height;
	}

	public void insert(int value)
	{
		root = insert(this.root, value);
	}

	public TreeNode insert(TreeNode node, int value)
	{
		if (node == null)
		{
			node = new TreeNode(value);
			return node;
		}

		if (value < node.value)
		{
			node.left = insert(node.left, value);
		}
		if (value > node.value)
		{
			node.right = insert(node.right, value);
		}
		node.height = Math.max(height(node.left), height(node.right)) + 1;

		return node;

	}

	private boolean isBalanced(TreeNode node)
	{
		if (node == null)
			return true;
		return Math.abs(height(node.left) - height(node.right)) <= 1 && isBalanced(node.left) && isBalanced(node.right);
	}

	public boolean isBalanced()
	{
		return isBalanced(root);
	}

	public void prettyDisplay()
	{
		prettyDisplay(root, 0);
	}

	private void prettyDisplay(TreeNode node, int level)
	{
		if (node == null)
			return;
		prettyDisplay(node.right, level + 1);
		for (int i = 0; i < level; ++i)
		{
			System.out.print("\t");
		}
		System.out.println(node.value);
		prettyDisplay(node.left, level + 1);
	}

	public void display()
	{
		display(root, "Root node");
	}

	public void display(TreeNode node, String details)
	{
		if (node == null)
		{
			return;
		}

		System.out.println(details + ":" + node.value);
		display(node.left, "Left node of " + node.value);
		display(node.right, "Right node of " + node.value);

	}

	public void populate(int[] arr)
	{
		Arrays.stream(arr).forEach(num -> insert(num));
	}

	public void populateSortedArray(int[] arr)
	{
		populateSortedArray(arr, 0, arr.length - 1);
	}
	/**
	 * Time complexity is n*log(n) because we are inserting n items and every item
	 * takes log(n) time to find the correct position.
	 * */
	private void populateSortedArray(int[] arr, int start, int end)
	{
		if (!(start <= end))
		{
			return;
		}
		int mid = start + (end - start) / 2;
		insert(arr[mid]);
		populateSortedArray(arr, start, mid - 1);
		populateSortedArray(arr, mid + 1, end);
	}
}
