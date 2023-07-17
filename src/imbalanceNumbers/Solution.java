package imbalanceNumbers;

import java.util.Arrays;

class Solution
{
	public static void main(String[] args)
	{
		System.out.println(sumImbalanceNumbers(new int[] { 2, 3, 1, 4 }));
	}

	public static int sumImbalanceNumbers(int[] nums)
	{
		int result = 0;
		// Let i represent contiguous subArray Length
		for (int i = 2; i <= nums.length; ++i)
		{
			for (int j = 0; j <= nums.length - i; ++j)
			{
				result += imbalanceNumber(Arrays.copyOfRange(nums, j, j + i));
			}
		}
		return result;
	}

	public static int imbalanceNumber(int[] arr)
	{
		Arrays.sort(arr);
		int result = 0;
		for (int i = 0; i < arr.length - 1; ++i)
		{
			if (arr[i + 1] - arr[i] > 1)
				result++;
		}
		return result;
	}

}