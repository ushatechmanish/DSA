package goodrich.arrays.ch3;

public class InsertionSort
{

	public int[] sortAscending2(int[] arr)
	{
		for(int i=1 ; i<arr.length ; ++i)
		{
			int j=i;
			int curr= arr[i];
			while(j>0 && arr[j-1]>curr)
			{
				// shift the elements 
				arr[j]=arr[j-1];
				--j;
			}
			arr[j]=curr;
		}
		return arr;
	}
	public int[] sortDescending1(int[] arr) //[2,4,3,5]
	{
		for(int i=1 ; i<arr.length ; ++i)
		{
			int j=i;
			int curr= arr[i];
			while(j>0 && arr[j-1]<curr)
			{
				// shift the elements 
				arr[j]=arr[j-1];
				--j;
			}
			arr[j]=curr;
		}
		return arr;
	}
	public int[] sortDescending2(int[] arr) //[2,4,3,5]
	{
		for(int i=0 ; i<arr.length-1 ; ++i)
		{
			for(int j=i+1; j>0 && arr[j]>arr[j-1] ;--j)
			{
				swap(arr, j, j-1);
			}
		}
		return arr;
	}
	// sort the array in ascending order
	public int[] sortAscending1(int[] arr)
	{
		// intuition . The array is divided into left part and right part excluding the current index position
		// Left part is always sorted 
		// The current index position needs to be put at correct position with respect to left part 
		
		for(int i=0 ; i< arr.length-1 ; ++i) // no of iterations will be arr.length -1 as first element is always sorted
		{
			int j = i+1; // j is the current position  
			while(j>0 && arr[j]<arr[j-1])
			{
				swap(arr,j,j-1);
				--j;
			}
		}
		return arr;
	}

	private void swap(int[] arr, int j, int i)
	{
		int temp = arr[j];
		arr[j]=arr[i];
		arr[i]= temp;
	}
	
}
