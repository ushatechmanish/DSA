package binarysearch;

public class BinarySearch
{

	public int search(int[] arr, int target)
	{
		return binarySearchHelper(arr, 0, arr.length - 1, target);
	}

	/**
	 * [2,3,6] 5 0 2 - mid = 1 3<5 2,2 - mid = 2 6>5 2,1
	 */

	// assuming it is ascending order
	private int binarySearchHelper(int[] arr, int start, int end, int target)
	{
		if (arr.length == 0)
			return -1;
		if (!(start <= end))
		{
			return -(start) - 1;
		} else
		{
			int mid = start + (end - start) / 2;
			if (arr[mid] == target)
			{
				return mid;
			} else if (arr[mid] < target)
			{
				return binarySearchHelper(arr, mid + 1, end, target);
			} else
			{
				return binarySearchHelper(arr, start, mid - 1, target);
			}
		}

	}

}
