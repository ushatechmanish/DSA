package goodrich.arrays.ch3;

import java.util.Arrays;

public class UseArraysMethods
{

	public void testArrayMethods()
	{
		boolean equal = Arrays.equals(new int[]
		{ 1, 2 }, new int[]
		{ 1, 2 });
		System.out.println("Using Arrays.equals method , value returned is " + equal);

		int[] arr = new int[3];
		Arrays.fill(arr, -1);
		System.out.println(Arrays.toString(arr));

		int[] arrcopy = Arrays.copyOf(arr, 4);
		System.out.println(Arrays.toString(arrcopy));

		int[] arrCopyRange = Arrays.copyOfRange(arrcopy, 1, 2); // 1 inclusive 2 exclusive
		System.out.println(Arrays.toString(arrCopyRange));

		int[] sortedArray =
		{ 2, 4, 6, 10 };

		System.out.println(Arrays.binarySearch(sortedArray, 1));// 0-1=-1

		System.out.println(Arrays.binarySearch(sortedArray, 5));// -2-1=-3

		/**
		 * -(index)-1 = result => index= -1-result if value returned by binary search
		 * method is negative , remove negative sign and reduce by 1 to find the correct
		 * insert index
		 */
	}
}
