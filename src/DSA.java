import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DSA
{

	public static void main(String[] args)
	{
		DSA obj = new DSA();
		int[] arr = {18,12,9,14,77,50};
//		int linearSearchResult =obj.linearSearch(arr,14);
//		System.out.println(linearSearchResult);
//		int linearSearchStreamResult =obj.linearSearchStream(arr,14);
//		System.out.println(linearSearchStreamResult);
//		int linearSearchStreamWitoutBoxingResult =obj.linearSearchStreamWithoutBoxing(arr,14);
//		System.out.println(linearSearchStreamWitoutBoxingResult);
//		
//		System.out.println(obj.linearSearchStreamWithoutBoxing(arr,14,2,5));

//		System.out.println(obj.findMin(arr));
//		System.out.println(obj.findMinStream(arr));
		
		int[][] twoDimensionalArray = new int[][]
				{
						{1,4,5,17},
						{2,5,6,7},
						{34,23,12,-1}				
				};
		int[] position = obj.findNumIn2DimArray(twoDimensionalArray,23);
		System.out.println(Arrays.toString(position));
	}
	
	
	private int[] findNumIn2DimArray(int[][] twoDimensionalArray, int target)
	{
		for(int row=0 ; row < twoDimensionalArray.length ; ++row)
		{
			for(int col=0; col<twoDimensionalArray[row].length ;++col )
			{
				if(twoDimensionalArray[row][col]==target)
				{
					return new int[] {row,col};
				}
			}
		}
		return new int[] {-1,-1};
	}


	private int findMin(int[] arr)
	{
		int result = Integer.MAX_VALUE;
		for(int num : arr)
		{
			result = Math.min(num, result);
		}
		return result;
	}


	private int findMinStream(int[] arr)
	{
		return Arrays.stream(arr).min().orElse(Integer.MAX_VALUE);
	}


	public int linearSearch(String text, char target)
	{
		if(text==null || text.length()==0)
			return -1;
		
		return text.indexOf(target);
	}
	public int linearSearchStream(String text, char target)
	{
		if(text==null || text.length()==0)
			return -1;
		
		return IntStream
		.range(0, text.length())
		.filter(pivot -> text.charAt(pivot)==target)
		.findFirst().orElse(-1);
	}
	/**
	 * returns the position of the target 
	 * if not present returns -1;
	 * */
	public int linearSearch(int[] arr,int target)
	{
		if(arr==null || arr.length==0)
			return -1;
		for(int index=0; index<arr.length ; ++index)
		{
			if(arr[index]==target)
			{
				return index;
			}
		}
		
		return -1;
	}
	/** To find time complexity , find the relation from the graph  between 
	 * the size of the input   vs max number of operations 
	 * Since the graph will be linear the time complexity is O(n) 
	 * */
	public int linearSearchStream(int[] arr, int target) {
	    if (arr == null || arr.length == 0)
	        return -1;
	    
	    return Arrays.stream(arr)	// return IntStream 
	    		.boxed()			// converts to Stream<Integer>
	    		.collect(Collectors.toList()) // collects to List 
	    		.indexOf(target); // returns index of target . return -1 if not found
	}
	
	public int linearSearchStreamWithoutBoxing(int[] arr, int target) {
	    if (arr == null || arr.length == 0)
	        return -1;

	   OptionalInt index = IntStream.range(0, arr.length) // create a range of numbers starting from 0 and excluding arr.length
			   .filter(pivot ->arr[pivot]==target) // filter for the condition
			   .findFirst(); // returns first element . This is a short circuit operation
	   
	   return index.orElse(-1);
	}
	
	public int linearSearchStreamWithoutBoxing(int[] arr, int target, int start , int end) {
	    if (arr == null || arr.length == 0)
	        return -1;

	   OptionalInt index = IntStream.rangeClosed(start, end) // create a range of numbers starting from 0 and excluding arr.length
			   .filter(pivot ->arr[pivot]==target) // filter for the condition
			   .findFirst(); // returns first element . This is a short circuit operation
	   
	   return index.orElse(-1);
	}
	
}
