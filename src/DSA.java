import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DSA
{

	public static void main(String[] args)
	{
		DSA obj = new DSA();
		int[] arr1 = {18,12,9,14,77,50};
		int linearSearchResult =obj.linearSearch(new int[] {18,12,9,14,77,50},14);
		System.out.println(linearSearchResult);
		int linearSearchStreamResult =obj.linearSearchStream(new int[] {18,12,9,14,77,50},14);
		System.out.println(linearSearchStreamResult);
		int linearSearchStreamWitoutBoxingResult =obj.linearSearchStreamWitoutBoxing(new int[] {18,12,9,14,77,50},14);
		System.out.println(linearSearchStreamWitoutBoxingResult);

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
	
	public int linearSearchStreamWitoutBoxing(int[] arr, int target) {
	    if (arr == null || arr.length == 0)
	        return -1;

	   OptionalInt index = IntStream.range(0, arr.length) // create a range of numbers starting from 0 and excluding arr.length
			   .filter(pivot ->arr[pivot]==target) // filter for the condition
			   .findFirst(); // returns first element . This is a short circuit operation
	   
	   return index.orElse(-1);
	}
}
