package sort;

import java.util.Arrays;

public class CycleSort
{
	public static void main(String[] args)
	{
		int[] arr = { 1, 4, 3, 2 };
		new CycleSort().sort1ToN(arr);
		System.out.println(Arrays.toString(arr));
		int[] arr2 = { 0, 1, 4, 3, 2 };
		new CycleSort().sort0ToN(arr2);
		System.out.println(Arrays.toString(arr2));
	}

	// For 1 to N
	public void sort1ToN(int[] arr)
	{
		for (int index = 0; index < arr.length; ++index)
		{
			while (arr[index] != (index + 1))
			{
				swap(arr, index, arr[index] - 1);
			}
		}
	}

	// For 1 to N
	public void sort0ToN(int[] arr)
	{
		for (int index = 0; index < arr.length; ++index)
		{
			while (arr[index] != (index))
			{
				swap(arr, index, arr[index]);
			}
		}
	}

	private void swap(int[] arr, int index1, int index2)
	{
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

}
