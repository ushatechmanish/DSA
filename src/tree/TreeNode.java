package tree;
public class TreeNode
{
	public TreeNode left;
	public TreeNode right;
	int value;
	
	public TreeNode(int value)
	{
		this.value=value;
	}
	public TreeNode(TreeNode left, TreeNode right, int value)
	{
		super();
		this.left = left;
		this.right = right;
		this.value = value;
	}	
}
