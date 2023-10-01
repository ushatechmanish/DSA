package binarysearch;

public class BinarySearch
{

	public int search(int[] arr, int target)
	{
		boolean isAscendingOrder = arr[arr.length - 1] > arr[0];
		int start = 0;
		int end = arr.length - 1;

		while (start <= end)
		{
			int mid = start + (end - start) / 2;
			if (arr[mid] == target)
			{
				return mid;
			} else
			{
				if (isAscendingOrder)
				{
					if (arr[mid] < target)
					{
						start = mid + 1;
					} else
					{
						end = mid - 1;
					}
				} else
				{
					if (arr[mid] > target)
					{
						start = mid + 1;
					} else
					{
						end = mid - 1;
					}
				}
			}
		}
		return -(start) - 1;
	}

}
