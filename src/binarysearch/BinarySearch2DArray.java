package binarysearch;

import java.util.Arrays;

public class BinarySearch2DArray
{

//	int[][] arr = new int[][] { { 18, 9, 12 }, { 36, -4, 91 }, { 44, 33, 16 } };

	public int[] simpleSearch(int[][] arr, int target)
	{
		for (int row = 0; row < arr.length; ++row)
		{
			for (int col = 0; col < arr[0].length; col++)
			{
				if (arr[row][col] == target)
				{
					return new int[] { row, col };
				}
			}
		}
		return new int[] { -1, -1 };
	}

//	int[][] arr {
//		{10, 20, 30, 40},
//		{15, 25, 35, 45},
//		{28, 29, 37, 49},
//		{33, 34, 38, 50}
//		};

	public int[] binarySearchOrdered(int[][] arr, int target)
	{
		int row = 0, col = arr.length - 1;
		while (row < arr.length && col >= 0)
		{
			if (arr[row][col] == target)
			{
				return new int[] { row, col };
			} else if (arr[row][col] > target)
			{
				col--;
			} else
			{
				row++;
			}
		}
		return new int[] { -1, -1 };
	}

//	int[][] arr {
//	{2, 3, 4, 5},
//	{7, 8, 10, 13},
//	{14, 17, 19, 21},
//	{24, 25, 27, 30}
//	};
	public int[] searchSortedArray(int[][] matrix, int target)
	{
		int rows = matrix.length;
		int cols = rows > 0 ? matrix[0].length : 0;

		if (rows == 1)
		{
			return binarySearch(matrix[0], 0, 0, matrix[0].length - 1, target);
		}

		int rowStart = 0;
		int rowEnd = rows - 1;
		int colMid = cols / 2;
		while (rowEnd - rowStart > 1) // it will have more than 2 rows
		{
			int mid = rowStart + (rowEnd - rowStart) / 2;
			if (matrix[mid][colMid] == target)
			{
				return new int[] { mid, colMid };
			}
			if (matrix[mid][colMid] < target)
			{
				rowStart = mid;
			} else
			{
				rowEnd = mid;
			}
		}
		// now we have 2 rows
		// check individually for 2 rows now
		int[] row1SearchResult = binarySearch(matrix[rowStart], rowStart, 0, cols - 1, target);
		if (!Arrays.equals(new int[] { -1, -1 }, row1SearchResult))
		{
			return row1SearchResult;
		}
		int[] row2SearchResult = binarySearch(matrix[rowStart + 1], rowStart + 1, 0, cols - 1, target);
		if (!Arrays.equals(new int[] { -1, -1 }, row2SearchResult))
		{
			return row2SearchResult;
		}
		return new int[] { -1, -1 };
	}

	private int[] binarySearch(int[] arr, int row, int colStart, int colEnd, int target)
	{
		while (colStart <= colEnd)
		{
			int mid = colStart + (colEnd - colStart) / 2;
			if (arr[mid] == target)
			{
				return new int[] { row, mid };
			}
			if (arr[mid] < target)
			{
				colStart = mid + 1;
			} else
			{
				colEnd = mid - 1;
			}
		}
		return new int[] { -1, -1 };
	}

}
