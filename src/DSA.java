
public class DSA
{

	public static void main(String[] args)
	{
		DSA obj = new DSA();
		int[] arr1 = {18,12,9,14,77,50};
		int linearSearchResult =obj.linearSearch(new int[] {18,12,9,14,77,50},-1);
		System.out.println(linearSearchResult);

	}
	/**
	 * returns the position of the target 
	 * if not present returns -1;
	 * */
	public int linearSearch(int[] arr,int target)
	{
		if(arr==null || arr.length==0)
			return -1;
		int index=0;
		for(int num : arr)
		{
			if(num==target)
			{
				return index;
			}
			++index;
		}
		
		return -1;
	}

}
