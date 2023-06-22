package sort;

public class BubbleSort
{

	public int[] sortAscending1(int[] arr) // [4,3,2] => [3,2,4] => [2,3]
	{
		for (int i = 0; i < arr.length - 1; ++i)
		{
			for (int j = 0; j < arr.length - 1 - i; ++j)
			{
				if (arr[j] > arr[j + 1])
				{
					swap(arr, j, j + 1);
				}
			}
		}
		return arr;
	}

	public void swap(int[] arr, int pos1, int pos2)
	{
		int temp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = temp;
	}
}
