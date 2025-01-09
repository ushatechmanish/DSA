package threesum;

import java.util.*;

class Solution {
    public List<List<Integer>> findTriplets(int[] arr)
    {
        // for each number we want a pair of numbers satisfying the condition for sum 
        // One option is to generate all the triplets and store unique ones 
        // but here we will be calculating the pair sum for all the numbers n times 
        // where n is the number of elements in array . 
        // to take the time complexity from n^3 to n^2 we save the sum and pairs in 
        // a key value pair to get it in O(1) 
        
        // Using set to store only unique values 
        Set<List<Integer>> res = new HashSet<>();
        
        int n = arr.length;
        // Map of key=sum , value of pair
        Map<Integer, List<int[]>> map = new HashMap<>();
        
        for(int i=0 ; i < n ; ++i)
        {
            for(int j=i+1 ; j < n ; ++j)
            {
                int sum = arr[i]+arr[j];
                
                if(!map.containsKey(sum)) map .put(sum, new ArrayList<int[]>());
                
                map.get(sum).add(new int[]{i,j});
            }
        }
        
        // Now the map is ready 
        
        for(int i=0; i< n ;++i)
        {
            int remaining = 0-arr[i];
            
            if(map.containsKey(remaining))
            {
                List<int[]> pairs = map.get(remaining);
                
                for(int[] pair: pairs)
                {
                    if(pair[0]!=i && pair[1]!=i)
                    {
                        List<Integer> inner = new ArrayList<>();
                        inner.add(i);
                        inner.add(pair[0]);
                        inner.add(pair[1]);
                        Collections.sort(inner);
                        res.add(inner);
                    }
                }
                
            }
        }
        
        
        
        return new ArrayList<>(res);
        
    }
}