package sort;

//Selection Sort Algorithm Theory +code #7
public class SelectionSort
{
	public void sort(int[] arr) // {2,1}
	{
//		System.out.println("Starting to sort " + Arrays.toString(arr));
		for (int i = 0; i < arr.length; ++i)
		{
			int last = arr.length - i - 1;
			int maxIndex = getMaxIndex(arr, 0, last);
			swap(arr, last, maxIndex);
		}
//		System.out.println("After sort " + Arrays.toString(arr));
	}

	private void swap(int[] arr, int last, int maxIndex)
	{
		int temp = arr[last];
		arr[last] = arr[maxIndex];
		arr[maxIndex] = temp;
	}

	private int getMaxIndex(int[] arr, int start, int end)
	{
		int max = start;
		for (int index = start; index <= end; ++index)
		{
			if (arr[index] > arr[max])
			{
				max = index;
			}
		}
		return max;
	}
}
