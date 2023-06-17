
public class DSA
{

	public static void main(String[] args)
	{
		DSA obj = new DSA();
		int[] arr1 = {18,12,9,14,77,50};
		boolean linearSearchResult =obj.linearSearch(new int[] {18,12,9,14,77,50},14);
		System.out.println(linearSearchResult);

	}
	
	public boolean linearSearch(int[] arr,int target)
	{
		if(arr==null || arr.length==0)
			return false;
		
		for(int num : arr)
		{
			if(num==target)
			{
				return true;
			}
		}
		
		return false;
	}

}
